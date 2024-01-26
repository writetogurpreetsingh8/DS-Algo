package hacker.rank;

public class LeftRotationOfArray {

	
	public static void main(String[] args) {
		
			int array[]={1,2,3,4,5};
			int repetationOfArray = 4;
			int tempElement = 0;
			
			System.out.println("GIVEN Array is ");
			
			for(int i=0; i<array.length; i++){
				System.out.print(array[i]+" ");
			}
			
			System.out.println("\n Array after "+repetationOfArray +" rotation is..... ");
			while( repetationOfArray!= 0){
				
				tempElement = array[0];
				for(int i=0; i<(array.length-1); i++){
					array[i] = array[i+1];
				}
				array[(array.length-1)] = tempElement;
				repetationOfArray--;
			}
			
			
			
			for(int i=0; i<array.length; i++){
				System.out.print(array[i]+" ");
			}
	}

}
