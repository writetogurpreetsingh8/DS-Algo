package algo.practice;

public class ReverseLinkedListNonRecursive {

	
	void displayDataInReverseOrder(Node list){
	
		if(list.getNext() == null){
			return ;
		}
		displayDataInReverseOrder(list.getNext());
		System.out.println("reverse display data "+list.getData());
	}
	
	Node reverseLinkedList(Node list){
		
		if(list == null){
			return list;
		}
		if(list.getNext() == null){
			return list;
		}
		
		Node current = list;
		Node temp = null;
		Node next = null;
		Node prev = null;
		
		while(current != null){
			
			next = current.getNext();
			current.setNext(prev);
			prev = current;
			current = next;
		}
		return prev;
		
	}
	
	
	
	public static void main(String[] args) {
		
		LinkingList linkingList = new LinkingList();
		Node head = linkingList.createLinkedList();
		ReverseLinkedListNonRecursive linkedList = new ReverseLinkedListNonRecursive();
		System.out.println("before reverse the list "+head);
		head = linkedList.reverseLinkedList(head);
		System.out.println("after reverse the list "+head);
		System.out.println();
		

	}

}

