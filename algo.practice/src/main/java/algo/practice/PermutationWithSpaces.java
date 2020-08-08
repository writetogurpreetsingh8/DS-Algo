package algo.practice;

public class PermutationWithSpaces {
	
	private static void permutationWithSpaces(String input) {
		
		if(input == null || input.trim().isEmpty()) {
			
			System.out.println("invalid given input!!!!");
			return;
		}
		permutationWithSpaces0(String.valueOf(input.charAt(0)),input.substring(1));
	}
	
	private static void permutationWithSpaces0(String output,String input) {
		
		if(input.length() == 0) {
			System.out.println(output);
			return;
		}
		String output1 = output;
		String output2 = output;
		
		output1 = output1 + input.charAt(0);
		output2 = output2 + " " +input.charAt(0);
		
		input = input.substring(1);
		
		permutationWithSpaces0(output1,input);
		permutationWithSpaces0(output2,input);
	}
	
	public static void main(String[] args) {
		
		PermutationWithSpaces.permutationWithSpaces("ABC");

	}

}
