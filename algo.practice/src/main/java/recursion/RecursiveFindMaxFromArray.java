package recursion;

public class RecursiveFindMaxFromArray {

	static int max(int[] array,int index,int max) {
		if(index <= 0) {
			return max;
		}
		if(array[index-1] > max) {
			max = array[index-1];
		}
		index = index-1;
		int max1 = max(array,index,max);
		if(max < max1) {
			max = max1;
		}
		return max;
		
	}
	static int findMax(int array[], int start, int end){
		
		int mid = 0;
		int max =0;
		int min = 0;
		if(start > end){
			return -1;
		}
		if(start == end){
			return array[start];
		}
		else{
			mid = (start+end)/2;
			max = findMax(array,start,mid);
			min = findMax(array,mid+1,end);
			if(max > min){
				return max;
			}
		}
		return min;
	}
	
	public static void main(String[] args) {
		//int array[]={0,1,2,13,11,12,1,12,0,14,14,20,45,50,32,12,44,-1};
		int array[]= {3,2,0,8,4,6,1};
		System.out.println(findMax(array,0,array.length-1));
		System.out.println(max(array,array.length,array[0]));

	}

}
