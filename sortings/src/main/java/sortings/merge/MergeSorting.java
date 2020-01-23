package sortings.merge;

public class MergeSorting {

	void mergeArray(int array[],int lower,int mid,int upper) {
		
		int i = lower;
		int j = mid + 1;
		int k = 0;
		int size = ((mid - lower) + (upper - mid) + 1);
		int tempArray[] = new int[size];
		
		while( i <= mid && j <= upper) {
			
			if(array[i] <= array[j]) {
				tempArray[k] = array[i];
				i++;
			}
			else {
				tempArray[k] = array[j];
				j++;
			}
			k++;
		}
		// coping remaining element from Ith list into temp Kth array
		while( i<= mid) {
				tempArray[k] = array[i];
				k++;
				i++;
		}// coping remaining element from Jth list into temp Kth array
		while(j <= upper) {
			tempArray[k] = array[j];
			j++;k++;
		}
		
		//copy  temp array into actual array;
		
		for(int l=0; l<tempArray.length;l++) {
			array[lower] = tempArray[l];
			lower++;
		}
		
	}
	
	void mergeSort(int array[], int lower,int upper) {
		
		int mid = 0;
		if(lower < upper) {
			mid = (lower + upper) / 2;
			mergeSort(array,lower,mid);
			mergeSort(array,mid+1,upper);
			mergeArray(array,lower,mid,upper);
		}
	}
	
	public static void main(String[] args) {
		
int array[]= {5,4,3,2,1};
		
		System.out.println("before applied merge sorting array elements are ........");
		for(int i :array) {
			System.out.print(i+"\t");
		}
		
		new MergeSorting().mergeSort(array,0,array.length-1);
		System.out.println("\n");
		System.out.println("after applied merge Sorting array elements ........");
		for(int i :array) {
			System.out.print(i+"\t");
		}

	}

}
