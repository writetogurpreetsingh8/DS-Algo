package tree;

import tree.BinarySearchTree.TreeNode;

public class Find_Kth_Smallest_Element_Into_BST {

	private static int find_Kth_Smallest_Element_Into_BST(tree.BinarySearchTree.TreeNode root, int k) {
		
		if(root == null) {
			return 0;
		}
		return find(root,k).value;
		
	}
	/**
	 * TC O(N)
	 * system-stack O(max high of bst)
	 * aux-space O(1)
	 */
	static int depth=1;
	private static TreeNode find(TreeNode root, int k) {
		if(root == null) {
			return null;
		}
		TreeNode value = find(root.left,k);
		
		if(value != null) {
			return value;
		}
		if(k == depth) {
			return root;
		}
		depth++;
		value = find(root.right, k);
		return value;
	}
	
	public static void main(String[] args) {
		
		tree.BinarySearchTree bst = new tree.BinarySearchTree();
		int[] array= {100,50,200,40,70,150,300,30,45};
		tree.BinarySearchTree.TreeNode root = bst.createBinarySearchTreeUsingArray(array);

		System.out.println(Find_Kth_Smallest_Element_Into_BST.find_Kth_Smallest_Element_Into_BST(root,3));
	}

}
