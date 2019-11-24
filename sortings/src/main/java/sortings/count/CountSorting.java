package sortings.count;

public class CountSorting {

	void countSort(int array[]) {
	
		// find max element as range of array;
		int range = Integer.MIN_VALUE;
		
		for(int i=0;i<array.length;i++) {
			
			if(array[i] > range) {
				range = array[i];
			}
		}
		
		int countArray[] = new int[range+1];
		// calculate the count of elements into countArray
		for(int i=0;i<array.length;i++) {
			
			countArray[array[i]]++;
		}
		
		//calculate the position of element into countArray
		for(int i=1;i<countArray.length;i++) {
			
			countArray[i] +=countArray[i-1];
		}
		
		// created temp array to hold sorted elements
		int tempArray[] = new int[array.length]; 
		
		for(int i=array.length-1; i>=0; i--) {
			
			tempArray[--countArray[array[i]]] = array[i];
		}
		
		// copy all the sorted elements from temp array to original array.
		for(int i=0;i<tempArray.length;i++) {
			
			array[i] = tempArray[i];
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		//int array[]= {5,4,3,2,1};
				//int array[]= {7,6,10,5,9,2,1,15,7};
				int array[]= {5,7,4,3,3,8,2,5,10,11,4,2,1,10,9,0,11,6,6,0};
				System.out.println("before applied quick sorting array elements are ........");
				for(int i :array) {
					System.out.print(i+"\t");
				}
				new CountSorting().countSort(array);
				System.out.println("\n");
				System.out.println("after applied quick Sorting array elements ........");
				for(int i :array) {
					System.out.print(i+"\t");
				}

	}

}
