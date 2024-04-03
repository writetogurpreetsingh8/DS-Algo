package tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import tree.BinaryTree.TreeNode;

public class Binary_Tree_Level_Order_Traversal_II {
	
	private static List<List<Integer>> binary_Tree_Level_Order_Traversal_II_Recursive(TreeNode root){
		
		if(root == null) {
			return Collections.emptyList();
		}
		List<List<Integer>> result = new ArrayList<>();
		recursiveSol(result,root,0);
		Collections.reverse(result);
		return result;
	}
	
	/**
	 * TC O(N)
	 * system stack O(logN)
	 * aux-space O(1)
	 */
	private static void recursiveSol(List<List<Integer>> result, TreeNode node, int depth) {
		if(node == null) {
			return;
		}
		
		if(result.size() == depth) {
			result.add(new ArrayList<>());
		}
		result.get(depth).add(node.value);
		recursiveSol(result, node.left, depth+1);
		recursiveSol(result, node.right, depth+1);
	}
	
	/**
	 * TC O(N) if we ignore the complexity of list.add(0,element) otherwise the complexity of list.add(0,element)  + 
	 * the complexity of our logic would be TC O(N^2)
	 * system stack O(1)
	 * aux-space O(max number of leafs in the tree)
	 * in BT max number of leafs would be depended on type of BT but
	 * here max number of leafs would be N/2
	 * @param root
	 * @return
	 */
	private static List<List<Integer>> binary_Tree_Level_Order_Traversal_II_Iterative(TreeNode root){
		
		if(root == null) {
			return Collections.emptyList();
		}
		
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		List<List<Integer>> result = new ArrayList<>();
		TreeNode temp;
		queue.offer(root);
		int size=0;
		while(!queue.isEmpty()) {
			size = queue.size();
			List<Integer> levels = new ArrayList<Integer>();
			for (int i = 0; i < size; i++) {
				temp = queue.poll();
				levels.add(temp.value);
				if(temp.left != null) {
					queue.offer(temp.left);
				}
				if(temp.right != null) {
					queue.offer(temp.right);
				}
			}
			result.add(0,levels); // instead of adding into 0th index every time we can directly add element into list
								 // and at the end just Collectios.reverse(); the list
		}
		return result;
	}
	
	public static void main(String[] args) {
		BinaryTree binaryTree = new BinaryTree();
		int array[] = { 3,9,20,15,7};

		TreeNode root = binaryTree.createBinaryTreeUsingArrayIterative(array);

		System.out.println(Binary_Tree_Level_Order_Traversal_II.binary_Tree_Level_Order_Traversal_II_Iterative(root));
		System.out.println(Binary_Tree_Level_Order_Traversal_II.binary_Tree_Level_Order_Traversal_II_Recursive(root));
	}

}
