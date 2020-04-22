package algo.practice;

public class FindDuplicateIntoArray {

	static void pringRepeating(int numRay[]) {
	
		for (int i = 0; i < numRay.length; i++) { 
            numRay[numRay[i] %  numRay.length] = numRay[numRay[i] %  numRay.length] + numRay.length; 
        } 
        System.out.println("The repeating elements are : "); 
        for (int i = 0; i < numRay.length; i++) { 
            if (numRay[i] >= numRay.length*2) { 
                System.out.print(i + " "); 
            } 
        }
	}
	
	static void printRepeating(int arr[], int size) 
    { 
        int i;   
        System.out.println("The repeating elements are : "); 
     
        for (i = 0; i < size; i++) 
        { 
            if (arr[ Math.abs(arr[i])] >= 0) 
                arr[ Math.abs(arr[i])] = -arr[ Math.abs(arr[i])]; 
            else
                System.out.print(Math.abs(arr[i]) + " "); 
        }          
    }  
  
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int array[]= {1,2,3,1,14,3,6,0,61,6,14,0};
		//printRepeating(array,array.length);
		pringRepeating(array);
	}

}
