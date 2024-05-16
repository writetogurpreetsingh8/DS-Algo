package algo.practice;

import java.util.ArrayList;
import java.util.List;

public class FindUnique {

	private static void uniqueValues(int input[]) {

		if (input == null || input.length == 0) {
			System.out.println("invalid input array.....");
		} else {
			int max = getMax(input);

			int temp[] = new int[max + 1];// [2,3,1,0,0]
			// [0, 0, 1, 1, 1, 2, 2, 3, 3, 4,255,255,1000,1010]
			List<Integer> list = new ArrayList<>();

			for (int i = 0; i < input.length; i++) {
				temp[input[i]]++;
			}

			for (int i = 0; i < input.length; i++) {
				temp[input[i]]++;
			}

			/*
			 * for(int i=0;i<temp.length;i++){
			 * 
			 * if(temp[i]>0){ list.add(i); // here we have uniqueValues }
			 * 
			 * }
			 */ // for sorted elements

			for (int i = 0; i < input.length; i++) {

				if (temp[input[i]] > 0) {
					temp[input[i]] = 0;
					list.add(input[i]);
				}

			} // with out sorted elements

			// display the values
			System.out.println("uniqueValues are " + list);

		}
	}

	private static int getMax(int input[]) {

		int max = Integer.MIN_VALUE;

		for (int i = 0; i < input.length; i++) {

			if (max < input[i]) {
				max = input[i];
			}
		}
		return max;
	}

	public static void main(String[] args) {
		int input[] = { 4, 0, 0, 9, 1, 1, 1, 2, 2, 3, 3, 4, 255, 255, 255, 255, 255, 255, 1000, 1010 };
		FindUnique.uniqueValues(input);

	}

}
