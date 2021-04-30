package recursion;

public class ReverseLinkedListRecursive {

	
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
		Node headNode = reverseLinkedList(list.getNext());
		list.getNext().setNext(list);
		list.setNext(null);
		return headNode;
		
	}
	
	
	Node reverseLinkedListHBI(Node list){
		if(list == null || list.getNext() == null) {
			return list;
		}
		
		Node temp = reverseLinkedListHBI(list.getNext());
		list.getNext().setNext(list);
		//list.getNext().setNext(temp1);
		list.setNext(null);
		return temp;
	}
	
	
	
	
	
	
	
	public static void main(String[] args) {
		
		recursion.LinkingList linkingList = new recursion.LinkingList();
		Node head = linkingList.createLinkedList();
		ReverseLinkedListRecursive linkedList = new ReverseLinkedListRecursive();
		System.out.println("before reverse the list "+head);
		head = linkedList.reverseLinkedList(head);
		//head = linkedList.reverseLinkedListHBI(head);
		System.out.println("after reverse the list "+head);
		System.out.println();
		

	}

}

