package recursion;

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
		
		for(int i=0;i<3;i++){
			if( i == 0 ){
				head = new Node();
				head.data = i;
				currentNode = head;
			}
			else{
				Node nextNode = new Node();
				nextNode.data = i;
				currentNode.next = nextNode;
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
					head.data = array[i];
					currentNode = head;
				}
				else{
					Node nextNode = new Node();
					nextNode.data = array[i];
					currentNode.next = nextNode;
					currentNode = nextNode;
				}
				size++;
			}
		}
}

class Node {
	
		public int data;
		public Node next;
		
		@Override
		public String toString() {
			return "data=" + data + ", next -> " + next;
		}
}
