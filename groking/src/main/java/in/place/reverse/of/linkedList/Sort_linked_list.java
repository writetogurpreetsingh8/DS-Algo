package in.place.reverse.of.linkedList;

public class Sort_linked_list {
	
	
	/**
	 * Insertion sort
	 * TC O(N^2)
	 * SC O(1) 
	 */
	
	private static Node sortedLinkedViaInsertionSort(Node head) {
		
		if(head == null || head.next == null) {
			return head;
		}
		
		Node newHead = head;
		head = head.next;
		newHead.next = null;
		Node temp = null,prev = null;
		
		while(head != null) {
			
			temp = newHead;
			prev = null;
			while(temp != null && temp.data < head.data) {
				prev = temp;
				temp = temp.next;
			}
			//{1,2,3,4,5,6};
			if(prev != null) {
				prev.next = head;
				head = head.next;
				prev.next.next = temp;
			}else {
				Node temp1 = head;
				head = head.next;
				temp1.next = temp;
				newHead = temp1;
			}
		}
		return newHead;
	}
	
	/**
	 * bubble sort
	 * TC O(N^2)
	 * SC O(1) 
	 */
	private static Node sortedLinkedViaBubbleSort(Node head) {
		
		int swapped = 0;
		Node curr = null,prev = null,next = null,end = null;
		do {
			curr = head;prev = null;
					next = head.next;
					swapped = 0;
					
			while(curr != end) {
				
				if(curr.data > next.data) {
					swapped++;
					if(prev != null) {
						curr.next = next.next;
						next.next = curr;
						prev.next = next;
					}else {
						curr.next = next.next;
						next.next = curr;
						head = next;
					}
					prev = next;
					next = curr.next;
				}else {
					prev = curr;
					curr = next;
					next = next.next;
				}
				
				if(curr.next == end)
				end = curr;
			}
			
		}while(swapped != 0);
		return head;
	}

	/**
	 * Sort linked list via mergeSort 
	 */
	private static Node sortLinkedSortViaMergeSort(Node head) {
		
		if(head == null || head.next == null) {
			return head;
		}
		Node mid = getMid(head);
		Node left = head;
		Node right = mid.next;
		mid.next = null;
		left = sortLinkedSortViaMergeSort(left);
		right = sortLinkedSortViaMergeSort(right);
		return mergeTwoSortedList(left,right);
	}
	
	private static Node mergeTwoSortedList(Node firstHead,Node secHead) {
		
		if(firstHead == null && secHead == null) {
			return null;
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

	private static Node getMid(Node head) {
		
		if(head == null || head.next == null || head.next.next == null) {
			return head;
		}
		
		Node slow = head, fast = head;
		do {
			slow = slow.next;
			fast = fast.next.next;
		}while(fast != null && fast.next != null);
		
		return slow;
	}
	
	public static void main(String[] args) {
		int arr[] = {10,3,2,5,6,7,5,1};
		LinkingList list = new LinkingList();
		list.createLinkedList(arr,-1);
		Node head = list.getHead();
		head = sortedLinkedViaInsertionSort(head);
		System.out.println(head);
		
		int arr1[] = {2,-1,0};
		list.createLinkedList(arr1,-1);
		Node head1 = list.getHead();
		head = sortedLinkedViaInsertionSort(head1);
		System.out.println(head);
	}

}
