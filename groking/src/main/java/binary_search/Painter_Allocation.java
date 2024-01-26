package binary_search;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 
 * @author Tony.Stark
 * TC O(logN*N)
 * stack O(1)
 * aux O(1)
 *
 */
public class Painter_Allocation {

		/**
		 * TC O(logN)
		 * stack O(1)
		 * aux O(1)
		 */
	    public static int findLargestMinDistance(List<Integer> boards, int students)
	    {
	        if(boards == null || boards.size() == 0 || students < 1 || boards.size() < students) {
	            return -1;
	        }
	        
	        //calculate search space
	        int start=1,end = (int)boards.stream().collect(Collectors
	        		.summarizingInt(t->t)).getSum();
	        int mid = 0,ans=-1;
	        while(start<=end) {
	            
	            mid = start + ((end-start)>>1);
	            
	            if(isBookAllocationValid(boards,mid,students)) {
	                ans = mid;
	                end = mid-1;
	            }else {
	                start = mid+1;
	            }
	        }
	        return ans;
	    }
	    
	    /**
		 * TC O(N)
		 * stack O(1)
		 * aux O(1)
		 */
	    private static boolean isBookAllocationValid(List<Integer> boards, int mid,int numerOfTotalStudents) {
	        int studentCount=1,pageAllocatedPerStudent=0;
	        
	        for (int i = 0; i < boards.size(); i++) {
	            if(pageAllocatedPerStudent + boards.get(i) <= mid) {
	                pageAllocatedPerStudent+=boards.get(i);
	            }else {
	                studentCount++;
	                if(studentCount > numerOfTotalStudents || boards.get(i) > mid) {
	                    return false;
	                }
	                pageAllocatedPerStudent = boards.get(i);
	            }
	        }
	        return true;
	    }
	
	public static void main(String[] args) {
		System.out.println(findLargestMinDistance(Arrays.asList(48,90),2));
		System.out.println(findLargestMinDistance(Arrays.asList(1,2,3,4),2));
		System.out.println(findLargestMinDistance(Arrays.asList(2 ,9 ,2, 4, 5, 10, 3, 3, 4, 1 ),2));
		System.out.println(findLargestMinDistance(Arrays.asList(6 ,2, 1, 3, 4, 7, 4, 6, 1, 1 ),7));
		System.out.println(findLargestMinDistance(Arrays.asList(10,40,60,30),3));
	}

}
