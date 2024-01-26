package recursion;

public class ReverseLinkedListRecursive {

	
	void displayDataInReverseOrder(Node list){
	
		if(list.next == null){
			return ;
		}
		displayDataInReverseOrder(list.next);
		System.out.println("reverse display data "+list.data);
	}
	
	static Node reverseLinkedList(Node list){
		
		if(list == null){
			return list;
		}
		if(list.next == null){
			return list;
		}
		Node headNode = reverseLinkedList(list.next);
		list.next.next = list;
		list.next=null;
		return headNode;
		
	}
	
	public static void main(String[] args) {
		
		LinkingList linkingList = new LinkingList();
		Node head = linkingList.createLinkedList();
		System.out.println("before reverse the list "+head);
		head = reverseLinkedList(head);
		System.out.println("after reverse the list "+head);
		System.out.println();
		

	}

}

