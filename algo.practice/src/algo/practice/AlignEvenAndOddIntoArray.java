package algo.practice;

// align even and odd element in the sequence left side would be all even and right side would be all odd
public class AlignEvenAndOddIntoArray {

	void alignEvenAndOddIntoArray(int array[]) {
		
		int low  = 0;
		int high = array.length - 1;
		int temp = 0;
		
		while(low < high) {
			
			if(array[low] % 2 == 0) {
				low++;
			}
			if(array[high] % 2 != 0) {
				high--;
			}
			
			if(array[low] % 2 !=0 && array[high] % 2 ==0) {
				temp = array[high];
				array[high] = array[low];
				array[low] = temp;
			}
		}
	}
	
	public static void main(String[] args) {
		
		int array[]= {5,7,4,3,3,8,2,5,10,11,4,2,1,10,9,0,11,6,6,0};
		System.out.println("before aligned even and odd........");
		for(int i :array) {
			System.out.print(i+"\t");
		}
		new AlignEvenAndOddIntoArray().alignEvenAndOddIntoArray(array);
		System.out.println("\n");
		System.out.println("after aligned even and odd........");
		for(int i :array) {
			System.out.print(i+"\t");
		}
		
	}

}
