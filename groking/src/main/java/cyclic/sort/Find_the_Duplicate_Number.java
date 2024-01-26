package cyclic.sort;

public class Find_the_Duplicate_Number {

	private static int find_the_Duplicate_Number(int[] arr) {
		
		if(arr == null || arr.length <=1 ) {
			return -1;
		}
		
		int i=0;
		int k=0;
		while(i<arr.length) {
			k = arr[i]-1;
				if(arr[i] != arr[k]) {
					swap(arr,i,k);
				}else {
					if(arr[i] == arr[k] && (i!=k)) {
						return arr[i];
					}
					i++;
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
			
		int arr[]= {1,4,4,3,2};
		System.out.println(find_the_Duplicate_Number(arr)); //4
		
		int arr1[]= {2,1,3,3,5,4};
		System.out.println(find_the_Duplicate_Number(arr1)); //3
		
		int arr2[]= {2,4,1,4,4};
		System.out.println(find_the_Duplicate_Number(arr2)); //4

	}

}
