package in.place.reverse.of.linkedList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Merge_Kth_SortedArrays {

	
	private static class ArrayPair{
		
		private int value;
		private int valueIndex;
		private int arrayIndex;
		
		public ArrayPair(int value, int valueIndex, int arrayIndex) {
			this.value = value;
			this.valueIndex = valueIndex;
			this.arrayIndex = arrayIndex;
		}
		
		public int getValue() {
			return this.value;
		}

		public void setValue(int value) {
			this.value = value;
		}

		public int getValueIndex() {
			return valueIndex;
		}

		public void setValueIndex(int valueIndex) {
			this.valueIndex = valueIndex;
		}

		public int getArrayIndex() {
			return arrayIndex;
		}
	}
	
	/**
	 * TC O(N log N) / precisely TC O(NK log N)
	 * SC O(K) , here k means length of given arr, and stack space O(1)
	 * this is the Painter_Allocation by PriorityQueue 
	 */
	public static int[] mergingK_Sored_Array_With_Priority_Queue(int[][] arr) {
		
			if(arr == null || arr.length == 0) {
				return null;
			}
		
			if(arr.length == 1) {
				return arr[0];
			}
			
			Queue<ArrayPair> pq = new PriorityQueue<ArrayPair>(Comparator.comparing(ArrayPair::getValue));
			
			int i=0;
			ArrayPair ap = null;
			while(i<arr.length) {
				ap = new ArrayPair(arr[i][0], 0, i);
				pq.offer(ap);
				i++;
			}
			
			final List<Integer> resultantList = new ArrayList<Integer>();
			
			while(!pq.isEmpty()) {
				
				ap = pq.poll();
				resultantList.add(ap.getValue());
				
				if(arr[ap.getArrayIndex()].length-1 > ap.getValueIndex()) {
					ap.setValueIndex(ap.getValueIndex()+1);
					ap.setValue(arr[ap.getArrayIndex()][ap.getValueIndex()]);
					pq.offer(ap);
				}
			}
			
			return resultantList.stream().mapToInt(ll-> ll).toArray();
	}
	
	/** 
	 * TC O(N log N) / precisely TC O(NK log N)
	 * SC O(N) / precisely O(NK) and stack space O(log k)
	 * this is the Painter_Allocation by divide and conquer technique 
	 */
	public static int[] merge_Kth_SortedArrayWithoutCreatingNewArray(int[][] arr){
		
		if(arr == null || arr.length == 0) {
			return null;
		}
		
		if(arr.length == 1) {
			return arr[0];
		}
		
		return dividingKSortedArray(arr,0,arr.length-1);
		
	}
	
	private static int[] dividingKSortedArray(int[][] arr, int start, int end) {
		
		if(start == end) {
			return arr[start];
		}
		
		int mid = (start + (end - start)/2);
		int[] left = dividingKSortedArray(arr,start,mid);
		int[] right = dividingKSortedArray(arr,mid+1,end);
		
		return mergingSortedArrays(left,right);
	}


	/** in this solution we are dividing the given array upto single array to do this we
	 * are physically creating new Array by Arrays.copyOfRange() method.............
	 * TC O(N log N) / precisely TC O(NK log N)
	 * SC O(N)/ precisely O(NK) and stack space O(log k)
	 * this is the Painter_Allocation by divide and conquer technique 
	 */
	public static int[] merge_Kth_SortedArray(int[][] arr){
		
		if(arr == null || arr.length == 0) {
			return null;
		}
		
		if(arr.length == 1) {
			return arr[0];
		}
		
		int mid = arr.length/2; // calculate mid and avoid overflow
		int[] left = merge_Kth_SortedArray(Arrays.copyOfRange(arr, 0,mid));
		int[] right = merge_Kth_SortedArray(Arrays.copyOfRange(arr,mid,arr.length));
		return mergingSortedArrays(left,right);
		
	}
	
	private static int[] mergingSortedArrays(int[] left,int[] right) {
		
		int[] newArray = new int[left.length + right.length];
		int i=0,j=0,k=0;
		
		while(i < left.length && j < right.length) {
			if(left[i] < right[j]) {
				newArray[k] = left[i];
				i++;
			}else {
				newArray[k] = right[j];
				j++;	
			}
			k++;
		}
		while(i < left.length) {
			newArray[k] = left[i];
			k++;i++;
		}
		
		while(j < right.length) {
			newArray[k] = right[j];
			k++;j++;
		}
		return newArray;
	}

	public static void main(String[] args) {
		
		int arr1[] = {0,1,2,3,4,5,100};
		
		int arr2[] = {1,2,6,8,9};
		
		int arr3[] = {-1,11,12,31,41,51};
		
		int arr[][]= {arr3,arr1,arr2};
		
		int result[] = merge_Kth_SortedArray(arr);
		System.out.println(Arrays.toString(result));
		
		result = merge_Kth_SortedArrayWithoutCreatingNewArray(arr);
		System.out.println(Arrays.toString(result));
		
		result = mergingK_Sored_Array_With_Priority_Queue(arr);
		System.out.println(Arrays.toString(result));
	}

}
