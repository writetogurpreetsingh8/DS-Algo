package bst;

import bst.BinarySearchTree.TreeNode;

public class Test {

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
		
		System.out.println("in - order traversal Iterative approach.........");
		
		binarySearchTree.inOrderTraversalInterative(root);

		System.out.println("pre - order traversal Iterative approach.........");
		binarySearchTree.preOrderTraversalInterative(root);
		
		System.out.println("level - wise traversal Iterative approach.........");

		binarySearchTree.levelWiseTraversal(root);
		
	}

}
