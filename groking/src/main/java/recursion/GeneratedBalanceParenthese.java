package recursion;

public class GeneratedBalanceParenthese {

	private static void generatedBalanceParenthese(int n) {
		
		if(n <=1 ) {
			System.out.println("invalid number given!!!!");
			return;
		}
		// out of both methods are same but if conditions are different
		generatedBalanceParenthese(n,n,""); 
		generatedBalanceParenthese1(n,n,"");
	}
	
	private static void generatedBalanceParenthese(int o,int c,String output) {
		
		if( o == 0 && c == 0) {
			System.out.println(output);
			return;
		}
		
		if(c == o) {
			output = output + "(";
			generatedBalanceParenthese(o-1,c,output);
		}	
		else if(o == 0 && c !=0 ){
			output = output  + ")";
			generatedBalanceParenthese(o,c-1,output);
		}
		else {
			String output1 = output;
			String output2 = output;
			
			output2 = output2 + ")";
			output1 = output1 + "(";
			
			generatedBalanceParenthese(o-1,c,output1);
			generatedBalanceParenthese(o,c-1,output2);
		}
	}
	
	private static void generatedBalanceParenthese1(int o,int c,String output) {
		
		if( o == 0 && c == 0) {
			System.out.println(output);
			return;
		}
		
		
		if(o !=0 && o < c) {
			String output1 = output;
			String output2 = output;
			
			output2 = output2 + "(";
			output1 = output1 + ")";
			
			generatedBalanceParenthese1(o,c-1,output1);
			generatedBalanceParenthese1(o-1,c,output2);
		}
		else if(o == c) {
			String output1 = output;
			output1 = output1 + "(";
			generatedBalanceParenthese1(o-1,c,output1);
		}
		else {
			String output1 = output;
			output1 = output1 + ")";
			generatedBalanceParenthese1(o,c-1,output1);
		}
	}
	
	public static void main(String[] args) {
		GeneratedBalanceParenthese.generatedBalanceParenthese(5);
		System.out.println("\n");
		GeneratedBalanceParenthese.generatedBalanceParenthese(5);
	}

}
