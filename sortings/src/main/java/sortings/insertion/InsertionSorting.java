package sortings.insertion;

public class InsertionSorting {

	void insertionSorting(int array[]) {
		
		int temp = 0;
		int j = 0;
		boolean isSwapingDone = false;

		for(int i=1;i<array.length;i++) {
			
			temp = array[i];
			j = i-1;
			
			while( j>=0 && temp < array[j]) {
				isSwapingDone = true;
				array[j+1] = array[j];
				array[j] = temp;
				j--;
			}
			if(!isSwapingDone) {
				break;// because array is already in sorting order
			}
			
		}
	}
	
	public static void main(String[] args) {

		int array[]= {5,3,10,2,1};
				
				System.out.println("before applied insertionSorting sorting array elements are ........");
				for(int i :array) {
					System.out.print(i+"\t");
				}
				new InsertionSorting().insertionSorting(array);
				System.out.println("\n");
				System.out.println("after applied bubble insertionSorting array elements ........");
				for(int i :array) {
					System.out.print(i+"\t");
				}

	}

}
