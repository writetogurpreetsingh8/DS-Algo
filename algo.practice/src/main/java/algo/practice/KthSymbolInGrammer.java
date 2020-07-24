package algo.practice;

public class KthSymbolInGrammer {

	private static int kthSymbolInGrammer(int n,int k) {
		
		if( n == 1 && k == 1) {
			return 0;
		}
		
		int length = (int)Math.pow(2, n-1);
		int mid = length/2;
		
		if(k <= mid) {
			int i =  kthSymbolInGrammer(n-1,k);
			return i;
		}
		int j = kthSymbolInGrammer(n-1,k-mid);
		return 1^j;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(KthSymbolInGrammer.kthSymbolInGrammer(3, 4));
	}

}
