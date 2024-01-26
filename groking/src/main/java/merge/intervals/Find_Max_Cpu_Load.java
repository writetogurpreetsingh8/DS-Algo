package merge.intervals;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class Find_Max_Cpu_Load {

	/**
	 * TC O(N LOG N ) for sorting two arrays ( startTime and entTime)
	 * SC O(N) for having two different arrays  ( startTime and entTime)
	 */
	private static int find_Max_Cpu_Load_With_Out_Priority_Queue(int [][] jobs) {
		
		if(jobs == null || jobs.length == 0) {
			return 0;
		}
		
		if(jobs.length == 1) {
			return jobs[0][2];
		}
		
		//create two 2D arrays for start and end time
		int startTime[][] = new int [jobs.length][3];
		int endTime[][] = new int [jobs.length][3];
		
		for(int i=0;i<jobs.length;i++) {
			startTime[i] = jobs[i];
			endTime[i] = jobs[i];
		}
		
		// sort startTime array on the basis of start-time
		// and sort endTime array on the basis of end-time
		
		Arrays.sort(startTime,(a,b)->Integer.compare(a[0], b[0]));
		Arrays.sort(endTime,(a,b)->Integer.compare(a[1], b[1]));
		
		int i=0,j=0,maxCpuLoad=0,currentMaxLoad=0;
		
		while(i < startTime.length && j < endTime.length) {
			
			if(startTime[i][0] <= endTime[j][1]) {
				currentMaxLoad+=startTime[i][2];
				i++;
			}else {
				currentMaxLoad-=endTime[j][2];
				j++;
			}
			maxCpuLoad = Math.max(maxCpuLoad, currentMaxLoad);
		}
		return maxCpuLoad;
	}
	
	/**
	 * TC O(N LOG N ) for sorting given array
	 * SC O(N) for having PriorityQueue
	 */
	private static int find_Max_Cpu_Load(int [][] jobs) {
		
		if(jobs == null || jobs.length == 0) {
			return 0;
		}
		if(jobs.length == 1) {
			return jobs[0][2];
		}
		
		int maxCpuLoad = 0 ,currentLoad=0;
		
		// sort arrays on the basis on starting time of jobs ASC order
		Arrays.sort(jobs,(a,b) -> Integer.compare(a[0], b[0]));
		
		// create priority-queue(need min heap here) and provide comparator
		// to sort the jobs on the basis on end time of jobs ASC order
		Queue<int[]> q = new PriorityQueue<int[]>((a,b) -> Integer.compare(a[1], b[1]));
				
		for(int[] sec : jobs) {
			
			while(!q.isEmpty() && q.peek()[1] < sec[0]) {
				currentLoad-=q.poll()[2];
			}
			q.offer(sec);
			currentLoad+=sec[2];
			maxCpuLoad = Math.max(currentLoad, maxCpuLoad);
		}
		return maxCpuLoad;
	}
	public static void main(String[] args) {
		int jobs[][] = { { 4,5,2}, { 2, 3,4 }, { 3, 6,0 },{ 6, 7,1 },{ 7, 8,5 } };
		System.out.println(find_Max_Cpu_Load(jobs));//6
		System.out.println(find_Max_Cpu_Load_With_Out_Priority_Queue(jobs));//6
		
		int jobs1[][] = { { 1,4,3}, { 2, 5,4 }, { 7, 9,6 } };
		System.out.println(find_Max_Cpu_Load(jobs1));//7
		System.out.println(find_Max_Cpu_Load_With_Out_Priority_Queue(jobs1));//7
		
		int jobs2[][] = { { 6,7,10,}, { 2,4,11 }, { 8,12,15 } };
		System.out.println(find_Max_Cpu_Load(jobs2));//15
		System.out.println(find_Max_Cpu_Load_With_Out_Priority_Queue(jobs2));//15
		
		int jobs3[][] = { { 1,4,2}, { 2,4,1 }, { 3,6,5 } };
		System.out.println(find_Max_Cpu_Load(jobs3));//8
		System.out.println(find_Max_Cpu_Load_With_Out_Priority_Queue(jobs3));//8
		
		int jobs4[][] = { { 4,5,1}, { 2,3,5 }, { 2,4,2 },{ 3,5,8 } };
		System.out.println(find_Max_Cpu_Load(jobs4));//15
		System.out.println(find_Max_Cpu_Load_With_Out_Priority_Queue(jobs4));//15

	}

}
