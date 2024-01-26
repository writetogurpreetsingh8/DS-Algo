package fast.slow.pointer;

public class LinkedList_Cycle_2 {

	private static Node detectCyle(Node head) {
		if(head == null || head.next == null){
            return null;
        }
        if(head == head.next){
            return head;
        }
        
        Node slow = head,fast = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                slow = head;
                while(fast != slow){
                    fast = fast.next;
                    slow = slow.next;
                }
                return fast;
            }
        }
        return null;
    }
	
	public static void main(String[] args) {
		
		int arr[] = {3,2,0,-4};
		LinkingList list = new LinkingList();
		list.createLinkedList(arr,0);
		Node head = list.getHead();
		//System.out.println(head);
		
		Node head1 = detectCyle(head);
		System.out.println(head1);
	}

}
