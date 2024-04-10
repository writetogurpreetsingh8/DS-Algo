package tree;

import java.util.LinkedList;
import java.util.Queue;

import tree.BinaryTree.TreeNode;

public class Symmentric_Tree {

	
	private static boolean symmentric_Tree(TreeNode root) {
			
		if(root == null) {
			return false;
		}
		
		Queue<TreeNode> q = new LinkedList<BinaryTree.TreeNode>();
		
		q.offer(root.left);q.offer(root.right);
		TreeNode left , right;
		
		while(!q.isEmpty()) {
			
			left = q.poll();
			right = q.poll();
			
			if(left == null && right == null) {
				continue;
			}
			
			if(left == null && right !=null) {
				return false;
			}
			
			if(left != null && right == null) {
				
				return false;
			}
			if(left.value != right.value) {
				return false;
			}
			
			q.offer(left.left);
			q.offer(right.right);
			q.offer(left.right);
			q.offer(right.left);
		}
		return true;
	}
	
	public static void main(String[] args) {
		BinaryTree binaryTree = new BinaryTree();
		int array[] = { 1,2,2,3,4,4,3};

		TreeNode root = binaryTree.createBinaryTreeUsingArrayIterative(array);

		System.out.println(Symmentric_Tree.symmentric_Tree(root));

	}

}
