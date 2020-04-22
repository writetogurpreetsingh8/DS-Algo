package algo.practice;

public class RecursiveCheckPalindromString {

	void panlindrom(String input) {
		
		if(input == null || input.isEmpty() || input.length() <= 1) {
			System.out.println("invalid string given........");
			return;
		}
		recursivePalindorm(input,0,input.length()-1);
	}
	
	private void recursivePalindorm(String input,int start,int end) {
		
		if(start >= end) {
			System.out.println("given string is a palindrom. String......");
			return;
		}
		if(input.charAt(start) != input.charAt(end)) {
			System.out.println("given string isn't a panlindrom string.........");
			return;
		}
		recursivePalindorm(input,start+1,end-1);
	}
	
	public static void main(String[] args) {
			
		RecursiveCheckPalindromString instance = 	new RecursiveCheckPalindromString();
		instance.panlindrom("abaulluaba");
	}

}
