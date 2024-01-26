package fast.slow.pointer;

import java.util.Stack;



// non recursive approach........with stack........
public class CheckPalindromLinkedListNonRecursive {

	Stack<Integer> stack = new Stack<>();
	boolean isPalindorm = true;
	
	boolean checkPalindrom(Node node){
	
		Node next = node;
		Node current = node;
		
		if(node == null){
			return !isPalindorm;
		}
		if(node.next == null){
			return isPalindorm;
		}
		
		// finding middle element and stores the data into stack upto middle node
		while(next != null && next.next != null){
			stack.add(current.data);
			current = current.next;
			next = next.next.next;
		}
		//set the current pointer on middle+1 node
		if(next != null && next.next== null){
			current = current.next;
		}
		
		// fetch value from stack and mapped with current 
		while(current != null){
			if(stack.pop() != current.data){
				return !isPalindorm;
			}
			current = current.next;
		}
		return isPalindorm;
	}
	
	boolean checkPalindromList(LinkingList linkingList){
		return checkPalindrom(linkingList.getHead());
	}
	
	public static void main(String[] args) {
		int arr[] = {1,2,2,1};
		LinkingList list = new LinkingList();
		list.createLinkedList(arr,-1);
		System.out.println(new CheckPalindromLinkedListNonRecursive().checkPalindromList(list));
		
	}

}
