package stacks;

import java.util.Arrays;
import java.util.Stack;

/**
 * Nearest greater to left
 * @author Tony.Stark
 *
 */
public class NGL_1 {
	/**
	 * TC is O(N)
	 * aux space is N for resultant array and N for stack so N+N = 2N = O(N)
	 * system stack is O(1)
	 * @param arr
	 * @return
	 */
	public static int[] nearestGreaterToLeft(int[] arr) {
		
		if(arr == null || arr.length == 0) {
			return null;
		}
		if(arr.length == 1) {
			return new int[] {-1};
		}
		
		int result[] = new int[arr.length];
		int resultPointer=0;
		Stack<Integer> stack = new Stack<>();
		
		for (int i = 0; i < arr.length; i++) {
			
			while(!stack.isEmpty() && stack.peek() <= arr[i]) {
				stack.pop();
			}
			
			if(stack.isEmpty()) {
				result[resultPointer++] = -1;
				stack.push(arr[i]);
			}
			else {
				result[resultPointer++] = stack.peek();
				stack.push(arr[i]);
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		int arr[]= {1,3,0,0,1,2,4};
		System.out.println(Arrays.toString(nearestGreaterToLeft(arr)));
		
		int arr1[]= {1,3,0,0,2,4};
		System.out.println(Arrays.toString(nearestGreaterToLeft(arr1)));
		
		int arr2[]= {1,3,2,4};
		System.out.println(Arrays.toString(nearestGreaterToLeft(arr2)));
		
		int arr3[]= {1,3,4,2};
		System.out.println(Arrays.toString(nearestGreaterToLeft(arr3)));
	}

}
