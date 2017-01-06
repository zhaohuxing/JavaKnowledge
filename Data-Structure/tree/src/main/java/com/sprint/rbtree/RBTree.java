package com.sprint.rbtree;

import java.util.*;
public class RBTree<T extends Comparable<T>> {
	private final RBTreeNode<T> root;

	//node number
	private java.util.concurrent.atomic.AtomicLong size = 
					new java.util.concurrent.atomic.AtomicLong(0);
	private volatile boolean overrideMode = true;

	public RBTree() {
		this.root = new RBTreeNode<T>();
	}

	public RBTree(boolean overrideMode) {
		this();
		this.overrideMode = overrideMode;
	}

	public boolean isOverrideMode() {
		return overrideMode;
	}

	public void setOverrideMode(boolean overrideMode) {
		this.overrideMode = overrideMode;
	}

	/**
	 *   get number of the tree node
	 */
	public long getSize() {
		return size.get();
	}

	/**
	 *  get the root node
	 */
	public RBTreeNode<T> getRoot() {
		return root.getLeft();
	}

	/**
	 * add node
	 */
	public T addNode(T value) {
		RBTreeNode<T> t = new RBTreeNode<T>(value);
		return addNode(t);
	}

	public T find(T value) {
		RBTreeNode<T> dataRoot = getRoot();
		while (dataRoot != null) {
			int cmp = dataRoot.getValue().compareTo(value);
			if (cmp < 0) {
				dataRoot = dataRoot.getRight(); 
			} else if (cmp > 0) {
				dataRoot = dataRoot.getLeft();
			} else {
				return dataRoot.getValue();
			}
		}
		return null;
	}

	public T remove(T value) {
		RBTreeNode<T> dataRoot = getRoot();
		RBTreeNode<T> parent = root;

		while (dataRoot != null) {
			int cmp = dataRoot.getValue().compareTo(value);
			if (cmp < 0) {
				parent = dataRoot;
				dataRoot = dataRoot.getRight();
			} else if (cmp > 0) {
				parent = dataRoot;
				dataRoot = dataRoot.getLeft();
			} else {
				if (dataRoot.getRight() != null) {
					RBTreeNode<T> min = removeMin(dataRoot.getRight());
					RBTreeNode<T> x = min.getRight() == null ? min.getParent() : min.getRight();
					boolean isParent = (min.getRight() == null); 

					min.setLeft(dataRoot.getLeft());
					setParent(dataRoot.getLeft(), min);
					if (parent.getLeft() == dataRoot) {
						parent.setLeft(min);
					} else {
						parent.setRight(min);
					}
					setParent(min, parent);

					boolean curMinIsBlack = min.isBlack();
					min.setRed(dataRoot.isRed());

					if (min != dataRoot.getRight()) {
						min.setRight(dataRoot.getRight());
						setParent(dataRoot.getRight(), min);
					}

					if (curMinIsBlack) {
						if (min != dataRoot.getRight()) {
							fixRemove(x, isParent);
						} else if (min.getRight() != null) {
							fixRemove(min.getRight(), false);
						} else {
							fixRemove(min, true);
						}
					}
				} else {
					setParent(dataRoot.getLeft(), parent);
					if (parent.getLeft() == dataRoot) {
						parent.setLeft(dataRoot.getLeft());
					} else {
						parent.setRight(dataRoot.getLeft());
					}

					if (dataRoot.isBlack() && !(root.getLeft() == null)) {
						RBTreeNode<T> x = dataRoot.getLeft() == null ? parent : dataRoot.getLeft();
						boolean isParent = dataRoot.getLeft() == null;
						fixRemove(x, isParent);
					}
				}
				setParent(dataRoot, null);
				dataRoot.setLeft(null);
				dataRoot.setRight(null);
				if (getRoot() != null) {
					getRoot().setRed(false);
					getRoot().setParent(null);
				}
				size.decrementAndGet();
				return dataRoot.getValue();
			}
		} 
		return null;
	}

