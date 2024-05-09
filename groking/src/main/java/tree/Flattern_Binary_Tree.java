package tree;

import tree.BinaryTree.TreeNode;

public class Flattern_Binary_Tree {
	
	
	/**
	 * TC O(N)
	 * aux-space O(1)
	 * system stack O(1)
	 * below algo based on DFS( Pre-Order )
	 * @param root
	 */
	private static void flattern_Binary_Tree_Iterative_with_Pre_Order(TreeNode root) {
		
		if(root == null) {
			return;
		}
		
		TreeNode current = root;
		TreeNode temp = current;
		
		while(current != null) {
			temp = current.left;
			if(temp != null) {
				while(temp.right != null) {
					temp = temp.right;
				}
				temp.right = current.right;
				current.right = current.left;
				current.left = null;
			}
			current = current.right;
		}
	}
	

	private static TreeNode temp;
	
	/**
	 * TC O(N)
	 * aux-space O(1)
	 * system stack O(max height of tree)
	 * below algo based on DFS( Post-Order )
	 * @param root
	 */
	private static void flattern_Binary_Tree_Recursive_with_Post_Order(TreeNode root) {
		 
		if(root == null){
             return;
		}
		
		flattern_Binary_Tree_Recursive_with_Post_Order(root.right);
		flattern_Binary_Tree_Recursive_with_Post_Order(root.left);
		root.right = temp;
		root.left = null;
		temp = root;
	}
	
	/**
	 * TC O(N)
	 * aux-space O(1)
	 * system stack O(max height of tree)
	 * below algo based on DFS( Pre-Order )
	 * @param root
	 */
	private static void flattern_Binary_Tree_Recursive_with_Pre_Order(TreeNode root) {
		
		if(root == null || root.left == null) {
			return;
		}
		TreeNode current = root.left;
        TreeNode temp = current;
        while(current.right != null){
                current = current.right;
        }
        current.right = root.right;
        root.right = temp;
        root.left = null;
        flattern_Binary_Tree_Recursive_with_Pre_Order(root.right);
	}
	
	public static void main(String[] args) {
		BinaryTree binaryTree = new BinaryTree();
		int array[] = { 1,2,3,4,5,6};

		TreeNode root = binaryTree.createBinaryTreeUsingArrayIterative(array);

		Flattern_Binary_Tree.flattern_Binary_Tree_Recursive_with_Pre_Order(root);
		System.out.println(root);
		
		TreeNode root1 = binaryTree.createBinaryTreeUsingArrayIterative(array);
		
		Flattern_Binary_Tree.flattern_Binary_Tree_Iterative_with_Pre_Order(root1);
		System.out.println(root1);
		
		TreeNode root2 = binaryTree.createBinaryTreeUsingArrayIterative(array);
		
		Flattern_Binary_Tree.flattern_Binary_Tree_Recursive_with_Post_Order(root2);
		System.out.println(root2);
	}

}
