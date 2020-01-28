package bst;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {

	class TreeNode{
		
		public int value;
		public TreeNode left;
		public TreeNode right;
		
		public TreeNode(int value, TreeNode left, TreeNode right) {
			super();
			this.value = value;
			this.left = left;
			this.right = right;
		}
	}
	
	private TreeNode root;
	
	private TreeNode makeRootNode(int value) {
		
		return new TreeNode(value,null,null);
	}
	
	// time complexity would be O(n) and space complexity would be n for queue and n for set , 
	//so total space complexity is 2n = O(n)
	TreeNode createBinaryTreeUsingArrayIterative(int array[]){
		
		Queue<TreeNode> queue = new LinkedList<BinaryTree.TreeNode>();
		HashSet<Integer> set = new HashSet<Integer>();
		
		root = makeRootNode(array[0]);
		set.add(root.value);
		
		queue.add(root);
		TreeNode cur = null;
		
		for(int i=1;i<array.length;i++) {
			
			if(!set.contains(array[i])) {
				
				cur = queue.peek();
				if(cur.left == null) {
					cur.left = makeRootNode(array[i]);
					queue.add(cur.left);
					set.add(cur.left.value);
				}
				else {
					cur.right = makeRootNode(array[i]);
					queue.add(cur.right);
					set.add(cur.right.value);
					queue.poll();
				}
			}
			else {
				System.out.println("number "+array[i]+" found duplicate ,duplicates aren't allowed!");
			}
		}
		
		System.out.println("end of tree..........");
		return root;
	}
	
	
	void postOrderTraversalRecursive(TreeNode root) {
	
		if(root != null) {
			postOrderTraversalRecursive(root.left); // 2 p
			postOrderTraversalRecursive(root.right); //20
			System.out.println(root.value);
		}
	}
	
	void preOrderTraversalRecursive(TreeNode root) {
		
		if(root != null) {
			System.out.println(root.value);
			preOrderTraversalRecursive(root.left);
			preOrderTraversalRecursive(root.right);
		}
	}
	
	void inOrderTraversalRecursive(TreeNode root) {
		
		if(root != null) {
			inOrderTraversalRecursive(root.left);
			System.out.println(root.value);
			inOrderTraversalRecursive(root.right);
		}
	}
	// time complexity is O(n) and space is O(n)
	void inOrderTraversalInterative(TreeNode root){
		
		TreeNode tempRoot = root;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		
		do{
			while(tempRoot != null){
				stack.push(tempRoot);
				tempRoot = tempRoot.left;
			}
			tempRoot = stack.pop();
			System.out.println(tempRoot.value);
			tempRoot = tempRoot.right;
		}while(tempRoot != null || !stack.isEmpty());
	}
	
	// time complexity is O(n) and space is O(n)
	void preOrderTraversalInterative(TreeNode root){
		
		TreeNode tempRoot = root;
		
		Stack<TreeNode> stack = new Stack<TreeNode>();
		
		do{
			while(tempRoot != null){
				System.out.println(tempRoot.value);
				stack.push(tempRoot);
				tempRoot = tempRoot.left;
			}
			tempRoot = stack.pop();
			tempRoot = tempRoot.right;
		}while(tempRoot != null  || !stack.isEmpty());
	}
	
	// time complexity is O(n) and space is O(n)
	void levelWiseTraversalIterative(TreeNode root){
	
		TreeNode tempRoot = root;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		
		do{
			System.out.println(tempRoot.value);
			if(tempRoot.left != null){
				queue.add(tempRoot.left);
			}
			if(tempRoot.right != null){
				queue.add(tempRoot.right);
			}
			tempRoot = queue.poll();
		}while(tempRoot != null || !queue.isEmpty());
		
	}
	
	public static void main(String[] args) {
		
		BinaryTree binaryTree = new BinaryTree();
		int array[]= {100,40,50,200,10,10,20};
		
		TreeNode root = binaryTree.createBinaryTreeUsingArrayIterative(array);
		
		System.out.println(" post order traversal....");
		binaryTree.postOrderTraversalRecursive(root);
		
		System.out.println(" pre order traversal.......");
		binaryTree.preOrderTraversalRecursive(root);
		
		System.out.println(" in-order order traversal.......");
		binaryTree.inOrderTraversalRecursive(root);
		
		System.out.println("in - order traversal Iterative approach.........");
		
		binaryTree.inOrderTraversalInterative(root);

		System.out.println("pre - order traversal Iterative approach.........");
		binaryTree.preOrderTraversalInterative(root);
		
		System.out.println("level - wise traversal Iterative approach.........");

		binaryTree.levelWiseTraversalIterative(root);
		
	}
	
}