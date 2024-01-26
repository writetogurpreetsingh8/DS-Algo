package stacks;

import java.util.Stack;

public class Minimum_Cost_To_Make_Parenthesis_Valid {

	
	     static int minSwaps(String s) {
	        int open = 0, close = 0, unbalanced = 0;
	        for(char ch : s.toCharArray()) {
	            if(ch == '{') open++;
	            else {
	                if(open > close) // i.e we have an extra open [ to be used in a pair
	                    close++;
	                else unbalanced++;
	            }
	        }
	        return (unbalanced+1)/2;
	    }
	
	/** Leet-Code#1963
	 * TC O(L)
	 * System stack O(1)
	 * aux-space O(L)
	 * L Denotes the length of String 
	 */
	private static int minimum_Cost_To_Make_Parenthesis_Valid_With_Stack(String parentheses) {
		
		if(parentheses == null || parentheses.isEmpty() || (parentheses.length() & 1) != 0) {
			return -1;
		}
		
		Stack<Character> stack = new Stack<>();
		char charr;
		for (int i = 0; i < parentheses.length(); i++) {
			charr = parentheses.charAt(i);
			if(charr == '{') {
				stack.push(charr);
			}
			else {
				if(!stack.isEmpty() && stack.peek() == '{') {
					stack.pop();
				}
				else {
					stack.push(charr);
				}
			}
		}
		int close=0,open=0;
		while(!stack.isEmpty()) {
			if(stack.peek() == '}') {
				close++;
			}
			else {
				open++;
			}
			stack.pop();
		}
		return (((open+1)/2) + ((close+1)/2));
	}
	
	public static void main(String[] args) {
		System.out.println(minimum_Cost_To_Make_Parenthesis_Valid_With_Stack("{}{}}{{}{{{}}{")); //3
		System.out.println(minimum_Cost_To_Make_Parenthesis_Valid_With_Stack("{}{}}{")); //2
		
		System.out.println(minSwaps("{}{}}{{}{{{}}{"));
	}

}
