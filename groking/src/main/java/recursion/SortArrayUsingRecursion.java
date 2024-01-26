package recursion;

import java.util.Arrays;

/**
 * 
 * @author Tony.Stark
 * 
 * TC  O(2^N)..
 * Stack O(N)
 * aux space O(1)
 * Recurrence relation  = 2T(n-1) + 1 
 */

public class SortArrayUsingRecursion {

	private static int  sort;
	private static int  insert;
	
	private static void sortArrayByUsingRecursion(int array[]) {
		
		if(array == null || array.length <= 1) {
			System.out.println("invalid array or having only 1 element into it!");
			return;
		}
		sortArray(array,array.length-1);
	}
	
	private static void sortArray(int array[],int size) { // Hypothesis
	
		sort++;
		if(size == 0) { // Base condition
			return;
		}
		int element = array[size];
		size = size - 1;
		sortArray(array, size); // Hypothesis
		insertElementIntoArray(array,++size,element); // Induction
	}
	
	private static void insertElementIntoArray(int array[],int size,int element) { // Hypothesis
		
		insert++;
		if(size == 0 || array[size-1] <= element) { // Base condition
			array[size] = element;
			return;
		}
		
		int value = array[size-1];
		size = size - 1;
		insertElementIntoArray(array,size,element); // Hypothesis 
		array[++size] = value; // Induction
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int array[] = {1,0,5,2,5,8,3,5,9,0,2,3,5,4,7,4,3,7,8,3,9,1,0,2,0,5,6,20,30,10,70,43,23,67,56,9,80,100,200,40,11,22,444,33,55,66,77,8,99,6,-1,1,0,5,2,5,8,3,5,9,0,2,3,5,4,7,4,3,7,8,3,9,1,0,2,0,5,6,20,30,10,70,43,23,67,56,9,80,100,200,40,11,22,444,33,55,66,77,8,99,6,-1,1,0,5,2,5,8,3,5,9,0,2,3,5,4,7,4,3,7,8,3,9,1,0,2,0,5,6,20,30,10,70,43,23,67,56,9,80,100,200,40,11,22,444,33,55,66,77,8,99,6,-1,1,0,5,2,5,8,3,5,9,0,2,3,5,4,7,4,3,7,8,3,9,1,0,2,0,5,6,20,30,10,70,43,23,67,56,9,80,100,200,40,11,22,444,33,55,66,77,8,99,6,-1,1,0,5,2,5,8,3,5,9,0,2,3,5,4,7,4,3,7,8,3,9,1,0,2,0,5,6,20,30,10,70,43,23,67,56,9,80,100,200,40,11,22,444,33,55,66,77,8,99,6,-1,1,0,5,2,5,8,3,5,9,0,2,3,5,4,7,4,3,7,8,3,9,1,0,2,0,5,6,20,30,10,70,43,23,67,56,9,80,100,200,40,11,22,444,33,55,66,77,8,99,6,-1,1,0,5,2,5,8,3,5,9,0,2,3,5,4,7,4,3,7,8,3,9,1,0,2,0,5,6,20,30,10,70,43,23,67,56,9,80,100,200,40,11,22,444,33,55,66,77,8,99,6,-1,1,0,5,2,5,8,3,5,9,0,2,3,5,4,7,4,3,7,8,3,9,1,0,2,0,5,6,20,30,10,70,43,23,67,56,9,80,100,200,40,11,22,444,33,55,66,77,8,99,6,-1,1,0,5,2,5,8,3,5,9,0,2,3,5,4,7,4,3,7,8,3,9,1,0,2,0,5,6,20,30,10,70,43,23,67,56,9,80,100,200,40,11,22,444,33,55,66,77,8,99,6,-1,1,0,5,2,5,8,3,5,9,0,2,3,5,4,7,4,3,7,8,3,9,1,0,2,0,5,6,20,30,10,70,43,23,67,56,9,80,100,200,40,11,22,444,33,55,66,77,8,99,6,-1,1,0,5,2,5,8,3,5,9,0,2,3,5,4,7,4,3,7,8,3,9,1,0,2,0,5,6,20,30,10,70,43,23,67,56,9,80,100,200,40,11,22,444,33,55,66,77,8,99,6,-1,1,0,5,2,5,8,3,5,9,0,2,3,5,4,7,4,3,7,8,3,9,1,0,2,0,5,6,20,30,10,70,43,23,67,56,9,80,100,200,40,11,22,444,33,55,66,77,8,99,6,-1};
		int array[]= {1,2,0,4};
		
		SortArrayUsingRecursion.sortArrayByUsingRecursion(array);
		System.out.println();
		System.out.println(Arrays.toString(array));
		System.out.println("\n for array length = "+array.length+" sort = "+sort+" and insert = "+insert+" total execution volume = "+(sort * insert));
	}

}
