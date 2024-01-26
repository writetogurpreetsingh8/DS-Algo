package recursion;

import java.util.Stack;

public class Delete_Middle_Element_Into_Stack {

	public static void delete_Middle_Element_Into_Stack(Stack<Integer> stack) {
		
		if(stack == null || stack.isEmpty()) {
			return;
		}
		
		if(stack.size() == 1) {
			stack.pop();
			return;
		}
		int k = (stack.size()/2)+1;
		delete_Middle_Element_Into_Stack0(stack,k);
	}
	
	private static void delete_Middle_Element_Into_Stack0(Stack<Integer> stack, int k) {
		
		if(k == 1) {
			stack.pop();
			return;
		}
		int ele = stack.pop();
		delete_Middle_Element_Into_Stack0(stack,k-1);
		stack.push(ele);
	}
	
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		
		stack.push(1);stack.push(5);
		stack.push(2);
		
		System.out.println("before deleting middle element: ");
		System.out.println(stack);
		
		delete_Middle_Element_Into_Stack(stack);
		
		System.out.println("after deleting middle element: ");
		System.out.println(stack);
		
	}

}
