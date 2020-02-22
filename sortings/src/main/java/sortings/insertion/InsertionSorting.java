package sortings.insertion;

public class InsertionSorting {

	void insertionSorting(int array[]) {
		
		int temp = 0;
		int j = 0;

		for(int i=1;i<array.length;i++) {
			
			temp = array[i];
			j = i-1;
			
			while( j>=0 && temp < array[j]) {
				array[j+1] = array[j];
				j--;
			}
			array[j+1] = temp;
		}
	}
	
	public static void main(String[] args) {

		int array[]= {5,6,10,2,1};
				
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
