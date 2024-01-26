package geeksforgeeks.mathematics;

public class Find_Fabo_Up_To_N {

	static int findFabo(int n) {
	
		if(n == 0) {
			return 0;
		}
		if(n  == 1) {
			return 0;
		}
		if(n  == 2) {
			return 1;
		}
		if( n == 3) {
			return 1;
		}
		int a=0,b=1,c=0;
		while(n>1) {
			c = ((a+b)%1000000007);
			a = b;
			b = c;
			n--;
		}
		return c;
	}
	
	public static void main(String[] args) {
		System.out.println(findFabo(5));

	}

}
