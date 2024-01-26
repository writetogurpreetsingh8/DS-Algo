package two.pointer;

import java.util.Arrays;

public class pair_with_target_sum {

	private static int[] pairWithTargetSum(int[] arr,int targetSum) {
		
		int i=0,j=arr.length-1,sum=0;
		while(i<j) {
			sum = arr[i] + arr[j];
			if(sum == targetSum) {
				return new int[] {(i+1),(j+1)};
			}
			if(sum > targetSum) {
				j--;
			}else {
				i++;
			}
		}
		return new int[] {-1,-1};
	}
	
	public static void main(String[] args) {
		int arr[]= {1,2,3,4,6};
		System.out.println(Arrays.toString(pairWithTargetSum(arr,6)));
		System.out.println((-3+-3));
	}

}
