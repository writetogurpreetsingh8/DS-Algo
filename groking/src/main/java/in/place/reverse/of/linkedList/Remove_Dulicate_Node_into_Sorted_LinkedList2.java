package in.place.reverse.of.linkedList;

public class Remove_Dulicate_Node_into_Sorted_LinkedList2 {

	/**
	 * I/P =  {1,1,2,3,4,5,5,6};
	 * O/P =  data=2, next -> data=3, next -> data=4, next -> data=6, next -> null
	 */
	private static Node remove_Dulicate_Node_into_Sorted_LinkedList2(Node head){

		Node current = head,prev=null;
		
		while(current != null && current.next != null) {
			
			if(current.data != current.next.data) {
				prev = current;
			}else {
				while(current.next != null && current.data == current.next.data) {
					current = current.next;
				}
				if(prev != null) {
					prev.next = current.next;
				}else {
					head = current.next;
				}
			}
			current = current.next;
			
		}
		return head;
	}
	
	public static void main(String[] args) {
		int arr[] = {1,1,2,3,4,5,5,6};
		LinkingList list = new LinkingList();
		list.createLinkedList(arr, -1);
		Node head = list.getHead();
		
		Node head1 = remove_Dulicate_Node_into_Sorted_LinkedList2(head);
		System.out.println(head1);
	}

}
