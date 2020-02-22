package sortings.selection;

import java.util.Collections;

public class SelectionSorting {

	
	void selectionSort(int array[]) {
		
		int minValueIndexIntoArray = 0;
		int temp = 0;
		
		for(int i=0;i<array.length-1;i++) {
			
			minValueIndexIntoArray = i;
			
			for(int j=i+1;j<array.length;j++) {
				
				if(array[minValueIndexIntoArray] > array[j]) {
					minValueIndexIntoArray = j;
				}
			}
			if(minValueIndexIntoArray != i) {
				temp = array[i];
				array[i] = array[minValueIndexIntoArray];
				array[minValueIndexIntoArray] = temp;
			}
			else {
				break; // if array is already sorted in order
			}
		}
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int array[]= {5,3,10,2,1};
		
		System.out.println("before applied selection sorting array elements are ........");
		for(int i :array) {
			System.out.print(i+"\t");
		}
		new SelectionSorting().selectionSort(array);
		System.out.println("\n");
		System.out.println("after applied selection sorting array elements ........");
		for(int i :array) {
			System.out.print(i+"\t");
		}
	}

}
