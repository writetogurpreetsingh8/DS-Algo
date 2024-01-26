package binary_search;

public class Koko_Eating_Banans {
	
	/**
	 * Brute force approach
	 * TC O(M*N) 
	 */
	 public static int minEatingSpeedBruteForce(int[] piles, int h) {
	        int max = 0;
	        for(int i=0;i<piles.length;i++){
	            max = Math.max(max,piles[i]);
	        }

	        int sum=0,ans = ~(1<<31),k=1;

	        for(int i=1;i<=max;i++){
	        	sum = 0;
	            for(int j=0;j<piles.length;j++){
	            	
	            	sum+= piles[j]/k;
	            	if(piles[j]%k !=0) {
	            		sum++;
	            	}
	                if(sum > h){
	                    break;
	                }
	            }
	            if(sum <=h ){
	                ans = Math.min(ans,k);
	            }
	            k++;
	        }
	        return ans;
	    }
	 
	 /**
	  * TC O(LogM*N) 
	  */
	 public static int minEatingSpeedBinarySearchApproach(int[] piles, int h) {
		 
		 int max = 0;
		 for(int i=0;i<piles.length;i++){
            max = Math.max(max,piles[i]);
         }
		 
		 int start=1,end=max,mid=0,ans=0;
		 while(start<=end) {
			 mid = start+((end-start)/2);
			 if(isSpeedGood(piles,mid,h)) {
				 ans = mid;
				 end = mid-1;
			 }
			 else {
				 start = mid + 1;
			 }
		 }
		 return ans;
	 }
	 
	
	private static boolean isSpeedGood(int[] piles, int mid, int h) {
		int totalBanans=0;
		for (int i = 0; i < piles.length; i++) {
			totalBanans+=piles[i]/mid;
			if(piles[i]%mid !=0 ) {
				totalBanans++;
			}
			if(totalBanans > h){
                return false;
            }
		}
		return true;
	}

	public static void main(String[] args) {
		int arr[] = {3,6,7,11};
		int arr1[] = {30,11,23,4,20};
		//System.out.println(minEatingSpeedBruteForce(arr,8));
		System.out.println(minEatingSpeedBinarySearchApproach(arr,8));
		System.out.println(minEatingSpeedBinarySearchApproach(arr1,6));
	}

}
