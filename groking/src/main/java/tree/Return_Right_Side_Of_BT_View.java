package tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import tree.BinarySearchTree.TreeNode;

public class Return_Right_Side_Of_BT_View {
	
	/**
	 * TC O(N) because we are traversing all the nodes
	 * system stack O(max height of tree)
	 * aux-space O(1)
	 * @param root
	 * @return
	 */
	private static List<Integer> return_Right_Side_Of_BT_View_Recursive(tree.BinarySearchTree.TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();
		return_Right_Side_Of_BT_View_Recursive0(root, result, 0);
		return result;
	}

	
	private static void return_Right_Side_Of_BT_View_Recursive0(TreeNode root, List<Integer> result, int level) {
			if(root == null ){
				return;
			}
			
			if(level == result.size()) {
				result.add(root.value);
			}
			return_Right_Side_Of_BT_View_Recursive0(root.right,result,level+1);
			return_Right_Side_Of_BT_View_Recursive0(root.left,result,level+1);
	}

	/**
	 * TC O(N) because we are traversing all the nodes
	 * system stack O(1)
	 * aux-space O(max number of leafs in the tree)
	 * in BT max number of leafs would be depended on type of BT but
	 * here max number of leafs would be N/2
	 * @param root
	 * @return
	 */
	private static List<Integer> return_Right_Side_Of_BT_View_Iterative(tree.BinarySearchTree.TreeNode root) {

		if (root == null) {
			return Collections.emptyList();
		}

		Queue<tree.BinarySearchTree.TreeNode> q = new LinkedList<>();
		List<Integer> result = new ArrayList<>();
		int size;
		tree.BinarySearchTree.TreeNode temp=null;
		q.offer(root);

		while (!q.isEmpty()) {
			size = q.size();
			for (int i = 0; i < size; i++) {
				temp = q.poll();
				if (temp.left != null)
					q.offer(temp.left);
				if (temp.right != null)
					q.offer(temp.right);
			}
			result.add(temp.value);
		}
		return result;
	}

	public static void main(String[] args) {
		
		BinarySearchTree binarySearchTree = new BinarySearchTree();
		
		int array[] = { 13, 1,2,3,7,6,5,4,11,12,14,15,16,17,18};
		tree.BinarySearchTree.TreeNode root = binarySearchTree.createBinarySearchTreeUsingArray(array);
		
		int array1[] = { 1,2,3,4,5,6,7,8,9,10};
		tree.BinarySearchTree.TreeNode root1 = binarySearchTree.createBinarySearchTreeUsingArray(array1);
		
		System.out.println(Return_Right_Side_Of_BT_View.return_Right_Side_Of_BT_View_Iterative(root1));
		
		System.out.println(Return_Right_Side_Of_BT_View.return_Right_Side_Of_BT_View_Recursive(root1));
	}

}
