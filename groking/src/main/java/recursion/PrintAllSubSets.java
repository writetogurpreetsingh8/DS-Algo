package recursion;

import java.util.Date;

public class PrintAllSubSets {

	private static int count;
	
	private static void printAllSubSets(String string) {
	
		if(string == null || string.isEmpty()) {
			System.out.println("invalid string.......");
			return;
		}
		
		print(string,"");
	}
	
	private static void print(String input,String output) {
		if(input.isEmpty()) {
			System.out.print(output+"\t");
			return;
		}
		count++;	
		String output1 = output;
		String output2 = output;
		
		output2 = output2+input.charAt(0);
		
		input = input.substring(1);
		
		print(input, output1);
		print(input, output2);
	}
	
	public static void main(String[] args) {
		
		System.out.println("\n");
		System.out.println(new Date());
		System.out.println("\n");
		PrintAllSubSets.printAllSubSets("abc");
		System.out.println("\ntotal sub-sets are "+count);
		
		System.out.println(new Date());
		
	}

}
