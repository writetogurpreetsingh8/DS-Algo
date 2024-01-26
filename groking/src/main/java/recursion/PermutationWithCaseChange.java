package recursion;

public class PermutationWithCaseChange {

	private static void permutationWithCaseChange(String input,String output) {
		
		if(input.length() == 0 ) {
			System.out.println(output);
			return;
		}
		
		String output1 = (output+input.charAt(0));
		char ch = Character.isUpperCase(input.charAt(0)) ? Character.toLowerCase(input.charAt(0)) 
				: Character.toUpperCase(input.charAt(0));
		String output2 = (output+ch);
		
		input = input.substring(1);
		
		permutationWithCaseChange(input,output1);

		permutationWithCaseChange(input,output2);
	}
	
	public static void main(String[] args) {
		String tt="";
		PermutationWithCaseChange.permutationWithCaseChange("AB", tt);
	}

}
