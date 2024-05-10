package bst;

import bst.BinarySearchTree.TreeNode;

public class MirrorImg {

	private static void mirrorImg(TreeNode root) {
		if(root == null || (root.left == null && root.right == null)) {
			return;
		}
		mirrorImg(root.left);
		mirrorImg(root.right);
		TreeNode left = root.left;
		root.left = root.right;
		root.right = left;
	}
	
	public static void main(String[] args) {
		
		BinarySearchTree bst = new BinarySearchTree();
		int array[] = {20,9,5,7,8,1,0,30,25,40};
		TreeNode root = bst.createBinarySearchTreeUsingArray(array);
		System.out.println("root before mirror-img "+root);
		mirrorImg(root);
		System.out.println("root after mirror-img "+root);
	}

}
