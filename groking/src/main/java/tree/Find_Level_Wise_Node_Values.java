package tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import tree.BinaryTree.TreeNode;

public class Find_Level_Wise_Node_Values {

	/**
	 * TC O(N)
	 * system stack O(1)
	 * aux-space O(max number of leafs in the tree)
	 * in BT max number of leafs would be depended on type of BT but
	 * here max number of leafs would be N/2
	 * @param root
	 * @return
	 */
	private static List<List<Integer>> returnLevelWiseNodeValues(TreeNode root) {
		
		if (root == null) {
			return Collections.emptyList();
		}
		
		TreeNode tempRoot = root;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		List<List<Integer>> result = new ArrayList<>();
		int size;
		queue.offer(root);
		while (!queue.isEmpty()) {
			size = queue.size();
			List<Integer> levelList = new ArrayList<>();
			for (int i = 0; i < size; i++) {
				tempRoot = queue.poll();
				levelList.add(tempRoot.value); // adding all the available of queue into list(values that available into queue
												// would represent the current level
				if (tempRoot.left != null) {
					queue.add(tempRoot.left); // node that is being deleting from queue add its left child into queue
					                          // for processing next level
				}
				if (tempRoot.right != null) { 
					queue.add(tempRoot.right); // node that is being deleting from queue add its left child into queue
                    						 //for processing next level
				}
			}
			result.add(levelList);
		}
		return result;
	}
	
	public static void main(String[] args) {
		BinaryTree binaryTree = new BinaryTree();
		int array[] = { 100, 40, 50, 200, 10, 20 };

		TreeNode root = binaryTree.createBinaryTreeUsingArrayIterative(array);

		System.out.println(Find_Level_Wise_Node_Values.returnLevelWiseNodeValues(root));
	}

}
