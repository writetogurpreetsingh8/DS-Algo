package recursion;

public class CalucatePowerFunction {

// brute forch approach having O(N) TC, no extra space , not extra stack
//
	
	private static int calculatePowerFunction(int value, int powerValue) {
		
		int result = 1;
				
		for(int i=1;i<=powerValue;i++) {
			result = (result * value);
		}
		return result;	
	}
	// improved approach divide and conquer approach O(LOGN) TC no extra space , logn extra stack
	static double calculatePowerFunctionRecursively(double base,int power) {
		
		if(power == 0) {
			return 1;//  base case
		}
		if(power == 1) {
			return base; // base case
		}
		double p = 0;
			p = calculatePowerFunctionRecursively(base,Math.abs(power/2));
		if(power % 2 == 0) {
			p = (p * p);
		}
		else {
			p = (base * p * p);
		}
		if(power < 0)
		return 1/p;
		else
		return p;
	}
			
		private static double powerFun(int base, int power) {
			
			if(power == 0) {
				return 1;
			}
			if(power == 1) {
				return base; 
			}
			int p = Math.abs(power);
			double re = 1;
			double b = base;
			while(p > 0) {
				if(p % 2 != 0)
					re = b * re;
					p = p/2;
					b = b * b;
			}
			if(power < 0)
			return 1/re;
			else
			return re;
		}
	
	public static void main(String[] args) {

		
		System.out.println(CalucatePowerFunction.calculatePowerFunctionRecursively(0, -3));
		System.out.println(Math.pow(0, -3));
		
		System.out.println(CalucatePowerFunction.calculatePowerFunctionRecursively(0, 3));
		System.out.println(Math.pow(0, 3));
		
		System.out.println(Math.pow(-2, -3));
		System.out.println(CalucatePowerFunction.calculatePowerFunctionRecursively(-2, -3));
		
		System.out.println(Math.pow(-0, -3));
		System.out.println(CalucatePowerFunction.calculatePowerFunctionRecursively(-0, -3));
		
		System.out.println(Math.pow(-0, 3));
		System.out.println(CalucatePowerFunction.calculatePowerFunctionRecursively(-0, 3));
		
		System.out.println("end");

		System.out.println(Math.pow(3, 5));
		System.out.println(CalucatePowerFunction.calculatePowerFunctionRecursively(3, 5));
		
		System.out.println(Math.pow(3,-5));
		System.out.println(CalucatePowerFunction.calculatePowerFunctionRecursively(3, -5));

		System.out.println(Math.pow(-3,5));
		System.out.println(CalucatePowerFunction.calculatePowerFunctionRecursively(-3, 5));
		
		System.out.println(Math.pow(-3,-5));
		System.out.println(CalucatePowerFunction.calculatePowerFunctionRecursively(-3, -5));
		
		double k = 2/0.0;
		System.out.println("k "+k);
	}

}
