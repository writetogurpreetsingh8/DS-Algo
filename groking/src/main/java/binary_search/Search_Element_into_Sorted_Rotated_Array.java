package binary_search;

/**
 * 
 * @author Tony.Stark
 * Leet-code# 33 
 */
public class Search_Element_into_Sorted_Rotated_Array {

	/**
	 * TC O(logN)
	 * Stack space O(1)
	 * aux space O(1)
	 */
	// Duplicate values into array is not allowed in this Problem
	// leet-code 33
	// duplicate values need to change the logic Leet-Code# see 81
	private static int findPivot(int[] arr) {
		
		if(arr == null || arr.length <=1 ) {
			return -1;
		}
		
		int start = 0,end=arr.length-1,mid=0;
		
		while(start < end) {
			mid = start+((end-start)>>1);
			if(arr[mid] < arr[end]) {
				end = mid;
			}else {
				start = mid + 1;
			}
		}
		return end;
	}
	
	/**
	 * TC O(logN)
	 * Stack space O(1)
	 * aux space O(1) 
	 * So total TC is O(logN) + O(logN) = O(2+logN) and 2 is constant and final TC is O(logN)
	 */
	// Duplicate values into array is not allowed in this Problem
	public static int search_Element_into_Sorted_Rotated_Array(int arr[], int targetElement) {
	
		if(arr == null || arr.length == 0) {
			return -1;
		}
		
		if(arr.length == 1 && arr[0] == targetElement) {
			return 0;
		}
		
		int pivot = findPivot(arr); // TC O(logN)
		int start = 0, end = 0, mid = -1;
		
		if(pivot == -1) {
			return pivot;
		}
		
		if(arr[pivot] == targetElement) {
			return pivot;
		}
		
		if(arr[pivot] <= targetElement && arr[arr.length-1] >= targetElement) {
			start = pivot;
			end = arr.length-1;
		}else {
			start = 0;
			end = pivot-1;
		}
		
		while(start <= end) {
			mid = start + ((end-start)/2);
			
			if(arr[mid] == targetElement) {
				return mid;
			}
			else if(arr[mid] > targetElement) {
				end = mid - 1;
			}else {
				start = mid + 1;
			}
		}
		return -1;
		
	}
	public static void main(String[] args) {
		
		int arr[]= {4,5,6,7,0,1,2};
		
		  System.out.println("0 stored At "+search_Element_into_Sorted_Rotated_Array(
		  arr,0));//4
		  System.out.println("6 stored At "+search_Element_into_Sorted_Rotated_Array(
		  arr,6));//2
		  System.out.println("1 stored At "+search_Element_into_Sorted_Rotated_Array(
		  arr,1));//5
		  System.out.println("2 stored At "+search_Element_into_Sorted_Rotated_Array(
		  arr,2));//6
		  System.out.println("7 stored At "+search_Element_into_Sorted_Rotated_Array(
		  arr,7));//3
		  System.out.println("5 stored At "+search_Element_into_Sorted_Rotated_Array(
		  arr,5));//1
		  System.out.println("15 stored At "+search_Element_into_Sorted_Rotated_Array(
		  arr,15));//-1
		  System.out.println("-5 stored At "+search_Element_into_Sorted_Rotated_Array(
		  arr,-5));//-1
		  System.out.println("4 stored At "+search_Element_into_Sorted_Rotated_Array(
		  arr,4));//0
		 		
		System.out.println("\n");
		
		int arr1[]= {40,50,1,5,10,20};
		
		  System.out.println("0 stored At "+search_Element_into_Sorted_Rotated_Array(
		  arr1,0));//-1
		  System.out.println("1 stored At "+search_Element_into_Sorted_Rotated_Array(
		  arr1,1));//5
		  System.out.println("5 stored At "+search_Element_into_Sorted_Rotated_Array(
		  arr1,5));
		  System.out.println("10 stored At "+search_Element_into_Sorted_Rotated_Array(
		  arr1,10));
		  System.out.println("50 stored At "+search_Element_into_Sorted_Rotated_Array(
		  arr1,50));
		  System.out.println("40 stored At "+search_Element_into_Sorted_Rotated_Array(
		  arr1,40));
		 
		
		int arr2[]= {1};
		System.out.println(search_Element_into_Sorted_Rotated_Array(arr2,0));
	}

}
