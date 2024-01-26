package stacks;

import java.util.Stack;



public class Minimum_Remove_to_Make_Valid_Parentheses {

	/**
	 * TC O(L)
	 * System stack O(1)
	 * aux space O(L) -> just to create new resultant String
	 */
	//https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/solutions/3509872/100-c-solution-without-using-stack-time-complexity-o-n-space-complexity-o-1/
	private static String minimum_Remove_to_Make_Valid_Parentheses_With_Out_Stack_2(String s) {
		
		StringBuilder R = new StringBuilder();
	        int open = 0, close = 0;
	        
	        // remove invalid close parenthesis
	        for(char ch : s.toCharArray()) {
	            if(Character.isAlphabetic(ch)) {
	                R.append(ch);
	            }
	            else if(ch=='(') {
	                open++;
	                R.append(ch);
	            }
	            else {
	                if(open > close) { // if there is an '(' to be considered for a valid pair
	                    R.append(ch);
	                    close++;
	                }
	            }
	        }

	        s = R.toString();
	        R.setLength(0); // reset ans
	        int n = s.length();
	        open = close = 0;
			
			// remove invalid open parenthesis
			
	        for(int i=n-1;i>=0;i--) {
	            char ch = s.charAt(i);
	            if(Character.isAlphabetic(ch)) {
	                R.insert(0, ch);
	            }
	            else if(ch == ')') {
	                R.insert(0, ch);
	                close++;
	            }
	            else {
	                if(close > open) {
	                    R.insert(0, ch);
	                    open++;
	                }
	            }
	        }        
	        return R.toString();
	}
	
	/**
	 * TC O(L)
	 * System stack O(1)
	 * aux space O(L) -> just to create new resultant String
	 */
	//https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/solutions/1850228/java-4-solutions-with-slight-optimisations/
	private static String minimum_Remove_to_Make_Valid_Parentheses_With_Out_Stack_1(String str) {
		
		if(str == null || str.isEmpty()) {
			return "";
		}
		
		int invalidBracket=0;
		char charr[] = str.toCharArray();
		
		//replacing invalid close parenthese by $
		for (int i = 0; i < charr.length; i++) {
		
			if(charr[i] == '(') {
				invalidBracket++;
			}
			else if (charr[i] == ')') {
					if(invalidBracket == 0) {
						charr[i] = '$';
					}
					else {
						invalidBracket--;
					}
			}
		}	
		
		invalidBracket=0;
		
		//replacing invalid open parenthese by $
		for (int i = charr.length-1; i >=0 ; i--) {
			
			if(charr[i] == ')') {
				invalidBracket++;
			}
			else if (charr[i] == '(') {
					if(invalidBracket == 0) {
						charr[i] = '$';
					}
					else {
						invalidBracket--;
					}
			}
		}
		
		StringBuilder sb = new StringBuilder(str.length());

		for (int i = 0; i < charr.length; i++) {
				if(charr[i] != '$')
				sb.append(charr[i]);
		}
		return sb.toString();
	}
	
	/**
	 * TC O(L^2)
	 * System stack O(1)
	 * aux space O(L)
	 */
	private static String minimum_Remove_to_Make_Valid_Parentheses_With_Stack(String str) {
		
		if(str == null || str.isEmpty()) {
			return "";
		}
		
		Stack<Integer> stack = new Stack<>();
		char charr;
		for (int i = 0; i < str.length(); i++) {  //O(L)
			charr = str.charAt(i);
			if(charr == '(') {
				stack.push(i);
			}
			else if(charr == ')') {
				if(!stack.isEmpty() && '(' == str.charAt(stack.peek())) {
					stack.pop();
				}
				else {
					stack.push(i);
				}
			}
		}
		
		//remove invalid parenthese
		if(stack.isEmpty()) {
			return str;
		}
		
		StringBuilder sb = new StringBuilder(str.length());
		
		for (int i = str.length()-1; i>=0 ; i--) { 		//O(L)
			
				if(!stack.isEmpty() && i == stack.peek()) {
					stack.pop();
				}
				else {
					sb.insert(0, str.charAt(i)); 		//O(L)
				}
		}
		return sb.toString();
	}
	public static void main(String[] args) {
		
		System.out.println("1st Approch");
		System.out.println(minimum_Remove_to_Make_Valid_Parentheses_With_Stack("lee(t(co)de)"));
	    System.out.println(minimum_Remove_to_Make_Valid_Parentheses_With_Stack("lee(t(c)o)de)"));
		System.out.println(minimum_Remove_to_Make_Valid_Parentheses_With_Stack("))(("));
		System.out.println(minimum_Remove_to_Make_Valid_Parentheses_With_Stack("(())"));
		System.out.println(minimum_Remove_to_Make_Valid_Parentheses_With_Stack("a)b(c)d"));
		System.out.println(minimum_Remove_to_Make_Valid_Parentheses_With_Stack("))(("));
		System.out.println(minimum_Remove_to_Make_Valid_Parentheses_With_Stack("())()((("));
		
		System.out.println("\n"+"2nd Approch");
		
		System.out.println(minimum_Remove_to_Make_Valid_Parentheses_With_Out_Stack_1("a)b(c)d"));
		System.out.println(minimum_Remove_to_Make_Valid_Parentheses_With_Out_Stack_1("))(("));
		System.out.println(minimum_Remove_to_Make_Valid_Parentheses_With_Out_Stack_1("())()((("));
		System.out.println(minimum_Remove_to_Make_Valid_Parentheses_With_Out_Stack_1("lee(t(co)de)"));
	    System.out.println(minimum_Remove_to_Make_Valid_Parentheses_With_Out_Stack_1("lee(t(c)o)de)"));
		System.out.println(minimum_Remove_to_Make_Valid_Parentheses_With_Out_Stack_1("))(("));
		System.out.println(minimum_Remove_to_Make_Valid_Parentheses_With_Out_Stack_1("(())"));
		
		System.out.println("\n"+"3rd Approch");
		
		System.out.println(minimum_Remove_to_Make_Valid_Parentheses_With_Out_Stack_2("a)b(c)d"));
		System.out.println(minimum_Remove_to_Make_Valid_Parentheses_With_Out_Stack_2("))(("));
		System.out.println(minimum_Remove_to_Make_Valid_Parentheses_With_Out_Stack_2("())()((("));
		System.out.println(minimum_Remove_to_Make_Valid_Parentheses_With_Out_Stack_2("lee(t(co)de)"));
	    System.out.println(minimum_Remove_to_Make_Valid_Parentheses_With_Out_Stack_2("lee(t(c)o)de)"));
		System.out.println(minimum_Remove_to_Make_Valid_Parentheses_With_Out_Stack_2("l(e(e(t(co)d)e"));
		System.out.println(minimum_Remove_to_Make_Valid_Parentheses_With_Out_Stack_2("))(("));
		System.out.println(minimum_Remove_to_Make_Valid_Parentheses_With_Out_Stack_2("(())"));
		
		
		int j;
		for(int i=0;i<3;i++) {
			for(j=0;j<3;j++) {
				if(j==2) {
					break;
				}
			}
			if(j==3) {
				System.out.println("inside if");
			}else {
				System.out.println("in side else");
			}
			System.out.println("j is "+j);
		}
	}

}
