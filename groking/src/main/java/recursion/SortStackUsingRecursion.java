package recursion;

import java.util.Stack;

public class SortStackUsingRecursion {

	private static void sortStack(Stack<Integer> stack) {
		
		if(stack == null || stack.isEmpty()) {
			return;
		}
		
		int popedValue = stack.pop();
		sortStack(stack);
		insertIntoStack(stack,popedValue);
		
	}
	
	private static void insertIntoStack(Stack<Integer> stack , int popedValue) {
		
		if(stack.isEmpty() || stack.peek() <= popedValue) {
			stack.push(popedValue);
			return;
		}
		int popedValue1 = stack.pop();
		insertIntoStack(stack,popedValue);
		stack.push(popedValue1);
	}
	
	public static void main(String[] args) {
		
		Stack<Integer> stack = new Stack<>();
		
		stack.push(1);stack.push(5);
		stack.push(2);stack.push(0);
		
		System.out.println("before sorting , "+stack);
		SortStackUsingRecursion.sortStack(stack);
		System.out.println("after sorting , "+stack);

	}

}
