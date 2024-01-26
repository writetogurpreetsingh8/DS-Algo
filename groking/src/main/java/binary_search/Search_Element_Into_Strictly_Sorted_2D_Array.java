package binary_search;

/**
 * 
 * @author Tony.Stark Aux space O(1) stack space O(1) Final TC O(Log N) + O(Log
 *         M) 
 *         2D Matrix containing Strictly Sorted element, here we can
 *         implement BS to Identify the Search Space for given Target TC O(Log
 *         N) => for Identify Search space for given target element And 
 *         TC O(Log M) => for apply BS with the range of Identify search space N stands for 
 *         number of Rows M stands for number of columns
 */
public class Search_Element_Into_Strictly_Sorted_2D_Array {

	public static boolean search_Element_Into_Strictly_Sorted_2D_Array(int[][] arr, int target) {

		if (arr == null || arr.length == 0) {
			return false;
		}
		int lastRow = arr.length - 1;
		int lastCol = arr[lastRow].length - 1;

		if (arr[0][0] > target || arr[lastRow][lastCol] < target) {
			return false;
		}
		
		// if having only 1 row and 1 column
		if (lastCol == 0 && lastRow == 0) {
			if (arr[lastRow][lastCol] == target) {
				return true;
			} else {
				return false;
			}
		}

		int start = 0, end = lastRow, mid = -1;
		int searchSpaceStart = -1, searchSpaceEnd = -1;

		// TC O(Log N) N stands for rows
		while (start <= end) {
			mid = (start + (end - start) / 2);
			lastCol = arr[mid].length - 1;
			if (arr[mid][0] <= target && arr[mid][lastCol] >= target) {
				searchSpaceStart = mid;
				searchSpaceEnd = lastCol;
				break;
			} else if (arr[mid][0] > target) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}

		if (searchSpaceStart == -1) {
			return false;
		}

		return findElementIntoSearchSpaces(arr, searchSpaceStart, searchSpaceEnd, target);
	}

	private static boolean findElementIntoSearchSpaces(int[][] arr, int rowIndex, int end, int target) {

		int mid = 0;
		int start = 0;
		while (start <= end) {
			mid = (start + (end - start) / 2);
			if (arr[rowIndex][mid] == target) {
				return true;
			} else if (arr[rowIndex][mid] > target) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return false;
	}

	public static void main(String[] args) {

		int[][] arr = { { 1, 2, 3, 4, 5 }, { 5, 6, 7, 8, 9 }, { 12, 13, 14, 15, 23 }, { 22, 24, 25, 26, 27 } };
		System.out.println(search_Element_Into_Strictly_Sorted_2D_Array(arr, 111));

		int[][] arr1 = { { 1, 2, 3, 4 }, { 5, 6 }, { 12, 13, 14, 15, 23, 34, 56, 78 },
				{ 80, 83, 85, 90, 111, 123, 133, 145, 160, 145, 178 },
				{ 810, 813, 815, 910, 1111, 1213, 1313, 1415, 1610, 1415, 1718 } };
		System.out.println(search_Element_Into_Strictly_Sorted_2D_Array(arr1, 1111));

		int[][] arr2 = { { 1, 2, 3, 4 }, };
		System.out.println(search_Element_Into_Strictly_Sorted_2D_Array(arr2, 4));

		int[][] arr3 = { { 1 }, };
		System.out.println(search_Element_Into_Strictly_Sorted_2D_Array(arr3, 4));
		System.out.println(search_Element_Into_Strictly_Sorted_2D_Array(arr3, 1));
		System.out.println(search_Element_Into_Strictly_Sorted_2D_Array(arr3, 14));
		System.out.println(search_Element_Into_Strictly_Sorted_2D_Array(arr3, 0));
	}

}
