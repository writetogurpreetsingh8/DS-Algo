package merge.intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class employee_free_time {
	
	/**
	 * TC O(N LOG N ) for sorting employeesIntervals
	 * SC O(N) for having result as List
	 * O(K*N) for converting the 3d array into 2d arrays
	 * Accordingly, as a function that is  O(kn)  [the conventional way of writing it] 
	 * is equally  O(n)  [as multiplicative & additive constants may be disregarded],
	 * then a function that is  O(kn)  is  O(nlogn) , or  nlogn  is asymptotically larger than  kn .
	 */
	private static int[][] employee_free_time(int[][][] employeesIntervals){
	
		List<int[]> result = new ArrayList<int[]>();
		
		if(employeesIntervals == null || employeesIntervals.length <= 1) {
			return result.toArray(new int[0][0]);
		}
		
		/*
		 * flattern 3D into 2D arrays
		 * TC O(K*N)
		 */
		Object[] temArray = Arrays.stream(employeesIntervals).flatMap(Arrays::stream).toArray();
		
		/*
		 * Flattern two 2D into 1D
		 * int[] temArray1 = Arrays.stream(temArray).flatMapToInt(s->{ return
		 * Arrays.stream((int[])s); }).toArray();
		 */
		
		Arrays.sort(temArray,(a,c)-> {
			return Integer.compare(((int[])a)[0],((int[])c)[0]);
			});
		  int mergedIntervals[] = (int[])temArray[0];
		  
		  for(int i=1;i<temArray.length;i++) { 
			  if(((int[])temArray[i])[0] <= mergedIntervals[1]) { 
						  mergedIntervals = ((int[])temArray[i]);
				  }
			  else { 
				  result.add(new int[]{mergedIntervals[1],((int[])temArray[i])[0]}); 
				  mergedIntervals =  (int[])temArray[i]; 
				  }  
			  } 
		  return result.toArray(new int[result.size()][0]);
	}
	

	public static void main(String[] args) {
		int array[][][] = { {{6,8}} ,{ {2,4}}, {{1,3} ,{ 9,12}} };
		int result[][] = employee_free_time(array);
		System.out.println(array); // free intervals [3,5]
		
		int array1[][] = { { 1, 3 }, { 9,12}, { 2,4 }, { 6, 8 } };
		//array = employee_free_time(array1);
		System.out.println(array); // free intervals [4,6],[8,9]
		
		int array2[][] = { { 1, 3 }, { 2,4}, { 3,5 }, { 7,9 } };
		//array = employee_free_time(array2);
		System.out.println(array); // free intervals [5,7]

	}

}
