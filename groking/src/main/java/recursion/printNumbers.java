package recursion;

public class printNumbers {

	static void print(int n) {
		
		if(n == 0){
			return;
		}
		print(n-1);
		System.out.print(n);
	}
	
	public static void main(String[] args) {
		print(7);
	}
}
