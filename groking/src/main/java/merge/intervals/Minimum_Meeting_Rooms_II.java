package merge.intervals;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class Minimum_Meeting_Rooms_II {
	

	/**
	 * TC O(N LOG N)  for sorting the combine array
	 * TC O(N LOG N) for add/remove into Priority-Queue for N element
	 * for each element it taks O(LOG N) so for N element it is O(N LOG N)
	 * So Total TC is O(N LOG N)
	 * 
	 * SC O(N) for priority-queue
	 */
	private static int minimum_Meeting_Rooms_II(int[][] meetings) {
		
		if(meetings == null || meetings.length == 0) {
			return 0;
		}
		if(meetings.length == 1) {
			return 1;
		}
		
		Arrays.sort(meetings,(a,b) ->
			Integer.compare(a[0], b[0])
		);
		Queue<Integer> pq = new PriorityQueue<Integer>();
		
		pq.offer(meetings[0][1]);
		
		for (int i = 1; i < meetings.length; i++) {
			
			if(!(pq.peek() > meetings[i][0])) {
				pq.remove();
			}
			pq.offer(meetings[i][1]);
		}
		return pq.size();
	}
	
	/**
	 * TC O(N LOG N)  for sorting the startTime array
	 * TC O(N LOG N) for sorting the endTime array
	 * 2 + N LOG N => So Total TC is O(N LOG N)
	 * 
	 * SC 2+N for creating Individual endTime and startTime array's, So Total SC is O(N)
	 */
	private static int minimum_Meeting_Rooms_II_WithOut_PriorityQueue(int[][] meetings) {
		if(meetings == null || meetings.length == 0) {
			return 0;
		}
		if(meetings.length == 1) {
			return 1;
		}
		
		int endTime[] = new int[meetings.length];
		int startTime[] = new int[endTime.length];
		
		for (int i = 0; i < startTime.length; i++) {
			startTime[i] = meetings[i][0];
		}
		
		for (int i = 0; i < startTime.length; i++) {
			endTime[i] = meetings[i][1];
		}
		
		Arrays.sort(startTime);
		Arrays.sort(endTime);
		
		int i=0,j=0,rooms=0;
		
		while(i < startTime.length && j < endTime.length) {
			
			if(startTime[i] < endTime[j]) {
				rooms++;
				i++;
			}else {
				i++;
				j++;
			}
		}
		
		return rooms;
	}
	
	
	public static void main(String[] args) {
		int array[][]={{4,5},{2,3},{2,4},{3,5}};
		System.out.println(minimum_Meeting_Rooms_II(array)); //2 
		System.out.println(minimum_Meeting_Rooms_II_WithOut_PriorityQueue(array)); //2
		
		int array1[][]={{1,4},{2,5},{7,9}};
		System.out.println(minimum_Meeting_Rooms_II(array1)); //2 
		System.out.println(minimum_Meeting_Rooms_II_WithOut_PriorityQueue(array1)); //2
		
		int array2[][]={{6,7},{2,4},{8,12}};
		System.out.println(minimum_Meeting_Rooms_II(array2)); //1
		System.out.println(minimum_Meeting_Rooms_II_WithOut_PriorityQueue(array2)); //1
		
		int array3[][]={{1,4},{2,3},{3,6}};
		System.out.println(minimum_Meeting_Rooms_II(array3)); //2
		System.out.println(minimum_Meeting_Rooms_II_WithOut_PriorityQueue(array3)); //2
		
		
	}

}
