package geeksforgeeks.mathematics;

public class GCD {

	private static int gcd(int a,int b) {
	
		if(b == 0 ) {
			return a;
		}
		int c = a%b;
		return gcd(b,c);
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(gcd(3,18));
	}

}
