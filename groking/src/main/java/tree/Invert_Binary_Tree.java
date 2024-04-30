package tree;

public class Invert_Binary_Tree {

	private static tree.BinarySearchTree.TreeNode invert_Binary_Tree(tree.BinarySearchTree.TreeNode root) {
		
		if(root == null) {
			return root;
		}
		
		tree.BinarySearchTree.TreeNode left = invert_Binary_Tree(root.left);
		tree.BinarySearchTree.TreeNode right = invert_Binary_Tree(root.right);
		root.left = right;
		root.right = left;
		return root;
	}

	public static void main(String[] args) {
		
		BinarySearchTree binaryTree = new BinarySearchTree();
		int array[] = { 20,13,65,34,0,12};

		tree.BinarySearchTree.TreeNode root = binaryTree.createBinarySearchTreeUsingArray(array);
		System.out.println(root);
		Invert_Binary_Tree.invert_Binary_Tree(root);
		System.out.println(root);
	}

}
