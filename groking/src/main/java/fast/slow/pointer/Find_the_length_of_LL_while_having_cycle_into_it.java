package fast.slow.pointer;

public class Find_the_length_of_LL_while_having_cycle_into_it {

	private static int findLengthOfCyclicLinkedList(Node head) {
		
		if(head == null){
            return 0;
        }
		if(head.next == null){
			return 1;
		}
        if(head == head.next){
            return 1;
        }
        
        Node slow = head,fast = head;
        int len=0,slowMove=1,fastMove=0;
        //1,2,3,4,5,6,7,8,9,10
        while(fast != null && fast.next != null) {
        	slow = slow.next;
        	slowMove++; //1
        	fast = fast.next.next;
        	if(fast != null) {
        		fastMove++;
        	}
        	len = (len + slowMove + fastMove);//3
        	slowMove = 0;fastMove = 0; 
        	if(fast == slow) {
        		len = 1;
        		slow = slow.next;
        		while(slow != fast) {
        			len++;
        			slow=slow.next;
        		}
        		System.out.println("cyclic length "+len);
        		slow = head;
        		while(slow != fast) {
        			len++;
        			slow=slow.next;
        			fast = fast.next;
        		}
        		break;
        	}
        }
        return len;
	}
	public static void main(String[] args) {
		int arr[] = {1,2,3,4,5,6,7,8};
		LinkingList list = new LinkingList();
		list.createLinkedList(arr,2);
		Node head = list.getHead();
		System.out.println(findLengthOfCyclicLinkedList(head));
	}

}
