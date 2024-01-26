package binary_search;

public class Find_Next_Alphabet_Sorted_Array {

	/**
	 * TC O(logN)
	 * Stack space O(1)
	 * aux space O(1)
	 * Note:-[ A) If given targetChar is available in the sorted array , we can just simply apply BS to find that element
	 * and return the just next element of it if we have else -1
	 *      B) If given targetChar is not available just return -1 Because we can't find just next element of it
	 *      because every time we applying BS to find element and if element doesn't available in the sorted array itself
	 *      then we can't find just next element of it
	 *      C) In case if we want to still find just next element of the given targetChar if targetChar is not available 
	 *      in the array refer below Algo ] 
	 */
	public static char find_Next_Alphabet_Sorted_Array(char[] arr, char targetChar) {
		
		char ans = '?';
		if(arr == null || arr.length == 0) {
			return ans;
		}
		
		int start = 0,end = arr.length-1,mid=0;
		
		while(start<=end) {
			mid = start + ((end - start)>>1);
			if(arr[mid] < targetChar) {
				start = mid + 1;
			}else {
				ans = arr[mid];
				end = mid - 1;
			}
		}
		return ans;
	}
	public static void main(String[] args) {
		char arr[]= {'a','c','f','h','k'};
		System.out.println(find_Next_Alphabet_Sorted_Array(arr,'k'));
		
		char arr1[]= {'a','c','d','g','j','l'};
		System.out.println(find_Next_Alphabet_Sorted_Array(arr1,'p'));
		
		char arr2[]= {'a','c','d','g','j','l'};
		System.out.println(find_Next_Alphabet_Sorted_Array(arr2,'e'));
	}

}
