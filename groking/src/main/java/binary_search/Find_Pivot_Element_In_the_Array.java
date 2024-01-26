package binary_search;

public class Find_Pivot_Element_In_the_Array {

	//will not work for duplicates elements
	public static int find_Pivot_Element_In_the_Array(int[] arr) {
		
		// at least need two element into array while finding Pivot element
		if(arr == null || arr.length <=1 ) {
			return -1;
		}
		
		int start = 0,end=arr.length-1,mid=0;
		
		while(start < end) {
			mid = start+((end-start)>>1);
			if(arr[mid] < arr[end]) {
				end = mid;
			}else {
				start = mid + 1;
			}
		}
		System.out.println("arr[start] "+arr[start]);
		System.out.println("arr[end] "+arr[end]);
		return arr[start];
	}
	public static void main(String[] args) {
		int arr[]= {40,10,20,30};
		System.out.println(find_Pivot_Element_In_the_Array(arr));
		
		int arr1[]= {30,40,10,20};
		System.out.println(find_Pivot_Element_In_the_Array(arr1));
		
		int arr2[]= {30,40,50,10,20};
		System.out.println(find_Pivot_Element_In_the_Array(arr2));
		
		int arr3[]= {10,20,30,40,50};
		System.out.println(find_Pivot_Element_In_the_Array(arr3));
		
		int arr4[]= {30,20,10};
		System.out.println(find_Pivot_Element_In_the_Array(arr4));
	}

}
