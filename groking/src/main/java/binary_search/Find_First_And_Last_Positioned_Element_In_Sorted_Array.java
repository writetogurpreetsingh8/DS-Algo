package binary_search;

import java.util.Arrays;

public class Find_First_And_Last_Positioned_Element_In_Sorted_Array {

	/**
	 * Total TC would be O(logN) + O(logN) => O(2+logN)
	 * 2 is constant so final TC is O(logN) 
	 * stack space is O(1)
	 * no aux space
	 */
	public static int[] find_First_And_Last_Positioned_Element_In_Sorted_Array(int arr[], int target) {
		
		int result[] = new int[] {-1,-1};
		if(arr == null || arr.length == 0) {
			return new int[] {-1,-1};
		}
		
		if(arr.length == 1 && arr[0] == target) {
			return new int[] {0,0};
		}
		
		result[0] = findOccurrenceOfIndex(arr,target,false);
		
		if(result[0] != -1) {
			result[1] = findOccurrenceOfIndex(arr,target,true);
		}
		return result;
	}
	
	/**
	 * TC is O(logN) 
	 * stack space is O(1)
	 * no aux space
	 */
	private static int findOccurrenceOfIndex(int[] arr, int target,boolean isFindFirstOccurrenceIndex) {
		int start = 0, end = arr.length-1, mid = 0;
		int result = -1;
		while(start <= end) {
			mid = start + ((end - start)>>1);
			if(arr[mid] == target) {
				result = mid;
				if(isFindFirstOccurrenceIndex) {
					if(mid < arr.length-1 && arr[mid+1] != target) {
						break;
					}
					start = mid + 1;
				}else {
					if(mid > 0 && arr[mid-1] != target) {
						break;
					}
					end = mid-1;
				}
			}else if(arr[mid] < target) {
				start = mid + 1;
			}else {
				end = mid - 1;
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		int arr[] = {5,7,7,8,8,10};
		System.out.println(Arrays.toString(find_First_And_Last_Positioned_Element_In_Sorted_Array(arr,8)));
		
		int arr1[] = {5,7,7,8,8,10};
		System.out.println(Arrays.toString(find_First_And_Last_Positioned_Element_In_Sorted_Array(arr1,6)));
		
		System.out.println(Arrays.toString(find_First_And_Last_Positioned_Element_In_Sorted_Array(new int[] {},6)));
		
		int arr2[] = {2,3,4,5,6,6,6,7,7};
		System.out.println(Arrays.toString(find_First_And_Last_Positioned_Element_In_Sorted_Array(arr2,6)));
		
		int arr3[] = {3,4,5,5,5,5,5,5,5,5,6,7,8};
		System.out.println(Arrays.toString(find_First_And_Last_Positioned_Element_In_Sorted_Array(arr3,5)));
	}

}
