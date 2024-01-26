package sliding.window;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Find_First_Neg_IN_Window {

	/**
	 * fixed size window
	 */
	private static List<Integer> findFirstNegINWindow(int[] array,int windowSize) {
		
		if(array == null || array.length < windowSize || windowSize <=0 ) {
			System.out.println("invalid array or windowSize");
			return Collections.emptyList();
		}
		int s = 0;
		Queue<Integer> hold = new LinkedList<Integer>();
		List<Integer> result = new ArrayList<Integer>();
		for (int e = 0; e < array.length; e++) {
			
			if(array[e] <0 ) {
				hold.offer(array[e]);
			}
			if( (e-s)+1 == windowSize) {
				if(hold.size() == 0) {
					result.add(0);
				}else {
					result.add(hold.peek());
					if(array[s] == hold.peek()) {
						hold.poll();
					}
				}
				s++;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		int array[]= {2,1,-1,0,-2,1,3,4,-5};
		System.out.println(findFirstNegINWindow(array,3));
		
	}

}
