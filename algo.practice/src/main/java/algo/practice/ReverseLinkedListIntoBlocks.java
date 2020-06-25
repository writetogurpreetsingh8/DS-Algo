package algo.practice;

public class ReverseLinkedListIntoBlocks {
	
	private static Node header;
	
	private static class Node{
		
		int element;
		Node next;
		
		private Node(int element, Node next) {
			
			super();
			this.element = element;
			this.next = next;
		}

		@Override
		public String toString() {
			return "Node [element=" + element + ", next=" + next + "]";
		}
		
		
		
	}

	// create linked-list method....add();
	private static void add(int element) {
		
		if(header == null)
		header = new Node(element,null);
		else{
			Node temp = new Node(element,null);
			Node base = header;
			
			while(base.next != null)
				base = base.next;
				base.next = temp;
		}
	}

	
	
	private static Node reverseLinkedListIntoBlocks(int blocks) {
		
		if(header == null) {
			return header;// invalid case
		}
		
		if(blocks < 2) {
			return header; // invalid case, block must be atleast 2
		}
		
		Node current = header, next = null , join = null, previous = null , newHead = null;
		int i = 0;

		while(current != null) {
			
			if( i < blocks) {
				
				next = current.next;
				current.next = previous;
				previous = current;
				current = next;
				i++;
				
			}else {
				if(newHead == null) {
					newHead = previous;
				}else {
					join.next = previous;
				}
				join = header;
				header = current; 
				previous = null;
				i=0;
			}
			
		}
		if(join != null) {
			join.next = previous;
		}
		if(newHead == null) {
			newHead = previous;
		}	
		header = newHead;
		return header;
	}
	
	
	public static void main(String[] args) {

		ReverseLinkedListIntoBlocks.add(1);
		ReverseLinkedListIntoBlocks.add(2);
		ReverseLinkedListIntoBlocks.add(3);
		ReverseLinkedListIntoBlocks.add(4);
		ReverseLinkedListIntoBlocks.add(5);
		ReverseLinkedListIntoBlocks.add(6);
		ReverseLinkedListIntoBlocks.add(7);
		ReverseLinkedListIntoBlocks.add(8);
		ReverseLinkedListIntoBlocks.add(9);
		ReverseLinkedListIntoBlocks.add(10);
		
		/*
		 * ReverseLinkedListIntoBlocksIterative.add(11);
		 * ReverseLinkedListIntoBlocksIterative.add(12);
		 * ReverseLinkedListIntoBlocksIterative.add(13);
		 * ReverseLinkedListIntoBlocksIterative.add(14);
		 * ReverseLinkedListIntoBlocksIterative.add(15);
		 * ReverseLinkedListIntoBlocksIterative.add(16);
		 */
		 
		 
		System.out.println("before reversing into block linked list is ... "+header);
		System.out.println(ReverseLinkedListIntoBlocks.reverseLinkedListIntoBlocks(4));
		
	}

}
