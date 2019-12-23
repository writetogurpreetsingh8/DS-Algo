package hacker.rank;

public class RecursiveFindMaxFromArray {

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
		int array[]={0,1,2,13,11,12,1,12};
		System.out.println(findMax(array,0,array.length-1));

	}

}
