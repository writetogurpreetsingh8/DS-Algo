package in.place.reverse.of.linkedList;

public class MergeTwoSortedList {

	private static Node mergeTwoSortedList(Node firstHead,Node secHead) {
		
		if(firstHead == null) {
			return secHead;
		}
		
		if(secHead == null) {
			return firstHead;
		}
		
		
		Node newHead = new Node();
		Node dummyNode = newHead;
		while(firstHead != null && secHead != null) {
			
			if(firstHead.data > secHead.data) {
				newHead.next = secHead;
				secHead = secHead.next;
			}else {
				newHead.next = firstHead;
				firstHead = firstHead.next;
			}
			newHead = newHead.next;
		}
		
		if(secHead != null) {
			newHead.next = secHead;
		}else {
			newHead.next = firstHead;
		}
		return dummyNode.next;
	}
	
	public static void main(String[] args) {
		int arr1[] = {1,2,5,7,8,10};
		LinkingList list1 = new LinkingList();
		list1.createLinkedList(arr1, -1);
		Node head1 = list1.getHead();
		
		int arr2[] = {3};
		LinkingList list2 = new LinkingList();
		list2.createLinkedList(arr2, -1);
		Node head2 = list2.getHead();
		
		Node newMergedSortedList = mergeTwoSortedList(head1,head2);
		System.out.println(newMergedSortedList);
	}

}
