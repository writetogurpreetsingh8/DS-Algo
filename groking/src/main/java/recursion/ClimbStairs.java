package recursion;

public class ClimbStairs {

	static int counter = 0;
	private static int climbStairs0(int k,int steps) {
		counter++;
		if(k == 0) {
			return (steps+1);
		}
		if(k == 1) {
		steps = climbStairs0(k-1,steps);
		}
		else {
			steps = climbStairs0(k-1,steps);
			steps = climbStairs0(k-2,steps);
		}
		return steps;
	}
	
	private static int climbStairs(int k) {
	
		if(k > 0) {
			 return climbStairs0(k,0);
		}
		return 0;
		
	}
	
	public static void main(String[] args) {
		System.out.println(ClimbStairs.climbStairs(45));
		System.out.println(counter);
	}

}
