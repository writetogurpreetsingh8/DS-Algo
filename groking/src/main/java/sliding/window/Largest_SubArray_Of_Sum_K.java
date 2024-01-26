package sliding.window;

public class Largest_SubArray_Of_Sum_K {

	private static int largetSubArray(int arr[],int sum) {
	
		int i=0 , result=0, max = (1<<31);
		
		for(int j=0;j<arr.length;j++) {
		
			result+=arr[j];
			 if(sum == result) {
				max = Math.max(max, (j-i+1));
			}
				while(result > sum) {
					result-=arr[i];
					i++;
			}
			
		}
		return max;
	}
	
	public static void main(String[] args) {
		int array[]= {4,1,1,1,2,3,5};
		System.out.println(largetSubArray(array,5));

	}

}
