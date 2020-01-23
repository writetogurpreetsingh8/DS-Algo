package algo.practice;

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
	
	
	
	public static void main(String[] args) {
		
		LinkingList linkingList = new LinkingList();
		Node head = linkingList.createLinkedList();
		ReverseLinkedListRecursive linkedList = new ReverseLinkedListRecursive();
		System.out.println("before reverse the list "+head);
		head = linkedList.reverseLinkedList(head);
		System.out.println("after reverse the list "+head);
		System.out.println();
		

	}

}

