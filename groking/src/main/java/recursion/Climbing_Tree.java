package recursion;

import java.util.Arrays;

public class Climbing_Tree {

	/**
	 * DP version
	 * @param k
	 * @return
	 */
	public static int climbStairs(int k) {
        if(k > 0) {
            int array[] = new int [k+1];
            Arrays.fill(array, -1);
			 return climbStairs0(k,0,array);
		}
		return 0;
    }
	
	private static int climbStairs0(int k, int steps, int[] array) {
		if(k == 0) {
			return (steps+1);
		}
        if(array[k] !=-1 ) {
			steps = (steps + array[k]);
			return steps;
		}
		if(k == 1) {
			steps = climbStairs0(k-1,steps,array);
            array[k] = steps;
		}
		else {
			steps = climbStairs0(k-1,steps,array);
			array[k] = steps;
			steps = climbStairs0(k-2,steps,array);
            array[k] = steps;
		}
		return array[k];
	}
	/**
	 * without DP , not having efficient TC 
	 * @param n
	 * @return
	 */
	public static int climbing_Tree(int n) {
		if(n < 0 ) {
			return -1;
		}
		return climb(n,"",0);
		
	}
	private static int climb(int n, String output,int steps) {
		if(n == 0) {
			System.out.println(output);
			return (steps+1);
		}
		String output1 = output;
		output1 = output1+"1 ";
		if(n > 1){
			String output2 = output;
			output2 = output2+"2 ";
			steps = climb(n-1,output1,steps);
			steps = climb(n-2,output2,steps);
		}
		else {
			steps = climb(n-1,output1,steps);
		}
		return steps;
	}
	public static void main(String[] args) {
		System.out.println("for 5 stairs");
			System.out.println(climbStairs(5));
			System.out.println("for 2 stairs");
			System.out.println(climbStairs(2));
			System.out.println("for 3 stairs");
			System.out.println(climbStairs(3));
	}

}
