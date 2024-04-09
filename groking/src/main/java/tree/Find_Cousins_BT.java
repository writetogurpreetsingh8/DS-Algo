package tree;

import java.util.Deque;
import java.util.LinkedList;

import tree.BinaryTree.TreeNode;

public class Find_Cousins_BT {
	
	/*
	 * TC O(N)
	 * system stack O(max height of tree)
	 * aux-space O(1)
	 */
	private static boolean find_Cousins_BT_Recursive(TreeNode root, int x, int y) {
		
		if(root == null) {
			return false;
		}
		
		TreeNode firstNode = findNode(root,x);
		TreeNode secondNode = findNode(root,y);
		
		if(firstNode != null && secondNode != null) {
			
			int firstLevel = findLevel(root,firstNode,0);
			int secondLevel = findLevel(root,secondNode,0);
			
			if(firstLevel == secondLevel) {
				return !isSiblings(root,firstNode,secondNode);
			}
		}
		return false;
	}
	
	private static TreeNode findNode(TreeNode root, int value) {
		
		if(root == null) {
			return root;
		}
		
		if(root.value == value) {
			return root;
		}
		
		TreeNode temp = findNode(root.left,value);
		
		if(temp != null) {
			return temp;
		}
		
		return findNode(root.right,value);
	}
	
	private static int findLevel(TreeNode root, TreeNode node , int level) {
		
		if(root == null) {
			return -1;
		}
		
		if(root == node) {
			return level;
		}
		int findLevel = findLevel(root.left, node, (level+1));
		if(findLevel != -1) {
			return findLevel;
		}
		return findLevel(root.right, node, (level+1));
	}
	
	private static boolean isSiblings(TreeNode root, TreeNode firstNode, TreeNode secondNode) {
		
		if(root == null) {
			return false;
		}
		return (((root.left == firstNode && root.right == secondNode) ||
				(root.left == secondNode && root.right == firstNode)) ||
				isSiblings(root.left, firstNode, secondNode) ||
				isSiblings(root.right, firstNode, secondNode));
	}

	/*
	 * TC O(N)
	 * system stack O(1)
	 * aux-space O(max height of tree)
	 */
	private static boolean find_Cousins_BT_Interative(TreeNode root, int x, int y) {
		
		if(root == null) {
			return false;
		}
		
		TreeNode temp=root, parent1=null, parent2=null;
		Deque<TreeNode> queue = new LinkedList<TreeNode>();
		int size;
		queue.offer(temp);
		
		while(!queue.isEmpty()) {
			size = queue.size();
			for(int i=0; i<size; i++) {
				temp = queue.poll();
				if(temp.left != null) {
					queue.add(temp.left);
					if(temp.left.value == x || temp.left.value == y) {
                        if(parent1 == null){
						    parent1 = temp;
                        }
                        else if(parent2 == null){
                            parent2 = temp;
                        }
					}
				}
				if(temp.right != null) {
					queue.add(temp.right);
					if(temp.right.value == x || temp.right.value == y) {
                        if(parent2 == null){
						    parent2 = temp;
                        }
                        else if(parent1 == null){
                            parent1 = temp;
                        }
					}
				}
			}
			if((parent1 !=null && parent2 !=null) && parent1 != parent2) {
				return true;
			}
			parent1=null;parent2=null;
		}
		return false;
	}
	
	public static void main(String[] args) {
		BinaryTree binaryTree = new BinaryTree();
		int array[] = { 1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
		int array1[] = { 1,2,3,4,5,6,7};

		TreeNode root = binaryTree.createBinaryTreeUsingArrayIterative(array1);

		System.out.println(Find_Cousins_BT.find_Cousins_BT_Interative(root, 5,7));
		System.out.println(Find_Cousins_BT.find_Cousins_BT_Recursive(root, 5,7));
	}

}
