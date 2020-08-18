package recursion;

public class CalculateExpoUsingRecursion {

	private static int calculateExpoUsingRecursion(int base,int expo) {
		
		if(base <=1 || expo < 0) {
			System.out.println("invalid base or expo or both!!!!!1");
			return -1;
		}
		if(expo == 0) {
			return 1;
		}
		if(expo == 1) {
			return base;
		}
		
		return calculateExpoUsingRecursion0(base,expo);
		
	}
	
	private static int calculateExpoUsingRecursion0(int base,int expo) {
	
		if(expo == 1) {
			return base;
		}
		int ex = calculateExpoUsingRecursion0(base,expo-1);
		return ex*base;
	}
	
	
	public static void main(String[] args) {

		System.out.println(CalculateExpoUsingRecursion.calculateExpoUsingRecursion(2,7));
	}

}
