package com.sprint.rbtree;

import java.util.*;
public class RBTreeNode<T extends Comparable<T>> {
	private T value; //node value
	private RBTreeNode<T> left;//left child pointer
	private RBTreeNode<T> right;//right child pointer
	private RBTreeNode<T> parent;//parent pointer
	private boolean red;//color is red or not red

	public RBTreeNode() {
	
	}

	public RBTreeNode(T value) {
		this.value = value;
	}

	public RBTreeNode(T value, boolean isRed) {
		this.value = value;
		this.red = isRed;
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

	public RBTreeNode<T> getLeft() {
		return left;
	}

	public void setLeft(RBTreeNode<T> left) {
		this.left = left;
	}

	public RBTreeNode<T> getRight() {
		return right;
	}

	public void setRight(RBTreeNode<T> right) {
		this.right = right;
	}

	public RBTreeNode<T> getParent() {
		return parent;
	}

	public void setParent(RBTreeNode<T> parent) {
		this.parent = parent;
	}

	public boolean isRed() {
		return red;
	}
	
	public void setRed(boolean red) {
		this.red = red;
	}

	public boolean isBlack() {
		return !red;
	}
	
	public void makeRed() {
		red = true;
	}

	public void makeBlack() {
		red = false;
	}
	
	/**
	 *  is leat node
	 **/
	public boolean isLeaf() {
		return left==null && right==null;
	}

	@Override
	public String toString() {
		return value.toString();
	}

}
