package cyclic.sort;

public class Find_First_Missing_Number {

	private static int find_First_Missing_Number(int[] arr) {
		
		if(arr == null || arr.length <=1 ) {
			return 0;
		}
		
		int i=0,j=0;
		while(i<arr.length) {
			j=arr[i]-1;
			if(arr[i] > 0 && arr[i] < arr.length && arr[i] != arr[j]) {
					swap(arr,i,j);
			}else {
				i++;
			}
		}
		int k=0;
		for (; k < arr.length; k++) {
			if( (k+1) != arr[k]) {
				return (k+1);
			}
		}
		return (k+1);
	}
	
	private static void swap(int[] arr, int source, int target) {
		arr[source] = arr[source] ^ arr[target];
		arr[target] = arr[source] ^ arr[target];
		arr[source] = arr[source] ^ arr[target];
	}
	
	public static void main(String[] args) {
		int arr[]= {-3,1,5,4,2};
		System.out.println(find_First_Missing_Number(arr)); //3
		
		int arr1[]= {3,-2,0,1,2};
		System.out.println(find_First_Missing_Number(arr1)); //4
		
		int arr2[]= {3,2,4,4};
		System.out.println(find_First_Missing_Number(arr2)); //4
		
		int arr3[]= {4,3,2,1};
		System.out.println(find_First_Missing_Number(arr3)); //5
		
		int arr4[]= {1,2,0};
		System.out.println(find_First_Missing_Number(arr4)); //3
		
		int arr5[]= {3,4,-1,1};
		System.out.println(find_First_Missing_Number(arr5)); //2
		
		int arr6[]= {7,8,9,11,12};
		System.out.println(find_First_Missing_Number(arr6)); //2
	}

}
