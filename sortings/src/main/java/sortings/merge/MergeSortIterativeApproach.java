package sortings.merge;

import java.util.Arrays;

public class MergeSortIterativeApproach {

	private static void mergeSortIterative(int array[]) {
		
		if( (array == null || array.length <=1 )) {
			System.out.println("invalid array.......");
			return;// invalid arrays
		}
		
		int lower = 0 , mid = 0 , end = array.length-1,upper = 0;
		
		for(int i=1;i<=end; i=(i*2)) {
			
			for(int j=0;j<=end; j+=(2*i)) {
				
				lower = j;
				mid = Integer.min((lower + i - 1),end);
				upper = Integer.min(end, (lower+(2 * i)-1));
				merging(array,lower,mid,upper);
			}
		}
		
	}
	
	private static void merging(int array[],int lower,int mid,int upper) {
		
		int i = lower;
		int j = mid+1;
		int k = 0;
		
		int tempArray[] = new int[((mid - lower) + (upper-mid) + 1)];
		
		while( i <= mid && j <=upper) {
			
			if(array[i] < array[j]) {
				tempArray[k] = array[i];
				i++;
			}
			else {
				tempArray[k] = array[j];
				j++;
			}
			k++;
		}
		
		while(i<=mid) {
			tempArray[k] = array[i];
			k++;i++;
		}
		
		while(j<=upper) {
			tempArray[k] = array[j];
			k++;j++;
		}
		
		for(int o=0;o<tempArray.length;o++) {
			
			array[lower] = tempArray[o];
			lower++;
		}
	}
	
	public static void main(String[] args) {

		int array[] = {1,2,5,3,6,4,7,10,8,0};
		
		System.out.println("array before applied merge sort is ");
		System.out.println(Arrays.toString(array));
		
		MergeSortIterativeApproach.mergeSortIterative(array);
		
		System.out.println("array after applied merge sort is ");
		System.out.println(Arrays.toString(array));
		
	}

}
