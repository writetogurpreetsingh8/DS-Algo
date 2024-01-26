package dp;

import java.util.Arrays;

public class ClimbStairs {

	static int counter = 0;

	private static int climbStairs0(int k,int array[]) {
		counter++;
		
		if(k == 0) {
			return 1;
		}
		if(array[k] !=-1 ) {
			return array[k];
		}
		if(k == 1) {
			array[k] = array[k-1] + climbStairs0(k-1,array);
		}
		else {
			array[k] = array[k-1] + climbStairs0(k-1,array);
			array[k] = array[k-1] + climbStairs0(k-2,array);
		}
		return array[k];
	}
	
	private static int climbStairs(int k) {
	
		int array[] = new int [k+1];
		if(k > 0) {
			Arrays.fill(array, -1);
			return climbStairs0(k,array);
		}
		return 0;
		
	}
	
	public static void main(String[] args) {
		System.out.println(ClimbStairs.climbStairs(5));
		System.out.println(counter);
	}

}
