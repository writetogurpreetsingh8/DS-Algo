package tree;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {

	class TreeNode {

		public int value;
		public TreeNode left;
		public TreeNode right;
		public TreeNode next;

		public TreeNode(int value, TreeNode left, TreeNode right) {
			super();
			this.value = value;
			this.left = left;
			this.right = right;
		}

		@Override
		public String toString() {
			return "TreeNode [value=" + value + ", left=" + left + ", right=" + right + ", next=" + next + "]";
		}
		
	}

	private TreeNode root;

	private TreeNode makeRootNode(int value) {

		return new TreeNode(value, null, null);
	}

	// time complexity would be O(n) and space complexity would be n for queue and n
	// for set ,
	// so total space complexity is 2n = O(n)
	TreeNode createBinaryTreeUsingArrayIterative(int array[]) {

		Queue<TreeNode> queue = new LinkedList<BinaryTree.TreeNode>();
		HashSet<Integer> set = new HashSet<Integer>();

		root = makeRootNode(array[0]);
		set.add(root.value);

		queue.add(root);
		TreeNode cur = null;

		for (int i = 1; i < array.length; i++) {

			if (!set.contains(array[i])) {

				cur = queue.peek();
				if (cur.left == null) {
					cur.left = makeRootNode(array[i]);
					queue.add(cur.left);
					set.add(cur.left.value);
				} else {
					cur.right = makeRootNode(array[i]);
					queue.add(cur.right);
					set.add(cur.right.value);
					queue.poll();
				}
			} else {
				System.out.println("number " + array[i] + " found duplicate ,duplicates aren't allowed!");
			}
		}

		System.out.println("end of tree..........");
		return root;
	}

}