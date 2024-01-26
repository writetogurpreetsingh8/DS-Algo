package in.place.reverse.of.linkedList;

public class Rotate_A_LinkedList {

	private static Node rotate_A_LinkedList(Node header, int k) {
	
		if(header == null || header.next == null || k <= 0) {
			return header;
		}
		
		Node current = header;
		int length=0;
		
		while(current != null) {
			length++;
			current = current.next;
		}
		
		int actualRotation = (k % length);
		
		if(actualRotation == 0) {
			return header;
		}
		
		actualRotation = length - actualRotation;
		
		Node prev = null, newHead = null;
		current = header;
		while(actualRotation > 1) {
			current = current.next;
			actualRotation--;
		}
		prev = current.next;
		newHead = prev;
		current.next = null;
		
		while(prev.next != null) {
			prev = prev.next;
		}
		
		prev.next = header;
		header = newHead;
		
		return header;
	}
	
	public static void main(String[] args) {
		int arr[] = {1,2,3,4,5,6,7,8,9,10};
		LinkingList list = new LinkingList();
		list.createLinkedList(arr,-1);
		Node head = list.getHead();
		head = rotate_A_LinkedList(head,12);
		System.out.println(head);
	}

}
