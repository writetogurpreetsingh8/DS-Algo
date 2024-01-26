package merge.intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Merge_Intervals {

	private static int[][] mergeIntervals(int[][] intervals){
		
		List<int[]> result = new ArrayList<int[]>();
		if(intervals == null || intervals.length < 2) {
			return result.toArray(new int[0][]);
		}
		
		Arrays.sort(intervals, (a,b) -> {
			return Integer.compare(a[0], b[0]);
		});
		
		int[] newInterval = intervals[0];
		result.add(newInterval);
		
		for (int[] val:intervals) {
			if(val[0]<=newInterval[1]) {
				newInterval[1] = Math.max(val[1], newInterval[1]);
			}else {
				newInterval = val;
				result.add(newInterval);
			}
		}
		return result.toArray(new int[result.size()][]);
	}
	
	public static void main(String[] args) {

		int array[][]={{2,6},{1,3},{15,18},{5,10}};
		//int array1[][][]={{{2,6},{1,3}},{{15,18},{5,10}}};
		System.out.println("value is "+array[1]);
		array=mergeIntervals(array);
		System.out.println(array);
		
	}

}
