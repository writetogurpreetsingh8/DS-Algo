package cyclic.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Find_All_Duplicate_numbers {

	/**
	 * TC O(N)
	 * SC O(N)
	 * With Set to remove the duplicate elements 
	 */
	private static List<Integer>  find_All_Duplicate_numbers_With_Set(int[] arr){
		
		Set<Integer> result = new HashSet<Integer>();
		if(arr == null || arr.length <=1 ) {
			return Collections.emptyList();
		}

		int i=0;
		int k=0;
		while(i<arr.length) {
			k = arr[i]-1;
				if(arr[i] != arr[k]) {
					swap(arr,i,k);
				}else {
					if(arr[i] == arr[k] && (i!=k)) {
						result.add(arr[i]);
					}
					i++;
				}
		}
		return new ArrayList<Integer>(result);
	}
	
	/**
	 * TC O(N)
	 * SC O(N)
	 * With-Out Set, Using List only to hold the all duplicate elements 
	 */
	private static List<Integer>  find_All_Duplicate_numbersWith_Out_Set(int[] arr){
		
		List<Integer>  result = new ArrayList<Integer>();
		if(arr == null || arr.length <=1 ) {
			return Collections.emptyList();
		}

		int i=0;
		int k=0;
		while(i<arr.length) {
			k = arr[i]-1;
				if(arr[i] != arr[k]) {
					swap(arr,i,k);
				}else {
					i++;
				}
		}
		for (int j = 0; j < arr.length; j++) {
			if( (j+1) != arr[j]) {
				result.add(arr[j]);
			}
		}
		return result;
	}
	
	
	private static void swap(int[] arr, int source, int target) {
		arr[source] = arr[source] ^ arr[target];
		arr[target] = arr[source] ^ arr[target];
		arr[source] = arr[source] ^ arr[target];
	}
	
	public static void main(String[] args) {
		
		int arr[]= {1,4,4,3,2};
		System.out.println(find_All_Duplicate_numbers_With_Set(arr)); //4
		System.out.println(find_All_Duplicate_numbersWith_Out_Set(arr)); //4
		
		int arr1[]= {2,1,3,3,5,4};
		System.out.println(find_All_Duplicate_numbers_With_Set(arr1)); //3
		System.out.println(find_All_Duplicate_numbersWith_Out_Set(arr1)); //3
		
		int arr2[]= {2,4,1,4};
		System.out.println(find_All_Duplicate_numbers_With_Set(arr2)); //4
		System.out.println(find_All_Duplicate_numbersWith_Out_Set(arr2)); //4
		
		int arr3[]= {3,4,4,5,5};
		System.out.println(find_All_Duplicate_numbers_With_Set(arr3)); //4,5
		System.out.println(find_All_Duplicate_numbersWith_Out_Set(arr3)); //4,5
		
		int arr4[]= {5,4,7,2,3,5,3};
		System.out.println(find_All_Duplicate_numbers_With_Set(arr4)); //5,3
		System.out.println(find_All_Duplicate_numbersWith_Out_Set(arr4));//5,3
		
		int arr5[]= {4,3,2,7,8,2,3,1};
		System.out.println(find_All_Duplicate_numbers_With_Set(arr5)); //2,3
		System.out.println(find_All_Duplicate_numbersWith_Out_Set(arr5));//2,3
		
		int arr6[]= {1,1,2};
		System.out.println(find_All_Duplicate_numbers_With_Set(arr6)); //2,3
		System.out.println(find_All_Duplicate_numbersWith_Out_Set(arr6)); //2,3
	}

}
