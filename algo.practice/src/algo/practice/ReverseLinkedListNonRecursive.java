package hacker.rank;

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
		
		Node current = null;
		Node temp = null;
		Node next = list;
		Node head = null;
		
		while(next != null && next.getNext() != null){
			
			if(head == null){
				head = temp;
			}else{
				head.setNext(temp);
			}
			current = next;
			next = next.getNext().getNext();
			temp = current.getNext();
			temp.setNext(current);
			current.setNext(null);
			temp = current;
		}
		if(next != null){
			
		}
		
		return head;
		
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

