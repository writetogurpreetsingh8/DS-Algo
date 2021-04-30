package sortings.quick;

public class QuickSorting {

	int partition(int array[],int l,int u) {
		
		int pivot = array[l];
		int start = l;
		int end = u;
		int temp = 0;
		
		while(start<end) {
			
			while( (array[start] <= pivot) && (start < u) ) {
				start++;
			}
			
			while( (array[end] > pivot)) {
				end--;
			}
			
			if(start < end) {
				temp = array[start];
				array[start] = array[end];
				array[end] = temp;
			}
		}
		temp = array[l];
		array[l] = array[end];
		array[end] = temp;
		return end;
		
	}
	void quickSort1(int array[],int l,int u) {
		
		int loc = 0; 
		
		if(l<u) {
			loc = partition(array,l,u);
			quickSort1(array,l,loc-1);
			quickSort1(array,loc+1,u);
		}
	}
	
	void quickSort(int array[]) {
	
		quickSort1(array,0,array.length-1);
	}
	
	public static void main(String[] args) {
		
		//int array[]= {5,4,3,2,1};
		//int array[]= {7,6,10,5,9,2,1,15,7};
		//int array[]= {5,7,4,3,8,2};
		int array[]= {3,1,2,6,5,4};
		System.out.println("before applied quick sorting array elements are ........");
		for(int i :array) {
			System.out.print(i+"\t");
		}
		new QuickSorting().quickSort(array);
		System.out.println("\n");
		System.out.println("after applied quick Sorting array elements ........");
		for(int i :array) {
			System.out.print(i+"\t");
		}
	}


}
