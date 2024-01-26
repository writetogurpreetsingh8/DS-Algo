package recursion;

public class KthSymbolInGrammer {

	private static int kthSymbolInGrammer(int n,int k) {
		
		if( n == 1 && k == 1) {
			return 0;
		}
		
		int length = (int)Math.pow(2, n-1);
		int mid = length/2;
		
		if(k <= mid) {
			return kthSymbolInGrammer(n-1,k);
		}
		return 1 ^ kthSymbolInGrammer(n-1,k-mid); // this is equal to !kthSymbolInGrammer(n-1,k-mid)
	}
	
	public static void main(String[] args) {
		System.out.println(KthSymbolInGrammer.kthSymbolInGrammer(3, 4));
	}

}
