package linear_search;


public class Lineary_Searching {
	
	// Find Numbers with Even Number of Digits 
	public static int findEven1(int []arr) {
		if(arr == null || arr.length == 0) {
			return -1;
		}
		int eventCount=0;
		int returnValue=0;
		for (int i = 0; i < arr.length; i++) {
			returnValue = findEvenCount(arr[i]);
				if(returnValue > 0 && (returnValue & 1) == 0) {
					eventCount++;
				}
		}
		return eventCount;
	}
	
	private static int findEvenCount(int number) {
		int count=0;
		// if number is -ve we converted into +ve number by using bitwise operator
		if(number < 0) {
			number = (~number)+1;
		}
		while(number > 0) {
			count++;
			number/=10;
		}
		return count;
	}
	
	// Find Numbers with Even Number of Digits 
	//https://leetcode.com/problems/find-numbers-with-even-number-of-digits/discuss/459489/JAVA-solution-with-100-better-space-and-Time
	public static int findEven2(int []arr) {
		if(arr == null || arr.length == 0) {
			return -1;
		}
		int eventCount=0,number=0;
		for (int i = 0; i < arr.length; i++) {
			number = arr[i];
			if(number < 0) {
				number = (~number)+1;
			}
			if((number >=10 && number <=99) || (number >=1000 && number <=9999) || (number == 100000)) {
				eventCount++;
			}
		}
		return eventCount;
	}
	
	// Find Numbers with Even Number of Digits 
	// when we calculate the LogBase10 of any numeric digits we got answer as the length-1 of actual digit
	//i.e Math.log10(1000) -> ans is 3 and if we add 1 into it we will find the exact length of actual digit
		public static int findEven3(int []arr) {
			if(arr == null || arr.length == 0) {
				return -1;
			}
			int eventCount=0,number=0;
			for (int i = 0; i < arr.length; i++) {
				number = arr[i];
				if(number < 0) {
					number = (~number)+1;
				}
				number = (int)(Math.log10(number)+1);
				if(number > 0 && (number & 1) == 0) {
					eventCount++;
				}
			}
			return eventCount;
		}
	
	public static void main(String[] args) {
		int arr[]= {1,2,3,-55,671,898,-91,0,100000};
		System.out.println(findEven1(arr));
		System.out.println(findEven2(arr));
		System.out.println(findEven3(arr));
	}

}
