package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.IntStream;


public class Sub_Set_Of_Array {

	private static Comparator<List<Integer>> comfun = (list1, list2) -> {
		if (list1 == null || list2 == null || list1.size() != list2.size()) {
			return list2.size() - list1.size();
		}

		for (int i = 0; i < list2.size(); i++) {
			if (list2.get(i) != list1.get(i)) {
				return 1;
			}
		}
		return 0;
	};

	public static List<List<Integer>> sub_Set_Of_Array(int arr[]) {

		if (arr == null || arr.length <= 1) {
			return null;
		}
		List<List<Integer>> result = new ArrayList<>();
		// createSubset(arr,new ArrayList<>(),result, new TreeSet<>(comfun));
		Arrays.sort(arr);
		Set<List<Integer>> chk = new TreeSet<>((list1, list2) -> {
			int d = (list1 == null || list2 == null || list1.isEmpty() || list2.isEmpty()
					|| (list1.size() != list2.size())) ? (list1.size() - list2.size())
							
							: IntStream.range(0, list1.size()).filter(i -> list1.get(i) != list2.get(i)).map(k -> 1)
									.findFirst().orElse(0);
			System.out.println("d"+d);
			return d;
		});
		
		createSubset(arr, new ArrayList<>(), result, chk);

		return result;
	}

	private static void createSubset(int[] input, List<Integer> output, List<List<Integer>> result,
			Set<List<Integer>> chk) {
		if (input.length == 0) {
			if (!chk.contains(output)) {
				result.add(output);
				chk.add(output);
			}
			return;
		}
		List<Integer> output1 = new ArrayList<>(output);
		List<Integer> output2 = new ArrayList<>(output);
		Integer i = input[0];
		input = Arrays.copyOfRange(input, 1, input.length);

		output2.add(i);
		createSubset(input, output1, result, chk);
		createSubset(input, output2, result, chk);
	}

	public static void main(String[] args) {
		int arr[] = { 1, 2, 3,1 };
		int arr1[] = { 5, 5, 5, 5, 5 };
		int arr2[] = { 4,4,4,1,4 };
		int arr3[]= {1,1,3};
		List<List<Integer>> list = sub_Set_Of_Array(arr);
		System.out.println(list.size());
		System.out.println(list);
		//[[], [3], [1], [1, 3], [2], [2, 3], [2, 1], [2, 1, 3], [1], [1, 3], [1, 1], [1, 1, 3], [1, 2], [1, 2, 3], [1, 2, 1], [1, 2, 1, 3], [2, 3], [2, 1], [2, 2], [2, 2, 3], [2, 2, 1], [2, 2, 1, 3], [2, 1, 1], [2, 1, 1, 3], [2, 1, 2], [2, 1, 2, 3], [2, 1, 2, 1], [2, 1, 2, 1, 3]]

		//[[],[1],[1,1],[1,1,2],[1,1,2,2],[1,1,2,2,3],[1,1,2,3],[1,1,3],[1,2],[1,2,2],[1,2,2,3],[1,2,3],[1,3],[2],[2,2],[2,2,3],[2,3],[3]]
	}

}
