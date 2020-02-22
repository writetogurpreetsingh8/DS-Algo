package heap;

// create heap on given complete binary tree....
// traversal from backward and compare each element of array with its parent if parent
// is small swap with its child ( creating max heap ) 
// time com is O(nlogn) and space com is O(1)

public class CreateHeapOnGivenArray {

	int temp = 0;
	void createHeapOnGivenArray(int array[],int arraySize) {
		
		if(array == null || arraySize == 1) {
			return;
		}
		int currentNode = arraySize - 1;
		int parentNode = (currentNode - 1) / 2;
		if(array[parentNode] < array[currentNode]) {
			temp = array[parentNode];
			array[parentNode] = array[currentNode];
			array[currentNode] = temp;
		}
		arraySize = currentNode;
		createHeapOnGivenArray(array, arraySize);
		
	}
	
	public static void main(String[] args) {
	
		int array[]= {100,1,3,50,90,81,20,19};
		
		CreateHeapOnGivenArray createHeapOnGivenArray = new CreateHeapOnGivenArray();
		createHeapOnGivenArray.createHeapOnGivenArray(array,array.length);
		
		System.out.println();
		for(int i=0;i<array.length;i++) {
			System.out.print(array[i]+"\t");
		}
	}

}
