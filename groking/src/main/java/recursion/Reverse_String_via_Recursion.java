package recursion;

public class Reverse_String_via_Recursion {

	public static String reverse_String_via_Recursion(String str) {
		
		if(str == null || str.trim().isEmpty() || str.length() < 1) {
			return str;
		}
		byte[] b = str.getBytes();
		b = reverse_String_via_Recursion1(b,b.length-1,0);
		return new String(b);
	}
	
	private static byte[] reverse_String_via_Recursion1(byte[] b, int length, int index) {
			if(length < 0) {
				return b;
			}
			byte storeFirstByte = b[index];
			b = reverse_String_via_Recursion1(b,length-1,++index);
			b[length] = storeFirstByte;
			return b;
	}
	public static void main(String[] args) {
			String str = "4567890%^&abcdefghiiiiijkkkklmnoppppqrstuuuuvwxyz123!@#$_-=+";
			System.out.println("before reverse: "+str);
			str = reverse_String_via_Recursion(str);
			System.out.println("after reverse: "+str);
	}

}
