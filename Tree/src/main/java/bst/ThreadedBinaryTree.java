package bst;

import bst.BinarySearchTree.TreeNode;

/**
 * Based on Morris traversal
 */
public class ThreadedBinaryTree {

	void traversalTBTIntoInOrder(TreeNode root) {
		
		TreeNode current = root;
		TreeNode next = root;
		
		if(root == null) {
			return;
		}
		
		while(current != null) {
			
			if(current.left == null) {
				System.out.println(current.value);
				current = current.right;
			}
			else {
				next = current.left;
				
				while(next.right != null && next.right != current) {
					next = next.right;
				}
				
				if(next.right == null) {
					next.right = current;
					current = current.left;
				}
				else {
					next.right = null;
					System.out.println(current.value);
					current = current.right;
				}
			}
		}
		
	}
	
	void traversalTBTIntoPreOrder(TreeNode root) {
		
		TreeNode current = root;
		TreeNode next = root;
		
		if(root == null) {
			return;
		}
		
		while(current != null) {
			
			if(current.left == null) {
				System.out.println(current.value);
				current = current.right;
			}
			else {
				next = current.left;
				
				while(next.right != null && next.right != current) {
					next = next.right;
				}
				
				if(next.right == null) {
					next.right = current;
					System.out.println(current.value);
					current = current.left;
				}
				else {
					next.right = null;
					current = current.right;
				}
			}
		}
		
	}

	
	public static void main(String[] args) {

		BinarySearchTree binarySearchTree = new BinarySearchTree();
		int array[]= {100,40,50,200,10,20};
		
		TreeNode root = binarySearchTree.createBinarySearchTreeUsingArray(array);
		
		ThreadedBinaryTree tbt = new ThreadedBinaryTree();
		System.out.println("TBT - In-Order Traversal..........");
		
		tbt.traversalTBTIntoInOrder(root);
		
		System.out.println("TBT -Pre-Order Traversal..........");
		
		tbt.traversalTBTIntoPreOrder(root);
		
	}

}