	/**
	 *  fix remove action 
	 *  @param node
	 *  @param isParent
	 */
	private void fixRemove(RBTreeNode<T> node, boolean isParent) {
		RBTreeNode<T> cur = isParent ? null:node;
		boolean isRed = isParent ? false : node.isRed();
		RBTreeNode<T> parent = isParent ? node : node.getParent();
		
		while (!isRed && !isRoot(cur)) {
			RBTreeNode<T> sibling = getSibling(cur, parent);
			boolean isLeft = (parent.getRight() == null);
			if (sibling.isRed() && !isLeft) {
				parent.makeRed();
				sibling.makeBlack();
				rotateRight(parent);
			} else if (sibling.isRed() && isLeft) {
				parent.makeRed();
				sibling.makeBlack();
				rotateLeft(parent);
			} else if (isBlack(sibling.getLeft()) && isBlack(sibling.getRight())) {
				sibling.makeRed();
				cur = parent;
				isRed = cur.isRed();
				parent = parent.getParent();
			} else if (isLeft && !isBlack(sibling.getLeft())
									&& isBlack(sibling.getRight())) {
				
				sibling.makeRed();
				sibling.getLeft().makeBlack();
				rotateRight(sibling);
			} else if (!isLeft && !isBlack(sibling.getRight())
									&& isBlack(sibling.getLeft())) {
			
				sibling.makeRed();
				sibling.getRight().makeBlack();
				rotateLeft(sibling);
			} else if (isLeft && isBlack(sibling.getRight())) {
				sibling.setRed(parent.isRed());
				parent.makeBlack();
				sibling.getRight().makeBlack();
				rotateLeft(parent);
				cur = getRoot();
			} else if (!isLeft && isBlack(sibling.getLeft())) {
				sibling.setRed(parent.isRed());
				parent.makeBlack();
				sibling.getLeft().makeBlack();
				rotateRight(parent);
				cur = getRoot();
			}
		}

		if (isRed) {
			cur.makeBlack();	
		}

		if (getRoot() != null) {
			getRoot().setRed(false);
			getRoot().setParent(null);
		}
	}

	private RBTreeNode<T> getSibling(RBTreeNode<T> node, RBTreeNode<T> parent) {
		parent = node == null ? parent : node.getParent();
		if (node == null) {
			return parent.getLeft()==null ? parent.getRight() : parent.getLeft();
		}
		if (node == parent.getLeft()) {
			return parent.getRight();
		} else {
			return parent.getLeft();
		}
	}

	private boolean isBlack(RBTreeNode<T> node) {
		return node == null || node.isBlack();
	}

	private boolean isRoot(RBTreeNode<T> node) {
		return root.getLeft() == node && node.getParent() == null;
	}

	private RBTreeNode<T> removeMin(RBTreeNode<T> node) {
		RBTreeNode<T> parent = node;
		while (node != null && node.getLeft() != null) {
			parent = node;
			node = node.getLeft();
		}

		if (parent == node) {
			return node;
		}

		parent.setLeft(node.getRight());
		setParent(node.getRight(), parent);

		return node;
	}
	
	private T addNode(RBTreeNode<T> node) {
		node.setLeft(null);
		node.setRight(null);
		node.setRed(true);
		setParent(node, null);
		if (root.getLeft() == null) {
			root.setLeft(node);
			node.setRed(false);
			size.incrementAndGet();
		} else {
			RBTreeNode<T> x = findParentNode(node);
			int cmp = x.getValue().compareTo(node.getValue());

			if (this.overrideMode && cmp == 0) {
				T v = x.getValue();
				x.setValue(node.getValue());
				return v;
			} else if (cmp == 0) {
				return x.getValue();
			}

			setParent(node, x);

			if (cmp > 0) {
				x.setLeft(node);
			} else {
				x.setRight(node);
			}

			fixInsert(node);
			size.incrementAndGet();
		}
		return null;
	}

	private RBTreeNode<T> findParentNode(RBTreeNode<T> x) {
		RBTreeNode<T> dataRoot = getRoot();
		RBTreeNode<T> child = dataRoot;

		while(child != null) {
			int cmp = child.getValue().compareTo(x.getValue());
			if (cmp == 0) {
				return child;
			}

			if (cmp > 0) {
				dataRoot = child;
				child = child.getLeft();
			} else if (cmp < 0) {
				dataRoot = child;
				child = child.getRight();
			}
		}
		return dataRoot;
	}

