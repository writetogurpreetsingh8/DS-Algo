package stacks;

import java.util.Stack;


public class Check_For_Redundant_Brackets {

	/**
	 * Given expression must be valid always
	 * TC O(N)
	 * system stack O(1)
	 * aux space O(N)
	 */
	public static boolean isCheck_For_Redundant_Bracket(String expression) {
	
		if(expression == null || expression.isEmpty()) {
			return false;
		}
		
		Stack<Character> stack  = new Stack<>();
		char ch=' ';
		boolean isRedundant = false;
		for (int i = 0; i < expression.length(); i++) {
			ch = expression.charAt(i);
			if(ch == '(' || ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '%') {
				stack.push(ch);
			}
			else if(ch == ')') {
				isRedundant = true;
				ch = stack.peek();
				while(!stack.isEmpty() && stack.peek() != '(') {
					if(ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '%') {
						isRedundant = false;
					}
					stack.pop();
				}
				stack.pop();
			}
			if(isRedundant) {
				break;
			}
		}
		return isRedundant;
	}
	
	public static void main(String[] args) {
		//System.out.println(isCheck_For_Redundant_Bracket("(a+(p+r)")); // false
		//System.out.println(isCheck_For_Redundant_Bracket("(a+((p+r))")); // true
		System.out.println(isCheck_For_Redundant_Bracket("(a+(p+r) % (y*i))")); // false
		System.out.println(isCheck_For_Redundant_Bracket("(a+((p+r) % (y*i)))")); // false
		System.out.println(isCheck_For_Redundant_Bracket("(a+((p+r) % ((y*i))))")); // true
		System.out.println(isCheck_For_Redundant_Bracket("(a+(((p+r)) % (y*i)))")); // true
		System.out.println(isCheck_For_Redundant_Bracket("(a+(((p+r) % (y*i))))")); // true
	}

}
