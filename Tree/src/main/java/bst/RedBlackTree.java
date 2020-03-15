package bst;

import java.util.Scanner;

// RBT insertion , deletion and searching all operation have O(logn) TC
class RedBlackTree1{
	
	private Node root;
	
	public Node getRoot() {
		return root;
	}

	private class Node{
		
		private int data;
		private Node left;
		private Node right;
		private Node parent;
		private boolean isBlack; // true mean black and false means red;
		
		public Node(int data,Node parent, boolean isBlack) {
			super();
			this.data = data;
			this.parent = parent;
			this.isBlack = isBlack;
		}
	}
	
	
		private Node createNode(int data,boolean isBlack,Node parent) {
			return new Node(data,parent,isBlack);
		}
		
		public void createRedBlackTree() {
			
			Node p,q = null;
			Scanner scanner = new Scanner(System.in);
			
			System.out.println("enter root value for RBT");
			int value = scanner.nextInt();
			root = createNode(value, true, null);
			
			while(scanner.hasNextInt()) {
			
				System.out.println("enter child value for RBT or enter -1 for exit!");
				value = scanner.nextInt();
				if(value == -1 ) {
					break;
				}
				
				System.out.println("find approriate place to connect child with it's parent.....");
				p = root;
				
				while(p.data != value) {
					
					if(p.data > value) {
						q = p.left;
					}
					else if(p.data < value) {
						q = p.right;
					}
					if( q == null) {
						break;
					}
					p = q;
				}
				
				if(p.data > value) {
					p.left = createNode(value, false, p);
					fixationAfterInsertion(p.left);
				}
				else if(p.data < value) {
					p.right = createNode(value, false, p);
					fixationAfterInsertion(p.right);
				}
				else {
					System.out.println("duplicate value "+value+" are not allowed in RBT...........");
				}
				
			}
			System.out.println("end of RBTree..........");
		}
	
		// fix the RBT after every insertion 
		private void fixationAfterInsertion(Node node) {
		
			// parent node must not be root and parent node must be red.... so red-red parent child conflict , 
			// so resolve it.....
			
			while(!isRoot(node.parent) && !node.parent.isBlack) {
				
				Node uncle = findSiblingOfParent(node);
				
				// if uncle isn't null and uncle having red color just simple re-color
				// and check if the parent's  parent of new node is not the root then re-color the parent's parent of new-node also
				// and re-check it the root or until found black node
				if(uncle != null && !uncle.isBlack) {
					
					uncle.isBlack = !uncle.isBlack;
					node.parent.isBlack = !node.parent.isBlack;
					if(!isRoot(node.parent.parent)) {
						node.parent.parent.isBlack = !node.parent.parent.isBlack;
					}	
					node = node.parent.parent;
				}
				else {
					// if uncle is null or uncle is black then rotation is required after 
					// rotation re-color it
					performsRotations(node);
					break;
				}
			}
		}
		
		private boolean isRoot(Node node) {
			return node == null || node == root;
		}
		
		private Node findSiblingOfParent(Node node) {
			
			Node grandParent = node.parent.parent;
			if(grandParent.left == node.parent) {
				return grandParent.right;
			}else {
				return grandParent.left;
			}
		}
	
		private void performsRotations(Node node) {
			
			Node parent = node.parent;
			
			// nodes are exits at R - R location , so perform LL Rotation
			if(parent.right == node && parent.parent.right == parent) {
				leftRotation(node,true);
			}
			// nodes are exits at L - L location , so perform RR Rotation
			else if(parent.left == node && parent.parent.left == parent) {
				rightRotation(node,true);
			}
			// nodes are exits at L - R location , so adjust them in LL side before performing RR Rotation
			else if(parent.parent.left != null && parent.left != node) {
				
				parent.parent.left = node;
				node.parent = parent.parent;
				parent.right = node.left;
				node.left = parent;
				parent.parent = node;
				
				rightRotation(parent,true);
			}
			// nodes are exits at R - L location , so adjust them in RR side before performing LL Rotation
			else if(parent.parent.right != null && parent.right != node) {
				
				parent.parent.right = node;
				node.parent = parent.parent;
				parent.left = node.right;
				node.right = parent;
				parent.parent = node;
				
				leftRotation(parent,true);
			}
		}
		
