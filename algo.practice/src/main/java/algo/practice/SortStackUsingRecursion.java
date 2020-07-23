package algo.practice;

import java.util.Stack;

public class SortStackUsingRecursion {

	private static void sortStack(Stack<Integer> stack) {
		
		if(stack == null || stack.isEmpty() || stack.size() == 0) {
			return;
		}
		
		int popedValue = stack.pop();
		sortStack(stack);
		insertIntoStack(stack,popedValue);
		
	}
	
	private static void insertIntoStack(Stack<Integer> stack , int popedValue) {
		
		if(stack.size() == 0 || stack.peek() <= popedValue) {
			stack.push(popedValue);
			return;
		}
		int popedValue1 = stack.pop();
		insertIntoStack(stack,popedValue);
		stack.push(popedValue1);
	}
	
	public static void main(String[] args) {
		
		Stack<Integer> stack = new Stack<>();
		
		stack.push(2);stack.push(1);
		stack.push(4);stack.push(3);
		stack.push(-1);stack.push(0);
		
		System.out.println("before sorting , "+stack);
		SortStackUsingRecursion.sortStack(stack);
		System.out.println("after sorting , "+stack);

	}

}
