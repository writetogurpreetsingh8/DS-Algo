package recursion;

import java.util.Arrays;

public class Reverse_Array {

	public static void reverse_Array(int[] arr) {
		
		if(arr == null || arr.length <=1 ) {
			return;
		}
		reveseArray0(arr,arr.length,0);
	}
	
	private static void reveseArray0(int[] arr, int moveElementUpTo, int index) {
		
		// it is recursively iterating the array from staring and upto index == arr.length
		if(index == arr.length) {
			return;
		}
		int lastEle = arr[index]; // storing index-th value , in the beginning index is 0 and so on
		reveseArray0(arr,--moveElementUpTo,index+1); // recursively calling itself
		moveArrayElements(arr,moveElementUpTo,arr.length-1); // before swapping last element into first 0th step and so on 
		// need to shift/move the array elements from left to right
		arr[moveElementUpTo] = lastEle; // move last element into 0th place and so on
	}
	
	private static void moveArrayElements(int[] arr, int moveElementUpTo, int len) {
		
			// initially len is equal to arr.length-1
			len--; // start traversing the array recursively from arr.lenght-2 to less than moveElementUpTo 
			if( len < moveElementUpTo ) { // when len became less than moveElementUpTo than just return 
				return;
			}
			int ele = arr[len]; // storing element available on len-th place
			moveArrayElements(arr,moveElementUpTo,len); // recursively call itself
			arr[len+1] = ele; // shift/move the len-th elemnet which is stored into ele and put it into len+1 place
	}
	
	public static void main(String[] args) {
		int arr[]= {1,2,3,4,4,3,2,1};
		int array[] = {1,0,5,2,5,8,3,5,9,0,2,3,5,4,7,4,3,7,8,3,9,1,0,2,0,5,6,20,30,10,70,43,23,67,56,9,80,100,200,40,11,22,444,33,55,66,77,8,99,6,-1,1,0,5,2,5,8,3,5,9,0,2,3,5,4,7,4,3,7,8,3,9,1,0,2,0,5,6,20,30,10,70,43,23,67,56,9,80,100,200,40,11,22,444,33,55,66,77,8,99,6,-1,1,0,5,2,5,8,3,5,9,0,2,3,5,4,7,4,3,7,8,3,9,1,0,2,0,5,6,20,30,10,70,43,23,67,56,9,80,100,200,40,11,22,444,33,55,66,77,8,99,6,-1,1,0,5,2,5,8,3,5,9,0,2,3,5,4,7,4,3,7,8,3,9,1,0,2,0,5,6,20,30,10,70,43,23,67,56,9,80,100,200,40,11,22,444,33,55,66,77,8,99,6,-1,1,0,5,2,5,8,3,5,9,0,2,3,5,4,7,4,3,7,8,3,9,1,0,2,0,5,6,20,30,10,70,43,23,67,56,9,80,100,200,40,11,22,444,33,55,66,77,8,99,6,-1,1,0,5,2,5,8,3,5,9,0,2,3,5,4,7,4,3,7,8,3,9,1,0,2,0,5,6,20,30,10,70,43,23,67,56,9,80,100,200,40,11,22,444,33,55,66,77,8,99,6,-1,1,0,5,2,5,8,3,5,9,0,2,3,5,4,7,4,3,7,8,3,9,1,0,2,0,5,6,20,30,10,70,43,23,67,56,9,80,100,200,40,11,22,444,33,55,66,77,8,99,6,-1,1,0,5,2,5,8,3,5,9,0,2,3,5,4,7,4,3,7,8,3,9,1,0,2,0,5,6,20,30,10,70,43,23,67,56,9,80,100,200,40,11,22,444,33,55,66,77,8,99,6,-1,1,0,5,2,5,8,3,5,9,0,2,3,5,4,7,4,3,7,8,3,9,1,0,2,0,5,6,20,30,10,70,43,23,67,56,9,80,100,200,40,11,22,444,33,55,66,77,8,99,6,-1,1,0,5,2,5,8,3,5,9,0,2,3,5,4,7,4,3,7,8,3,9,1,0,2,0,5,6,20,30,10,70,43,23,67,56,9,80,100,200,40,11,22,444,33,55,66,77,8,99,6,-1,1,0,5,2,5,8,3,5,9,0,2,3,5,4,7,4,3,7,8,3,9,1,0,2,0,5,6,20,30,10,70,43,23,67,56,9,80,100,200,40,11,22,444,33,55,66,77,8,99,6,-1,1,0,5,2,5,8,3,5,9,0,2,3,5,4,7,4,3,7,8,3,9,1,0,2,0,5,6,20,30,10,70,43,23,67,56,9,80,100,200,40,11,22,444,33,55,66,77,8,99,6,-1};
		int array0[]= {1,0,5,2,-1,-2,-3};
		int ar[]= {1,2};
		
		reverse_Array(arr);
		System.out.println(Arrays.toString(arr));
		
		reverse_Array(array);
		System.out.println(Arrays.toString(array));
		
		reverse_Array(array0);
		System.out.println(Arrays.toString(array0));
		
		reverse_Array(ar);
		System.out.println(Arrays.toString(ar));
	}

}
