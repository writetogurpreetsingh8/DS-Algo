package bst;

import bst.BinarySearchTree.TreeNode;

public class DeleteNodeIntoBST {

	void deleteNodeIntoBST(TreeNode root,int nodeValue) {
		
		if(root == null) {
			System.out.println("not root availabe in the tree!");
		}
		else {
			TreeNode q = null,temp = root;
			while(temp != null && nodeValue != temp.value) {
				
					q = temp;
				if(nodeValue < temp.value) {
					temp = temp.left;
				}
				else if(nodeValue > temp.value) {
					temp = temp.right;
				}
			}
			// element found into tree
			if(temp != null) {
				// if tree has only one single node called root node
				if(temp == root && temp.left == null && temp.right == null) {
					root = null;
				}
				else {
					// case 1
					if(temp.left == null && temp.right == null) {
						
						if(q.right == temp) {
							q.right = null;
						}else {
							q.left = null;
						}
					}// case 2
					else if(temp.left == null) {
						
						if(q.left == temp) {
							q.left = temp.right;
						}
						else {
							q.right = temp.right;
						}
					}//case 3
					else if(temp.right == null) {
						
						if(q.left == temp) {
							q.left = temp.left;
						}
						else {
							q.right = temp.left;
						}
					}// case 4
					else{
						// find max value from left-sub tree
						TreeNode current = null;
						q = temp;
						temp = temp.left;
						current = temp;
						while(temp.right != null) {
							current = temp;
							temp = temp.right;
						}
						q.value = temp.value;
						if(temp.left != null) {
							current.right = temp.left;
						}
						else {
							current.right = null;
							
						}
					}
				}
				
			}else {
				System.out.println("value not found into tree!");
			}
		}
	}
	
	public static void main(String[] args) {

		BinarySearchTree binarySearchTree = new BinarySearchTree();
		int array[]= {100,40,50,200,20,10,45};
		
		TreeNode root = binarySearchTree.createBinarySearchTreeUsingArray(array);
		System.out.println("in order traversal of tree.. before deleting ....");
		
		binarySearchTree.inOrderTraversalRecursive(root);
		
		DeleteNodeIntoBST deleteNodeIntoBST = new DeleteNodeIntoBST();
		deleteNodeIntoBST.deleteNodeIntoBST(root,100);
		System.out.println("in order traversal of tree.. after deleting node 300....");
		
		binarySearchTree.inOrderTraversalRecursive(root);
	}

}
