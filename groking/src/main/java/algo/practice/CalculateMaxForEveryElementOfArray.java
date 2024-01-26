package algo.practice;


public class CalculateMaxForEveryElementOfArray {

	int[] calculateMaxForEveryElementOfArray(int array[]) {
		
		int tempArray[] = new int[array.length];
		int tempValue = 0;
		
		tempArray[array.length-1] = -1;
		
		tempValue = array[array.length-1];
		
		for(int i=array.length-1; i>0; i--) {
			
			if(array[i] < array[i-1]) {
				tempValue = array[i-1];
			}
			if(array[i-1] == tempValue) {
				tempArray[i-1] = -1;
			}
			else
			tempArray[i-1] = tempValue;
			
		}
		
		return tempArray;
	}
	
	
	public static void main(String[] args) {
		
		
				//int array[]= {5,7,4,3,3,8,2,5,10,11,4,2,1,10,9,0,11,6,6,0};
				int array[]= {1,3,15,71,18,14,17};
				System.out.println("before find max of every element of array.......");
				for(int i :array) {
					System.out.print(i+"\t");
				}
				array = new CalculateMaxForEveryElementOfArray().calculateMaxForEveryElementOfArray(array);
				System.out.println("\n");
				System.out.println("after find max of every element of array.......");
				for(int i :array) {
					System.out.print(i+"\t");
				}
		
	}

}
