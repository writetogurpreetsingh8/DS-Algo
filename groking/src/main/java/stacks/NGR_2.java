package stacks;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Nearest greater to right
 * @author Tony.Stark
 *
 */
public class NGR_2 {
	/**
	 * TC is O(N+M)
	 * aux space is N for resultant array and N for stack and N for map so N+N+N = 3N = O(N)
	 * system stack is O(1)
	 * @param arr
	 * @return
	 */
	public static int[] nearestGreaterToRight(int[] num1,int[] num2) {
		
		// both array are null
		if(num2 == null || num1 == null) {
			return null;
		}
		// if either num1 is empty or num2 than can't return greater element
		if(num1.length == 0 || num2.length == 0) {
			return new int[] {-1};
		}
		
		int result[] = new int[num1.length];
		Map<Integer, Integer> reference = new HashMap<Integer, Integer>();
		
		Stack<Integer> stack = new Stack<>();
		
		for (int i = num2.length-1; i>=0; i--) {
			
			while(!stack.isEmpty() && stack.peek() <= num2[i])
				stack.pop();
			
			if(stack.isEmpty()) {
				reference.put(num2[i], -1);
			}
			else {
				reference.put(num2[i], stack.peek());
			}
			stack.push(num2[i]);
		}
		
		// prepare resultant array with the help of map named reference!!
		for (int i = 0; i < num1.length; i++) {
			result[i] = reference.getOrDefault(num1[i],-1);
		}
		return result;
	}
	
	
	public static void main(String[] args) {
		
		int num1[] = {4,1,2}; int num2[]= {1,3,4,2};
		System.out.println(Arrays.toString(nearestGreaterToRight(num1,num2)));
		
	}

}
