package recursion;

/**
 * Leet-code 69
 * @author Tony.Stark
 *
 */
public class FindSquareRoot {

	/**
	 * 
	 * @param n
	 * @return
	 * find FindSquareRoot of given number with brute-force approach
	 * TC is O(FindSquareRoot N) aux space and stack space O(1)
	 */
	
	public static int findSqrRoot(int n) {
		
		if(n<=1) {
			return n;
		}
		
		int value =0;
		int result = 0;
		
		while(result<=n) {
			value = value + 1;
			result = value * value;
		}
		return value-1;
	}
	
	static int oldValue=0;
	
	/**
	 * FindSquareRoot
	 * @param n
	 * @return
	 * divide and conquer approach... 
	 * TC O(LOGN) aux sapce O(1) and stack space O(LOGN)
	 */
	public static int findSquareRoot(int n) {
		
		FindSquareRoot.oldValue = n;
		
		if(n<=1) {
			return n;
		}
		
		return findSquareRoot0(1,n,0);
		
	}

	/**
	 * 
	 * @param n
	 * @return
	 * divide and conquer approach... Binaray search approach
	 * TC O(LOGN) aux sapce O(1) and stack space O(LOGN)
	 */
	private static int findSquareRoot0(int l,int h,int value) {
		
		if(l>=h) {
			return value;
		}
		int mid = (l+h)/2;
		
		if((mid * mid) == FindSquareRoot.oldValue) {
			return mid;
		}
		
		if((mid * mid) > FindSquareRoot.oldValue) {
			h = mid-1;
			return findSquareRoot0(l,h,value);
		}
		else {
			l = mid+1;
			value = mid;
			return findSquareRoot0(l,h,value);
		}
	}
	
	public static void main(String[] args) {
		//System.out.println(FindSquareRoot.findSqrRoot(50));
		System.out.println(FindSquareRoot.findSqrRoot(16));

	}

}
