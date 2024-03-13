package tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import tree.BinaryTree.TreeNode;

public class ZigZag_BT_Traversal {

	/**
	 * TC O(N) because we are traversing all the nodes
	 * system stack O(1)
	 * aux-space O(max number of leafs in the tree)
	 * in BT max number of leafs would be depended on type of BT but
	 * here max number of leafs would be N/2
	 * @param root
	 * @return
	 */
	private static List<List<Integer>> zigZag_BT_Traversal(TreeNode root){
		
		if(root == null) {
			return Collections.emptyList();
		}
	
		TreeNode tempRoot = root;
		Deque<TreeNode> queue = new LinkedList<TreeNode>();
		List<List<Integer>> result = new ArrayList<>();
		int size;
		queue.offer(root);
		boolean reverse=false;
		while (!queue.isEmpty()) {
			size = queue.size();
			List<Integer> levelList = new ArrayList<>();
			for (int i = 0; i < size; i++) {
				if(!reverse) {
					tempRoot = queue.pollFirst();
					if (tempRoot.left != null) {
						queue.addLast(tempRoot.left); // node that is being deleting from queue add its left child into queue
						// for processing next level
					}
					if (tempRoot.right != null) { 
						queue.addLast(tempRoot.right); // node that is being deleting from queue add its left child into queue
						//for processing next level
					}
					levelList.add(tempRoot.value);
				}
				else {
					tempRoot = queue.pollLast();
					if (tempRoot.right != null) {
						queue.addFirst(tempRoot.right); // node that is being deleting from queue add its left child into queue
						// for processing next level
					}
					if (tempRoot.left != null) { 
						queue.addFirst(tempRoot.left); // node that is being deleting from queue add its left child into queue
						//for processing next level
					}
					levelList.add(tempRoot.value); // adding all the available of queue into list(values that available into queue
													// would represent the current level
				}
			}
			reverse = !reverse;
			result.add(levelList);
		}
		return result;
		
	}
	
	public static void main(String[] args) {
		BinaryTree binaryTree = new BinaryTree();
		int array[] = { 1,2,3,7,6,5,4,11,12,13,14,15,16,17,18};

		TreeNode root = binaryTree.createBinaryTreeUsingArrayIterative(array);

		System.out.println(ZigZag_BT_Traversal.zigZag_BT_Traversal(root));

	}

}
