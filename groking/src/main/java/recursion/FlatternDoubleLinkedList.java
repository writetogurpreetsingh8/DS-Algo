package recursion;

import recursion.DLinkedList.Node;

class DLinkedList{

	static class Node {
		
		public int data;
		public Node next;
		public Node prev;
		public Node child;
		
		public Node(int data, Node next, Node prev, Node child) {
			super();
			this.data = data;
			this.next = next;
			this.prev = prev;
			this.child = child;
		}

		/*
		 * @Override public String toString() { return "Node [data=" + data + ", next="
		 * + next + ", prev=" + prev + ", child=" + child + "]"; }
		 */
	}

}

class FlatternDLinkedList{
	
	public static Node flatten(Node head) {
	       Node temp = head;
	       Node tempNext = null;
	       if(temp == null || temp.next == null)
	           return temp;
	       Node child = temp.child;
	       if(child!=null){
	          tempNext= temp.next;
	           temp.next = child;
	           child.prev = temp;
	           temp=child;
	       }
	       else{
	           temp=temp.next;
	       }
	       Node lastElement = flatten(temp);
	       lastElement.next = tempNext;
	       if(tempNext != null)
	           tempNext.prev = lastElement;
	       temp=tempNext;
	       lastElement = flatten(temp);
	       return head;
	   }
	
	public static Node flatten1(Node head) {
        
        if(head.next == null && head.child == null){
            return head;
        }
        if(head.child != null){
            Node temp = flatten1(head.child);
            Node next = head.next;
            head.next = head.child;
            head.child.prev = head;
            head.child = null;
            temp.next = next;
            if(next != null)
            next.prev = temp;
        } 
        if(head.next != null){
            return flatten1(head.next);
        }
        return head;
    }

}

public class FlatternDoubleLinkedList {
	
	static Node third = new Node(3,null,null,null);
	static Node six = new Node(6,null,null,null);

	static Node five = new Node(5,null,null,null);
	static Node four = new Node(4, null, null, null);
	static Node sec = new Node(2,null,null,null);
	static Node first = new Node(1,null,null,null);
	static Node seven = new Node(7,null,null,null);
	static Node _8 = new Node(8,null,null,null);
	static Node _9 = new Node(9,null,null,null);
	static Node _10 = new Node(10,null,null,null);
	static Node _11 = new Node(11,null,null,null);
	static Node _12 = new Node(12,null,null,null);
	static Node _13 = new Node(13,null,null,null);
	static Node _14 = new Node(14,null,null,null);
	static Node _15 = new Node(15,null,null,null);
	static Node _16 = new Node(16,null,null,null);
	static Node _17 = new Node(17,null,null,null);
	static Node _18 = new Node(18,null,null,null);
	static Node _19 = new Node(19,null,null,null);
	static Node _20 = new Node(20,null,null,null);
	static Node _21 = new Node(21,null,null,null);
	static Node _22 = new Node(22,null,null,null);
	static Node _23 = new Node(23,null,null,null);
	static Node _24 = new Node(24,null,null,null);
	static Node _25 = new Node(25,null,null,null);
	static Node _26 = new Node(26,null,null,null);
	static Node _27 = new Node(27,null,null,null);
	static Node _28 = new Node(28,null,null,null);
	static Node _29 = new Node(29,null,null,null);
	static Node _30 = new Node(30,null,null,null);

	
	public static void main(String[] args) {
		
		Node head = firstTestCase();		
		
		
		FlatternDLinkedList.flatten(head);
		FlatternDLinkedList.flatten(head);
		
		
		while(head.next != null) {
			System.out.println(head.data);
			head = head.next;
		}
		System.out.println(head.data);
		while(head.prev != null) {
			System.out.println(head.data);
			head = head.prev;
		}
		System.out.println(head.data);
		
	}
	
	private static Node firstTestCase() {
		
		first.next = sec;
		sec.prev = first;
		sec.next = third;
		third.prev = sec;
		sec.child = four;
		four.next = five;
		five.prev = four;
		return first;

	}
	
	private static Node secTestCase() {
		
		first.next = sec;
		sec.prev = first;
		sec.child = third;
		
		return first;
	}
		
	private static Node thirdTestCase() {
		first.next = sec;
		sec.prev = first;
		first.child = third;
		return first;
	}
	
	private static Node fourTestCase() {
		first.child = seven;
		first.next = sec;
		sec.prev = first;
		sec.next = third;
		sec.child = four;
		four.child = five;
		five.next = six;
		six.prev = five;
		return first;
	}
	
	private static Node _7TestCase() {
		first.child = sec;
		sec.child = third;
		third.child = four;
		four.next = five;
		five.prev = four;
		five.next = six;
		six.prev = five;
		return first;
	}
	
	private static Node fiveTestCase() {
		first.next = sec;
		sec.prev = first;
		sec.next = third;
		third.prev = sec;
		third.next = four;
		four.prev = third;
		four.next = five;
		five.prev = four;
		five.next = six;
		six.prev = five;
		third.child = seven;
		seven.next = _8;
		_8.prev = seven;
		_8.next = _9;
		_9.prev = _8;
		_9.next = _10;
		_10.prev = _9;
		_8.child = _11;
		_11.next = _12;
		_12.prev = _11;
		return first;
	}
	
	private static Node sixTestCase() {
		
		_10.next = five;
		five.prev = _10;
		five.next = _12;
		_12.prev = five;
		_12.next = seven;
		seven.prev = _12;
		seven.next = _11;
		_11.prev = seven;
		
		_10.child = four;
		four.next = _20;
		_20.prev = four;
		_20.next = _13;
		_13.prev = _20;
		_20.child = sec;
		_13.child = _16;
		_16.child = third;
		
		seven.child = _17;
		_17.child = _9;
		_9.child = _19;
		_17.next = six;
		six.prev = _17;
		_9.next = _8;
		_8.prev = _9;
		_19.next = _15;
		_15.prev = _19;
		return _10;
	}
	
	private static Node sevenTestCase() {
		
		first.next = sec;
		sec.prev = first;
		sec.next = third;
		third.prev = sec;
		third.next = four;
		four.prev = third;
		first.child = five;
		five.next = six;
		six.prev = five;
		six.next = seven;
		seven.prev = six;
		five.child = _8;
		six.child = _9;
		seven.child = _10;
		_10.next = _11;
		_11.prev = _10;
		
		four.child = _12;
		_12.next = _13;
		_13.prev = _12;
		_13.next = _14;
		_14.prev = _13;
		
		_13.child = _15;
		_15.child = _16;
		_16.child = _17;
		_16.next = _18;
		_18.prev = _16;
		_18.child = _19;
		_18.next = _20;
		_20.prev = _18;
		
		_14.child = _21;
		_21.next = _22;
		_22.prev = _21;
		_22.next = _23;
		_23.prev = _22;
		_23.next = _24;
		_24.prev = _23;
		
		_23.child = _25;
		_25.child = _26;
		_26.child = _27;
		_26.next = _28;
		_28.prev = _26;
		_24.next = _29;
		_29.prev = _24;
		
		four.next = _30;
		_30.prev = four;
		
		return first;
		
	}

}
