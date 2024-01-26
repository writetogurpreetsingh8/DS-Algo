package two.pointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Triplet_Sum_Close_to_Target {
	
	 public static int threeSumClosest(int[] nums, int target) {
		    
	        int left =0;
	        int right = 0;
	        int sum=0; int ans=0;int max=~(1<<31);
	        int diff=0;
	        Arrays.sort(nums);
	        
	        for(int i=0;i<nums.length-2;i++){
	            left = i+1;
	            right = nums.length-1;
	            while(left < right){
	                
	                sum = nums[i]+nums[left]+nums[right];
	                diff = sum-target;
	                if(diff == 0){
	                    return target;
	                }
	                else if(Math.abs(diff) < max){
	                    max = Math.abs(diff);
	                    ans = sum;
	                }
	                if(diff > 0){
	                    right--;
	                }else{
	                    left++;
	                }
	            }
	        }
	        return ans;
	    }

	private static List<Integer> finalList = new ArrayList<>();
	public static int tripletSumCloseToTarget(int arr[],int target) {
		
		if(arr == null || arr.length < 3) {
			System.out.println("invalid array..........");
		}
		
		Arrays.sort(arr);
		int max = ~(1<<31);
		int ans=0;
		int left =0,right = 0,difference=0;
		int sum = 0;
		for (int i = 0; i < arr.length-2; i++) {
			
			if(i > 0 && arr[i] == arr[i-1]) {
				continue;
			}
			left = i+1;
			right = arr.length-1;
			difference = target - arr[i];
			while(left < right) {
				
				sum = arr[left] + arr[right];
				if(difference == sum) {
					finalList = new ArrayList<Integer>();	
					finalList.add(arr[left]);
					finalList.add(arr[right]);
					finalList.add(target-difference); 
					return target;
					
				}else {
					int diff = difference-sum;
					//2nd condition into below if-condition is for to handle the smallest sum when
					//we have more than one solution and we need to opt most small one i.e diff >= ans
					// if needed higher solution the use .ie diff <= ans 
					if (Math.abs(max) > Math.abs(diff) && diff >= ans ) {
						max = diff;
						finalList = new ArrayList<Integer>();	
						finalList.add(arr[left]);
						finalList.add(arr[right]);
						finalList.add(target-difference); 
						ans = arr[left]+arr[right]+(target-difference);
					}
					if(diff > 0) {
						left++; // we need triplet with the bigger sum
						// here diff > 0 means we have some value which need to be decrease to achieve 
						// diff == 0 since we also need to achieve triplet sum as exactly as given target sum 
					}else {
						right--; // we need triplet with the smallest sum
						// here diff < 0 means we have some value which need to be increase to achieve 
						// diff == 0 since we also need to achieve triplet sum as exactly as given target sum 
					}
				}
			}
		}
		return ans;
	}
	
	public static void main(String[] args) {
		
		int arr[]= {-3, -1, 1, 2};
		//System.out.println(tripletSumCloseToTarget(arr,1)); //0
		System.out.println(threeSumClosest(arr,1));//0
		System.out.println(finalList);
		
		int arr1[]= {1, 0, 1, 1};
		//System.out.println(tripletSumCloseToTarget(arr1,100)); //3
		System.out.println(threeSumClosest(arr1,100));//0
		System.out.println(finalList);
		
		int arr2[]= {-2, 0, 1, 2};
	   // System.out.println(tripletSumCloseToTarget(arr2,2)); //1
		System.out.println(threeSumClosest(arr2,2));//0
		System.out.println(finalList);
		
		int arr4[]= {1,2,4,8,16,32,64,128};
		//System.out.println(tripletSumCloseToTarget(arr4,82)); //1
		System.out.println(threeSumClosest(arr4,82));//0
		System.out.println(finalList);
		
		int arr3[] = {-1,2,1,-4};
		System.out.println(threeSumClosest(arr3,1)); //2
		//System.out.println(tripletSumCloseToTarget(arr3,1)); //2
		System.out.println(finalList);
		
		int arr31[] = {2,-3,4,-2};
		System.out.println(threeSumClosest(arr31,1));//-1
		System.out.println(tripletSumCloseToTarget(arr31,1)); //-1
		System.out.println(finalList);
		
	}

}
