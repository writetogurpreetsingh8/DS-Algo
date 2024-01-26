package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;


/**
 * TC is O(L!) , aux space is O(L * L!) & system stack O(L). L is the length of given
 * string
 */
class Creating_Anagram_String_with_Array {

	public static List<List<Integer>> creating_Anagram_String_with_Array(int input[]) {
		if (input == null || input.length == 0) {
			return Collections.emptyList();
		}
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		findAnagramOfGivenArrayElements(result, new ArrayList<Integer>(), input);
		return result;
	}

	private static void findAnagramOfGivenArrayElements(List<List<Integer>> result, List<Integer> output, int[] input) {
		if (input.length == 0) {
			result.add(output);
			return;
		}

		for (int i = 0; i < input.length; i++) {
			List<Integer> output1 = new ArrayList<>(output);
			output1.add(input[i]);
			int left[] = Arrays.copyOfRange(input, 0, i);
			int right[] = Arrays.copyOfRange(input, (i + 1), input.length);
			int newArray[] = IntStream.concat(Arrays.stream(left), Arrays.stream(right)).toArray();
			findAnagramOfGivenArrayElements(result, output1, newArray);
		}
	}
}


class Returning_Total_Number_Of_String_Anagram{
	
	public static int returning_Total_Number_Of_String_Anagram(String input,String output,int sum) {
		
		if(input.length() == 0 ) {
			sum+=1;
			return sum;
		}
		for (int i = 0; i < input.length(); i++) {
			String output1 = output;
			output1+=input.charAt(i);
			String leftStr = input.substring(0,i);
			String rightStr = input.substring(i+1);
			sum = returning_Total_Number_Of_String_Anagram(leftStr+rightStr,output1,sum);
		}
		return sum;
	}
}

/**
 * TC is O(L!)
 * aux space is also same
 * L is the length of given string
 *
 */
public class Creating_Anagram_String {

	private static Set<String> l = new HashSet<>();
	
	
	static void createAnagram(String input,String output) {
		
		if(input.length() == 0 ) {
			l.add(output);
			return;
		}
		for (int i = 0; i < input.length(); i++) {
			String output1 = output;
			output1+=input.charAt(i);
			String leftStr = input.substring(0,i);
			String rightStr = input.substring(i+1);
			createAnagram(leftStr+rightStr,output1);
		}
	}
	
	public static void main(String[] args) {
		String input = new String("abc");
		createAnagram(input, "");
		int input1[] = { 1, 2, 3 };
		System.out.println(Creating_Anagram_String_with_Array.creating_Anagram_String_with_Array(input1));
		System.out.println(l);
		
		System.out.println(Returning_Total_Number_Of_String_Anagram.returning_Total_Number_Of_String_Anagram(input, "", 0));
	}

}
