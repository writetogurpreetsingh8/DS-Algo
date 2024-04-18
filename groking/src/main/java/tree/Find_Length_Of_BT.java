package tree;

public class Find_Length_Of_BT {

	private static int find_Length_Of_BT(tree.BinarySearchTree.TreeNode root) {
		
		if(root == null) {
			return 0;
		}
		int lh = find_Length_Of_BT(root.left);
		int rh = find_Length_Of_BT(root.right);
		return Math.max(lh, rh)+1;
	}
	
	public static void main(String[] args) {
		BinarySearchTree binaryTree = new BinarySearchTree();
		int array[] = { 20,10,30,25,40,22,15,5,7,3,2};

		tree.BinarySearchTree.TreeNode root = binaryTree.createBinarySearchTreeUsingArray(array);

		System.out.println(Find_Length_Of_BT.find_Length_Of_BT(root));

	}

}
