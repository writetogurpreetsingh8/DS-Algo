package in.place.reverse.of.linkedList;

public class Divide_List_into_SubList_Based_Upon_N {

	/**
	    TC O(N)
	    SC O(1)
	    If ‘n’ is even, reverse the list in a group of n/2 nodes.
	    If n is odd, keep the middle node as it is, reverse the first ‘n/2’ nodes and reverse the last ‘n/2’ nodes.
	    Painter_Allocation: When ‘n’ is even we can perform the following steps:

		Reverse first ‘n/2’ nodes: head = reverse(head, 1, n/2)
		Reverse last ‘n/2’ nodes: head = reverse(head, n/2 + 1, n)
		When ‘n’ is odd, our algorithm will look like:

		head = reverse(head, 1, n/2)
		head = reverse(head, n/2 + 2, n)
		Please note the function call in the second step. 
		We’re skipping two elements as we will be skipping the middle element. 
	*/
	
	private static Node divide_List_into_SubList_Based_Upon_N(Node header , int N) {
		if(header == null || header.next == null || 
				N <= 3) {
			return header;
		}
		
		Node current = header,prev=null;
		int i=0;
		while(i < N/2) {
			prev = current;
			current = current.next;
			i++;
		}
		Node firstReverseSubListHeader = reverseSubList(header,prev);
		
		if( (N & 1) != 0 ) {
			prev = current;
			current = current.next;
			prev.next = null;
		}
		
		Node secondReverseSubListHeader = reverseSubList(current,null);
		
		if( (N & 1) != 0 ) {
			header.next = prev;
			prev.next = secondReverseSubListHeader;
		}else {
			header.next = secondReverseSubListHeader;
		}
		
		return header = firstReverseSubListHeader;
	}
	
	private static Node reverseSubList(Node start,Node end) {
		Node next=null , prev = null;
		while(start != end) {
			next = start.next;
			start.next = prev;
			prev = start;
			start = next;
		}
		if(prev != null && start != null) {
			start.next = prev;
		}
		else {
			start = prev;
		}
		return start;
	}
	
	public static void main(String[] args) {
		int arr[] = {1,2,3,4,5};
		LinkingList list = new LinkingList();
		list.createLinkedList(arr,-1);
		Node head = list.getHead();
		head = divide_List_into_SubList_Based_Upon_N(head,5);
		System.out.println(head);
	}

}
