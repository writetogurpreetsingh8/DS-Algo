package stacks;

import java.util.Stack;

public class Valid_Parenthesis {

	/**
	 * TC O(N)
	 * system stack O(1)
	 * aux space O(N)
	 */
	public static boolean isParenthesisValid(String str) {
		
		if(str == null || str.isEmpty()) {
			return false;
		}
		
		Stack<Character> stack = new Stack<Character>();
		char ch = ' ';
		
		for (int i = 0; i < str.length(); i++) {
			
			ch = str.charAt(i);
			
			if(ch == '(' || ch == '{' || ch == '['){
				stack.push(ch);
			}
			else {
				if(!stack.isEmpty()) {
					if( (ch == '(' && stack.peek() == ')') 
							&& ch == '[' && stack.peek() == ']'
							&& ch == '{' && stack.peek() == '}') {
						stack.pop();
					}else {
						return false;
					}
				}else {
					return false;
				}
			}
		}
		return stack.isEmpty() ? true : false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
