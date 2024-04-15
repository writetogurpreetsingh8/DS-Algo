package tree;

import tree.BinaryTree.TreeNode;

public class Find_Diameter_Of_BT {

	private static int find_Diameter_Of_BT(TreeNode root) {
		
		if(root == null) {
			return 0;
		}
		
		int lh = find_Diameter_Of_BT(root.left);
		int rh = find_Diameter_Of_BT(root.right);
		
		int diameter = (lh+rh+1);
		return diameter;
		
	}
	
	public static void main(String[] args) {
		BinaryTree binaryTree = new BinaryTree();
		int array[] = { 1,2,2,3,4,4,3};

		TreeNode root = binaryTree.createBinaryTreeUsingArrayIterative(array);

		System.out.println(Find_Diameter_Of_BT.find_Diameter_Of_BT(root));
	}

}
