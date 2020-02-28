package sortings.heap;

public class HeapSorting {

	void heapSorting(int array[]) {
		
		int value = 0;
		for(int i=(array.length/2)-1; i>=0;i--) {
			maxHeapify(array,i,array.length-1);
		}
		
		for(int i=array.length-1;i>=0;i--) {
			value = array[0];
			array[0] = array[i];
			array[i] = value;
			maxHeapify(array,0,i-1);
		}
	}
	
	
	private void maxHeapify(int array[],int min,int size) {
		
		int i = min;
		int value = 0;
		
		int leftC = ((2 * i) + 1);
		int rightC = (( 2 * i) + 2);
		
		if(size >= leftC && array[leftC] < array[i]) {
			i = leftC;
		}
		if(size >= rightC && array[rightC] < array[i]) {
			i = rightC;
		}
		if( i != min) {
			value = array[i];
			array[i] = array[min];
			array[min] = value;
			maxHeapify(array,i,size);
		}
	}
	
	public static void main(String[] args) {
		
		int array[]= {100,1,3,50,101,81,20,19,1};
		System.out.println();
		System.out.println("before appiled heap sorting ");
		
		for(int i :array) {
			System.out.print(i+"\t");
		}
		new HeapSorting().heapSorting(array);
		System.out.println("\n");
		System.out.println("after applied heap Sorting array elements ........");
		for(int i :array) {
			System.out.print(i+"\t");
		}

	}

}
