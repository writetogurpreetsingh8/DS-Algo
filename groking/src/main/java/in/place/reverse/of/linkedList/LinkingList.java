package in.place.reverse.of.linkedList;

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
	
	void createLinkedList(int array[],int createCycleOn){
		
		head = null;
		Node currentNode = null;
		Node cycleNode = null;
		
			for(int i=0;i<array.length;i++){
				if( i == 0 ){
					head = new Node();
					head.data = array[i];
					currentNode = head;
					if(createCycleOn == 0) {
						cycleNode = currentNode;
					}
				}
				else{
					Node nextNode = new Node();
					nextNode.data = array[i];
					currentNode.next = nextNode;
					currentNode = nextNode;
					if(createCycleOn > 0) {
						cycleNode = currentNode;
					}
					createCycleOn--;
				}
				size++;
			}
				currentNode.next = cycleNode;
		}
	
	Poly createPolynominalLinkedList(int coff[],int[] expo){
		
		Poly polyHead = null;
		Poly currentNode = null;
		
			for(int i=0;i<coff.length;i++){
				if( i == 0 ){
					polyHead = new Poly();
					polyHead.coff = coff[i];
					polyHead.expo = expo[i];
					currentNode = polyHead;
				}
				else{
					Poly nextNode = new Poly();
					nextNode.coff = coff[i];
					nextNode.expo = expo[i];
					currentNode.next = nextNode;
					currentNode = nextNode;
				}
			}
			return polyHead;
		}
}

class Node {
	
		public int data;
		public Node next;
		
		@Override
		public String toString() {
			return "data=" + data + ", next -> " + next;
		}

		public int getData() {
			return data;
		}

		public Node(int data, Node next) {
			super();
			this.data = data;
			this.next = next;
		}

		public Node() {
		}
		
}

class Poly {
	
	public int coff;
	public int expo;
	public Poly next;
	
	public int getCoff() {
		return coff;
	}
	public int getExpo() {
		return expo;
	}
	@Override
	public String toString() {
		return "coff=" + coff + ", expo=" + expo + ", next->" + next;
	}
	
	
	
}
