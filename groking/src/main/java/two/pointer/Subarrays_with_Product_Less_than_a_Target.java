package two.pointer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Subarrays_with_Product_Less_than_a_Target {

	private static List<List<Integer>> subarrays_with_Product_Less_than_a_Target(int arr[],int target){
		
		int j=0,product=1;
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		
		for (int i = 0; i < arr.length; i++) {
			
			product*=arr[i];
			while(product >= target && j<i ) {
				product/=arr[j];
				j++;
			}
			
			List<Integer> list = new LinkedList<Integer>();
			for (int k = i; k >=j ; k--) {
				list.add(0,arr[k]);
				result.add(new ArrayList<Integer>(list));
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		int arr[]= {2, 5, 3, 10};
		System.out.println(subarrays_with_Product_Less_than_a_Target(arr,30));
		
		int arr1[]= {8, 2, 6, 5};
		System.out.println(subarrays_with_Product_Less_than_a_Target(arr1,50));
		
		int arr2[]= {10, 5, 2, 6};
		System.out.println(subarrays_with_Product_Less_than_a_Target(arr2,100));
	}

}
