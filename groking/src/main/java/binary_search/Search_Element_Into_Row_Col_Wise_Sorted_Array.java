package binary_search;

/**
 * 
 * @author Tony.Stark
 * Aux space O(1)
 * TC O(N) 
 * 2D Matrix not containing Strictly Sorted element otherwise we could have implement BS here to reduce the TC
 */
public class Search_Element_Into_Row_Col_Wise_Sorted_Array {

	public static boolean search_Element_Into_Row_Col_Wise_Sorted_Array(int[][] arr , int target) {
	
		if(arr == null) {
			return false;
		}
		
		int m = arr.length-1;
		int row = 0, col = arr[0].length-1; // getting column size
		
		while(row <= m && col >=0 ) {
			if(arr[row][col] == target) {
				return true;
			}
			else if(arr[row][col] > target) {
				col--;
			}
			else {
					row++;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		
		int arr[][]= {{10,20,30,40},{15,25,35,35},{27,29,37,48},{32,33,39,50}};
		//System.out.println(search_Element_Into_Row_Col_Wise_Sorted_Array(arr,23)); // false
		//System.out.println(search_Element_Into_Row_Col_Wise_Sorted_Array(arr,29)); // true
		//System.out.println(search_Element_Into_Row_Col_Wise_Sorted_Array(arr,27)); // true
		//System.out.println(search_Element_Into_Row_Col_Wise_Sorted_Array(arr,48)); // true
		//System.out.println(search_Element_Into_Row_Col_Wise_Sorted_Array(arr,37)); // true
		//System.out.println(search_Element_Into_Row_Col_Wise_Sorted_Array(arr,33)); // false
		
		int arr1[][]= {{32,33,39,50}};
		//System.out.println(search_Element_Into_Row_Col_Wise_Sorted_Array(arr1,213)); // false
		//System.out.println(search_Element_Into_Row_Col_Wise_Sorted_Array(arr1,33)); // true
		
		int arr2[][]= {{32},{33},{39},{50}};
		//System.out.println(search_Element_Into_Row_Col_Wise_Sorted_Array(arr2,213)); // false
		//System.out.println(search_Element_Into_Row_Col_Wise_Sorted_Array(arr2,33)); // true
		
		int arr3[][]= {{32}};
		System.out.println(search_Element_Into_Row_Col_Wise_Sorted_Array(arr3,213)); // false
		System.out.println(search_Element_Into_Row_Col_Wise_Sorted_Array(arr3,32)); // true
		
	}

}
