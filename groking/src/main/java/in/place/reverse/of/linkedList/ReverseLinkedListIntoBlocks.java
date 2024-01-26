package in.place.reverse.of.linkedList;


/**
 * 
 * @author Tony.Stark
 * Approach 1 & 2 both are same with same TC and SC 
 * but coding style is different.... 
 * and approach 3 has different logic 
 */
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

	

	/**
	 * TC O(N)
	 * SC O(1) 
	 */
	private static Node reverseLinkedListIntoBlocks1(int blocks) {
		
		if(header == null) {
			return header;// invalid case
		}
		
		if(blocks < 2) {
			System.out.println("Invalid block it should be greater than 1");
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
		if(join == null) {
			header = previous;
		}
		else { 
			join.next = previous;
			header = newHead;
		}	
		return header;
	}
	
	/**
	 * TC O(N)
	 * SC O(1) 
	 */
	private static Node reverseLinkedListIntoBlocks2(int blocks) {
		
		if(header == null || header.next == null) {
			return header;
		}
		if(blocks < 2) {
			System.out.println("Invalid block it should be greater than 1");
			return header; // invalid case, block must be atleast 2
		}
		
		Node current = header,next = null,prev = null,joiner=null,lastNodeOfPrevList=null;
		while(current != null) {
			
			joiner = current;
			lastNodeOfPrevList = prev;
			
			for(int i=0; (i < blocks && current != null); i++) {
				next = current.next;
				current.next = prev;
				prev = current;
				current = next;
			}
			
			if(lastNodeOfPrevList != null) {
				lastNodeOfPrevList.next = prev;
			}else {
				header = prev;
			}
			
			joiner.next = current;
			
			prev = joiner;
		}
		return header;
	}
	
	/**
	 * TC O(N)
	 * SC O(1) 
	 */
	private static Node reverseLinkedListIntoBlocks3(int blocks) {
		
		if(header == null || header.next == null) {
			return header;// invalid case
		}
		
		if(blocks < 2) {
			System.out.println("Invalid block it should be greater than 1");
			return header; // invalid case, block must be atleast 2
		}
		
		Node current = header, next = null , join = null, newHead = null;
		int i = 0;

		while(current != null) {
			i++;
			if( i % blocks != 0) {
				
				current = current.next;
			}else {
				next = current.next;
				Node rev = reverse(current,header);
				if(newHead == null) {
					newHead = rev;
				}else {
					join.next = rev;
				}
				join = header;
				join.next = next;
				header = next;
				current = next;
			}
			
		}
		return newHead;
	}
	
	private static Node reverse(Node last,Node begin) {
		
		Node next = null,prev = null;
		while(begin != last) {
			next = begin.next;
			begin.next = prev;
			prev = begin;
			begin = next;
		}
		if(prev != null) {
			begin.next = prev;
		}
		return begin;
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
		
		 
		System.out.println("before reversing into block linked list is ... "+header);
		System.out.println(ReverseLinkedListIntoBlocks.reverseLinkedListIntoBlocks1(3));
		
	}

}
