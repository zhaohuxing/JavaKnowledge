package com.sprint;

import com.sprint.rbtree.*;
public class Main {
	public static void main(String[] args) {
		RBTree<Integer> bst = new RBTree<Integer>();
		for (int i = 0; i < 10; i++) {
			bst.addNode(i);
		}
		bst.printTree(bst.getRoot());
	}
}
