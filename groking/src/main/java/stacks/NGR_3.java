package stacks;

import java.util.Arrays;
import java.util.Stack;
import java.util.stream.IntStream;

/**
 * Nearest greater to right
 * @author Tony.Stark
 * Leet-Code# 503
 * https://leetcode.com/problems/next-greater-element-ii/
 *
 */
public class NGR_3 {
	/**
	 * TC is O(N)
	 * aux space is N for resultant array and N for stack so N+N = 2N = O(N)
	 * system stack is O(1)
	 * @param arr
	 * @return
	 */
	public static int[] nearestGreaterToRight(int[] arr) {
		
		if(arr == null || arr.length == 0) {
			return null;
		}
		if(arr.length == 1) {
			return new int[] {-1};
		}
		
		int result[] = new int[arr.length];
		int resultPointer=result.length-1;
		Stack<Integer> stack = new Stack<>();
		
		// below is streaming version to iterate array from backwards
		IntStream.range(0, arr.length)
		.map(index -> arr.length - 1 - index)
		.map(finalIndex -> arr[finalIndex])
		.forEach(stack::push);
		
		// conventional code to traverse array from backwards
		//for (int i = arr.length-1; i >=0 ; i--) {
			//stack.push(arr[i]);
		//}
		
		for (int i = arr.length-1; i >=0 ; i--) {
			
			while(!stack.isEmpty() && stack.peek() <= arr[i]) {
				stack.pop();
			}
			
			if(stack.isEmpty()) {
				result[resultPointer--] = -1;
				stack.push(arr[i]);
			}
			else {
				result[resultPointer--] = stack.peek();
				stack.push(arr[i]);
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		int arr[]= {5,4,3,2,1};
		System.out.println(Arrays.toString(nearestGreaterToRight(arr)));
		
		int arr1[]= {1,2,3,4,5};
		System.out.println(Arrays.toString(nearestGreaterToRight(arr1)));
		
		int arr2[]= {1,2,9,6,3,5,0,4};
		System.out.println(Arrays.toString(nearestGreaterToRight(arr2)));
		
		int arr3[]= {1,2,3,6,3,5,0,4};
		System.out.println(Arrays.toString(nearestGreaterToRight(arr3)));
		
		int arr4[]= {1,2,3,4,3,5,0,4};
		System.out.println(Arrays.toString(nearestGreaterToRight(arr4)));
	}

}
