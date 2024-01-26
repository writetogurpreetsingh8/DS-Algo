package binary_search;

/**
 * 
 * @author 91783
 * Find the position of given element in the sorted infinite array
 *  size of array not know or can't use array.length
 *  all the elements are sorted in order ascending order
 *  
 *  stack and space complexity is O(1)
 *  time complexity would be = time taken to find the interval + perform binary-searching on that interval
 *  										O(logi)				+		O(logi)
 * total TC would be 2logi So O(logi)
 */

public class FindPositionOfElementInInfiniteArray {

	private static int findPosition(int array[],int key) {
		
		// can't use array.length or its seems like size not given 
		if(array == null) {
			return -1;
		}
		
		int lower = 0,end = 0;
		int interval = 10; // value of interval could be any +val
		end = interval;
		
		while(array[end] < key) {
		
			lower = end+1;
			end = (end << 1);
		}
		//perform binary searching on the find interval..........
		return binarySearchingOnTheInterval(key,lower,end,array);
	}
	
	private static int binarySearchingOnTheInterval(int key,int lower,int end,int array[]) {
		
		if(array[lower] == key) {
			return lower;
		}
		if(array[end] == key) {
			return end;
		}
		int mid = 0;
		while(lower <= end) {
			
			mid = (lower + end) >>1;
			
			if(array[mid] == key) {
				return mid;
			}
			if(array[mid] > key) {
				end = mid - 1;
			}
			else {
				lower = mid + 1;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		
		int array[]= {1,2,3,4,5,6,7,8,30,40,50,51,55,57,100};
		System.out.println(FindPositionOfElementInInfiniteArray.findPosition(array, 40));
	}

}
