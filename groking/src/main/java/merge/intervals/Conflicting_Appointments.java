package merge.intervals;

import java.util.Arrays;

public class Conflicting_Appointments {

	private static boolean conflictingAppointments(int intervals[][]) {
		
		if(intervals == null || intervals.length <=1 ) {
			return false;
		}
		
		Arrays.sort(intervals,(a,b) ->
			Integer.compare(a[0], b[0])
		);
		
		for(int i=1;i<intervals.length;i++) {
			if(!(intervals[i-1][1]<intervals[i][0])) {
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		int array[][] = { { 1, 4 }, { 2, 5 }, { 7, 9 } };
		System.out.println(conflictingAppointments(array));
		
		int array1[][] = { { 6, 7 }, { 2, 4 }, { 8, 12 } };
		System.out.println(conflictingAppointments(array1));
		
		int array2[][] = { { 4, 5 }, { 2, 3 }, { 3, 6 } };
		System.out.println(conflictingAppointments(array2));
	}

}
