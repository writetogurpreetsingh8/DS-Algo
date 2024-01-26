package cyclic.sort;

import java.util.Arrays;

public class Sort_the_Given_Array {

	/**
	 *
	 *The time complexity of the above algorithm is O(n). 
	 *Although we are not incrementing the index i when swapping the numbers, 
	 *this will result in more than ‘n’ iterations of the loop, but in the worst-case scenario, 
	 *the while loop will swap a total of ‘n-1’ numbers and once a number is at its correct index, 
	 *we will move on to the next number by incrementing i. So overall, our algorithm will take O(n) + O(n-1)
	 *which is asymptotically equivalent to O(n)
	 * 
	 */
	private static int[] sort_the_Given_Array(int[] arr) {
	
		if(arr == null | arr.length <=1 ) {
			return arr;
		}
		
		int index=0;
		int compareIndex=0;
		while(index < arr.length) {
			compareIndex = arr[index]-1;
			if(arr[index] != (arr[compareIndex])) {
				swap(arr,index,compareIndex);
			}else {
				index++;
			}
		}
		return arr;
	}
	
	private static void swap(int[] arr, int source, int target) {
		arr[source] = arr[source] ^ arr[target];
		arr[target] = arr[source] ^ arr[target];
		arr[source] = arr[source] ^ arr[target];
	}
	
	public static void main(String[] args) {
		int arr[] = {2,3,1,4};
		//System.out.println(Arrays.toString(sort_the_Given_Array(arr)));
		
		int arr1[] = {3,1,5,4,1,4};
		System.out.println(Arrays.toString(sort_the_Given_Array(arr1)));
	}

}