	private void fixInsert(RBTreeNode<T> x) {
		RBTreeNode<T> parent = x.getParent();

		while (parent != null && parent.isRed()) {
			RBTreeNode<T> uncle = getUncle(x);
			if (uncle == null) {
				RBTreeNode<T> ancestor = parent.getParent();
				if (parent == ancestor.getLeft()) {
					boolean isRight = x == parent.getRight();	
					if (isRight) {
						rotateLeft(parent);
					}
					rotateRight(ancestor);

					if (isRight) {
						x.setRed(false);
						parent = null;
					} else {
						parent.setRed(false);
					}
					ancestor.setRed(true);
				} else {
					boolean isLeft = x==parent.getLeft();
					if (isLeft) {
						rotateRight(parent);
					}
					rotateLeft(ancestor);

					if (isLeft) {
						x.setRed(false);
						parent = null;
					} else {
						parent.setRed(false);
					} 
					ancestor.setRed(true);
				} 
			} else {
				parent.setRed(false);
				uncle.setRed(false);
				parent.getParent().setRed(true);
				x = parent.getParent();
				parent = x.getParent();
			}
		}
		getRoot().makeBlack();
		getRoot().setParent(null);
	}

	private RBTreeNode<T> getUncle(RBTreeNode<T> node) {
		RBTreeNode<T> parent = node.getParent();
		RBTreeNode<T> ancestor = parent.getParent();
		if (ancestor == null) {
			return null;
		}
		if (parent == ancestor.getLeft()) {
			return ancestor.getRight();
		} else {
			return ancestor.getLeft();
		}
	}

	private void rotateLeft(RBTreeNode<T> node) {
		RBTreeNode<T> right = node.getRight();
		if (right == null) {
			throw new java.lang.IllegalStateException("right node is null");
		}
		RBTreeNode<T> parent = node.getParent();
		node.setRight(right.getLeft());
		setParent(right.getLeft(), node);

		right.setLeft(node);
		setParent(node, right);

		if (parent == null) {
			root.setLeft(right);
			setParent(right, null);
		} else {
			if (parent.getLeft() == node) {
				parent.setLeft(right);
			} else {
				parent.setRight(right);	
			}	
			setParent(right, parent);
		}
	}

	private void rotateRight(RBTreeNode<T> node) {
		RBTreeNode<T> left = node.getLeft();
		if (left == null) {
			throw new java.lang.IllegalStateException("left node is null");
		}
		RBTreeNode<T> parent = node.getParent();
		node.setLeft(left.getRight());
		setParent(left.getRight(), node);

		left.setRight(node);
		setParent(node, left);

		if (parent == null) {
			root.setLeft(left);
			setParent(left, null);
		} else {
			if (parent.getLeft() == node) {
				parent.setLeft(left);
			} else {
				parent.setRight(left);
			}
			setParent(left, parent);
		}
	}

	private void setParent(RBTreeNode<T> node, RBTreeNode<T> parent) {
		if (node != null) {
			node.setParent(parent);
			if (parent == root) {
				node.setParent(null);
			}
		}
	}

	public void printTree(RBTreeNode<T> root) {
		java.util.LinkedList<RBTreeNode<T>> queue = new java.util.LinkedList<RBTreeNode<T>>();
		java.util.LinkedList<RBTreeNode<T>> queue2 = new java.util.LinkedList<RBTreeNode<T>>();
		if (root == null) {
			return;
		}
		queue.add(root);
		boolean firstQueue = true;

		while (!queue.isEmpty() || !queue2.isEmpty()) {
			java.util.LinkedList<RBTreeNode<T>> q = firstQueue ? queue : queue2;
			RBTreeNode<T> n = q.poll();

			if (n != null) {
				String pos = n.getParent() == null ? "":(n == n.getParent().getLeft()?"LE":"RI");
				String pstr = n.getParent() == null ? "":n.getParent().toString();
				String cstr = n.isRed()?"R":"B";
				cstr = n.getParent() == null ? cstr: cstr+" ";
				System.out.println(n + "(" + (cstr) + pstr + (pos) + ")" + "\t");
				if (n.getLeft() != null) {
					(firstQueue ? queue2:queue).add(n.getLeft());
				}
				if (n.getRight() != null) {
					(firstQueue ? queue2:queue).add(n.getRight());
				}
			} else {
				System.out.println();
				firstQueue = !firstQueue;
			}
		}

	}
}
