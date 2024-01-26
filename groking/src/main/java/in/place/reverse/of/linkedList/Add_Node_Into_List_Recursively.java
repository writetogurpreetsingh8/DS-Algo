package in.place.reverse.of.linkedList;

public class Add_Node_Into_List_Recursively {

	private static Node add_Node_Into_List_Recursively(Node head,int index,int value) {
		
		if(head == null || index <= 0) {
			return head;
		}
		
		if(index == 1) {
			Node newNode = new Node();
			newNode.data = value;
			newNode.next = head;
			return newNode;
		}
		Node n = add_Node_Into_List_Recursively(head.next,--index,value);
		head.next = n;
		return head;
	}
	
	public static void main(String[] args) {
		int arr[] = {1};
		LinkingList list = new LinkingList();
		list.createLinkedList(arr,-1);
		Node head = list.getHead();
		head = add_Node_Into_List_Recursively(head,1,100);
		System.out.println(head);
	}

}
