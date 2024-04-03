package tree;
import java.util.Scanner;


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
	public TreeNode createBinarySearchTreeUsingArray(int array[]){
		
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
}