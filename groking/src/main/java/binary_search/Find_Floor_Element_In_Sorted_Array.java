package binary_search;

public class Find_Floor_Element_In_Sorted_Array {
	
	/**
	 * TC O(logN)
	 * stack space O(1)
	 * aux space O(1)
	 */
	public static int find_Floor_Element_In_Sorted_Array(int arr[] , int ele) {
		
		if(arr == null || arr.length == 0) {
			return -1;
		}
		int start = 0, mid=0,end = arr.length-1,ans=-1;
		while(start<=end) {
			mid = start+((end-start)>>1);
			if(arr[mid] == ele) {
				return mid;
			}
			if(arr[mid] > ele) {
				end = mid-1;
			}else {
				start = mid+1;
				ans = mid;
			}
		}
		return ans;
	}
	public static void main(String[] args) {
		int arr[]= {0,1,3,4,6,7,8,9};
		System.out.println(find_Floor_Element_In_Sorted_Array(arr,5));

	}

}
