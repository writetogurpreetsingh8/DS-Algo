package recursion;

public class SwapLinkedListInFaires {

	public static Node swapLinkedListInFaires(Node head) {
		
		if(head == null || head.next == null) {
			return head;
		}
		Node ret = swapLinkedListInFaires(head.next.next);
		Node save = head.next;
		head.next = ret;
		save.next = head;
		return save;
	}
	
	public static void main(String[] args) {
		
		LinkingList list = new LinkingList();
		int[] array= {1,2,3,4,5,6,7};
		list.createLinkedList(array);
		Node node = list.getHead();
		System.out.println("before swaping "+node);
		System.out.println(swapLinkedListInFaires(node));	

	}

}
