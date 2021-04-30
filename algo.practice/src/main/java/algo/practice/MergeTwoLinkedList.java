package algo.practice;

public class MergeTwoLinkedList {

	/**
	 * 
	 * @param head1
	 * @param head2
	 */
	static Node mergeTwoSortedLinkedList(Node head1, Node head2) {
		
		if(head1 == null || head2 == null) {
			return null;
		}
		
		Node returnAbleHead = null;
		Node temp1 = head1 , temp2 = head2;
		Node ptr1 = temp1 , ptr2 = temp2;
		while(temp1 != null && temp2 != null) {
			
			while(temp2 != null && temp1 != null && temp2.getData() < temp1.getData()) {
				ptr2 = temp2;
				temp2 = temp2.getNext();
			}
			if(temp1 != null && ptr2.getData() < temp1.getData()) {
				ptr2.setNext(temp1);
				ptr1 = temp1;
				if(returnAbleHead == null) {
					returnAbleHead = head2;
				}
			}
			
			while(temp2 != null && temp1 != null && temp1.getData() < temp2.getData()) {
				ptr1 = temp1;
				temp1 = temp1.getNext();
			}
			if(temp2 != null && ptr1.getData() < temp2.getData()) {
				ptr1.setNext(temp2);
				ptr2 = temp2;
				if(returnAbleHead == null) {
					returnAbleHead = head1;
				}
			}
			
			if(temp1 != null && temp2 != null && temp1.getData() == temp2.getData()) {
				
				if(ptr2.getNext() == temp1) {
					ptr1 = temp1;
					temp1 = temp1.getNext();
					ptr1.setNext(temp2);
					ptr1 = temp1;
				}
				else {
					ptr2 = temp2;
					temp2 = temp2.getNext();
					ptr2.setNext(temp1);
					ptr2 = temp2;
				}
			}
		}
		return returnAbleHead;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int array1[] = {-10,-8,0,4,6,7,8,9};
		Node list1 = new LinkingList().createLinkedList(array1);
		System.out.println(list1);
		
		int array2[] = {-2,-1,3,8,10,11};
		Node list2 = new LinkingList().createLinkedList(array2);
		System.out.println(list2);
		
		System.out.println("after merging... "+MergeTwoLinkedList.mergeTwoSortedLinkedList(list1, list2));

	}

}
