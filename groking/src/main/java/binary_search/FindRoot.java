package binary_search;

/**
 * Leet-code 69
 * 
 * @author Tony.Stark
 *
 */
public class FindRoot {

	/**
	 * 
	 * @param n
	 * @return find under-root/root of given number with brute-force approach TC is
	 *         O(sq-root N) aux space and stack space O(1)
	 */

	public static int findSqrRoot(int n) {

		if (n <= 1) {
			return n;
		}

		int value = 0;
		int result = 0;

		while (result <= n) {
			value = value + 1;
			result = value * value;
		}
		return value - 1;
	}

	static int oldValue = 0;

	/**
	 * find under-root/root
	 * @param n
	 * @return divide and conquer approach... TC O(LOGN) aux sapce O(1) and stack
	 *         space O(LOGN)
	 */
	public static int findSquareRoot(int n) {

		FindRoot.oldValue = n;

		if (n <= 1) {
			return n;
		}

		return findSquareRoot0(0, n, 0);

	}

	/**
	 * find under-root/root
	 * @param n
	 * @return divide and conquer approach... Binaray search approach TC O(LOGN) aux
	 *         sapce O(1) and stack space O(LOGN)
	 */
	private static int findSquareRoot0(int l, int h, int value) {

		if (l > h) {
			return value;
		}
		long mid = l + ((h - l) >> 1);

		if ((mid * mid) == FindRoot.oldValue) {
			return (int) mid;
		}

		if ((mid * mid) > FindRoot.oldValue) {
			h = (int) mid - 1;
			return findSquareRoot0(l, h, value);
		} else {
			l = (int) mid + 1;
			value = (int) mid;
			return findSquareRoot0(l, h, value);
		}
	}

	public static void main(String[] args) {
		// System.out.println(FindRoot.findSqrRoot(50));
		System.out.println(Integer.MAX_VALUE);
		//System.out.println(FindRoot.findSqrRoot(Integer.MAX_VALUE));
		System.out.println(FindRoot.findSquareRoot(Integer.MAX_VALUE));
		System.out.println(FindRoot.findSquareRoot(30));
		System.out.println(FindRoot.findSquareRoot(0));
		 System.out.println(FindRoot.findSquareRoot(1));
		System.out.println(FindRoot.findSquareRoot(3));

	}
}
