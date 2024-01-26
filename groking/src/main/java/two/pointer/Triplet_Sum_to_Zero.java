package two.pointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

class Triplet_Sum_Pairs{

	int i;
	int j;
	int k;
	
	public Triplet_Sum_Pairs(int i, int j, int k) {
		super();
		this.i = i;
		this.j = j;
		this.k = k;
	}

	@Override
	public String toString() {
		return "Triplet_Sum_Pairs [i=" + i + ", j=" + j + ", k=" + k + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * ((result + Math.abs(i)) + (result + Math.abs(j)) + (result + Math.abs(k)));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Triplet_Sum_Pairs other = (Triplet_Sum_Pairs) obj;
		if(other.i == i || other.i == j || other.i == k) {
			if(other.j == i || other.j == j || other.j == k) {
				if(other.k == k || other.k == i || other.k == j) {
					return true;
				}
			}
		}
		return false;
	}
}

public class Triplet_Sum_to_Zero {

	/**
	 * @param arr
	 * @param sum
	 * @return
	 */
	public static List<List<Integer>> triplet_Sum_to_Zero(int arr[],int sum){
		
		List<List<Integer>> finalList;
		Set<Triplet_Sum_Pairs> tempSet = new HashSet<>();
		int firstDifference = 0;
		int secDifference=0;
		for (int i = 0; i < arr.length; i++) {
			//{-3,0,1,2,-1,1,-2};
			Set<Integer> set = new HashSet<Integer>();
			firstDifference = sum-arr[i];
			for(int j=i+1;j<arr.length;j++) {
				secDifference= firstDifference-arr[j];
				if(set.contains(secDifference)) {
					tempSet.add(new Triplet_Sum_Pairs(arr[i],arr[j],secDifference));
				}else {
					set.add(arr[j]);
				}
			}
		}
		
		finalList = tempSet.stream().map(k -> {
			List<Integer> list1 = new ArrayList<>();
			list1.add(k.i);
			list1.add(k.j);
			list1.add(k.k);
			return list1;
		}).collect(Collectors.toList());
		
		return finalList;
	}
	
	//	TC O(N^2) & Space complexity (1)
	public static List<List<Integer>> triplet_Sum_to_Zero_without_Set(int arr[],int sum) {
		
		Arrays.sort(arr);
		List<List<Integer>> finalList = new ArrayList<>();
		for (int i = 0; i < arr.length-2; i++) {
			
			if(i > 0 && arr[i] == arr[i-1]) {
				continue;
			}
			find3SumPaires(finalList,i+1,arr,sum-arr[i],sum);
		}
		return finalList;
	}
	
	private static void find3SumPaires(List<List<Integer>> finalList, int start, int[] arr, int target,int givenSum) {
		int right = arr.length-1;
		int sum = 0;
		while(start < right) {
			//{-3,0,1,2,-1,1,-2};
			sum = arr[start] + arr[right];
			if(target == sum) {
				finalList.add(Arrays.asList(arr[start],arr[right],(~(target)+1))); 
				// skipping duplicate values from starting of the array
				while(start < right && arr[start] == arr[start+1]) {
					start++;
				}
				// skipping duplicate values from ending of the array
				while(start < right && arr[right] == arr[right-1]) {
					right--;
				}
				start++;right--;
			}
			else if(target > sum) {
				start++;
			}else {
				right--;
			}
		}
	}

	
	public static void main(String[] args) {
		
		int arr2[]= {-4,-2,1,-5,-4,-4,4,-2,0,4,0,-2,3,1,-5,0};
		System.out.println(triplet_Sum_to_Zero_without_Set(arr2,0)); //[[1, 4, -5], [0, 4, -4], [1, 3, -4], [-2, 4, -2], [1, 1, -2], [0, 0, 0]]
		
		int arr21[]= {-4,-2,1,-5,-4,-4,4,-2,0,4,0,-2,3,1,-5,0};
		//System.out.println(triplet_Sum_to_Zero(arr21,0));
		
		int arr3[]= {-3,0,1,2,-1,1,-2};
		System.out.println(triplet_Sum_to_Zero_without_Set(arr3,0)); //[[1, 2, -3], [0, 2, -2], [1, 1, -2], [0, 1, -1]]
		
		int arr13[]= {-3,0,1,2,-1,1,-2};
		System.out.println(triplet_Sum_to_Zero(arr13,0));
		
		int arr113[]= {-5, 2, -1, -2, 3};
		System.out.println(triplet_Sum_to_Zero_without_Set(arr113,0));
		System.out.println(1+(-4));
	}

}
