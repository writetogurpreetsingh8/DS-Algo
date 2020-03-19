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
		
		public void createRedBlackTree(int array[]) {
			
			root = createNode(array[0], true, null);
			Node p,q = null;
			for(int i=1;i<array.length;i++) {
				
				q = p = root;
				while(p.data != array[i]) {
					
					if( array[i] > p.data ) {
						 q = p.right;
					}
					else if( array[i] < p.data) {
						 q = p.left;
					}
					if( q == null) {
						break;
					}
					p = q;
				}
					
				if(p.data > array[i]) {
					p.left = createNode(array[i], false, p);
					fixationAfterInsertion(p.left);
				}
				else if(p.data < array[i]) {
					p.right = createNode(array[i], false, p);
					fixationAfterInsertion(p.right);
				}
				else {
					System.out.println("duplicate value "+array[i]+" are not allowed in RBT...........");
				}
			}
			
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
					performsRotations(node,true);
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
		
		private Node findSibilingOfDoubleBlack(Node node) {
			
			return node.parent != null ? node.parent.left == node ? node.parent.right : node.parent.left : null;
		}
	
		private void performsRotations(Node node,boolean isColorChanged) {
			
			Node parent = node.parent;
			
			// nodes are exits at R - R location , so perform LL Rotation
			if(parent.right == node && parent.parent.right == parent) {
				leftRotation(node,isColorChanged);
			}
			// nodes are exits at L - L location , so perform RR Rotation
			else if(parent.left == node && parent.parent.left == parent) {
				rightRotation(node,isColorChanged);
			}
			// nodes are exits at L - R location , so adjust them in LL side before performing RR Rotation
			else if(parent.parent.left != null && parent.left != node) {
				
				parent.parent.left = node;
				node.parent = parent.parent;
				parent.right = node.left;
				node.left = parent;
				parent.parent = node;
				
				rightRotation(parent,isColorChanged);
			}
			// nodes are exits at R - L location , so adjust them in RR side before performing LL Rotation
			else if(parent.parent.right != null && parent.right != node) {
				
				parent.parent.right = node;
				node.parent = parent.parent;
				parent.left = node.right;
				node.right = parent;
				parent.parent = node;
				
				leftRotation(parent,isColorChanged);
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
			
			//leaf node with red color , just delete it.
			if( (node.left == null && node.right == null && !node.isBlack) ) {
				setChildToEmpty(node);
			}
			else {
				// node having right child and left child, in this case find successor
				if(node.left != null && node.right != null){
				
					Node successorNode = successor(node);
					node.data = successorNode.data;
					node = successorNode;
				}
				
				// node having either left or right child
				Node replacementNode = node.left != null ? node.left : node.right; 
				
				if(replacementNode != null) {
					
				if(node.parent == null) {
					root = replacementNode;
				}
				else if(isLeftChild(node)) {
					node.parent.right = replacementNode;
				}
				else {
					node.parent.right = replacementNode;
				}
				replacementNode.parent = node.parent;
				
				if(node.isBlack && !replacementNode.isBlack) {
					// changing the node color red to black because we have deleted the black node having red child
					replacementNode.isBlack = true;
				}
				else if(node.isBlack && replacementNode.isBlack) {
					// double black condition
					fixAtDeletion(replacementNode);
				}
				}
				else if(node.parent == null) {
					root = null;
				}
				else {
					// double black condition
					if(node.isBlack) {
						fixAtDeletion(node);
					}
					else {
						setChildToEmpty(node);
					}
				}
			}	
		}
		
		private Node successor(Node node) {
			
			node = node.right;
			while(node.left != null) {
				node = node.left;
			}
			return node;
		}

		private void fixAtDeletion(Node node) {
			
			Node dbSibiling = null;
			
			while(node != root && node.isBlack) {
				
				dbSibiling = findSibilingOfDoubleBlack(node);
				
				//check for case 3
				if(dbSibiling.isBlack && ((dbSibiling.left == null && dbSibiling.right == null)
						|| (dbSibiling.left.isBlack && dbSibiling.right.isBlack)) ) {
					
					dbSibiling.isBlack = false;
					setChildToEmpty(node);
					//node.parent = null;
					
					if(!dbSibiling.parent.isBlack) {
						dbSibiling.parent.isBlack = true;
						node = root;
					}
					else {
						// re-apply the cases's
						node = dbSibiling.parent;
					}
				}// case 3 over
				
				// check for case 4
				else if(!dbSibiling.isBlack) {
					
					swapColor(dbSibiling);
					
					if(isLeftChild(dbSibiling)) {
						
						if(dbSibiling.left != null) {
							performsRotations(dbSibiling.left,false);
						}
						else {
							performsRotations(dbSibiling,false);
						}
					}
					else {
						
						if(dbSibiling.right != null) {
							performsRotations(dbSibiling.right,false);
						}
						else {
							performsRotations(dbSibiling,false);
						}
					}
				}// case 4 over
				
				// check for case 5 and 6 altogether
				else if(dbSibiling.isBlack) {
					
					// for left child
					if(isLeftChild(dbSibiling)) {
						
						//check dbsibling is black and far child is red, so apply case 6
						if(dbSibiling.left !=null  && !dbSibiling.left.isBlack) {
							
							swapColor(dbSibiling);
							dbSibiling.left.isBlack = true;
							performsRotations(dbSibiling.left,false);
							node = root;// termination condition
						}
						else {
							// apply case 5 only for left side........  // after apply case 5 definitely apply case 6
							swapColor(dbSibiling.right);
							if(dbSibiling.right.right != null) {
								performsRotations(dbSibiling.right.right,false);
							}
							else {
								performsRotations(dbSibiling.right,false);
							}
						}
					}
					else {
						// for right child, symentric case
						//check dbsibling is black and far child is red, so apply case 6
						if(dbSibiling.right !=null && !dbSibiling.right.isBlack) {
							
							swapColor(dbSibiling);
							dbSibiling.right.isBlack = true;
							performsRotations(dbSibiling.right,false);
							node = root;// termination condition
						}
						else {
							// apply case 5 only for right side........ // after apply case 5 definitely apply case 6
							swapColor(dbSibiling.left);
							if(dbSibiling.left.left != null) {
								performsRotations(dbSibiling.left.left,false);
							}
							else {
								performsRotations(dbSibiling.left,false);
							}
						}
					}
				}
				
			}
		}

		// swap colors between nodes.....
		private void swapColor(Node dbSibiling) {
			
			boolean color = dbSibiling.parent.isBlack;
			dbSibiling.parent.isBlack = dbSibiling.isBlack;
			dbSibiling.isBlack = color;
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
			node.parent = null;
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
		
		public void forfullyChangeTheNodeColor(int nodeValue,boolean isBlack) {
			
			Node temp = root;
			
			while(temp != null) {
				
				if(temp.data == nodeValue) {
					temp.isBlack = isBlack;
					break;
				}else if(temp.data > nodeValue) {
					temp = temp.left;
				}
				else {
					temp = temp.right;
				}
			}
		}
}

	public class RedBlackTree {

		public static void main(String[] args) {

			RedBlackTree1 rbt = new RedBlackTree1();
			//int array[]= {50,65,55,70,68,80,90,30,15,35};
			int array[]= {10,5,30,1,7,25,40,20,28};
			//rbt.createRedBlackTree();
			rbt.createRedBlackTree(array);
			rbt.inOrderTraversal();
			
			rbt.forfullyChangeTheNodeColor(20, true);
			rbt.forfullyChangeTheNodeColor(1, true);
			rbt.forfullyChangeTheNodeColor(7, true);
			rbt.forfullyChangeTheNodeColor(20, true);
			rbt.forfullyChangeTheNodeColor(28, true);
			rbt.forfullyChangeTheNodeColor(40, true);
			rbt.forfullyChangeTheNodeColor(30, true);
			rbt.forfullyChangeTheNodeColor(25, false);
			
			rbt.deleteRBTNode(1);
			
			rbt.inOrderTraversal();
		}
}
