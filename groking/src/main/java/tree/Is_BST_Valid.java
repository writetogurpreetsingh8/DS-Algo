package tree;

import tree.BinaryTree.TreeNode;

public class Is_BST_Valid {

	private static boolean is_BST_Valid(TreeNode root) {

		if (root == null || (root.left == null && root.right == null)) {
			return true;
		}

		return extracted(root, null, null);
	}

	/**
	 * TC O(N)
	 * system stack O(max height of tree)
	 * aux-stack O(1)
	 * Based on pre-order (Left Right Root) 
	 * @param root
	 * @param low
	 * @param high
	 * @return
	 */
	private static boolean extracted(TreeNode root, Integer low, Integer high) {

		if (root == null) {
			return true;
		}

		boolean leftValid = extracted(root.left, low, root.value);
		boolean rightValid = extracted(root.right, root.value, high);

		if (low != null && root.value <= low) {
			return false;
		}
		if (high != null && root.value >= high) {
			return false;
		}
		return leftValid && rightValid;
	}

	public static void main(String[] args) {
		BinaryTree binaryTree = new BinaryTree();
		int array[] = { 100, 30, 200, 20, 50, 150, 300, 10, 21, 40 };

		TreeNode root = binaryTree.createBinaryTreeUsingArrayIterative(array);

		System.out.println(Is_BST_Valid.is_BST_Valid(root));
	}

}
