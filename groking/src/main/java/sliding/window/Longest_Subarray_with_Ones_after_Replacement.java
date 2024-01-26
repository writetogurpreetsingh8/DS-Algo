package sliding.window;

public class Longest_Subarray_with_Ones_after_Replacement {
	/**
	 * TC O(N)
	 * SC O(1) 
	 * variable size window
	 */
	private static int longest_Subarray_with_Ones_after_Replacement(int arr[],int k) {
		 
			int j=0,maxOnes=0,result=(1<<31);
	        
			for(int i=0;i<arr.length; i++){
	            if(arr[i] == 1){
	                maxOnes++;
	            }
	            
	            while( (((i-j)+1) - maxOnes) > k) {
	            	if(arr[j] == 1){
		                maxOnes--;
		            }
	                j++;
	            }
	         // OR , while or if both are correct here!!
	            /*if( (((i-j)+1) - maxOnes) > k ){
	            	if(arr[j] == 1){
		                maxOnes--;
		            }
	                j++;
	            }*/
	            result = Math.max(result,(i-j)+1);
	        }
	        return result;
	}
	public static void main(String[] args) {
			int arr[] = {0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1};
			System.out.println(longest_Subarray_with_Ones_after_Replacement(arr,2));
			
			int arr1[] = {0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1};
			System.out.println(longest_Subarray_with_Ones_after_Replacement(arr1,3));
	}

}
