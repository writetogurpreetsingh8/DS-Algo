package cyclic.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Find_First_K_Missing_Positive_numbers {

	private static List<Integer> find_First_K_Missing_Positive_numbers(final int[] arr, final int k) {
	
			if(arr == null || arr.length <=1 ) {
				return Collections.emptyList();
			}
			
			int i=0,j=0;
			Set<Integer> set = new HashSet<Integer>(k);
			List<Integer> result = new ArrayList<Integer>();
			
			while(i<arr.length) {
				j = arr[i] - 1;
				if(arr[i] > 0 && arr[i] <= arr.length && arr[i] != arr[j]) {
					swap(arr,i,j);
				}else {
					if(arr[i] > 0 && i!=j) {
						set.add(arr[i]);						
					}
					i++;
				}
			}
			int l=0,candidateNo=arr.length;
			while(l < arr.length && result.size()<k) {
				
					if(arr[l] != (l+1)) {
						result.add((l+1));
					}
					l++;
			}
			
			while(result.size()<k) {
				candidateNo++;
				if(!set.contains(candidateNo)) {
					result.add(candidateNo);
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
		int arr[]= {3,-1,4,5,5};
		System.out.println(find_First_K_Missing_Positive_numbers(arr,3)); //[1,2,6]
		
		int arr1[]= {2,3,4};
		System.out.println(find_First_K_Missing_Positive_numbers(arr1,3)); //[1,5,6]
		
		int arr2[]= {-2,-3,4};
		System.out.println(find_First_K_Missing_Positive_numbers(arr2,3)); //[1,5,6]
		
		int arr3[]= {-2,-3,4};
		System.out.println(find_First_K_Missing_Positive_numbers(arr3,2)); //[1,2,3]
	}

}
