package stacks;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Game_Of_Two_Stacks {

	/**
	 * this below program not working properly
	 */
	private static int game_Of_Two_Stacks1(List<Integer> arr1, List<Integer> arr2, int sum) {
		
		if(arr1 == null || arr2 == null || sum <=0) {
			return -1;
		}
		
		return game_Of_Two_Stacks1(arr1,arr2,sum,0,0)-1;
	}
	
	  private static int game_Of_Two_Stacks1(List<Integer> arr1, List<Integer> arr2, int sum, int target, int steps) {
		
		  if(target > sum) {
			return steps;
		}
		if(arr1.isEmpty() || arr2.isEmpty()) {
			return steps;
		}
		int result1 = game_Of_Two_Stacks1(arr1.subList(1, arr1.size()),arr2,sum,(target+arr1.get(0)),(steps+1));
		int result2 = game_Of_Two_Stacks1(arr1,arr2.subList(1, arr2.size()),sum,(target+arr2.get(0)),(steps+1));
		
		return Math.max(result1, result2);
	}
	

	/**
	 * This below program is working fine!!
	 * TC O(N+M)
	 * aux-space O(1)
	 * system stack O(N+M)
	 * N,M refers to arr1 and arr2   
	 */
	private static int game_Of_Two_Stacks(int[] arr1, int[] arr2, int sum) {
		
		if(arr1 == null || arr2 == null || sum <=0) {
			return -1;
		}
		
		return game_Of_Two_Stacks(arr1,arr2,sum,0,0,0,0)-1;
	}
	
	private static int game_Of_Two_Stacks(int[] arr1, int[] arr2, int sum, int target, int arr1Index, int arr2Index, int steps) {
		if(target > sum) {
			return steps;
		}
		if(arr1Index == arr1.length || arr2Index == arr2.length) {
			return steps;
		}
		int result1 = game_Of_Two_Stacks(arr1,arr2,sum,(target+arr1[arr1Index]),(arr1Index+1),arr2Index,(steps+1));
		int result2 = game_Of_Two_Stacks(arr1,arr2,sum,(target+arr2[arr2Index]),arr1Index,(arr2Index+1),(steps+1));
		
		return Math.max(result1, result2);
	}
	
	public static void main(String[] args) {
		
		int arr1[] = {3,2,1};
		int arr2[] = {7,6};
		System.out.println(game_Of_Two_Stacks(arr1,arr2,16)); //4
		
		System.out.println("game_Of_Two_Stacks1 "+game_Of_Two_Stacks1(Stream.of(3,2,1).collect(Collectors.toList()),
				Stream.of(7,6).collect(Collectors.toList()),16)); //4
		
		int arr11[] = {1,2,3};
		int arr12[] = {7,6};
		System.out.println(game_Of_Two_Stacks(arr11,arr12,6)); //3
		System.out.println("game_Of_Two_Stacks1 "+game_Of_Two_Stacks1(Stream.of(3,2,1).collect(Collectors.toList()),
				Stream.of(7,6).collect(Collectors.toList()),6)); //4
		
		
		int arr111[] = {4,2,4,6,1};
		int arr112[] = {2,1,8,5};
		System.out.println(game_Of_Two_Stacks(arr111,arr112,10));
		System.out.println("game_Of_Two_Stacks1 "+game_Of_Two_Stacks1(Stream.of(4,2,4,6,1).collect(Collectors.toList()),
				Stream.of(2,1,8,5).collect(Collectors.toList()),6)); //4
		
		
	}

}
