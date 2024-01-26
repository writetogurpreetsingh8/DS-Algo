package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.IntStream;

public class Sub_Set_Of_Array2 {

	

	public static List<List<Integer>> sub_Set_Of_Array(int arr[]) {

		if (arr == null || arr.length <= 1) {
			return null;
		}
		List<List<Integer>> result = new ArrayList<>();
		Arrays.sort(arr);
		createSubset(arr, new ArrayList<>(), result, -1);

		return result;
	}

	private static void createSubset(int[] input, List<Integer> output, List<List<Integer>> result,
			int index) {
		if (input.length == 0) {
				result.add(output);
			return;
		}
		List<Integer> output1 = new ArrayList<>(output);
		List<Integer> output2 = new ArrayList<>(output);
		
		if(index > 0  && input[index] == input[index-1]) {
			return;
		}
		Integer i = input[0];
		input = Arrays.copyOfRange(input, 1, input.length);
		output2.add(i);
		createSubset(input, output1, result, index+1);
		createSubset(input, output2, result, index+1);
	}

	public static void main(String[] args) {
		int arr[] = { 1, 2, 3 };
		int arr1[] = { 5, 5, 5, 5, 5 };
		int arr2[] = { 4,4,4,1,4 };
		int arr3[]= {2,1,2,1,3};
		List<List<Integer>> list = sub_Set_Of_Array(arr3);
		System.out.println(list.size());
		System.out.println(list);
		//[[],[1],[1,1],[1,1,2],[1,1,2,2],[1,1,2,2,3],[1,1,2,3],[1,1,3],[1,2],[1,2,2],[1,2,2,3],[1,2,3],[1,3],[2],[2,2],[2,2,3],[2,3],[3]]
	}

}
