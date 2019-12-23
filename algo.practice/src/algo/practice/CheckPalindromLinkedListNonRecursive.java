package algo.practice;

import java.util.Stack;

import algo.practice.LinkingList;

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
		if(node.getNext() == null){
			return isPalindorm;
		}
		
		while(next != null && next.getNext() != null){
			stack.add(current.getData());
			current = current.getNext();
			next = next.getNext().getNext();
		}
		
		if(next != null && next.getNext() == null){
			current = current.getNext();
		}
		// fetch value from stack and mapped with current 
		
		while(current != null){
			if(stack.pop() != current.getData()){
				return !isPalindorm;
			}
			current = current.getNext();
		}
		return isPalindorm;
	}
	
	boolean checkPalindromList(LinkingList linkingList){
		return checkPalindrom(linkingList.getHead());
	}
	
	public static void main(String[] args) {
		LinkingList linkingList = new LinkingList();
		linkingList.createLinkedList(new int[]{78});
		System.out.println(new CheckPalindromLinkedListNonRecursive().checkPalindromList(linkingList));
		
	}

}
