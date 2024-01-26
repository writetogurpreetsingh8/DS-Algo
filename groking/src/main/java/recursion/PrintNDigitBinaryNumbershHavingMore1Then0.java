package recursion;

public class PrintNDigitBinaryNumbershHavingMore1Then0 {

	private static int counter;
	
	private static void printNDigitBinaryNumbershHavingMore1Then0(int n) {
		
		if(n<1) {
			System.out.println("invalid given N....... Number must be greater then or equal to 1");
			return;
		}
		printNDigitBinaryNumbershHavingMore1Then0(n,0,0,"");
	}
	
	private static void printNDigitBinaryNumbershHavingMore1Then0(int n,int ones,int zeros,String output) {
		
		if(n == 0) {
			System.out.println(output);
			return;
		}
		counter++;
		
		if(ones == zeros) {
			output = output + "1";
			n = n-1;
			printNDigitBinaryNumbershHavingMore1Then0(n,ones+1,zeros,output);
		}
		else {
			
			String output1 = output;
			String output2 = output;
			
			output1 = output1+"1";
			output2 = output2+"0";
			
			n = n-1;
			printNDigitBinaryNumbershHavingMore1Then0(n,ones+1,zeros,output1);
			printNDigitBinaryNumbershHavingMore1Then0(n,ones,zeros+1,output2);
			
		}
		
	}
	
	
	public static void main(String[] args) {
		
		PrintNDigitBinaryNumbershHavingMore1Then0.printNDigitBinaryNumbershHavingMore1Then0(3);
		System.out.println("total passess are "+counter);
	}

}
