package two.pointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Triplets_with_Smaller_Sum {

	private static List<List<Integer>> list;
	
	private static int triplets_with_Smaller_Sum(int arr[],int target) {
		
		list = new ArrayList<>();
		if(arr == null || arr.length < 3) {
			return -1;
		}
		Arrays.sort(arr);
		int left=0,right=0,current_sum=0,count=0;
		for(int i=0;i<arr.length-2;i++) {
			left = i+1;
			right = arr.length-1;
			current_sum = target-arr[i];
			
			while(left < right) {
				if(arr[left]+arr[right] < current_sum) {
					count+= right - left;
					//{-1, 1, 2, 3, 4};
					for(int j=right;j>left;j--) {
						list.add(Arrays.asList(arr[i],arr[left],arr[j]));
					}
					left++;
				}else {
					right--;
				}
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
		int arr[]= {-1, 0, 2, 3};
		//System.out.println(triplets_with_Smaller_Sum(arr,3));
		System.out.println(list);
		
		int arr1[]= {-1, 4, 2, 1, 3};
		System.out.println(triplets_with_Smaller_Sum(arr1,5));
		System.out.println("list is "+list);
	}

}
