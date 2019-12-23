package algo.practice;

public class LinkingList{
	
	private int size = 0;
	Node head = null;
	
	public int getSize() {
		return size;
	}

	public int length(){
		return size;
	}
	
	public Node getHead(){
		return head;
	}
	
	Node createLinkedList(){
		
	head = null;
	Node currentNode = null;
		
		for(int i=0;i<5;i++){
			if( i ==0 ){
				head = new Node();
				head.setData(i);
				currentNode = head;
			}
			else{
				Node nextNode = new Node();
				nextNode.setData(i);
				currentNode.setNext(nextNode);
				currentNode = nextNode;
			}
			size++;
		}
		return head;
	}
	
	void createLinkedList(int array[]){
		
		head = null;
		Node currentNode = null;
			
			for(int i=0;i<array.length;i++){
				if( i ==0 ){
					head = new Node();
					head.setData(array[i]);
					currentNode = head;
				}
				else{
					Node nextNode = new Node();
					nextNode.setData(array[i]);
					currentNode.setNext(nextNode);
					currentNode = nextNode;
				}
				size++;
			}
		}

	
	
}

class Node {
	
		private int data;
		private Node next;
		
		public Node getNext() {
			return next;
		}
		public void setNext(Node node) {
			this.next = node;
		}
		public int getData() {
			return data;
		}
		public void setData(int data) {
			this.data = data;
		}
		@Override
		public String toString() {
			return "data=" + data + ", next -> " + next;
		}
}
