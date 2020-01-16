package bst;

import bst.BinarySearchTree.TreeNode;


public class TestClass {

	public static void main(String[] args) {
		
			
		BinarySearchTree binarySearchTree = new BinarySearchTree();
		int array[]= {100,40,50,200,10,20};
		
		TreeNode root = binarySearchTree.createBinarySearchTreeUsingArray(array);
		//binarySearchTree.createBinarySearchTree();
		//TreeNode root = binarySearchTree.createBinarySearchTreeUsingRecursive();
		
		System.out.println(" post order traversal....");
		binarySearchTree.postOrderTraversal(root);
		
		System.out.println(" pre order traversal.......");
		binarySearchTree.preOrderTraversal(root);
		
		System.out.println(" in-order order traversal.......");
		binarySearchTree.inOrderTraversal(root);
		
		System.out.println(" desc-order order traversal.......");
		binarySearchTree.descTraversal(root);
	}

}
