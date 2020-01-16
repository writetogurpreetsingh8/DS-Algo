package tree.bst;

import java.util.Scanner;

public class BinarySearchTree {

	
	class TreeNode{
		
		private int value;
		private TreeNode left;
		private TreeNode right;
		
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
		return createBinarySearchTreeUsingRecursive1(sanScanner);
	}
	
	private TreeNode createBinarySearchTreeUsingRecursive1(Scanner scanner) {
		
		System.out.println("enter node value(-1 for no value...)");
		int nodeValue = scanner.nextInt();
		
		if(nodeValue < 0) {
			return null;
		}
		TreeNode treeNode = makeRootNode(nodeValue);
		System.out.println("enter left child value for "+nodeValue);
		
		treeNode.left = createBinarySearchTreeUsingRecursive1(scanner);
		
		System.out.println("enter right child value for "+nodeValue);
		
		treeNode.right = createBinarySearchTreeUsingRecursive1(scanner);

		return treeNode;
	}
	
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
	
	TreeNode createBinarySearchTree() {
		
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
	
	void postOrderTraversal(TreeNode root) {
	
		if(root != null) {
			postOrderTraversal(root.left); // 2 p
			postOrderTraversal(root.right); //20
			System.out.println(root.value);
		}
		
	}
	
	void preOrderTraversal(TreeNode root) {
		
		if(root != null) {
			System.out.println(root.value);
			preOrderTraversal(root.left);
			preOrderTraversal(root.right);
		}
	}
	
	void inOrderTraversal(TreeNode root) {
		
		if(root != null) {
			inOrderTraversal(root.left);
			System.out.println(root.value);
			inOrderTraversal(root.right);
		}
	}
	
	void descTraversal(TreeNode root) {
		
		if(root != null) {
			descTraversal(root.right);
			System.out.println(root.value);
			descTraversal(root.left);
		}
	}
}
