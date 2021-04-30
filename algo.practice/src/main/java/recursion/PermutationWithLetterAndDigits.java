package recursion;

public class PermutationWithLetterAndDigits {

	private static void permutationWithLetterAndDigits(String input,String output) {
		
		if(input.length() == 0) {
			System.out.println(output);
			return;
		}
		
		String output1 = output;
		String output2 = output;
		
		int c = input.charAt(0);
		
		input = input.substring(1);
		
		if( !(c >=48 && c <= 58) ) {
			
			output1 = output1+Character.toLowerCase((char)c);
			output2 = output2+Character.toUpperCase((char)c);
			permutationWithLetterAndDigits(input,output1);
			permutationWithLetterAndDigits(input,output2);
		}
		else {
			output1 = output1+(char)c;
			permutationWithLetterAndDigits(input,output1);
		}
	}
	
	public static void main(String[] args) {
		PermutationWithLetterAndDigits.permutationWithLetterAndDigits("a0B9", "");
	}

}
