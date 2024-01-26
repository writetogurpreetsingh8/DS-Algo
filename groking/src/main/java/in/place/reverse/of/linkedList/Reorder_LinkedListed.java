package in.place.reverse.of.linkedList;


public class Reorder_LinkedListed {

	private static void reorderList(Node head) {
		
		if(head == null || head.next == null) {
			return;
		}
		if(head.next.next == null) {
			return;
		}
		
		Node middleNode = findMiddleNode(head);
		Node reverseHead = reverseFromMiddleNode(middleNode.next);
		Node temp = head,reverseHeadNext,headNext,prevNode=null;
		
		while(temp != null && reverseHead != null) {
				headNext = temp.next;
				temp.next = reverseHead;
				prevNode = reverseHead;
				reverseHeadNext = reverseHead.next;
				reverseHead.next = headNext;
				temp = headNext;
				reverseHead = reverseHeadNext;
		}
		if(temp.next == prevNode) {
			temp.next = null;
		}else {
			temp.next.next = null;
		}
	}
	
	private static Node findMiddleNode(Node head) {
		
		Node slow = head,fast = head;
		while(fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		return slow;
	}
	
	private static Node reverseFromMiddleNode(Node slow) {
		
		if(slow == null || slow.next == null) {
			return slow;
		}
		Node t = reverseFromMiddleNode(slow.next);
		slow.next.next = slow;
		slow.next = null;
		return t;
	}
	
	public static void main(String[] args) {
		int arr[] = {1,2,3,4,5,7};
		LinkingList list = new LinkingList();
		list.createLinkedList(arr,-1);
		Node head = list.getHead();
		reorderList(head);
		System.out.println(head);
	}
}
