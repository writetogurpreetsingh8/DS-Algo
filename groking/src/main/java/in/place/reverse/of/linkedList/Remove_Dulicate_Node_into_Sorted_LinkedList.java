package in.place.reverse.of.linkedList;

public class Remove_Dulicate_Node_into_Sorted_LinkedList {

	
	/**
	 * I/P = {1,2,2,3,4,4,4,5,6,7,7,7,8,9};
	 * O/P = data=1, next -> data=2, next -> data=3, next -> data=4, next -> data=5, next -> data=6, next -> data=7, next -> data=9, next -> null
	 */
	private static Node remove_Dulicate_Node_into_Sorted_LinkedList(Node head){
		
		if(head == null || head.next == null) {
			return head;
		}
		
		Node current = head,temp=null;
		
		while(current != null) {
			temp = current.next;
			while(temp != null && current.data == temp.data) {
				temp = temp.next;
			}
			current.next = temp;
			current = temp;
		}
		return head;
	}
	
	public static void main(String[] args) {
		int arr[] = {1,2,2,3,4,4,5,6,7,9};
		LinkingList list = new LinkingList();
		list.createLinkedList(arr, -1);
		Node head = list.getHead();
		
		Node head1 = remove_Dulicate_Node_into_Sorted_LinkedList(head);
		System.out.println(head1);
	}

}
