package geeksforgeeks.mathematics;

import java.util.Arrays;

public class Product_Of_Two_Arrays {

	static int[] productOfArrays(int actualArray[]) {
		
		if(actualArray == null || actualArray.length <=1 ) {
			System.out.println("invalid array");
			return actualArray;
		}
		int left[] = new int[actualArray.length];
		int right[] = new int[actualArray.length];
		
		left[0] = 1;
		for(int i=1;i<actualArray.length;i++) {
			left[i] = left[i-1] * actualArray[i-1];
		}
		
		right[actualArray.length-1] = 1;
		for(int i=actualArray.length-2;i>=0;i--) {
			right[i] = right[i+1] * actualArray[i+1];
		}
		
		for(int i=0;i<actualArray.length;i++) {
			right[i] = left[i] * right[i];
		}
		return right;
	}
	
	public static void main(String[] args) {
		int array[] = {10,3,5,6,2};
		int result[] = productOfArrays(array);
		System.out.println(Arrays.toString(result));
		// 0 to 9
		//48 to 57
		int j=4%9;
		System.out.println("4%9 "+j);
		j = j+48;
		System.out.println("j+48 ascii code is "+j);

	}

}
