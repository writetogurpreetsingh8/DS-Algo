package merge.intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Finding_Maximum_Platform_For_Trains_At_A_Time {

	/**
	 * TC O(N LOG N)  for sorting the combine array
	 * TC O(N LOG N) for add/remove into Priority-Queue for N element
	 * for each element it taks O(LOG N) so for N element it is O(N LOG N)
	 * So Total TC is O(N LOG N)
	 * 
	 * SC O(N) for priority-queue
	 */
	
	private static int finding_Maximum_Platform_For_Trains_At_A_Time(int[] arrivalTime,int[] departureTime) {
		
		int combine[][] = new int[arrivalTime.length][2];
		
		for(int r=0;r<combine.length;r++) {
			for(int c=0;c<combine[r].length;c++) {
				if(c == 0) {
					combine[r][c] = arrivalTime[r];					
				}else {
					combine[r][c] = departureTime[r];
				}
			}
		}
		
		Arrays.sort(combine,(a,b) -> { 
			System.out.println("a and b "+a +" b is "+b);
			System.out.println("a and b "+a[0] +" b is "+b[0]);
		return Integer.compare(a[0], b[0]);
	}
				);
		
		
		Queue<Integer> pq = new PriorityQueue<Integer>();
		
		pq.offer(combine[0][1]);
		
		for (int i = 1; i < combine.length; i++) {
			
			if(!(pq.peek() > combine[i][0])) {
				pq.remove();
			}
			pq.offer(combine[i][1]);
		}
		return pq.size();
		
	}
	
	/**
	 * TC O(N LOG N)  for sorting the arrivalTime array
	 * TC O(N LOG N) for sorting the departureTime array
	 * 2 + N LOG N => So Total TC is O(N LOG N)
	 * Total SC is O(1)
	 */
	private static int finding_Maximum_Platform_For_Trains_At_A_Time_WithOut_PriorityQueue(int[] arrivalTime,int[] departureTime) {

		Arrays.sort(arrivalTime);
		Arrays.sort(departureTime);
		
		int i=0,j=0,platforms=0;
		
		while(i < arrivalTime.length && j < departureTime.length) {
			if(arrivalTime[i] < departureTime[j]) {
				platforms++;
				i++;
			}else {
				i++;
				j++;
			}
		}
		return platforms;
	}
	
	public static void main(String[] args) {
		int arrival[] = {900,940,950,1100,1500,1800};
		int departure[] = {910,1200,1120,1130,1900,2000};
		System.out.println(finding_Maximum_Platform_For_Trains_At_A_Time(arrival,departure));
		System.out.println(finding_Maximum_Platform_For_Trains_At_A_Time_WithOut_PriorityQueue(arrival,departure));
		
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);list.add(2);list.add(3);
		
		int tem[][]=new int[list.size()][2];
		
		for(int i=0;i<list.size();i++) {
			tem[i][0] = list.get(i);
			tem[i][1] = i;
		}
		System.out.println(tem);
		
	}

}
