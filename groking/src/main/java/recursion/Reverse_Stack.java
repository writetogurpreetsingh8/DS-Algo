package recursion;

import java.util.Stack;

public class Reverse_Stack {

	public static void reverse_Stack(Stack<Integer> stack) {
		if (stack == null || stack.isEmpty() || stack.size() == 1) {
			return;
		}
		reverse_Stack0(stack);
	}

	private static void reverse_Stack0(Stack<Integer> stack) {
		if (stack.size() == 1) {
			return;
		}
		int ele = stack.pop();
		reverse_Stack0(stack);
		insertElementAtBottom(stack, ele);
	}

	private static void insertElementAtBottom(Stack<Integer> stack, int ele) {
			if(stack.isEmpty()) {
				stack.push(ele);
				return;
			}
			
			int val = stack.pop();
			insertElementAtBottom(stack,ele);
			stack.push(val);
	}

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		
		stack.push(2);stack.push(5);
		stack.push(3);stack.push(1);
		
		System.out.println("before reversing , "+stack);
		reverse_Stack(stack);
		System.out.println("after reversing , "+stack);
	}

}
