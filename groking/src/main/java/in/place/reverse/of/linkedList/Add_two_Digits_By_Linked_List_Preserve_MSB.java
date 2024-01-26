package in.place.reverse.of.linkedList;


public class Add_two_Digits_By_Linked_List_Preserve_MSB {

	
	/**
	 * TC O(N + M + D)
	 * SC O(1)
	 * stack space O(1) 
	 */
	public static Node add_two_Digits_By_Linked_List_Preserve_MSB2(Node head1,Node head2) {
		
		if(head1 == null && head2 == null) {
			return null;
		}
		else if(head1 == null && head2 != null) {
				return head2;
		}else if(head2 == null && head1 != null) {
			return head1;
		}
		int firstInt = convertLinkedListIntoInteger(head1); // O(N)
		int secInt = convertLinkedListIntoInteger(head2); // O(M)
		int finalInt = firstInt + secInt;
		int rem=0;
		Node dummy = new Node(0,null);
		Node temp = null;
		
		while(finalInt > 0) { // O(D)
			rem = finalInt % 10;
			Node newNode = new Node(rem,null);
			temp = dummy.next;
			dummy.next = newNode;
			newNode.next = temp;
			finalInt = finalInt / 10;
		}
		return dummy.next;
	}
	
	private static int convertLinkedListIntoInteger(Node head) {
		int multi=0;
		while(head != null) {
			multi=(multi*10)+head.data;
			head = head.next;
		}
		return multi;
	}
	
	/**
	 * TC O(N+M)
	 * SC O(1)
	 * stack space O(1)
	 * 
	 * There is another solution in which we use Stack -> 
	 * https://leetcode.com/problems/add-two-numbers-ii/discuss/2302501/C%2B%2B-or-Stack-or-easy-understanding-or-simple-solution
	 */
	public static Node add_two_Digits_By_Linked_List_Preserve_MSB1(Node head1,Node head2) {
		
		if(head1 == null && head2 == null) {
			return null;
		}
		else if(head1 == null && head2 != null) {
				return head2;
		}else if(head2 == null && head1 != null) {
			return head1;
		}
		// find lenght of both the list
		int l1 = getLength(head1);
		int l2 = getLength(head2);
		int difference = Math.abs(l1-l2);
		Node longL = null, shortL = null;
		
		if(l1 > l2) {
			longL = head1;
			shortL = head2;
		}else {
			longL = head2;
			shortL = head1;
		}
		
		Node dummyTemp = new Node(0,shortL);
		Node temp = null;
		// prefix the zero's with shorter list only and make it equal length with longer list
		while(difference > 0) {
			Node prefixZero = new Node(0,null);
			temp = dummyTemp.next;
			dummyTemp.next = prefixZero;
			prefixZero.next = temp;
			difference--;
		}
		
		// add the digits recursively
		Node dummy = new Node();
		int carry = recursivelyAddingDigits(dummyTemp.next,longL,dummy);
		
		if(carry > 0) {
			temp = dummy.next;
			dummy.next = new Node(carry,null);
			dummy.next.next = temp;			
		}
		
		return dummy.next;
	}
	
	private static int recursivelyAddingDigits(Node head1, Node head2, Node dummy) {
		
			if(head1 == null) {
				return 0;
			}
		int result = recursivelyAddingDigits(head1.next,head2.next,dummy);
		int sum = head1.data + head2.data + result;
		int carry = sum / 10;
		Node newNode = new Node(sum%10,null);
		Node temp = dummy.next;
		dummy.next = newNode;
		newNode.next = temp;
		return carry;
	}

	/**
	 * TC O(N)
	 * SC O(1) 
	 */
	private static int getLength(Node head) {
		int count=0;
		while(head != null) {
			count++;
			head = head.next;
		}
		return count;
	}
	
	public static void main(String[] args) {
		
		int arr1[] = {2,4,3,4};
		LinkingList list1 = new LinkingList();
		list1.createLinkedList(arr1, -1);
		Node head1 = list1.getHead();	
		
		int arr2[] = {6,7,5,6,4,9};
		LinkingList list2 = new LinkingList();
		list2.createLinkedList(arr2, -1);
		Node head2 = list2.getHead();
		//      2,4,3,4
		//  6,7,5,6,4,9
		//+     8 0 8 3
		//Node result = add_two_Digits_By_Linked_List_Preserve_MSB1(head1,head2);
		Node resultt = add_two_Digits_By_Linked_List_Preserve_MSB2(head1,head2);
		System.out.println(resultt);
		
		int arr3[] = {1};
		LinkingList list3 = new LinkingList();
		list3.createLinkedList(arr3, -1);
		Node head3 = list3.getHead();	
		
		int arr4[] = {9,9};
		LinkingList list4 = new LinkingList();
		list4.createLinkedList(arr4, -1);
		Node head4 = list4.getHead();
		//      2,4,3,4
		//  6,7,5,6,4,9
		//+     8 0 8 3
		//Node result1 = add_two_Digits_By_Linked_List_Preserve_MSB1(head3,head4);
		Node resulttt = add_two_Digits_By_Linked_List_Preserve_MSB2(head4,head3);
		System.out.println(resulttt);
		
	}

}
