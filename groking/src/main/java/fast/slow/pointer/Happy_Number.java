package fast.slow.pointer;

public class Happy_Number {

	private static boolean isHappyNumber(int n) {
		int slow = n, fast = n;
        do{
            slow = sumAfterSquare(slow);
            fast = sumAfterSquare(sumAfterSquare(fast));
        }while(slow != fast);
        return (slow == 1);
    }
    
    private static int sumAfterSquare(int n){
        
        int sum = 0;
        int result = 0;
        while(n >0 ){
            result = n % 10;
            sum = sum + (result * result);
            n = n / 10;
        }
        return sum;
    }
	
	
	public static void main(String[] args) {
		System.out.println(isHappyNumber(6));
		System.out.println(0-(-5));
	}

}
