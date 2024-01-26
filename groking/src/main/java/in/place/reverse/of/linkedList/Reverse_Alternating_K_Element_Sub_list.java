package in.place.reverse.of.linkedList;

public class Reverse_Alternating_K_Element_Sub_list {

	private static Node reverse_Alternating_K_Element_Sub_list(Node header , int blocks) {
		
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
			
			int j=0;
			Node lessThenKthNode=current;
			for(;(j<blocks && current != null);j++) {
				prev = current;
				current = current.next;
			}
			
			if( j < blocks) {
				lessThenKthNode = reverseList(lessThenKthNode);
				joiner.next = lessThenKthNode;
			}
		}
		return header;
	}
	
	private static Node reverseList(Node subList) {
		
		Node prev = null,current = subList,next = null;
		while(current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		return prev;
	}
	
	public static void main(String[] args) {
		int arr[] = {1,2,3,4,5,6,7,8,9,10,11};
		LinkingList list = new LinkingList();
		list.createLinkedList(arr,-1);
		Node head = list.getHead();
		head = reverse_Alternating_K_Element_Sub_list(head,3);
		System.out.println(head);
	}

}
