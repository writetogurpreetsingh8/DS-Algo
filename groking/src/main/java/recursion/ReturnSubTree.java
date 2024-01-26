package recursion;

import recursion.BinarySearchTree.TreeNode;

public class ReturnSubTree {

	private static TreeNode searchBST(TreeNode root, int val) {
        
			if(root == null || root.value == val) {
				return root;
			}
			if(root.value > val) {
				return searchBST(root.left,val);
			}else {
				return searchBST(root.right,val);
			}
    }
	
	public static void main(String[] args) {

		BinarySearchTree bst = new BinarySearchTree();
		int[] array= {7,3,9,4,0,6,2,1};
		TreeNode root = bst.createBinarySearchTreeUsingArray(array);
		TreeNode re = searchBST(root,0);
		System.out.println(re);
		

	}

}
