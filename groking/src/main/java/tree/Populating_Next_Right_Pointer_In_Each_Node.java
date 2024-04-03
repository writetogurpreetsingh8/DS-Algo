package tree;

import tree.BinaryTree.TreeNode;

public class Populating_Next_Right_Pointer_In_Each_Node {

	
	private static TreeNode populating_Next_Right_Pointer_In_Each_Node(TreeNode root) {
		
		if(root == null || (root.left == null && root.right == null)) {
			return root;
		}
		
		TreeNode temp = root,t,p;
		while(temp.left != null) {
			t=temp;
			p = t.left;
			while(t != null) {
				t.left.next = t.right;
				p = t;
				t = t.next;
				if(t != null) {
					p.right.next = t.left;
				}
			}
			temp = temp.left;
		}
		return root;
		
	}
	public static void main(String[] args) {
		BinaryTree binaryTree = new BinaryTree();
		int array[] = { 1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
		int array1[] = { 1,2,3,4,5,6,7};

		TreeNode root = binaryTree.createBinaryTreeUsingArrayIterative(array1);
		System.out.println(root);
		System.out.println(Populating_Next_Right_Pointer_In_Each_Node.populating_Next_Right_Pointer_In_Each_Node(root));
	}

}
