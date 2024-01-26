package in.place.reverse.of.linkedList;

public class Add_Two_Integer_Given_As_LinkedList {

	/**
	 * TC O(max(size of list1,size of list2))
	 * SC O(max(size of list1,size of list2)) because we are creating new linked list
	 * stack space O(1)
	 * Each of their nodes contains a single digit.
	 * LeetCode #  2 Medium
	 * @param head1
	 * @param head2
	 * @return
	 */
	public static Node add_Two_Integer_Given_As_LinkedList(Node head1,Node head2) {
		
		if(head1 == null && head2 == null) {
			return null;
		}
		else if(head1 == null && head2 != null) {
				return head2;
		}else if(head2 == null && head1 != null) {
			return head1;
		}
		
		Node newHead = new Node();
		Node traveler = newHead;
		int carry=0,sum=0;
		
		while( head1 != null || head2 != null || carry !=0 ) {
			
			sum = (head1 != null ? head1.data : 0) + (head2 != null ? head2.data : 0) + carry;
			carry = sum / 10;
			sum = sum % 10;
			newHead.next = new Node(sum,null);
			newHead = newHead.next;
			head1 = head1 != null ? head1.next : null;
			head2 = head2 != null ? head2.next : null;
		}
		return traveler.next;
	}
	
	public static void main(String[] args) {
		int arr1[] = {2,4,3,4};
		LinkingList list1 = new LinkingList();
		list1.createLinkedList(arr1, -1);
		Node head1 = list1.getHead();	
		
		int arr2[] = {5,6,4,9};
		LinkingList list2 = new LinkingList();
		list2.createLinkedList(arr2, -1);
		Node head2 = list2.getHead();
		
		Node result = add_Two_Integer_Given_As_LinkedList(head1,head2);
		System.out.println(result);
	}

}
