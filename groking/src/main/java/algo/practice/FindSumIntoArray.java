package algo.practice;

import java.util.HashSet;
import java.util.Set;

// find sum as any pair of array's value
public class FindSumIntoArray {

	boolean findSumIntoArray(int[] array,int sum) {
	
		Set<Integer> set = new HashSet<>();
		
		for(int data : array) {
			
			if(set.contains(data)) {
				return true;
			}
			else {
				set.add(sum - data);
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int array[]= {1,2,3,4,5}; // find sum as 8
		
		System.out.println(new FindSumIntoArray().findSumIntoArray(array,9));

	}

}
