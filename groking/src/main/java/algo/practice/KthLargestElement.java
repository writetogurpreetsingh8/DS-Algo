package algo.practice;

// find kth largest element or smallest element
// max heap TC is O(n + klogn) to find kth largest number
// min heap TC is O( n + (n-k)+1 log(n)) to find kth largest number
//max heap TC is O( n + (n-k)+1 log(n))  to find kth smallest number
//min heap TC is O(n + klogn)  to find kth smallest number
// in both the condition (max or min) TC can be differ in we find smallest in case of largest
// wheather we find smallest or largest the TC would be based upon the choose of heap either min or max
public class KthLargestElement {

	
	int findKthLargestElement(int array[],int k,int size) {
		
		int value = 0;
		// tc is O(n)
		for(int i=(array.length/2)-1; i>=0;i--) {
			minHeapify(array,array.length-1,i);
		}
		int i=k+1;
		while(i>=0) {
			value = array[0];
			array[0] = array[size];
			array[size] = value;
			size--;
			i--;
			minHeapify(array,size,0);
		}
		return array[k-1];
	}
	
	private void minHeapify(int array[],int size,int largest) {
		
		int i = largest;
		int value = 0;
		
		int leftC = ((2 * i) + 1);
		int rightC = (( 2 * i) + 2);
		
		if(size >= leftC && array[leftC] < array[i]) {
			i = leftC;
		}
		if(size >= rightC && array[rightC] < array[i]) {
			i = rightC;
		}
		if( i != largest) {
			value = array[i];
			array[i] = array[largest];
			array[largest] = value;
			minHeapify(array,size,i);
		}
			
	}
	
	public static void main(String[] args) {

		
		int array[]= {100,1,3,50,101,81,20,19,1};
		System.out.println();
		System.out.println("before appiled heap sorting ");
		
		for(int i :array) {
			System.out.print(i+"\t");
		}
		System.out.println();
		System.out.println("k th largest element is "+new KthLargestElement().findKthLargestElement(array, 1,array.length-1));
		
		System.out.println("\n");
		System.out.println("after applied heap Sorting array elements ........");
		for(int i :array) {
			System.out.print(i+"\t");
		}
	}

}
