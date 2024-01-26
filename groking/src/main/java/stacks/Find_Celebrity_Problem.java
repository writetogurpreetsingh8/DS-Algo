package stacks;

import java.util.Stack;

public class Find_Celebrity_Problem {

	
	/**
	 * TC O(N)
	 * System stack O(1)
	 * aux-space O(1) By using Two pointer approach
	 * Refer below Youtube link for Two Pointer approach after 8:58 Length
	 * https://www.youtube.com/watch?v=aENYremq77I
	 */
	private static int find_Celebrity_Problem_With_Two_Pointer_Approach(int[][] party) {
			
		int celebrity=-1;
		
		if(party == null) {
			return celebrity;
		}
		
		int start =0, end = party.length-1;
		while(start != end){
		    if(party[start][end] == 1){
		        start++;
		    }else{
		        end--;
		    }
		}
		celebrity = start;
		
		for (int i = 0; i < party.length; i++) {
		    if(party[celebrity][i] != 0) {
					celebrity = -1;
					break;
				}
			if(i != celebrity) {
				if(party[i][celebrity] != 1) {
					celebrity = -1;
					break;
				}
			}
		}
		return celebrity;
	}
	
	/**
	 * TC O(N)
	 * System stack O(1)
	 * aux-space O(N) for taking Stack here
	 * @param party
	 * @return
	 */
	private static int find_Celebrity_Problem_With_Stack(int[][] party) {
			
			int celebrity=-1;
			
			if(party == null) {
				return celebrity;
			}
			
			Stack<Integer> stack = new Stack<Integer>();
			for (int i = 0; i < party.length; i++) {
				stack.push(i);
			}
			
			int candidate1=0, candidate2=0;
			
			while(stack.size() > 1) {
				
				candidate1 = stack.pop();
				candidate2 = stack.pop();
				if(party[candidate1][candidate2] == 1) {
					stack.push(candidate2);
				}
				else {
					stack.push(candidate1);
				}
			}
			
			celebrity = stack.pop();
			
			for (int i = 0; i < party.length; i++) {
				
				if(party[celebrity][i] != 0) {
					celebrity = -1;
					break;
				}
				
				if(i != celebrity) {
					if(party[i][celebrity] != 1 ) {
						celebrity = -1;
						break;
					}
				}
			}
			
			return celebrity;
	}
		
		
	/**
	 * TC O(N^2)
	 * System stack O(1)
	 * aux-space O(1)
	 * @param party
	 * @return
	 */
	private static int find_Celebrity_Problem(int[][] party) {
		
		int celebrity=-1;
		
		if(party == null) {
			return celebrity;
		}
		int j;
		for (int i = 0; i < party.length; i++) {
			for (j = 0; j < party[i].length; j++) {
				if(party[i][j] != 0) {
					break;
				}
			}
			if(j == party[i].length) {
				if(celebrity == -1) {
					celebrity = i;
				}
				else {
					celebrity = -1;
					break;
				}
			}
		}
		
		if(celebrity == -1) {
			return celebrity;
		}
		
		for (int i = 0; i < party.length; i++) {
			if(i != celebrity) {
				if(party[i][celebrity] != 1) {
					celebrity = -1;
					break;
				}
			}
		}
		return celebrity;
	}
	public static void main(String[] args) {
		
		int party[][] = { {0,1,1},
						  {0,0,1},
						  {0,0,0}
						};
		
		System.out.println(find_Celebrity_Problem(party));
		System.out.println(find_Celebrity_Problem_With_Stack(party));
		System.out.println(find_Celebrity_Problem_With_Two_Pointer_Approach(party));
	}

}
