package in.place.reverse.of.linkedList;


public class Remove_Nth_Node_From_End_of_List {
	
	 private static Node removeNthFromEnd(Node head, int n) {
	        
	        if( head == null){
	            return null;
	        }
	        if(head.next == null && n == 1){
	            return null;
	        }
	        
	        Node slow=head,fast = head,prev = head;
	        int c=1;
	        
	        while(fast != null){
	            fast = fast.next;
	            if(c>n){
	                prev = slow;
	                slow= slow.next;
	            }
	            c++;
	        }
	        if(c>n){
	            if(slow == prev){
	                head = slow.next;
	            }else{
	                prev.next = slow.next;
	            }
	        }else{
	            return null;
	        }
	        return head;
	    }
	 
	public static void main(String[] args) {
		int arr[] = {3,2,0,-4};
		LinkingList list = new LinkingList();
		list.createLinkedList(arr, -1);
		Node head = list.getHead();
		
		Node head1 = removeNthFromEnd(head,3);
		System.out.println(head1);
		//while((t = returnn(head)) != null) {
			//System.out.println("1 "+t);
		//}
	}

}
