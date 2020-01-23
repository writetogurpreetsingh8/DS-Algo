package algo.practice;

public class FindTotalOccurrenceOfCharactersIntoString {

	void findOccurrences(String value) {
		
		int array[] = new int[91];
		int charInt = 0;
		
		for(int i=0;i<value.length();i++) {
			
			charInt = value.charAt(i);
			
			if(charInt >=97 && charInt <= 122) {
				charInt -= 32;
			}
			array[charInt]++; 
		}
		
		for(int i=0;i<value.length();i++) {
		
			charInt = value.charAt(i);
			if(charInt >=97 && charInt <= 122) {
				charInt -= 32;
			}
			//if(array[charInt] !=0) {
				System.out.println("frequency of "+(char)charInt+" is "+array[charInt]);
				//array[charInt] = 0;
			//}
		}
	}
	
	public static void main(String[] args) {
		// find total numbers of occurrencces of characters into string...
		// with O(n) time and O(1) space complexity
		
		new FindTotalOccurrenceOfCharactersIntoString().findOccurrences("gurupreEt singh bHatT");
	}

}
