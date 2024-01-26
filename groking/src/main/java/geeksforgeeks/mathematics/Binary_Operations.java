package geeksforgeeks.mathematics;

public class Binary_Operations {


	private static String subtractBinaries(String binary1,String binary2) {
		
		if( (binary1 == null || binary2 == null) || ( binary1.isEmpty() || binary2.isEmpty())) {
			return "invalid binaries";
		}
		//make both the lengths equal// 
		if(binary1.length() != binary2.length()) {
			int remainingLength = Math.abs(binary1.length() - binary2.length());
			for(int i=0;i<remainingLength;i++) {
				if(binary1.length() > binary2.length()) {
					binary2 = "0"+binary2;
				}else {
					binary1 = "0"+binary1;
				}
			}
		}
		byte binarayCompliments[] = findOne_S_Compliments(binary2.getBytes());
		binarayCompliments = findTwo_S_Compliments(binarayCompliments,"1");
		String finalResult = addBinaries(binary1,new String(binarayCompliments));
		if(finalResult.length() == binary1.length()) {
			binarayCompliments = findOne_S_Compliments(finalResult.getBytes());
			binarayCompliments = findTwo_S_Compliments(binarayCompliments,"1");
			return "-"+new String(binarayCompliments);
		}
		else {
			return finalResult.substring(1);
		}
	}
	
	private static String addBinaries(String binary1,String binary2) {
	
		if( (binary1 == null || binary2 == null) || ( binary1.isEmpty() || binary2.isEmpty())) {
			return "invalid binaries";
		}
		
		if(binary1.length()>binary2.length()) {
			String temp = binary1;
			binary1 = binary2;
			binary2 = temp;
		}
		String result="";
		int k = binary1.length()-1;
		int bit1 = 0 ,bit2 = 0, carry = 0, sum = 0;
		
		for(int i=binary2.length()-1; i>=0;i--,k--) {
			
			bit2 = binary2.charAt(i) - 48;
			bit1 = (k >= 0) ? binary1.charAt(k) - 48 : 0;
			
			sum = bit1 + bit2 + carry;
			result = (sum % 2 != 0) ? "1"+result : "0"+result;
			carry = sum/2;
		}
		return (carry > 0) ? carry+result : result;
	}
	
	public static void main(String[] args) {
		System.out.println(addBinaries("1010","1010"));
		System.out.println(addBinaries("10","1010"));
		System.out.println(addBinaries("1","1010"));
		System.out.println(addBinaries("10101100110","1010"));
		
		System.out.println("subtract binaries = "+ subtractBinaries("1010","1010"));
		System.out.println("subtract binaries = "+ subtractBinaries("10101100110","1010"));
		System.out.println("subtract binaries = "+ subtractBinaries("1010","10101100110"));
	}
	
	private static byte[] findOne_S_Compliments(byte[] binary2) {
		
		for(int i=0;i<binary2.length;i++) {
			if(binary2[i] == 48) {
				binary2[i] = 49;
			}else {
				binary2[i] = 48;
			}
		}
		return binary2;
	}
	
	private static byte[] findTwo_S_Compliments(byte[] binary2,String addOne) {
		return addBinaries(new String(binary2),addOne).getBytes();
	}

}
