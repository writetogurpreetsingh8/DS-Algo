package sliding.window;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class Maximum_Of_All_Sub_Array {
	
	
	public static int[] slidingWindowMax(final int[] in, final int w) {
	    final int[] max_left = new int[in.length];
	    final int[] max_right = new int[in.length];

	    max_left[0] = in[0];
	    int j=0;
	    max_right[in.length - 1] = in[in.length - 1];

	    for (int i = 1; i < in.length; i++) {
	        max_left[i] = (i % w == 0) ? in[i] : Math.max(max_left[i - 1], in[i]);

	        j = in.length - i - 1;
	        max_right[j] = (j % w == 0) ? in[j] : Math.max(max_right[j + 1], in[j]);
	    }

	    int result[] = new int [in.length-w+1];
	    for (int i = 0,p=0; i<result.length; i++) {
	    	result[p++]=Math.max(max_right[i], max_left[i + w - 1]);
	    }

	    return result;
	}
	
	/**
	 * store index into Dequeue instead of array's value
	 * fixed size window
	 * @param array
	 * @param windowSize
	 * @return
	 */
	private static List<Integer> maximumOfAllSubArray2(int array[],int windowSize) {
		
		if(array == null || array.length < windowSize) {
			System.out.println("invalid array or window-size");
			return null;
		}
		
		Deque<Integer> dequeue = new ArrayDeque<Integer>();
		List<Integer> result = new ArrayList<Integer>();
		
		for(int we = 0; we<array.length; we++) {
			
			while(!dequeue.isEmpty() && array[dequeue.peekLast()] < array[we]) {
				dequeue.pollLast();
			}
			dequeue.offerLast(we); // storing index in stead of values
			
			if( we >= (windowSize-1)) {
				
				result.add(array[dequeue.peekFirst()]);
				if(array[dequeue.peekFirst()] == array[(we-windowSize)+1]) {
					dequeue.pollFirst();
				}
			}
		}
		return result;
	}

	/**
	 * store array's value into Dequeue instead of index
	 * fixed size window
	 * @param array
	 * @param windowSize
	 * @return
	 */
	private static List<Integer> maximumOfAllSubArray1(int array[],int windowSize) {
		
		if(array == null || array.length < windowSize) {
			System.out.println("invalid array or window-size");
			return null;
		}
		
		int ws = 0;
		Deque<Integer> dequeue = new ArrayDeque<Integer>();
		List<Integer> result = new ArrayList<Integer>();
		
		for(int we = 0; we<array.length; we++) {
			
			while(!dequeue.isEmpty() && dequeue.peekLast() < array[we]) {
				dequeue.pollLast();
			}
			dequeue.offerLast(array[we]);
			
			if((we - ws + 1) == windowSize) {
				
				result.add(dequeue.peekFirst());
				if(dequeue.peekFirst() == array[ws]) {
					dequeue.pollFirst();
				}
				ws++;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		
		
		  int array[]= {-3,15,1,8,7,-4,10,5,7,11,-2,4};
		//  System.out.println(maximumOfAllSubArray1(array,5));
		//  System.out.println(maximumOfAllSubArray2(array,5));
		//  System.out.println(Arrays.toString(slidingWindowMax(array,5)));
		  
		  int array1[]={3,-5,1,2,7,-4,10};
		  System.out.println(maximumOfAllSubArray1(array1,3));
		  System.out.println(maximumOfAllSubArray2(array1,3));
		  System.out.println(Arrays.toString(slidingWindowMax(array1,3)));
		  
		  int array2[]={3,0,-1,-3,-2,-4};
		  System.out.println(maximumOfAllSubArray1(array2,3));
		  System.out.println(maximumOfAllSubArray2(array2,3));
		  System.out.println(Arrays.toString(slidingWindowMax(array2,3)));
		  
		  int array3[]={1,3,-1,-3,5,3,6,5,4,2,1};
		  System.out.println(maximumOfAllSubArray1(array3,3));
		  System.out.println(maximumOfAllSubArray2(array3,3));
		  System.out.println(Arrays.toString(slidingWindowMax(array3,3)));
		  
		  int array4[]={9,11};
		  System.out.println(maximumOfAllSubArray1(array4,2));
		  System.out.println(maximumOfAllSubArray2(array4,2));
		  System.out.println(Arrays.toString(slidingWindowMax(array4,2)));
		 
		
		int array5[]={4,2,3,2,1,0,7,8,9,-7,3};
		System.out.println(maximumOfAllSubArray1(array5,4));
		System.out.println(maximumOfAllSubArray2(array5,4));	
		System.out.println(Arrays.toString(slidingWindowMax(array5,4)));

	}

}
