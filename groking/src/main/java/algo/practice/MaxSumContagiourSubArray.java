package interview.bit;

public class MaxSumContagiourSubArray {

	
	  public static void maxSubArray(final int[] a) {
	  
		  int max_here = 0;
		  int max_so_far = a[0];
		  int start = 0;
		  int end = 0;
		  int s = 0;
		  for(int i=0;i<a.length;i++){
			  
			  max_here = max_here + a[i];
			  
			  if(max_here > max_so_far ){
				  max_so_far = max_here;
				  start = s;end = i;
			  }
			  if(max_here < 0){
				  max_here = 0;
				  s = i+1;
			  }
		  }
		  
		  System.out.println("max sum is "+max_so_far);
		  System.out.println("start_index and end_index is "+start+" "+(end+1));
	  }
	  
	public  static void main(String[] args) {
//A = [-2, 1, -3, 4, -1, 2, 1, -5, 4]
		//int array[]={-2,1,-3,4-1,2,1,-5,4};
		//int array[]={-2,-3,4,-1,-2,1,5,-3};
		int array[]={-5,3,4,9};
		 maxSubArray(array);
	}

}
