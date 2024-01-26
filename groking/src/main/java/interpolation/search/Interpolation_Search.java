package interpolation.search;

public class Interpolation_Search {

	public static boolean findElement(int[] arr, int target) {

		if (arr == null || arr.length == 0 || target < 0) {
			return false;
		}

		if (arr.length == 1 && arr[0] == target) {
			return true;
		}

		// formula of Interpolation Searching
		// ( ((low + target - arr[low]) / (arr[high] - arr[low])) * (high - low) )

		int low = 0, high = arr.length - 1;
		double interMid = 0;int mid =0;

		while (low <= high) {
			interMid = ((double)(low + (target - arr[low])) / (arr[high] - arr[low]));
			mid = (int)(interMid * ((high - low) > 0 ? (high - low) : 1));
			//mid = (int)(((double)((arr[high] - arr[low]) / (high - low))) / (low + (target - arr[low]))); 
			if (arr[mid] == target) {
				return true;
			}
			if(arr[mid] > target) {
				high = mid - 1;
			}
			else {
				low = mid + 1;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		int arr[] = {1,3,5,7,9,11,13,15};
		//System.out.println(findElement(arr,9));
		
		int arr1[] = {1,3,5,7,10,15,25,50,75,80,90,100};
		System.out.println(findElement(arr1,90));
	}

}
