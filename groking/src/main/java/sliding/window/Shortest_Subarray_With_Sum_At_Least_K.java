package sliding.window;

import java.util.ArrayDeque;
import java.util.Deque;



public class Shortest_Subarray_With_Sum_At_Least_K {

	private class Pair{
		
		private int sum;
		private int index;
		
		public Pair(int sum, int index) {
			this.sum = sum;
			this.index = index;
		}
	}

	/**
	 * 
	 * @author Tony.Stark
	 * https://www.youtube.com/watch?v=K0NgGYEAkA4
	 * TC O(N), Stack space O(1)
	 * aux space O(N)
	 */
	public int shortest_Subarray_With_Sum_At_Least_K1(int arr[], int target) {
			
		if(arr == null || arr.length == 0) {
			return -1;
		}
		
		int sum = 0,ans = ~(1<<31);
		Deque<Pair> deq = new ArrayDeque<Pair>();
		Pair current = null;
		for (int j = 0; j < arr.length; j++) {
			
			sum+=arr[j];
			if (sum >= target) {
				ans = Math.min(ans, j+1);
			}
			
			while(!deq.isEmpty() && (sum-deq.peekFirst().sum) >= target) {
				current = deq.pollFirst();
			}
			
			if(current != null) {
				ans = Math.min(ans, j-current.index);
			}
			
			while(!deq.isEmpty() && deq.peekLast().sum >= sum) {
				deq.pollFirst();
			}
			deq.offerLast(new Pair(sum, j));
		}
		return ans == ~(1<<31) ? -1 : ans;
	}
	
	
	/**
	 * Intuition is not clear for below logic , Refer above logic
	 * TC O(N), Stack space O(1)
	 * aux space O(N)
	 */
	public static int shortest_Subarray_With_Sum_At_Least_K(int A[],int k) {
	        
		 long[] prefixSum = new long[A.length + 1];
         
	       for(int i=0; i<A.length; i++){
	           prefixSum[i+1] = prefixSum[i] + (long) A[i];
	       }
	     
	       int ans = A.length + 1;
	         
	       Deque<Integer> dq = new ArrayDeque<>();
	         
	        for(int i=0; i<prefixSum.length; i++){
	            while(!dq.isEmpty() && prefixSum[dq.peekLast()] >= prefixSum[i]){
	                dq.pollLast();
	            }
	            while(!dq.isEmpty() && prefixSum[dq.peekFirst()] + k <= prefixSum[i]){
	                int poll = dq.pollFirst();
	            	ans = Math.min(ans, i - poll);
	            }
	             
	            dq.offerLast(i);
	        }
	        return ans == A.length + 1 ? -1 : ans;
	    }
		
	
	
	public static void main(String[] args) {
		
		Shortest_Subarray_With_Sum_At_Least_K obj = new Shortest_Subarray_With_Sum_At_Least_K();
		  
		  int arr[]= {84,-37,32,40,95};
		  int arr1[]= {2,-1,2};
		  int arrk[] = {-12,-22,-33,3};
		  System.out.println("logic 1 "+shortest_Subarray_With_Sum_At_Least_K(arr,4)); // 3
		System.out.println("logic 1 "+shortest_Subarray_With_Sum_At_Least_K(arr1,4)); // 
		 System.out.println("logic 1 "+shortest_Subarray_With_Sum_At_Least_K(arrk,4)); // 
		  
		  
		 System.out.println("logic 2 "+obj.shortest_Subarray_With_Sum_At_Least_K1(arr,4)); // 3
		 System.out.println("logic 2 "+obj.shortest_Subarray_With_Sum_At_Least_K1(arr1,4)); // 
		 System.out.println("logic 2 "+obj.shortest_Subarray_With_Sum_At_Least_K1(arrk,4)); // 
		  
		  int arr2[]= {2,3,-5,1,6,7};
		 System.out.println("logic 1 "+shortest_Subarray_With_Sum_At_Least_K(arr2,6)); // 1
		 System.out.println("logic 2 "+obj.shortest_Subarray_With_Sum_At_Least_K1(arr2,6)); // 1
		  
		  int arr3[]= {2,3,-5,1,7};
		  int arr13[]= {2,7,3,-8,4,10};
		  System.out.println("logic 1 arr13 "+shortest_Subarray_With_Sum_At_Least_K(arr13,6)); // 1
		 System.out.println("logic 1 arr3 "+shortest_Subarray_With_Sum_At_Least_K(arr3,6)); // 
		  
		 System.out.println("logic 2 arr13 "+obj.shortest_Subarray_With_Sum_At_Least_K1(arr13,6)); // 1
		 System.out.println("logic 2 arr3 "+obj.shortest_Subarray_With_Sum_At_Least_K1(arr3,6)); // getting 2 but it should be 1
		 		
		  int arr4[]= {2,3,5,-1,7};
		 System.out.println("logic 1 arr4 "+shortest_Subarray_With_Sum_At_Least_K(arr4,6)); // 1
		 System.out.println("logic 2 arr4 "+obj.shortest_Subarray_With_Sum_At_Least_K1(arr4,6)); // 1
		
		
		
		  Deque<Integer> de = new ArrayDeque<Integer>(1); 
		  System.out.println("1 de "+de);
		  de.offerFirst(100); 
		  System.out.println("2 de "+de);
		  System.out.println("de.peekFirst() "+de.peekFirst());
		  System.out.println("de.peekLast() "+de.peekLast());
		  
		  de.offerFirst(190);
		  
		  System.out.println("3 de "+de);
		  System.out.println("de.peekFirst() "+de.peekFirst());
		  System.out.println("de.peekLast() "+de.peekLast());
		  
		  de.offerFirst(2010);
		  System.out.println("4 de "+de);
		  de.offerLast(33);
		  de.offerLast(43);
		  de.offerLast(431);
		  de.offerLast(439);;
		  de.offerLast(4113);
		  de.offerLast(4311);
		  de.offerLast(41113);
		  de.offerLast(1143);
		  de.offerLast(143);
		  de.offerLast(413);
		  System.out.println("after shifting de "+de);
		  de.removeFirst();
		  de.removeFirst();
		  System.out.println("de "+de);
		  System.out.println("de.peekFirst() "+de.peekFirst());
		  System.out.println("de.peekLast() "+de.peekLast());
		 
		 
		
		//java.util.Iterator<Integer> itr = de.iterator();
//		while(itr.hasNext()) {
//			System.out.println("itr..... "+itr.next());
//		}
	}

}
