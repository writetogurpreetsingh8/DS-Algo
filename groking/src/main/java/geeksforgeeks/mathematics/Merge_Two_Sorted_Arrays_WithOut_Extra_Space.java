package geeksforgeeks.mathematics;

import java.util.Arrays;

public class Merge_Two_Sorted_Arrays_WithOut_Extra_Space {

	private static void merging(int arr1[],int arr2[]) {
		
		if( (arr1 == null || arr1.length == 0) || (arr2 == null || arr2.length == 0) ) {
			System.out.println("invalid arrays are given................");
			return;
		}
		
		int n = arr1.length,m = arr2.length;
		int gap = (int) Math.ceil(((double)n+m)/2);
		int i,k;
		while(gap>0) {
			for(i=0; (i+gap)<n;i++) {
				swapArrayValues(arr1,arr1,i,(i+gap));
			}
			for(k=(gap>n)?gap-n:0;(i<n && k<m);i++,k++) {
				swapArrayValues(arr1,arr2,i,k);
			}
			for(int j=0; (k<m && (j+gap)<m);j++) {
				swapArrayValues(arr2,arr2,j,(j+gap));
			}
			gap = gap/2 !=0 ? (int) Math.ceil((double)gap/2) : 0;
		}
		
	}
	
	private static void swapArrayValues(int arr1[], int arr2[],int source,int destination) {
		if(arr1[source] > arr2[destination]) {
			int temp = arr1[source];
			arr1[source] = arr2[destination];
			arr2[destination] = temp;
		}
	}
	
	public static void main(String[] args) {
			
		//int arr1[]= {1,3,5,7};
		//int arr2[]= {0,2,6,8,9};
		//int arr1[]= {1,5,9,10,15,20};
		//int arr2[]= {2,8,13,13};
		int arr1[]= {2,3,5,7,8};
		int arr2[]= {1,5,9,10,11,15,13,14,18,20,22,24,26,28,30,32,34,36,37,40};
		//int arr1[]= {7,9,9,10,11,11,13,14,17,19};
		//int arr2[] = {1,1,4,5,8,11,13,16,19,19};
		System.out.println("both the arrays before merging..............");
		System.out.println("array 1 = "+Arrays.toString(arr1));
		System.out.println("array 2 = "+Arrays.toString(arr2));
		merging(arr1,arr2);
		System.out.println("both the arrays after merging..............");
		System.out.println("array 1 = "+Arrays.toString(arr1));
		System.out.println("array 2 = "+Arrays.toString(arr2));
		
		
	}

}
