package binary_search;

public class Find_Maximum_Into_Sorted_Rotated_Array {

	/** 
	 * find minimum element into sorted array but array will have only unique elements
	 * In worst case TC would be O(N) only due to many duplicate elements 
	 * in best case TC would be O(logN) 
	 */
	public static int find_Maximum_Into_Sorted_Rotated_Array(int[] arr) {
		int start = 0, end = arr.length - 1, mid = 0;

		while (start < end) {
			mid = start + ((end - start) / 2);
			if (arr[mid] < arr[end]) {
				end = mid;
			} else if (arr[mid] > arr[end]) {
				start = mid + 1;
			} 
		}
		return arr[start];
	}

	public static void main(String[] args) {
		
		int[] arr= {4,5,1,2,3};
		System.out.println(find_Maximum_Into_Sorted_Rotated_Array(arr));
		
		int[] arr1= {7,8,9,10,0,1,2,3,4,5,6};
		System.out.println(find_Maximum_Into_Sorted_Rotated_Array(arr1));
		
		int[] arr2= {1,2,3};
		System.out.println(find_Maximum_Into_Sorted_Rotated_Array(arr2));
		
		int[] arr3= {0,1,2,3};
		System.out.println(find_Maximum_Into_Sorted_Rotated_Array(arr3));
		
	}

}
