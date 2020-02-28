package heap;

import java.util.Scanner;

public class Heap {

	int temp = 0;
	int size = 0;
	
	// max heap method for making tree max-heap O(logn)
	private void maxHeapForInsertion(int array[],int counter) {
		
		if(array == null || counter == 0) {
			return;
		}
		
		int currentNode = counter;
		int parentNode = ((currentNode - 1) / 2);
		
		if(array[parentNode] < array[currentNode]) {
			temp = array[parentNode];
			array[parentNode] = array[currentNode];
			array[currentNode] = temp;
			counter = parentNode;
			maxHeapForInsertion(array,counter);
		}
		
	}
	// time com is O(n)
	int[] insertIntoHeap() {
		
		int array[] = new int [5];
		Scanner scanner = new Scanner(System.in);
		int value = 0; int counter = 0;
		while(scanner.hasNext()) {
			value = scanner.nextInt();
			if(value <0 || counter == 5) {
				break;
			}
			array[counter] = value;
			// time com is O(logn) = O(n) * O(logn) = O(nlogn) for complete algo
			maxHeapForInsertion(array,counter);
			counter++;
		}
		
		System.out.println();
		for(int i=0;i<counter;i++) {
			System.out.print(array[i]+"\t");
		}
		return array;
	}
	
	private void maxHeapForDeletion(int[] array,int size,int largest){
		
		int i = largest;
		
		int leftChild = ((2 * largest) + 1);
		int rightChild = ((2 * largest) + 2);
		
		temp = array[largest];
		
		if(leftChild <= size && array[leftChild] > array[largest]) {
			largest = leftChild;
		}
		if(rightChild <= size && array[rightChild] > array[largest]) {
			largest = rightChild;
		}
		
		if(i != largest) {
			array[i] = array[largest];
			array[largest] = temp;
			maxHeapForDeletion(array,size,largest);
		}
	}
	
	int deleteIntoHeap(int array[],int size) {
		
		int deletedElement = 0;
		int counter = 0;
		
		if(array == null || size <= 0) {
			this.size = 0;
			return -1;
		}
		deletedElement = array[0];
		array[0] = array[size-1];
		array[size-1] = deletedElement;
		size--;
		this.size = size;
		maxHeapForDeletion(array,size-1,counter);
		return deletedElement;
	}
	
	
	public static void main(String[] args) {
		
		//{100,1,3,50,90,81,20,19};
		Heap heap = new Heap();
		int array [] = heap.insertIntoHeap();
		heap.size = array.length;
		System.out.println();
		
		System.out.println("1st deleted element from heap is "+heap.deleteIntoHeap(array, heap.size));
		
		System.out.println("after deletion .............");
		for(int i=0;i<array.length;i++) {
			System.out.print(array[i]+"\t");
		}
		
		System.out.println();
		
		System.out.println("2ndst deleted element from heap is "+heap.deleteIntoHeap(array, heap.size));
		
		System.out.println("after deletion .............");
		for(int i=0;i<array.length;i++) {
			System.out.print(array[i]+"\t");
		}
		
		System.out.println();
		
		System.out.println("3rd deleted element from heap is "+heap.deleteIntoHeap(array, heap.size));
		
		System.out.println("after deletion .............");
		for(int i=0;i<array.length;i++) {
			System.out.print(array[i]+"\t");
		}
		
		System.out.println();
		
		System.out.println("4rd deleted element from heap is "+heap.deleteIntoHeap(array, heap.size));
		
		System.out.println("after deletion .............");
		for(int i=0;i<array.length;i++) {
			System.out.print(array[i]+"\t");
		}
		
		System.out.println();
		
		System.out.println(" 5th deleted element from heap is "+heap.deleteIntoHeap(array, heap.size));
		
		System.out.println("after deletion .............");
		for(int i=0;i<array.length;i++) {
			System.out.print(array[i]+"\t");
		}
	}

}
