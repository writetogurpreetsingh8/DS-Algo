package in.place.reverse.of.linkedList;

public class Reverse_Sub_List {
	
	private static Node reverseSubList(Node head, int left,int right) {
		
		 if(left <=0 || right <=0 || left>=right){
	            return head;
	        }
	        
		 	Node current=head,prev = null;
	        int i=0;
	        //reaching at p-1 nodes
	        while( i < left-1 && current != null){
	            prev = current;
	            current = current.next;
	            i++;
	        }
	        
	        //reversing nodes starting from p to q
	        int j=0;
	        Node temp=null,next = null,connect=current;
	        while(j < (right-left+1) && current != null){
	            next = current.next;
	            current.next = temp;
	            temp = current;
	            current = next;
	            j++;
	        }
	        
	        if(prev != null){
	            prev.next = temp;
	        }else{
	            head = temp;
	        }
	        connect.next = current;
	        return head;
}
		

	public static void main(String[] args) {
		int arr[] = {1,2,3,4,5};
		LinkingList list = new LinkingList();
		list.createLinkedList(arr,-1);
		Node head = list.getHead();
		head = reverseSubList(head,2,4);
		System.out.println(head);
	}

}
