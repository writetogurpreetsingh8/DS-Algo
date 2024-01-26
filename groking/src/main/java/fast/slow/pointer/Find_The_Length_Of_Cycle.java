package fast.slow.pointer;

public class Find_The_Length_Of_Cycle {

	
	private static int findLengthOfCycle(Node head) {
		
		if(head == null || head.next == null){
            return 0;
        }
        if(head == head.next){
            return 1;
        }
        
		int len=0;
		Node slow=head,fast=head;
		
		while(fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			if(slow == fast) {
				len++;
				slow = slow.next;
				while(slow != fast) {
					len++;
					slow = slow.next;
				}
				return len;
			}
		}
		return 0;
	}
	
	public static void main(String[] args) {
		int arr[] = {3,2,0,-4};
		LinkingList list = new LinkingList();
		list.createLinkedList(arr,3);
		Node head = list.getHead();
		System.out.println(findLengthOfCycle(head));
	}

}
