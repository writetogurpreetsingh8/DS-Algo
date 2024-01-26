package geeksforgeeks.mathematics;

public class Facto {

	private static int facto(int n) {
		if(n == 0) {
			return 1;
		}
		if(n == 1 || n == 2) {
			return n;
		}
		int temp = n;
		n = facto(n-1);
		temp = temp * n;
		return temp;
				
	}
	public static void main(String[] args) {
		System.out.println(facto(5));
	}

}
