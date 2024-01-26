package two.pointer;

import java.util.Arrays;

public class remove_duplicate_into_sorted_array {
	
	private static int[] removeDuplicateIntoSortedArray(int[] arr) {
		
		if(arr.length == 0)
            return new int[] {};
		
		int dupCount=0,num=arr[0],index=1;
		for (int i = 1; i < arr.length; i++) {
			if(arr[i] == num) {
				dupCount++;
			}else {
				arr[index]=arr[i];
				num = arr[i];
				index++;
			}
		}
		System.out.println(arr.length-dupCount);
		return arr;
	}
	
	public static void main(String[] args) {
		int arr[]= {1,2,2,3,3,4,4,4,4,5,5};
		System.out.println(Arrays.toString(removeDuplicateIntoSortedArray(arr)));
		System.out.println(-(-5+2));

	}

}
