package binary_search;

public class Order_Not_Know_Search {

	public static int order_Not_Know_Search(int[] arr, int target) {
		if(arr == null || arr.length == 0) {
			return -1;
		}
		
		if(arr.length == 1 && arr[0] == target) {
			return 0;
		}
		
		int start = 0, end = arr.length-1,mid = 0;
		
		while(start <= end) {
			
			mid = start + (( end - start )>>1);
			
			if(arr[mid] == target) {
				return mid;
			}
			// array is in DESC order
			if(arr[mid] < arr[start]) {
				if(arr[mid] > target) {
					start = mid + 1;
				}else {
					end = mid - 1;
				}
			}else {
				// array is in ASC order
				if(arr[mid] > target) {
					end = mid - 1;
				}else {
					start = mid + 1;
				}
			}
		}
		return -1;
		
	}
	public static void main(String[] args) {
		
		int arr[]= {1,2,3,4,6,7,9,10};
		System.out.println(order_Not_Know_Search(arr,2));//1
		System.out.println(order_Not_Know_Search(arr,9));//6
		System.out.println(order_Not_Know_Search(arr,0));//-1
		System.out.println(order_Not_Know_Search(arr,16));//-1
		
		System.out.println("\n");
		
		int arr1[]= {10,9,7,5,3,2,1};
		System.out.println(order_Not_Know_Search(arr1,9));//1
		System.out.println(order_Not_Know_Search(arr1,3));//4
		System.out.println(order_Not_Know_Search(arr1,19));//-1
		System.out.println(order_Not_Know_Search(arr1,0));//-1
	}

}
