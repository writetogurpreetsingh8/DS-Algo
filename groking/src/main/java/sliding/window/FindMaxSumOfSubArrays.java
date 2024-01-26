package sliding.window;

public class FindMaxSumOfSubArrays {

	
	private static int findMaxSumOfSubArrays(int[] array,int windowSize) {
		
		if(array == null || array.length < windowSize || windowSize <=0 ) {
			System.out.println("invalid array or windowSize");
			return -1;
		}
		int s = 0,sum=0,result = Integer.MIN_VALUE;
		int startIndex = s,endIndex = 0;
		for (int e = 0; e < array.length; e++) {
			
			sum+=array[e];
			if( (e-s)+1 == windowSize) {
				if(result < sum) {
					result = sum;
					endIndex = e;
					startIndex = s;
				}
				sum-=array[s];
				s++;
			}
		}
		System.out.println("start range = "+startIndex +" end range = "+endIndex);
		return result;
	}
	
	
	public static void main(String[] args) {
		int array[]= {1,2,0,3,4,7,8};
		System.out.println(findMaxSumOfSubArrays(array,3));
	}

}
