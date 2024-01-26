package binary_search;

public class Find_Kth_Missing_Number {

	public static int find_Kth_Missing_Number(int arr[], int k) {
		if(arr == null || arr.length == 0 || k<=0 ) {
			return -1;
		}
		
		if(arr[0] > k ) {
			return k;
		}
		
		int start=0,end=arr.length-1,mid=0;
		while(start<=end) {
			mid = start+((end-start)/2);
			if(arr[mid] - (mid+1) < k) {
				start = mid+1;
			}else {
				end = mid - 1;
			}
		}
		return arr[end] + (k - (arr[end] - (end+1)));
	}
	public static void main(String[] args) {
		int arr[]= {2,3,5,7,11};
		System.out.println(find_Kth_Missing_Number(arr,5));
	}

}
