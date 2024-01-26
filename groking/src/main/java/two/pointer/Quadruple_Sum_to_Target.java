package two.pointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Quadruple_Sum_to_Target {

	private static List<List<Integer>> quadruple_Sum_to_Target(int nums[],int target){
		 List<List<Integer>> list = new ArrayList<List<Integer>>();
	        if(nums.length < 4){
	             return list;
	        }
	        Arrays.sort(nums);
	        if(nums.length == 4 && (nums[0]+nums[1]+nums[2]+nums[3] == target)){
	             list.add(Arrays.asList(nums[0],nums[1],nums[2],nums[3])); 
	            return list;
	        }
	        
	        int diff = 0;
	        for(int i=0;i<nums.length-3;i++){
	            if( i > 0 && nums[i] == nums[i-1])
	                continue;
	            for(int j=i+1;j<nums.length-2;j++){
	                if( j > i+1 && nums[j] == nums[j-1])
	                continue;
	                diff = (target - nums[i]) - nums[j];
	                findQuardluptes(j,i,nums,diff,list);
	            }
	        }
	        return list;
	    }
	
	private static void findQuardluptes(int j,int i,int[] nums,int diff,List<List<Integer>> list){
        
        int start = j+1;
        int end = nums.length-1;
        while(start < end){
        	int sum = nums[start]+nums[end];
            if(diff == sum){
                list.add(Arrays.asList(nums[i],nums[j],nums[start],nums[end]));
                while(start < end && nums[start] == nums[start+1]){
                	start++;
                }
                while(start < end && nums[end] == nums[end-1]){
                	end--;
                }
                start++;end--;
            }
            else if(sum > diff){
                end--;
            }else{
                start++;
            }
        }
    }
	
	public static void main(String[] args) {
		int arr[]= {1,3,2,2,-1};
		System.out.println(quadruple_Sum_to_Target(arr,6));
		
		int arr1[]= {1,0,-1,0,-2,2};
		System.out.println(quadruple_Sum_to_Target(arr1,0));
		
		int arr2[]= {2,2,2,2,2};
		System.out.println(quadruple_Sum_to_Target(arr2,8));
	}

}
