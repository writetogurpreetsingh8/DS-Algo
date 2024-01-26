package cyclic.sort;

import java.lang.reflect.Array;

public class Find_Missing_And_Repeating_Numbers {

	private static int[] find_Missing_And_Repeating_Numbers(int[] arr){
		
		if(arr == null || arr.length <=1 ) {
			return (int[])Array.newInstance(int[].class, 0); 
		}
		
		int i=0,k=0;
		
		while(i<arr.length) {
			k = arr[i]-1;
			if(arr[k] != arr[i]) {
				swap(arr,i,k);
			}else {
				i++;
			}
		}
		
		for (int j = 0; j < arr.length; j++) {
			if((j+1) != arr[j]) {
				return new int[] {arr[j],(j+1)};
			}
		}
		return (int[])Array.newInstance(int[].class, 0);  
	}
	
	private static void swap(int[] arr, int source, int target) {
		arr[source] = arr[source] ^ arr[target];
		arr[target] = arr[source] ^ arr[target];
		arr[source] = arr[source] ^ arr[target];
	}
	
	public static void main(String[] args) {
		int arr[]= {3,1,2,5,2};
		System.out.println(find_Missing_And_Repeating_Numbers(arr));
		
		int arr1[]= {3,1,2,3,4,6};
		System.out.println(find_Missing_And_Repeating_Numbers(arr1));
		
		int arr2[]= {1,2,2,4};
		System.out.println(find_Missing_And_Repeating_Numbers(arr2));
		
		int arr3[]= {1,1};
		System.out.println(find_Missing_And_Repeating_Numbers(arr3));
}
}
