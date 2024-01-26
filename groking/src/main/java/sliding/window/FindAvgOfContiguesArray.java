package sliding.window;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAvgOfContiguesArray {

	private static float findAvgOfContiguesArray1(int[] arr,int k) {
	
		if(arr == null || arr.length == 0) {
			return -1f;
		}
		if(arr.length == 1) {
			return (float)arr[0];
		}
		
		int sum=0,j=0;
		int maxSum = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			
			sum+=arr[i];
			if(i>=(k-1)) {
				maxSum = Math.max(maxSum,sum);
				sum-= arr[j];
				j++;
			}
		}
		return ((maxSum*1.0f)/k);
	}
	
	
	private static float[] findAvgOfContiguesArray(int[] arr,int k) {
		
		int sum=0,j=0;
		float[] result = new float[arr.length-k+1];
		for(int i=0;i<arr.length;i++) {
			
			sum+=arr[i];
			if(i>=(k-1)) {
				result[j] = (sum/k)*1.0f;
				sum-=arr[j];
				j++;
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		
		int array[] = {1,3,2,6,-1,4,1,8,2};
		float[] array1 = findAvgOfContiguesArray(array,5);
		
		System.out.println((0+(-2)));
		System.out.println("");
		int array2[]={8860,-853,6534,4477,-4589,8646,-6155,-5577,-1656,-5779,-2619,-8604,-1358,-8009,4983,7063,3104,-1560,4080,2763,5616,-2375,2848,1394,-7173,-5225,-8244,-809,8025,-4072,-4391,-9579,1407,6700,2421,-6685,5481,-1732,-8892,-6645,3077,3287,-4149,8701,-4393,-9070,-1777,2237,-3253,-506,-4931,-7366,-8132,5406,-6300,-275,-1908,67,3569,1433,-7262,-437,8303,4498,-379,3054,-6285,4203,6908,4433,3077,2288,9733,-8067,3007,9725,9669,1362,-2561,-4225,5442,-9006,-429,160,-9234,-4444,3586,-5711,-9506,-79,-4418,-4348,-5891};
		System.out.println("length of array2 is "+array2.length);
		System.out.println("max avg value is "+Arrays.toString(findAvgOfContiguesArray(array2,10)));
		
	}

}
