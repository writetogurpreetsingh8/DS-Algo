package sortings.radix;

public class RadixSort {

	private int findMaxElement(int array[]) {
		
		int max = Integer.MIN_VALUE;
		for(int i=0;i<array.length;i++) {
			
			if(array[i] > max) {
				max = array[i];
			}
		}
		return max;
	}
	
	void radixSort(int array[]) {
		
		int maxElement = findMaxElement(array);
		int tempArray[] = new int[array.length];
		
		for(int pos=1; maxElement/pos > 0; pos=pos*10) {
		
			countSort(array,pos,tempArray);
		}
	}
	
	private void countSort(int array[],int pos,int tempArray[]) {
	
		int count[] = new int[10];
		//creating count array with the help of count-sort
		for(int i=0;i<array.length;i++) {
			
			++count[((array[i]/pos) % 10)];
		}
		
		// updating count array with their index value 
		for(int i=1; i<count.length;i++) {
			
			count[i] = count[i] + count[i-1]; 
		}
		
		// sorting array elements into temArray with the help of count array
		
		for(int i = array.length-1; i>=0; i--) {
			
			 tempArray[--count[((array[i] / pos) % 10)]] = array[i];
			
		}
		// copy elements into actual array named array from temp-array named tempArray
		for(int i=0; i<tempArray.length;i++) {
			
			array[i] = tempArray[i]; 
		}
		
		// end of radix-sort
		
	}
	
	public static void main(String[] args) {
		
		int array[]= {5,4,200};
		
		System.out.println("before applied radix sorting array elements are ........");
		for(int i :array) {
			System.out.print(i+"\t");
		}
		
		new RadixSort().radixSort(array);
		
		System.out.println("\n");
		System.out.println("after radix Sorting array elements ........");
		for(int i :array) {
			System.out.print(i+"\t");
		}
	}

}
