package geeksforgeeks.mathematics;

public class Calculate_Decimal_From_Binary {

	private static String calculateDecimal(String binary) {
	
		if(binary == null || binary.isEmpty()) {
			return "invalid binary";
		}
		if(binary.equals("1") || binary.equals("0")) {
			System.out.println("Decimal value is "+binary);
			return (Integer.parseInt(binary) % 3 == 0) ? "YES" : "NO";
		}
		
		long multi = 1,result = 0,two=1;
		for(int i=binary.length()-1 ; i>=0; i--) {
			multi = multi * two;
			if(binary.charAt(i) == 49 ) { // checking whather character store at i is it 1 or not!!
				result = result + multi;
			}
			if(i == binary.length()-1) {
				two++;
			}
		}
		System.out.println("Decimal value is "+result);
		return (result % 3 == 0) ? "YES" : "NO";
	}
	
	public static void main(String[] args) {
		System.out.println(calculateDecimal("1100010110101100111001001111100100110000001101001110010000000111011110000011000010101000111"));
	}

}
