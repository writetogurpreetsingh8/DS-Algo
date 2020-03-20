package bst;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class BinarySearchTree {

	
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
	
	TreeNode createBinarySearchTreeUsingRecursive(){
		
		Scanner sanScanner = new Scanner(System.in);
		return createBinaryTreeUsingRecursive(sanScanner);
	}
	
	private TreeNode createBinaryTreeUsingRecursive(Scanner scanner) {
		
		System.out.println("enter node value(-1 for no value...)");
		int nodeValue = scanner.nextInt();
		
		if(nodeValue < 0) {
			return null;
		}
		TreeNode treeNode = makeRootNode(nodeValue);
		System.out.println("enter left child value for "+nodeValue);
		
		treeNode.left = createBinaryTreeUsingRecursive(scanner);
		
		System.out.println("enter right child value for "+nodeValue);
		
		treeNode.right = createBinaryTreeUsingRecursive(scanner);

		return treeNode;
	}
	
	// time complexity is O(n) and space is O(1)
	TreeNode createBinarySearchTreeUsingArray(int array[]){
		
		TreeNode p = null;
		TreeNode q = null;
		
		root = makeRootNode(array[0]);
		
		
		for(int i=1;i<array.length;i++) {
			
			q = p = root;
			while(p.value != array[i]) {
				
				if( array[i] > p.value ) {
					 q = p.right;
				}
				else if( array[i] < p.value) {
					 q = p.left;
				}
				if( q == null) {
					break;
				}
				p = q;
			}
				
			if(array[i] > p.value) {
				p.right = makeRootNode(array[i]);
			}
			else if(array[i] < p.value) {
				p.left = makeRootNode(array[i]);
			}
			else {
				System.out.println(array[i]+" duplicate values are not allowed into tree......");
			}
		}
		System.out.println("end of tree..........");
		return root;
		
	}
	
	// time complexity is O(n) and space is O(1)
	TreeNode createBinarySearchTreeIterative() {
		
		int value = 0;
		TreeNode p = null;
		TreeNode q = null;
		
		Scanner sanner = new Scanner(System.in);
		System.out.println("Enter root value...");
		
		value = sanner.nextInt();
		root = makeRootNode(value);
		
		System.out.println("enter child value....");
		
		while(sanner.hasNextInt()) {
			
			value = sanner.nextInt();
			if(value < 0) {
				break;
			}
			q = p = root;
			
			while(p.value != value) {
				
				if( value > p.value ) {
					 q = p.right;
				}
				else if( value < p.value) {
					 q = p.left;
				}
				if( q == null) {
					break;
				}
				p = q;
			}
				
			if(value > p.value) {
				p.right = makeRootNode(value);
			}
			else if(value < p.value) {
				p.left = makeRootNode(value);
			}
			else {
				System.out.println(value+" duplicate values are not allowed into tree......");
			}
		}
		System.out.println("end of tree..........");
		return root;
		
	}
	
	TreeNode createBinarySearchTreeRecursive() {
		
		TreeNode root = null;
		Scanner sanScanner = new Scanner(System.in);
		int nodeValue = 0;
		System.out.println("enter node value or enter -1 to exit!");
		while(sanScanner.hasNextInt()) {
			System.out.println("enter node value or enter -1 to exit!");
			nodeValue = sanScanner.nextInt();
			if(nodeValue == -1) {
				break;
			}
			root = insertNodeIntoBinarySearchTreeRecursively(root,nodeValue);
		}
		return root;
	}
	
	private TreeNode insertNodeIntoBinarySearchTreeRecursively(TreeNode root, int nodeValue) {
		
		if(root == null) {
			return makeRootNode(nodeValue);
		}
		if(root.value > nodeValue) {
			root.left = insertNodeIntoBinarySearchTreeRecursively(root.left,nodeValue);
		}
		else if(root.value < nodeValue) {
			root.right = insertNodeIntoBinarySearchTreeRecursively(root.right,nodeValue);
		}
		else {
			System.out.println("duplicate element( "+nodeValue+" ) isn't allowed into bst!");
		}
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
	
	void descTraversalRecursive(TreeNode root) {
		
		if(root != null) {
			descTraversalRecursive(root.right);
			System.out.println(root.value);
			descTraversalRecursive(root.left);
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
	
	void postOrderTraversalIterative(TreeNode root) {
		
		TreeNode temp = root;
		
		Stack<TreeNode> stack = new Stack<TreeNode>();
		
		do {
			
			while(temp != null) {
				stack.push(temp);
				temp = temp.left;
			}
			temp = stack.peek();
			if( temp.right == null) {
				System.out.println(temp.value);
				temp = stack.pop();
				
				while( ! stack.isEmpty() && temp == stack.peek().right) {
					temp = stack.pop();
					System.out.println(temp.value);
				}
			}
			if(!stack.isEmpty()) {
				temp = stack.peek().right;
			}
		}while(!stack.isEmpty());
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
		
		BinarySearchTree binarySearchTree = new BinarySearchTree();
		//int array[]= {100,40,50,200,10,20};
		int array[]= {50,30,70,20,45,65,90,10,22,41};
		
		TreeNode root = binarySearchTree.createBinarySearchTreeUsingArray(array);
		//binarySearchTree.createBinarySearchTree();
		//TreeNode root = binarySearchTree.createBinarySearchTreeUsingRecursive();
		
		//TreeNode root1 = binarySearchTree.createBinarySearchTreeRecursive();
		
		System.out.println(" post order traversal....");
		binarySearchTree.postOrderTraversalRecursive(root);
		
		System.out.println(" pre order traversal.......");
		binarySearchTree.preOrderTraversalRecursive(root);
		
		System.out.println(" in-order order traversal.......");
		binarySearchTree.inOrderTraversalRecursive(root);
		
		System.out.println(" desc-order order traversal.......");
		binarySearchTree.descTraversalRecursive(root);
		
		System.out.println("in - order traversal Iterative approach.........");
		
		binarySearchTree.inOrderTraversalInterative(root);

		System.out.println("pre - order traversal Iterative approach.........");
		binarySearchTree.preOrderTraversalInterative(root);
		
		System.out.println("level - wise traversal Iterative approach.........");

		binarySearchTree.levelWiseTraversalIterative(root);
		
		System.out.println("post - order traversal Iterative approach.........");

		binarySearchTree.postOrderTraversalIterative(root);
		
	}
	
	
}