		private void leftRotation(Node node,boolean isColorChanged) {
		
			Node parent = node.parent;
			Node parentLeft = parent.left;
			parent.left = parent.parent;
			Node parentToParentToParent = parent.left.parent;
			parent.left.parent = parent;
			parent.left.right = parentLeft;
			parent.parent = parentToParentToParent;
			if(parentLeft != null) {
				parentLeft.parent = parent.left;
			}
			if(parentToParentToParent != null) {
				
				if(parentToParentToParent.left == parent.left) {
					parentToParentToParent.left = parent;
				}
				else {
					parentToParentToParent.right = parent;
				}
			}
			else {
				root = parent;
			}
			if(isColorChanged) {
				parent.isBlack = !parent.isBlack;
				parent.left.isBlack = !parent.left.isBlack;
			}
		}

		private void rightRotation(Node node,boolean isColorChanged) {
			
			Node parent = node.parent;
			Node parentRight = parent.right;
			parent.right = parent.parent;
			Node parentToParentToParent = parent.right.parent;
			parent.right.parent = parent;
			parent.right.left = parentRight;
			parent.parent = parentToParentToParent;
			
			if(parentRight != null) {
				parentRight.parent = parent.right;
			}
			if(parentToParentToParent != null) {
				
				if(parentToParentToParent.right == parent.right) {
					parentToParentToParent.right = parent;
				}
				else {
					parentToParentToParent.left = parent;
				}
			}
			else {
				root = parent;
			}
			
			if(isColorChanged) {
				parent.isBlack = !parent.isBlack; 
				parent.right.isBlack = !parent.right.isBlack;
			}
		}
		
		public void deleteRBTNode(int nodeData) {
			
			Node q = root;
			
			if(root == null) {
				System.out.println("not root availabe in the tree!");
			}
			else{
				while(q != null && q.data != nodeData) {
			
					if(q.data > nodeData) {
						q = q.left;
					}
					else if(q.data < nodeData) {
						q = q.right;
					}
				}
				if( q != null) {
					delete(q);
				}
				else {
					System.out.println("element not found into Red-Black Tree.........");
				}
			}
		}
		
		private void delete(Node node) {
			
			// delete root node , if it is only available node into RBT
			if( (node.left == null && node.right == null && node.parent == null) ) {
				root = null;
			}
			//leaf node with red color , just delete it.
			else if( (node.left == null && node.right == null && !node.isBlack) ) {
				setChildToEmpty(node);
			}
			// in case of found double-black node at leaf leave into RBT
		/*
		 * else if( (node.left == null && node.right == null && node.isBlack) ) {
		 * fixAtDeletion(node); }
		 */
			// node having right child and left child, in this case find successor
			else {
				
				if(node.left != null && node.right != null){
				
					Node successorNode = successor(node);
					node.data = successorNode.data;
					//delete(node);
					node = successorNode;
				}
				
			// node having either left or right child
			//else {
				Node replacementNode = node.left != null ? node.left : node.right; 
				
				if(replacementNode != null) {
					
				if(node.parent == null) {
					root = replacementNode;
					root.isBlack = true;
				}
				else if(isLeftChild(node)) {
					replacementNode = node.left;
					node.parent.left = replacementNode;
				}
				else {
					replacementNode = node.right;
					node.parent.right = replacementNode;
				}
				replacementNode.parent = node.parent;
				
				if(node.isBlack && !replacementNode.isBlack) {
					replacementNode.isBlack = true;
				}
				else if(node.isBlack && replacementNode.isBlack) {
					delete(replacementNode);
				}
				}
				else {
					fixAtDeletion(replacementNode);
				}
			}	
			//}
		}
		
		private Node successor(Node node) {
			// TODO Auto-generated method stub
			return null;
		}

		private void fixAtDeletion(Node node) {
			
		}
		
		// check particular node was the left child or right child of it's parent.
		private boolean isLeftChild(Node node) {
			return node.parent.left == node ? true : false;
		}
		
		// set child to null either right child or left child
		private void setChildToEmpty(Node node) {
			
			if(isLeftChild(node)) {
				node.parent.left = null;
			}
			else {
				node.parent.right = null;
			}
		//	setNodeParentToEmpty(node);
			node.parent = null;
		}
		
		// set node.parent to null, to break the link from child to parent;
		private void setNodeParentToEmpty(Node node) {
		}
		
		public void inOrderTraversal() {
			inOrderTraversalForRBT(root);
		}
		
		private void inOrderTraversalForRBT(Node node) {
				
			if(node != null) {
			
				inOrderTraversalForRBT(node.left);
				System.out.println(node.data);
				inOrderTraversalForRBT(node.right);
			}
		}
}

	public class RedBlackTree {

		public static void main(String[] args) {

			RedBlackTree1 rbt = new RedBlackTree1();
			rbt.createRedBlackTree();
			rbt.inOrderTraversal();
		}
}
