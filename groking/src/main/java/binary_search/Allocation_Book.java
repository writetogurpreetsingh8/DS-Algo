package binary_search;

import java.util.Arrays;

/**
 * 
 * @author Tony.Stark
 * TC O(logN*N)
 * stack O(1)
 * aux O(1)
 *
 */
public class Allocation_Book {

	/**
	 * TC O(logN)
	 * stack O(1)
	 * aux O(1)
	 */
	public static int allocation_Book(int[] books,int students) {
		
		if(books == null || books.length == 0 || students < 1 
				|| books.length < students) {
			return -1;
		}
		
		//calculate search space
		int start=0,end = Arrays.stream(books).sum();
		int mid = 0,ans=-1;
		while(start<=end) {
			
			mid = start + ((end-start)>>1);
			
			if(isBookAllocationValid(books,mid,students)) {
				ans = mid;
				end = mid-1;
			}else {
				start = mid+1;
			}
		}
		return ans;
	}
	
	/**
	 * TC O(N)
	 * stack O(1)
	 * aux O(1)
	 */
	private static boolean isBookAllocationValid(int[] books, int mid,int numerOfTotalStudents) {
		int studentCount=1,pageAllocatedPerStudent=0;
		
		for (int i = 0; i < books.length; i++) {
			if(pageAllocatedPerStudent + books[i] <= mid) {
				pageAllocatedPerStudent+=books[i];
			}else {
				studentCount++;
				if(studentCount > numerOfTotalStudents || books[i] > mid) {
					return false;
				}
				pageAllocatedPerStudent = books[i];
			}
		}
		return numerOfTotalStudents == studentCount;
	}


	public static void main(String[] args) {
		
		int books[]= {10,20,30,40};
		System.out.println(allocation_Book(books,2));
		System.out.println(allocation_Book(books,3));
		
		int books1[]= {30,10,40,20};
		System.out.println(allocation_Book(books1,2));
		
		int books2[]= {0,1,2,3};
		System.out.println(allocation_Book(books2,2));
		
		int books3[]= {2,3,5,4};
		System.out.println(allocation_Book(books3,2));
		
		int books4[]= {1, 2, 2, 3, 1};
		System.out.println(allocation_Book(books4,3)); //4
		
		int books5[]= {10,40,60,30};
		System.out.println(allocation_Book(books5,3));
		
		int books6[]= {1,4,4};
		System.out.println(allocation_Book(books6,3));
		
		int books7[] = {2,3,1,2,4,3};
		System.out.println(allocation_Book(books7,5));
		
	}

}
