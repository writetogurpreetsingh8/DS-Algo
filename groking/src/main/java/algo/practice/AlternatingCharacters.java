package algo.practice;

public class AlternatingCharacters {

	public static void main(String[] args) {

		String str = "aaaa";
		//String str = "ABABABAB";
		//String str = "BABABA";
		//String str = "AAABBB";
		StringBuilder sb = new StringBuilder();
		char chars[] = str.toCharArray();
		
		for(int i = 0; i<chars.length-1; i++){
			if(chars[i] == chars[i+1]){
				sb.append(chars[i]);
			}
		}
		if(sb.length() == 0){
			System.out.println("ZERO");
		}
		else{
			System.out.println((str.length() - (str.length() - sb.length())));
		}
		
		//second approched
		char chars1[] = str.toCharArray();
		int counter = 0;
		for(int i = 0; i<chars1.length-1; i++){
			if(chars1[i] == chars1[i+1]){
				counter++;
			}
		}
		System.out.println("counter is "+counter);
		
		
		
	}

}
