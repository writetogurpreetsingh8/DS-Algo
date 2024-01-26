package binary_search;

public class find_last_true_in_sorted_boolean_array {

	public static int find_last_true_in_sorted_boolean_array(boolean[] arr) {
		
		if(arr == null || arr.length == 0) {
			return -1;
		}
		
		return find_last_true_in_sorted_boolean_array1(arr,0,arr.length-1);
		
	}
	
	private static int find_last_true_in_sorted_boolean_array1(boolean[] arr, int start, int end) {
		
		if(start > end) {
			return -1;
		}
		
		int mid = start+((end-start)/2);
		
		if(mid < end && arr[mid] && !arr[mid + 1]) {
			return mid;
		}
		else if(mid > start && !arr[mid] && arr[mid - 1]) {
			return mid-1;
		}else if(arr[mid]) {
			return find_last_true_in_sorted_boolean_array1(arr,mid+1,end);
		}else {
			return find_last_true_in_sorted_boolean_array1(arr,start,mid-1);
		}
	}

	public static void main(String[] args) {
		boolean arr[]= {true,true,true,true,true,false};
		System.out.println(find_last_true_in_sorted_boolean_array(arr));
	}

}
