package sortings.shell;

// gap could be anything like n/2 or (3*x+1)
// if gap is n/2 than complexity would be O(n)2 
// if gap is 3*x+1 than complexity would be O(n)3/2 that is much lesser than O(n)2
// worst-case complexity depends upon the gap sequence 
//https://www.youtube.com/watch?v=pGhazjsFW28
// to found best gap sequence is a search problem............
// one of best fast sorting algo unless array size is huge if in case of gap sequence is well defined.
public class ShellSorting {
	
	void shellSort(int array[]) {
		
		int gap = array.length / 2;
		int k = 0;
		int temp = 0;
		while(gap > 0) {
			
			for(int i=0; i<(array.length-gap); i++) {
				k = i;
				for(int j=gap+i; k>=0; j-=gap,k-=gap) {
					
					if(array[k] < array[j]) {
						break;
					}
					else {
						temp = array[k];
						array[k] = array[j];
						array[j] = temp;
					}
				}
			}
			gap/=2;
		}
	}
	
	public static void main(String[] args) {
			

		int array[]= {5,4,3,2,1};
		//int array[]= {7,6,10,5,9,2,1,15,7};
		
		//int array[]= {5,7,4,3,8,2};
		System.out.println("before applied quick sorting array elements are ........");
		for(int i :array) {
			System.out.print(i+"\t");
		}
		
		new ShellSorting().shellSort(array);
		System.out.println("\n");
		System.out.println("after applied quick Sorting array elements ........");
		for(int i :array) {
			System.out.print(i+"\t");
		}
	}
	
}
