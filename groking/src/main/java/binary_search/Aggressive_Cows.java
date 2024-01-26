package binary_search;

import java.util.Arrays;

/**
 * final TC O(NLogN) 
 */
public class Aggressive_Cows {

	/**
	 *  TC O(NlogN) + O(NlogN) = O(NlogN) 
	 */
	public static int aggressiveCows(int stalls[] , int cows) {
		
		if(stalls == null || stalls.length == 0 || cows > stalls.length) {
			return -1;
		}
		
		Arrays.sort(stalls); // O(NlogN)
		int start = 0, end = Arrays.stream(stalls).sum(), mid=0;
		int ans=-1;
		while(start<=end) {
			mid = start+((end-start)/2);
			if(isDistancePossible(stalls,mid,cows)) {
				ans = mid;
				start = mid+1;
			}else {
				end = mid-1;
			}
		}
		return ans;
	}
	/**
	 * TC O(N) 
	 */
	private static boolean isDistancePossible(int stalls[], int distance, int cows) {
		int counter = 1, diff = stalls[0];
		for (int i = 1; i < stalls.length; i++) {
			if(Math.abs(diff-stalls[i]) >= distance) {
				counter++;
				diff = stalls[i];
			}
			if(counter == cows) {
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		int stalls[]= {4,2,1,3,6};
		System.out.println(aggressiveCows(stalls,3));
		
		int stalls1[]= {4,2,1,3,6};
		System.out.println(aggressiveCows(stalls1,2));
		
		int stalls2[]= {1,2,8,4,9};
		System.out.println(aggressiveCows(stalls2,3));
	}

}
