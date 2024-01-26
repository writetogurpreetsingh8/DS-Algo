package binary_search;

public class Nearly_Sorted_Array {

	public static int nearly_Sorted_Array(int arr[] , int ele) {
		
		if(arr == null || arr.length == 0) {
			return -1;
		}
		if(arr.length <=3 ) {
			if(arr[0] == ele) {
				return 0;
			}
			else if(arr.length > 1 && arr[1] == ele) {
				return 1;
			}
			else if(arr.length > 2  && arr[2] == ele) {
				return 2;
			}
			return -1;
		}	
			int start = 0, end = arr.length-1,mid = 0;
			while(start <= end) {
				mid = start + ((end-start)>>1);
				if(arr[mid] == ele) {
					return mid;
				}
				else if( (mid-1) >= start && arr[mid-1] == ele ) {
					return mid - 1;
				}
				else if((mid+1) <= end && arr[mid+1] == ele ) {
					return mid+1;
				}
				else {
					if(arr[mid] < ele) {
						start = mid + 2;
					}else {
						end = mid - 2;
					}
				}
			}
			return -1;
		
	}
	public static void main(String[] args) {
			int arr[]= {5,10,30,20,40};
			System.out.println(nearly_Sorted_Array(arr,30));
			
			System.out.println("\n");
			
			int arr1[]= {10,3,40,20,50,80,70};
			System.out.println(nearly_Sorted_Array(arr1,30));
			System.out.println(nearly_Sorted_Array(arr1,70));
			System.out.println(nearly_Sorted_Array(arr1,10));
			System.out.println(nearly_Sorted_Array(arr1,50));
			System.out.println(nearly_Sorted_Array(arr1,3));
			
			int arr2[]= {10,0,3};
			System.out.println(nearly_Sorted_Array(arr2,3));
	}

}
