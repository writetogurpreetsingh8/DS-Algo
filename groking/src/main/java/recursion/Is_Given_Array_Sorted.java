package recursion;

public class Is_Given_Array_Sorted {

	
	
	public static boolean is_Given_Array_Sorted1(int[] arr) {
		
		if(arr == null || arr.length<=1) {
			return true;
		}
		return isArraySorted1(arr,arr.length-1,0);
		
	}
	
	/**
	 * comparing array values while recursion is invoking.........
	 */
	private static boolean isArraySorted1(int[] arr, int length, int index) {
		if(length == 0) {
			return true;
		}
		
		if(arr[index] > arr[index+1]) {
			return false;
		}
		
		return isArraySorted1(arr,length-1,index+1);
	}


	public static boolean is_Given_Array_Sorted(int[] arr) {
		
		if(arr == null || arr.length<=1) {
			return true;
		}
		return isArraySorted(arr,arr.length-1);
		
	}
	
	/**
	 * comparing array value's while Recursion is backtracking........
	 */
	private static boolean isArraySorted(int[] arr, int size) {
			if(size == 0) {
				return true;
			}
			int value = arr[size];
			boolean result = isArraySorted(arr,size-1);
			if(result && value > arr[size-1]) {
				return true;
			}
			else {
				return false;
			}
	}
	public static void main(String[] args) {
			int arr[]= {1,2,5,8,81,91};
			System.out.println(is_Given_Array_Sorted(arr));
			System.out.println(is_Given_Array_Sorted1(arr));
	}

}
