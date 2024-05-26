package tree;

import java.util.Stack;

import tree.BinarySearchTree.TreeNode;


public class FindMaxElementFromBinaryTree {

	int findMaxIterative(TreeNode root) {
		
		int max = Integer.MIN_VALUE;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		if(root == null) {
			return max;
		}
		else {
			TreeNode q = root;
			do {
				while(q != null) {
				stack.push(q);
				q = q.left;
				}
				
				q = stack.pop();
				if(max < q.value) {
					max = q.value;
				}
				q = q.right;
			}while(q != null || !stack.isEmpty());
		}
		return max;
	}
	

	int findMaxRecursive(TreeNode root) {
		
		int max = Integer.MIN_VALUE;
		int value = 0;
		if(root != null) {
			
			value = root.value;
			max = findMaxIterative(root.left);
			max = findMaxIterative(root.right);
			
			if(max < value) {
				max = value;
			}
		}
		return max;
	}

	
	public static void main(String[] args) {

		BinarySearchTree binarySearchTree = new BinarySearchTree();
		int array[]= {100,40,2000,50,12,200,20,10,60,459};
		
		tree.BinarySearchTree.TreeNode root = binarySearchTree.createBinarySearchTreeUsingArray(array);
		
		FindMaxElementFromBinaryTree iterativeFindMaxElementFromBinaryTree = new  FindMaxElementFromBinaryTree();
		
		System.out.println(iterativeFindMaxElementFromBinaryTree.findMaxIterative(root));
		
		System.out.println(iterativeFindMaxElementFromBinaryTree.findMaxRecursive(root));
	}
}
