package binary_search;

/**
 * 
 * @author Tony.Stark
 * This is problem can be solved by using two different approaches
 * 1) first find peak element then apply BS at left side if returns -1 then apply BS on right side,
 * TC is O(logN) for find peak element + O(logN) for Apply BS at left side + O(logN) for Apply BS at right side
 * TC O(3LOG N) => final TC is O(LOG N) 
	
 */
public class Find_in_Mountain_Array {

	public static int find_in_Mountain_Array(int[] arr, int target) {
	
		if(arr == null || arr.length == 0) {
			return -1;
		}
		
		if(arr.length == 1 || arr[0] == target) {
			return 0;
		}
		
		int peakElementIndex = findPeakElement(arr); // TC O(LogN)
		int firstHalf = applyBSOnBothTheHalfs(arr,target,0,peakElementIndex,true);  // TC O(LogN)
		if(firstHalf != -1) {
			return firstHalf;
		}
		int secHalf = applyBSOnBothTheHalfs(arr,target,peakElementIndex+1,arr.length-1,false);  // TC O(LogN)
		return secHalf;
	}
	
	/**
	 * TC O(LogN)
	 * stack O(1)
	 * aux O(1)
	 */
	private static int applyBSOnBothTheHalfs(int arr[],int target,int start,int end,boolean isBSAppliedOnFirstHalf) {
		
		int mid=0;
		while(start<=end) {
			mid = start + ((end - start)/2);
			if(arr[mid] == target) {
				return mid;
			}
			if(isBSAppliedOnFirstHalf) {
				if(arr[mid] > target) {
					end = mid-1;
				}else {
					start = mid+1;
				}
			}else {
				if(arr[mid] < target) {
					end = mid-1;
				}else {
					start = mid+1;
				}
			}
		}
		return -1;
	}
	
	/**
	 * TC O(LogN)
	 * stack O(1)
	 * aux O(1)
	 */
	
	private static int findPeakElement(int arr[]) {
		
		int start = 0,end = arr.length-1,mid = 0;
		while(start <= end) {
			mid = start + ((end-start)>>1);
			
			if((mid > 0 && mid < arr.length -1) && (arr[mid] > arr[mid-1] && arr[mid] > arr[mid+1])) {
				return mid;
			}
			else if((mid >= 0 && mid < arr.length -1) && (arr[mid] > arr[mid+1])) {
				end = mid - 1;
			}else {
				start = mid + 1;
			}
		}
		return mid;
	}
	
	private static int findPeakElement0(int arr[]) {
		
		int start = 0,end = arr.length-1,mid=0;
		while(start<end) {
			mid = start + ((end-start)>>1);
			if(arr[mid] > arr[mid+1]){
                end = mid;
            }else{
                start = mid+1;
            }
			
		}
		return start;
	}
	
	public static void main(String[] args) {
		int arr[]= {1,2,3,4,5,3,1};
		System.out.println(find_in_Mountain_Array(arr,3));
		
		int arr1[]= {0,1,3,4,5,6,7};
		System.out.println(find_in_Mountain_Array(arr1,3));
		System.out.println(find_in_Mountain_Array(arr1,4));
		
		int arr2[]= {0,1,2,4,2,1};
		System.out.println(find_in_Mountain_Array(arr2,3));
		
		int arr3[]= {1,2,3,5,3};
		System.out.println(find_in_Mountain_Array(arr3,3));
		System.out.println(find_in_Mountain_Array(arr3,2));
		System.out.println(find_in_Mountain_Array(arr3,0));
	}

}
