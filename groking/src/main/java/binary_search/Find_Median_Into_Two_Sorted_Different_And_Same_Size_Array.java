package binary_search;

// https://www.youtube.com/watch?v=LPFhl65R7ww&t=1027s
// https://www.youtube.com/watch?v=q6IEA26hvXc
public class Find_Median_Into_Two_Sorted_Different_And_Same_Size_Array {
	/**
	 * using two pointer approach ,TC would be O(M+N), we can reduce it up to
	 * O(LogM+N) by applying BS SC would be O(1), aux space O(1) This algo will also
	 * work fine if both the array's having same size
	 */
	public static double find_Median_Into_Two_Sorted_Different_Size_Array(int[] arr1, int[] arr2) {

		// if both the array's either null or empty
		if (arr1 == null && arr2 == null || (arr1.length == 0 && arr2.length == 0)) {
			return -1;
		}

		int totalArrayLength = arr1.length + arr2.length; // find total length of both the arrays
		boolean isOdd = totalArrayLength % 2 != 0; // after getting total length checking either arrays length is odd or
													// even

		// calculate total number of elements that need to be skipped
		int skipElements = totalArrayLength % 2 == 0 ? ((totalArrayLength / 2) - 1) : (totalArrayLength / 2);
		int i = 0, j = 0;
		while ((i < arr1.length && j < arr2.length) && (skipElements > 0)) {

			if (arr1[i] < arr2[j]) {
				i++;
			} else {
				j++;
			}
			skipElements--;
		}
		// if still need to skip elements
		if (skipElements > 0) {

			// skipping elements from arr1
			while (i < arr1.length && skipElements > 0) {
				i++;
				skipElements--;
			}
			// skipping elements from arr2
			while (j < arr2.length && skipElements > 0) {
				j++;
				skipElements--;
			}
		}

		// if total length of both array's is odd
		if (isOdd) {
			// if both array's have elements
			if (i < arr1.length && j < arr2.length) {
				if (arr1[i] < arr2[j]) {
					return (double) arr1[i];
				} else {
					return (double) arr2[j];
				}
			} else if (i < arr1.length) {
				// if arr1 have elements and arr2 is either null or empty
				return (double) arr1[i];
			} else {
				// if arr2 have elements and arr1 is either null or empty
				return (double) arr2[j];
			}
		}
		// if total length of both array's is even
		else {
			// if both array's have elements
			if (i < arr1.length && j < arr2.length) {
				// this condition use to check while calculating median
				// should need to take second element from arr1 or arr2
				if (arr2[j] < arr1[i]) {
					/**
					 * i = arr1={1,3,5,9,10,11} j = arr2={2,4,6,8,15,18}
					 */
					if (((j + 1) < arr2.length) && arr2[j + 1] < arr1[i]) {
						return ((double) arr2[j] + (double) arr2[j + 1]) / 2;
					} else {
						/**
						 * i = arr1={3,4,6,8,10,11} j = arr2={1,2,5,7}
						 */
						return ((double) arr1[i] + (double) arr2[j]) / 2;
					}
				} else {
					// reverse of above condition i.e ( arr2[j] < arr1[i] )
					if (((i + 1) < arr1.length) && arr1[i + 1] < arr2[j]) {
						return ((double) arr1[i] + (double) arr1[i + 1]) / 2;
					} else {
						return ((double) arr2[j] + (double) arr1[i]) / 2;
					}
				}
			} else if ((i + 1) < arr1.length && i < arr1.length) {

				// if arr1 have elements and arr2 is either null or empty
				return ((double) arr1[i] + (double) arr1[i + 1]) / 2;

			} else if ((j + 1) < arr2.length && j < arr2.length) {

				// if arr2 have elements and arr1 is either null or empty
				return ((double) arr2[j] + (double) arr2[j + 1]) / 2;
			}
		}
		return -1;
	}

	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

