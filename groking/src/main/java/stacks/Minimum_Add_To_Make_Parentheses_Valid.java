package stacks;

import java.util.Stack;

public class Minimum_Add_To_Make_Parentheses_Valid {
	
	
	/**
	 * TC O(L)
	 * System stack O(1)
	 * aux-space O(1)
	 * L Denotes the length of String 
	 * @param parentheses
	 * @return
	 */
	private static int minimum_Add_To_Make_Parentheses_Valid_Without_Stack(String parentheses) {
			
		if(parentheses == null || parentheses.isEmpty()) {
			return -1;
		}
		
		char charr; int open=0,close=0;
		for (int i = 0; i < parentheses.length(); i++) {
			charr = parentheses.charAt(i);
			if(charr == '(') {
				open++;
			}
			else {
				if(open > 0) {
					open--;
				}
				else {
					close++;
				}
			}
		}
		return open+close;
	}
	
	/**
	 * TC O(L)
	 * System stack O(1)
	 * aux-space O(L)
	 * L Denotes the length of String 
	 * @param parentheses
	 * @return
	 */
	private static int minimum_Add_To_Make_Parentheses_Valid_With_Stack(String parentheses) {
		
		if(parentheses == null || parentheses.isEmpty()) {
			return -1;
		}
		
		Stack<Character> stack = new Stack<>();
		char charr;
		for (int i = 0; i < parentheses.length(); i++) {
			charr = parentheses.charAt(i);
			if(charr == '(') {
				stack.push(charr);
			}
			else {
				if(!stack.isEmpty() && stack.peek() == '(') {
					stack.pop();
				}
				else {
					stack.push(charr);
				}
			}
		}
		return stack.size();
	}
	public static void main(String[] args) {
		
		System.out.println(minimum_Add_To_Make_Parentheses_Valid_With_Stack("())"));
		System.out.println(minimum_Add_To_Make_Parentheses_Valid_With_Stack(")))"));
		System.out.println(minimum_Add_To_Make_Parentheses_Valid_With_Stack("((("));
		
		System.out.println(minimum_Add_To_Make_Parentheses_Valid_Without_Stack("())"));
		System.out.println(minimum_Add_To_Make_Parentheses_Valid_Without_Stack(")))"));
		System.out.println(minimum_Add_To_Make_Parentheses_Valid_Without_Stack("((("));
	}

}
