package tree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

import tree.BinaryTree.TreeNode;

public class Find_Level_Oder_Successor_BT {

	/**
	 * TC O(N) system stack O(1) aux-space O(max number of leafs in the tree) in BT
	 * max number of leafs would be depended on type of BT but here max number of
	 * leafs would be N/2
	 * 
	 * @param root
	 * @return
	 */
	private static int find_Level_Oder_Successor_BT(TreeNode root, int findSuccessorOfnodeValue) {

		int successorNodeValue=-1;
		
		if (root == null) {
			return successorNodeValue;
		}

		TreeNode tempRoot = root;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			tempRoot = queue.poll();
			if (tempRoot.left != null) {
				queue.add(tempRoot.left); // node that is being deleting from queue add its left child into queue
											// for processing next level
			}
			if (tempRoot.right != null) {
				queue.add(tempRoot.right); // node that is being deleting from queue add its left child into queue
											// for processing next level
			}
			if(tempRoot.value == findSuccessorOfnodeValue) {
				successorNodeValue = (queue.peek() != null) ? queue.peek().value : -1;
				break;
			}

		}
		return successorNodeValue;
	}

	public static void main(String[] args) {
		BinaryTree binaryTree = new BinaryTree();
		int array[] = { 100, 40, 50, 200, 10, 20,30};

		TreeNode root = binaryTree.createBinaryTreeUsingArrayIterative(array);

		System.out.println(Find_Level_Oder_Successor_BT.find_Level_Oder_Successor_BT(root,20));
		
		Deque<Integer> q = new LinkedList<Integer>();
	
		System.out.println(q);
		q.addFirst(4);
		q.addFirst(5);
		q.addFirst(6);
		q.addFirst(7);
		
		System.out.println(q);
		System.out.println(q.pollFirst());
		System.out.println(q);
		
		Deque<Integer> q1 = new LinkedList<Integer>();
		
		System.out.println(q1);
		q1.addLast(4);
		q1.addLast(5);
		q1.addLast(6);
		q1.addLast(7);
		
	
		System.out.println(q1);
		System.out.println(q1.pollFirst());
		System.out.println(q1);
		

	}

}
