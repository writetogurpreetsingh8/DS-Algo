package cyclic.sort;

import java.util.ArrayList;
import java.util.List;

public class Find_all_Missing_Numbers {

	private static List<Integer> find_all_Missing_Numbers(int[] arr) {
		
		List<Integer> result = new ArrayList<Integer>();
		
		if(arr == null || arr.length <=1 ) {
			return result;
		}
		
		int i=0;
		int j=0;
		while(i<arr.length) {
			j = arr[i]-1;
				if( arr[i] != arr[j]) {
					swap(arr,i,j);
				}else {
					i++;
				}
		}
		for (int k = 0; k < arr.length; k++) {
			if((k+1) != arr[k]) {
				result.add((k+1));
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
		int arr[]= {2,3,1,8,2,3,5,1};
		System.out.println(find_all_Missing_Numbers(arr));
		
		int arr1[]= {2,3,2,1};
		System.out.println(find_all_Missing_Numbers(arr1));
		
		int arr2[]= {2,4,2,1};
		System.out.println(find_all_Missing_Numbers(arr2));
	}

}
