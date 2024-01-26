package binary_search;

/**
 * 
 * @author Tony.Stark
 * Leet-code# 81 
 */
public class Search_Element_into_Sorted_Rotated_Array_Duplicate_Elements {

	/**
	 * TC O(logN)
	 * Stack space O(1)
	 * aux space O(1)
	 */
	// duplicate values need to change the logic Leet-Code# see 81
	public static boolean search(int[] arr, int targetElement) {
        
        if(arr.length == 1 && arr[0] == targetElement){
            return true;
        }
        
        int start = 0, end = arr.length-1,mid=0;
        
        while(start<=end){
            mid = start + ((end-start)/2);
            
            if(arr[mid] == targetElement){
                return true;
            }
            if(arr[start] == arr[mid] && arr[mid] == arr[end]){
                start++;
                end--;
            }
            else if(arr[start] <= arr[mid]){
                if(arr[start] <= targetElement && arr[mid] >= targetElement){
                        end = mid-1;
                }else{
                    start = mid+1;
                }
            }
            else{
                if(arr[mid] <= targetElement && arr[end] >= targetElement){
                    start = mid+1;
                }else{
                    end = mid-1;
                }    
            }
        }
        return false;
    }
	
	/**
	 * TC O(logN)
	 * Stack space O(1)
	 * aux space O(1) 
	 * So total TC is O(logN) + O(logN) = O(2+logN) and 2 is constant and final TC is O(logN)
	 */
	// Duplicate values into array is not allowed in this Problem
	
		
	public static void main(String[] args) {
		
		int arr[]= {2,5,6,0,0,1,2};
		//System.out.println(search_Element_into_Sorted_Rotated_Array(arr,0));
		
		int arr1[] = {1,1,1,1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1};
		//System.out.println(search_Element_into_Sorted_Rotated_Array(arr1,2));
		
		int arr2[]= {1,0,1,1,1};
		//System.out.println(search_Element_into_Sorted_Rotated_Array(arr2,0));
		
		int arr3[]= {1};
		//System.out.println(search_Element_into_Sorted_Rotated_Array(arr3,1));
		
		int arr4[]= {2,2,2,3,2,2,2};
		System.out.println(search(arr4,3));
		
		
	}

}
