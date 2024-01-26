package binary_search;

public class Find_Minimum_Into_Sorted_Rotated_Duplicate_Array {

	/** 
	 * find minimum element into sorted array but array may have duplicate elements too
	 * In worst case TC would be O(N) only due to many duplicate elements 
	 * in best case TC would be O(logN) 
	 * Leet code# 154
	 */
	public static int find_Minimum_Into_Sorted_Rotated_Duplicate_Array(int[] arr) {
		int start = 0, end = arr.length - 1, mid = 0;

		while (start < end) {
			mid = start + ((end - start) / 2);
			// if start ,mid and end , all three values are duplicate 
			// just skip start and end as well
			if(arr[start] == arr[mid] && arr[mid] == arr[end]) {
				start++;end--;
			}
			if (arr[mid] < arr[end]) {
				end = mid;
			} else if (arr[mid] > arr[end]) {
				start = mid + 1;
			} else {
				// if in case mid and end both are same/duplicate
				// then just skip end 
				end--;
			}
		}
		return arr[start];
	}

	public static void main(String[] args) {
		int[] arr= {2,2,2,0,1};
		System.out.println(find_Minimum_Into_Sorted_Rotated_Duplicate_Array(arr));
		
		int[] arr1= {2,2,2,2,2,0,1,1,1};
		System.out.println(find_Minimum_Into_Sorted_Rotated_Duplicate_Array(arr1));
		
		int[] arr2= {1,3,3};
		System.out.println(find_Minimum_Into_Sorted_Rotated_Duplicate_Array(arr2));
	}

}
