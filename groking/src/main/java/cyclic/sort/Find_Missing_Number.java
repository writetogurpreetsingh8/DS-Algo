package cyclic.sort;

public class Find_Missing_Number {

	private static int find_Missing_Number(int[] arr) {
		if(arr == null || arr.length <=1 ) {
			return -1;
		}
		
		int i=0;
		while(i<arr.length) {
				if(arr[i] < arr.length && arr[i] != i) {
					swap(arr,i,arr[i]);
				}else {
					i++;
				}
		}
		for (int j = 0; j < arr.length; j++) {
			if(j != arr[j]) {
				return  j;
			}
		}
		return -1;
	}
	
	private static void swap(int[] arr, int source, int target) {
		arr[source] = arr[source] ^ arr[target];
		arr[target] = arr[source] ^ arr[target];
		arr[source] = arr[source] ^ arr[target];
	}
	
	public static void main(String[] args) {
			int arr[]= {4,0,1,3};
			System.out.println(find_Missing_Number(arr));
			
			int arr1[]= {8,3,5,2,4,6,0,1};
			System.out.println(find_Missing_Number(arr1));
	}

}