		if (nums1.length > nums2.length) {
			return (findMedianSortedArrays(nums2, nums1));
		}
		int n1 = nums1.length;
		int n2 = nums2.length;
		int lo = 0, hi = n1;
		while (lo <= hi) {
//       Initialize the cuts or partitions
			int cut1 = lo + (hi - lo) / 2;
//       Total required - already present
			int cut2 = ((n1 + n2) / 2) - cut1;

//       Initialize l1,l2,r1,r2
			int l1 = (cut1 == 0) ? Integer.MIN_VALUE : nums1[cut1 - 1];
			int l2 = (cut2 == 0) ? Integer.MIN_VALUE : nums2[cut2 - 1];
			int r1 = (cut1 == n1) ? Integer.MAX_VALUE : nums1[cut1];
			int r2 = (cut2 == n2) ? Integer.MAX_VALUE : nums2[cut2];

//       Shift element to the left
			if (l1 > r2)
				hi = cut1 - 1;
			else if (l2 > r1)
				lo = cut1 + 1;
			else {
//           Check for even length
				if ((n1 + n2) % 2 == 0)
					return (double) (Math.max(l1, l2) + Math.min(r1, r2)) / 2;
				else
					return (double) (Math.min(r1, r2));
			}
//       To avoid error  
		}
		return 0.0;
	}

	public static void main(String[] args) {

		int arrr1[] = { 1, 3 };
		int arrr2[] = {};

		System.out.println(find_Median_Into_Two_Sorted_Different_Size_Array(arrr1, arrr2));

		int arr1[] = { 1, 3, 5, 9, 10, 11, 16 };
		int arr2[] = { 2, 4, 6, 8, 15, 18 };
		System.out.println(find_Median_Into_Two_Sorted_Different_Size_Array(arr1, arr2)); // 8.0
		System.out.println(find_Median_Into_Two_Sorted_Different_Size_Array(arr2, arr1)); // 8.0

		int arr10[] = { 1, 3, 5, 9, 10, 11 };
		int arr20[] = { 2, 4, 6, 8, 15, 18 };
		System.out.println(find_Median_Into_Two_Sorted_Different_Size_Array(arr10, arr20)); // 7.0
		System.out.println(find_Median_Into_Two_Sorted_Different_Size_Array(arr20, arr10)); // 7.0

		int arr3[] = { 3, 4, 6, 8, 10, 11 };
		int arr4[] = { 1, 2, 5, 7, 15 };
		System.out.println(find_Median_Into_Two_Sorted_Different_Size_Array(arr3, arr4)); // 6.0
		System.out.println(find_Median_Into_Two_Sorted_Different_Size_Array(arr4, arr3)); // 6.0

		int arr31[] = { 3, 4, 6, 8, 10, 11 };
		int arr41[] = { 1, 2, 5, 7 };
		System.out.println(find_Median_Into_Two_Sorted_Different_Size_Array(arr31, arr41)); // 5.5
		System.out.println(find_Median_Into_Two_Sorted_Different_Size_Array(arr41, arr31)); // 5.5

		int arr141[] = { 1, 2, 5, 7 };
		int arr131[] = { 3 };
		System.out.println(find_Median_Into_Two_Sorted_Different_Size_Array(arr141, arr131)); // 3.0
		System.out.println(find_Median_Into_Two_Sorted_Different_Size_Array(arr131, arr141)); // 3.0

		int arr311[] = { 3 };
		int arr411[] = { 1 };
		System.out.println(find_Median_Into_Two_Sorted_Different_Size_Array(arr311, arr411)); // 3.0

		int arr3011[] = { 1, 3, 4, 5, 6, 7 };
		int arr4011[] = { 0, 2 };
		System.out.println(find_Median_Into_Two_Sorted_Different_Size_Array(arr3011, arr4011)); // 3.5
		System.out.println(find_Median_Into_Two_Sorted_Different_Size_Array(arr4011, arr3011)); // 3.5

		int arr14011[] = { 0, 2, 4 };
		int arr31011[] = { 1, 3, 5, 6, 7, 8 };
		System.out.println(find_Median_Into_Two_Sorted_Different_Size_Array(arr14011, arr31011)); // 4.0
		System.out.println(find_Median_Into_Two_Sorted_Different_Size_Array(arr31011, arr14011)); // 4.0

		int arr1011[] = { 0, 2, 4 };
		int arr1111[] = { 1, 3, 5, 6, 7, 8, 9, 10 };
		System.out.println(find_Median_Into_Two_Sorted_Different_Size_Array(arr1011, arr1111)); // 4.0
		System.out.println(find_Median_Into_Two_Sorted_Different_Size_Array(arr1111, arr1011)); // 4.0

		int arr011[] = { 0, 2, 4 };
		int arr111[] = { 1, 3, 5, 6, 7, 8, 9 };
		System.out.println(find_Median_Into_Two_Sorted_Different_Size_Array(arr011, arr111)); // 4.0
		System.out.println(find_Median_Into_Two_Sorted_Different_Size_Array(arr111, arr011)); // 4.0

		int arr11[] = { 0, 2, 4 };
		int arr211[] = { 1, 3, 5, 6, 7, 8, 9, 10, 11, 12, 13 };
		System.out.println(find_Median_Into_Two_Sorted_Different_Size_Array(arr11, arr211)); // 4.0
		System.out.println(find_Median_Into_Two_Sorted_Different_Size_Array(arr211, arr11)); // 4.0

		int arr110[] = { 1, 3 };
		int arr2110[] = { 2, 7 };
		System.out.println(find_Median_Into_Two_Sorted_Different_Size_Array(arr110, arr2110)); // 2.5
		System.out.println(find_Median_Into_Two_Sorted_Different_Size_Array(arr2110, arr110)); // 2.5

		int arr1100[] = { 3 };
		int arr21100[] = { -2, -1 };
		System.out.println(find_Median_Into_Two_Sorted_Different_Size_Array(arr1100, arr21100)); // -1.0
		System.out.println(find_Median_Into_Two_Sorted_Different_Size_Array(arr21100, arr1100)); // -1.0

		int arr100[] = {};
		int arr2100[] = { 1, 2, 3, 4 };
		System.out.println(find_Median_Into_Two_Sorted_Different_Size_Array(arr100, arr2100)); // 2.5
		System.out.println(find_Median_Into_Two_Sorted_Different_Size_Array(arr2100, arr100)); // 2.5
	}

}
