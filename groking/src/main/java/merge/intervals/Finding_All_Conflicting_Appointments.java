package merge.intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Finding_All_Conflicting_Appointments {

	private static List<List<int[]>> findingAllConflictingAppointments(int intervals[][]) {
		
		List<List<int[]>> result = new ArrayList<List<int[]>>();
		
		if(intervals == null || intervals.length <=1 ) {
			return result;
		}
		
		Arrays.sort(intervals,(a,b) ->
			Integer.compare(a[0], b[0])
		);
		
		int interv[] = intervals[0];
		List<int[]> subResult = null;
		
		for(int i=1;i<intervals.length;i++) {
		
			if(interv[1]>intervals[i][0]) {
				subResult = new ArrayList<int[]>();
				subResult.add(interv);
				subResult.add(intervals[i]);
				if(intervals[i][1]>=interv[1]) {
					interv = intervals[i];
				}
				result.add(subResult);
			}else {
				interv = intervals[i];
			}
		}
		return result;
		
	}
	public static void main(String[] args) {
		int array[][] = { { 4,5}, { 2, 3 }, { 3, 6 },{ 5, 7 },{ 7, 8 } };
		List<List<int[]>> result = findingAllConflictingAppointments(array);
		System.out.println("result "+result);
		
		int array1[][] = { { 4,5}, { 2, 3 }, { 3, 6 },{ 5, 7 },{6,7},{ 7, 8 } };
	    result = findingAllConflictingAppointments(array1);
		System.out.println("result "+result);
		
		
	}

}
