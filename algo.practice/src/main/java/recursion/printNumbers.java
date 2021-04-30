package recursion;

public class printNumbers {

	static void print(int n) {
		
		if(n == 0){
			//System.out.print(n);
			return;
		}
		print(n-1);
		System.out.print(n);
	}
	
	public static void main(String[] args) {
		print(5);
	}
}
