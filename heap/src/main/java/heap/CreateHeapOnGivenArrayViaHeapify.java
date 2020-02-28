package heap;

// create heap on given complete binary tree....
// traversal from backward (except leaf nodes) and compare with its parent if parent
// is small swap with its child ( creating max heap ) 
// time com is O(n) and space com is O(1)

public class CreateHeapOnGivenArrayViaHeapify {

	void createHeapOnGivenArray(int array[]) {
		
		if(array == null || array.length/2 == 0) {
			return;
		}
		for(int i=(array.length/2)-1;i>=0;i--) {
			maxHeapify(array, i,array.length-1);
			
		}
	}
	
	void maxHeapify(int array[],int halfArraySize,int size) {
	
		int i = halfArraySize;
		int value = 0;
		int leftC = ((2 * i) + 1);
		int rightC = ((2 * i) + 2);
		
		if(size >= leftC && array[leftC] > array[i]) {
			i = leftC;
		}
		if(size >= rightC && array[rightC] > array[i]) {
			i = rightC;
		}
		if( i != halfArraySize) {
			value = array[halfArraySize];
			array[halfArraySize] = array[i];
			array[i] = value;
			maxHeapify(array, i, size);
		}
	}
	
	public static void main(String[] args) {
	
		int array[]= {100,1,3,50,101,81,20,19,20,25,30,1};
		//100	90	81	19	50	3	20	1	0	0
		CreateHeapOnGivenArrayViaHeapify createHeapOnGivenArray = new CreateHeapOnGivenArrayViaHeapify();
		createHeapOnGivenArray.createHeapOnGivenArray(array);
		
		System.out.println();
		for(int i=0;i<array.length;i++) {
			System.out.print(array[i]+"\t");
		}
	}

}
