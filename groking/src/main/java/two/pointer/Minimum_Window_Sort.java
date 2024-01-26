package two.pointer;

public class Minimum_Window_Sort {
	
	

	public static int minimum_Window_Sort(int nums[]) {
		
		if( (nums.length == 0 || nums.length == 1) 
		          || (nums.length == 2 && nums[0] == nums[1]) ){
		            return 0;
		        }
		        
		        if(nums.length == 2 && nums[0] > nums[1]){
		            return 2;
		        }
		        
		        int min = ~(1<<31);
		        int max = (1<<31);
		        int start = -2,end = -1;
		        int len = nums.length-1;
		        
		        for(int i=0;i<=len;i++){
		        //{1,3,2,0,-1,7,10}; // len = 6
		            max = Math.max(max,nums[i]);
		            min = Math.min(min,nums[len-i]);
		            
		            if(max > nums[i])
		                start = i;//4
		            
		            if(min < nums[len-i])
		                end = len-i;//3,0
		        }
		        return start-end+1;
	}
	
	
	public static void main(String[] args) {
			
		int arr[] = {2,0,1,9,3};
		//System.out.println(minimum_Window_Sort(arr));
		//System.out.println(minimum_Window_Sort1(arr));
		
		int arr1[] = {1,2,5,3,7,10,9,12};
		//System.out.println(minimum_Window_Sort(arr1));
		//System.out.println(minimum_Window_Sort1(arr1));
		
		int arr2[] = {1,3,2,0,-1,7,10};
		System.out.println(minimum_Window_Sort(arr2));
		
		int arr3[] = {2,6,4,8,10,9,15};
		//System.out.println(minimum_Window_Sort(arr3));
		
		int arr4[] = {1,2,3,4};
		System.out.println("sort  is "+minimum_Window_Sort(arr4));
		
		int arr5[] = {4,3,2,1};
		System.out.println("sort is "+minimum_Window_Sort(arr5));
			
			
	}

}
