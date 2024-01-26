package fast.slow.pointer;

public class Cycle_in_a_Circular_Array {

	/**
	 * TC O(N^2)
	 * SC O(1) 
	 */
	private static boolean cycle_in_a_Circular_Array(int arr[]) {
		
		if(arr == null || arr.length <=1) {
			return false;
		}
		
		for(int i=0;i<arr.length;i++) {
			if(arr[i] == 0) {
				continue;
			}
			int slowIndex = i, fastIndex = i;
			boolean isFarwardDirection = arr[i] > 0;
			
			do {
				slowIndex = calculateNextIndex(arr,slowIndex,isFarwardDirection);
				if(slowIndex == -1) {
					break;
				}
				fastIndex = calculateNextIndex(arr,fastIndex,isFarwardDirection);
				if(fastIndex == -1) {
					break;
				}
				fastIndex = calculateNextIndex(arr,fastIndex,isFarwardDirection);
				if(fastIndex == -1) {
					break;
				}
			}while(slowIndex != fastIndex);
			
			if(slowIndex !=-1 && slowIndex == fastIndex) {
				return true;
			}
		}
		return false;
		
	}
	
	/**
	 * TC (N)
	 * SC (N) 
	 */
	private static boolean cycle_in_a_Circular_Array_With_Improved(int arr[]) {
		
		if(arr == null || arr.length <=1) {
			return false;
		}
		
		int tempArray[] = new int [arr.length];
		
		for(int i=0;i<arr.length;i++) {
			if(arr[i] == 0) {
				continue;
			}
			int slowIndex = i, fastIndex = i;
			boolean isFarwardDirection = arr[i] > 0;
			
			do {
				slowIndex = calculateNextIndex(arr,slowIndex,isFarwardDirection);
				if(slowIndex == -1) {
					break;
				}
				fastIndex = calculateNextIndex(arr,fastIndex,isFarwardDirection);
				if(fastIndex == -1) {
					break;
				}
				fastIndex = calculateNextIndex(arr,fastIndex,isFarwardDirection);
				if(fastIndex == -1) {
					break;
				}
				if(tempArray[slowIndex]  == -1 || tempArray[fastIndex] == -1) {
					break;
				}
			}while(slowIndex != fastIndex);
			
			if(slowIndex !=-1 && slowIndex == fastIndex) {
				return true;
			}
			tempArray[i] = -1;
		}
		return false;
		
	}
	
	/**
	 *	TC O(N)
	 *  SC O(1)  
	 */
	private static boolean cycle_in_a_Circular_Array_With_More_Improved(int arr[]) {
		
		if(arr == null || arr.length <=1) {
			return false;
		}
		
		for(int i=0;i<arr.length;i++) {
			if(arr[i] == 0) {
				continue;
			}
			int slowIndex = i, fastIndex = i;
			boolean isFarwardDirection = arr[i] > 0;
			
			do {
				slowIndex = calculateNextIndex(arr,slowIndex,isFarwardDirection);
				if(slowIndex == -1) {
					break;
				}
				fastIndex = calculateNextIndex(arr,fastIndex,isFarwardDirection);
				if(fastIndex == -1) {
					break;
				}
				fastIndex = calculateNextIndex(arr,fastIndex,isFarwardDirection);
				if(fastIndex == -1) {
					break;
				}
				if(arr[slowIndex]  == 0 || arr[fastIndex] == 0) {
					break;
				}
			}while(slowIndex != fastIndex);
			
			if(slowIndex !=-1 && slowIndex == fastIndex) {
				return true;
			}
			arr[i] = 0;
		}
		return false;
		
	}
	
	private static int calculateNextIndex(int[] arr, int currentIndex, boolean isFarwardDirection) {
			
		int nextIndex = (currentIndex + arr[currentIndex]) % arr.length;
		if(nextIndex < 0) {
			nextIndex = nextIndex + arr.length;
		}
		boolean direction = arr[nextIndex] > 0;
		if(direction != isFarwardDirection) {
			return -1;
		}
		
		if(currentIndex == nextIndex) {
			return -1;
		}
		return nextIndex;
	}
	
	public static void main(String[] args) {
		
		int arr0[]= {-1,-1,-1};
		System.out.println(cycle_in_a_Circular_Array(arr0)); // true
		System.out.println(cycle_in_a_Circular_Array_With_Improved(arr0)); // true
		System.out.println(cycle_in_a_Circular_Array_With_More_Improved(arr0)); // true
		
		int arr[]= {1,2,-1,2,2};
		System.out.println(cycle_in_a_Circular_Array(arr)); // true
		System.out.println(cycle_in_a_Circular_Array_With_Improved(arr)); // true
		System.out.println(cycle_in_a_Circular_Array_With_More_Improved(arr)); // true
		
		int arr1[]= {2,2,-1,2};
		System.out.println(cycle_in_a_Circular_Array(arr1)); // true
		System.out.println(cycle_in_a_Circular_Array_With_Improved(arr)); // true
		System.out.println(cycle_in_a_Circular_Array_With_More_Improved(arr)); // true
		
		int arr2[]= {-1,2};
		System.out.println(cycle_in_a_Circular_Array(arr2)); // false
		System.out.println(cycle_in_a_Circular_Array_With_Improved(arr2)); // false
		System.out.println(cycle_in_a_Circular_Array_With_More_Improved(arr2)); // false
		
		int arr3[]= {-2,1,-1-2,2};
		System.out.println(cycle_in_a_Circular_Array(arr3)); // false
		System.out.println(cycle_in_a_Circular_Array_With_Improved(arr3)); // false
		System.out.println(cycle_in_a_Circular_Array_With_More_Improved(arr3)); // false
		
		int arr4[]= {4,1,1,1};
		System.out.println(cycle_in_a_Circular_Array(arr4)); // false
		System.out.println(cycle_in_a_Circular_Array_With_Improved(arr4)); // false
		System.out.println(cycle_in_a_Circular_Array_With_More_Improved(arr4)); // false
		
		int arr5[]= {2,1,-1,-2};
		System.out.println(cycle_in_a_Circular_Array(arr5)); // false
		System.out.println(cycle_in_a_Circular_Array_With_Improved(arr5)); // false
		
		System.out.println("mm "+Math.signum(10));
	}

}
