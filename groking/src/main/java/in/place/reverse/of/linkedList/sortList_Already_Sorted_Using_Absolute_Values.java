package in.place.reverse.of.linkedList;

public class sortList_Already_Sorted_Using_Absolute_Values {

	/**
	 * TC O(N)
	 * SC O(1)
	 * @param head
	 */
	private static Node sortList_Already_Sorted_Using_Absolute_Value(Node head){
		
		if(head == null || head.next == null) {
			return head;
		}
		
		Node curr = head.next,prev = head;
		while(curr != null) {
			if(prev.data > curr.data) {
				prev.next = curr.next;
				curr.next = head;
				head = curr;
				curr = prev;
			}
			else {
				prev = curr;
				curr = curr.next;
			}
		}
		return head;
	}
	
	public static void main(String[] args) {
		int arr[] = {1,2,-3,4,-5};
		LinkingList list = new LinkingList();
		list.createLinkedList(arr,-1);
		Node head = list.getHead();
		System.out.println("before sorting "+head);
		head  = sortList_Already_Sorted_Using_Absolute_Value(head);
		System.out.println("after sorting "+head);
	}

}
