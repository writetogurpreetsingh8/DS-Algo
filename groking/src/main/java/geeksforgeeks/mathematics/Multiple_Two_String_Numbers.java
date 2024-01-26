package geeksforgeeks.mathematics;

public class Multiple_Two_String_Numbers {

	//TC O(a*b) with constant space O(a+b)
	private static String multipleTwoStringNumbers(String a,String b) {
		
		boolean isMinus = false;
		
		if(b.charAt(0) == '-' && b.charAt(0) == '-') {
			b = b.substring(1);
			a = a.substring(1);
		}else if(b.charAt(0) == '-') {
			b = b.substring(1);
			isMinus = true;
		}else if(a.charAt(0) == '-') {
			a = a.substring(1);
			isMinus = true;
		}
		
		if(a.equals("0") || b.equals("0") || a.isEmpty() || b.isEmpty()) {
			return "0";
		}
		
		int carry, m = 0,k,op;
		int result[] = new int[(a.length() + b.length())];
		String temp;
		// we consider always, that b string should be greater then a else swap them
		if(b.length() < a.length()){
            temp = b;
            b = a;
            a = temp;
        }
		for(int i=a.length()-1;i>=0;i--) { // 123 
			carry = 0;
			k = (result.length-1)-m;
			for(int j=b.length()-1;j>=0;j--) { // 456
				
				op = ((a.charAt(i)-48) * (b.charAt(j)-48)) + carry;
				op = result[k] + op;
				if(j != 0) {
					carry = op / 10;
					op = op % 10;
				}
				result[k] = op;
				k--;
			}
			m++;
		}
		String str="";
		boolean isLeadingZero = false;
		for(int j=0;j<result.length;j++) {
				if(result[j] !=0 || isLeadingZero) {
					str+=result[j];
					isLeadingZero = true;
				}
		}
		if(isMinus) {
			return "-"+str;
		}
		return str;
		
	}
	public static void main(String[] args) {
		System.out.println("-456 * 123 "+multipleTwoStringNumbers("-456","123"));
		System.out.println("0000456 * 123 "+multipleTwoStringNumbers("0000456","123"));
		System.out.println("45611232 * 3 "+multipleTwoStringNumbers("45611232","3"));
		System.out.println("232399 * 3 "+multipleTwoStringNumbers("232399","3"));
		System.out.println("123 * 456 "+multipleTwoStringNumbers("123","456"));
		System.out.println("456 * 12 "+multipleTwoStringNumbers("456","12"));
		System.out.println("12 * 456 "+multipleTwoStringNumbers("12","456"));
		System.out.println("-1 * 456 "+multipleTwoStringNumbers("-1","456"));
		System.out.println("456 * 1 "+multipleTwoStringNumbers("456","1"));
		System.out.println("-456 * -2 "+multipleTwoStringNumbers("-456","-2"));
		System.out.println("2 * 456 "+multipleTwoStringNumbers("2","456"));
		System.out.println("2 * 8 "+multipleTwoStringNumbers("2","8"));
		System.out.println("8 * 2 "+multipleTwoStringNumbers("8","2"));
		System.out.println("8 * - "+multipleTwoStringNumbers("8","-"));
		System.out.println("8 * 0 "+multipleTwoStringNumbers("8","0"));
		System.out.println("-0 * 2 "+multipleTwoStringNumbers("-0","2"));
		System.out.println("x * x "+multipleTwoStringNumbers("212345875434678934564579943567","212345875434678934564579943567"));
		System.out.println("x * x "+multipleTwoStringNumbers("212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567","212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567212345875434678934564579943567"));
	}

}
