package merge.intervals;

import java.util.ArrayList;
import java.util.List;

public class Insert_Intervals {

	// https://leetcode.com/problems/insert-interval/discuss/463417/My-concise-Java-solution-(single-pass-O(n)-3-steps)-with-explanation
	private static int[][] insertIntervals(int intervals[][], int mergeInterval[]) {

		List<int[]> result = new ArrayList<int[]>();

		if (intervals == null || intervals.length == 0) {
			result.add(mergeInterval);
			return result.toArray(new int[result.size()][0]);
		}
		int i = 0;
		// Step 1 - add all intervals ending before newInterval starts
		while (i < intervals.length && intervals[i][1] < mergeInterval[0])
			result.add(intervals[i++]);

		// Step 2 - update the newInterval by merging with all overlapping intervals
		while (i < intervals.length && intervals[i][0] <= mergeInterval[1] && intervals[i][1] >= mergeInterval[0]) {
			mergeInterval[0] = Math.min(intervals[i][0], mergeInterval[0]);
			mergeInterval[1] = Math.max(intervals[i][1], mergeInterval[1]);
			i++;
		}
		
		// add updated interval
		result.add(mergeInterval);
		
		// Step 3 - add remaining intervals
		while(i<intervals.length) 
			result.add(intervals[i++]);
		
		return result.toArray(new int[result.size()][0]);
	}

	public static void main(String[] args) {
		int array[][] = { { 1, 2 }, { 3, 5 }, { 3, 10 }, { 6, 7 }, { 8, 10 }, { 12, 16 } };
		int merge[] = { 4, 8 };
		array = insertIntervals(array, merge);
		System.out.println(array); // [[1, 2], [3, 10], [12, 16]]

		int array1[][] = { { 1, 3 }, { 6, 9 } };
		int merge1[] = { 2, 5 };
		array = insertIntervals(array1, merge1);
		System.out.println(array); // [[1, 5], [6, 9]]

		int array2[][] = { { 1, 3 }, { 5, 7 }, { 8, 12 } };
		int merge2[] = { 4, 10 };
		array = insertIntervals(array2, merge2);
		System.out.println(array); // [[1, 3], [4, 12]]

		int array3[][] = { { 1, 5 } };
		int merge3[] = { 6, 8 };
		array = insertIntervals(array3, merge3);
		System.out.println(array);// [[1, 5], [6, 8]]

		int array4[][] = { { 1, 5 } };
		int merge4[] = { 0, 0 };
		array = insertIntervals(array4, merge4);
		System.out.println(array);//[[0, 0], [1, 5]]
	}

}
