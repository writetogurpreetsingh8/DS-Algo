package fast.slow.pointer;

// recursive approach...............
public class CheckPalindromLinkedListRecursive {
	
	private static Node headHolder;
	private static boolean isPalindrome(Node head) {
	        
	        if(head.next == null){
	            return true;
	        }
	        headHolder = head;
	        return isPalindrome0(head);
	}
	    
	private static boolean isPalindrome0(Node rev){
	        
	        if(rev == null){
	            return true;
	        }
	        boolean isPalindrome = isPalindrome0(rev.next);
	        boolean accumalated = headHolder.data == rev.data ? true : false;
	        headHolder = headHolder.next;
	        return (isPalindrome && accumalated);
	}

	
	
	public static void main(String[] args) {
		int arr[] = {1,2,3,2,1};
		LinkingList list = new LinkingList();
		list.createLinkedList(arr,-1);
		Node head = list.getHead();
		System.out.println(isPalindrome(head));
	}

}
