package recursion;

public class PrintNDigitBinaryNumbers {

	
	private static int counter;

	
	private static void printNDigitBinaryNumbers(int n) {
		
		if(n<1) {
			System.out.println("invalid given N....... Number must be greater then or equal to 1");
			return;
		}
		printNDigitBinaryNumbers(n,"");
	}
	
	private static void printNDigitBinaryNumbers(int n,String output) {
		
		if(n == 0) {
			System.out.println(output);
			return;
		}
		counter++;
		
		String output1 = output;
		String output2 = output;
		
		output1 = output1+"1";
		output2 = output2+"0";
		n = n-1;
		printNDigitBinaryNumbers(n,output1);
		printNDigitBinaryNumbers(n,output2);
		
	}
	
	
	public static void main(String[] args) {
		
		PrintNDigitBinaryNumbers.printNDigitBinaryNumbers(3);
		System.out.println("total passess are "+counter);

	}

}
