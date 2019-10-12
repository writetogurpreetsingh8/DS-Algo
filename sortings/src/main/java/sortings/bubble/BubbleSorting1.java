package sortings.bubble;

public class BubbleSorting1 {

	
	void bubbleSorting1(int array[]) {
		
		int temp = 0;
		boolean isSwapingDone = false;

		for(int i=0;i<array.length-1;i++) {
			
			for(int j=0;j<array.length-1-i;j++) { // bubble sorting 1 and bubble sortings2 both class has little bit different
				// logic inside inner loop
				
				if(array[j] > array[j+1]) {
					isSwapingDone = true;
					temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
				}
			}
			if(!isSwapingDone) {
				break;// because array is already in sorting order
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int array[]= {5,3,10,2,1};
		
		System.out.println("before applied bubble sorting array elements are ........");
		for(int i :array) {
			System.out.print(i+"\t");
		}
		new BubbleSorting1().bubbleSorting1(array);
		System.out.println("\n");
		System.out.println("after applied bubble sorting array elements ........");
		for(int i :array) {
			System.out.print(i+"\t");
		}
	}

}
