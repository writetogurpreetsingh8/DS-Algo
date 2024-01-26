package recursion;

public class ReverseString {
	
	private static void reverseCharArray(char[] str,int lenght) {
		
		if(lenght == 0){
			return;
		}
		lenght = lenght - 1;
		char lastChar = str[lenght];
		reverseCharArray(str,lenght);
		str[str.length - (lenght + 1)] = lastChar;
		
	}
	
	static String reverseString(String str) {
	
		if(str == null) {
			return str;
		}
		if(str.length() == 1) {
			return str;
		}
			
		String temp = str.substring(0, str.length()-1);
		String lastString = str.substring(str.length()-1, str.length());
		String cstr = reverseString(temp);
		return (lastString+cstr);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*String str = "gurpreet";
		System.out.println(reverseString("gurpreet"));
		System.out.println(str.substring(str.length()-1, str.length()));
		*/
		char[] c={'a','b','c','d'};
		System.out.println("before reverse "+new String(c));
		//ReverseString.size = c.length-1;
		ReverseString.reverseCharArray(c,c.length);
		System.out.println("after reverse "+new String(c));

		
	}

}
