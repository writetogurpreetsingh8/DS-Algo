package recursion;

public class ReverseArrayWithRecursiveApproach {

	private int temp = 0;
	private int counter = 0;
	
	void reverseArray(int array[]) {
		
		if(array == null || array.length <=1 ) {
			System.out.println("\n invalid array...............");
			return; // invalid case
		}
		
		if(counter == (array.length / 2)) {
			return; // base case
		}
		
		temp = array[counter];
		array[counter] = array[( (array.length - 1) - counter)];
		array[((array.length - 1) - counter)] = temp;
		counter++;
		reverseArray(array);
	}
	
	void reverseArray1(int array[],int start,int end) {
		
		
		if(array == null || array.length <=1 ) {
			System.out.println("\n invalid array...............");
			return; // invalid case
		}
		
		if(start >= end) {
			return; // base case
		}
		
		temp = array[start];
		array[start] = array[end];
		array[end] = temp;
		reverseArray1(array, start+1, end-1);
		
	}
	
	public static void main(String[] args) {

		ReverseArrayWithRecursiveApproach instance = new ReverseArrayWithRecursiveApproach();
		int array[]= {1,2,1,4};
		
		System.out.println("array before reverse order is.........");
		for(int i=0;i<array.length;i++) {
			System.out.print(array[i]+"\t");
		}
		
		instance.reverseArray(array);
		
		System.out.println("array after reverse order is.........\n");
		for(int i=0;i<array.length;i++) {
			System.out.print(array[i]+"\t");
		}
		
		System.out.println("revers array with different approach........................................................................");
		
		instance.reverseArray1(array, 0, array.length-1);
		
		System.out.println("array after reverse order is.........\n");
		for(int i=0;i<array.length;i++) {
			System.out.print(array[i]+"\t");
		}
		

		
	}

}
