package recursion;

import java.util.ArrayList;
import java.util.List;

public class PhoneKeyPadProblem {

	/**
	 * Time Complexity : O(3^N × 4^M) where N is the number of digits which have 3 letters( ex: 2,3,4) assigned to it 
	 * and M is the number of digits which has 4 letters(ex: 7,9) assigned to it.

	 * Space Complexity : O(3^N × 4^M) where N is the number of digits which have 3 letters( ex: 2,3,4) assigned to it 
	 * and M is the number of digits which has 4 letters(ex: 7,9) assigned to it.
	 * 
	 * System stack O(N) since as per given size/length of digits the depth of tree grows.
	 */
	public static List<String> phoneKeyPadProblem(String keys) {
		
		List<String> result = new ArrayList<String>();
		if(keys == null || keys.trim().isEmpty()) {
			return result;
		}
		
		String output=""; int index=0;
		String mapping[]= {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
		solve(output,mapping,index,keys,result);
		return result;
	}
	
	private static void solve(String output, String[] mapping, int index, String keys, List<String> result) {
			if(index == keys.length()) {
				result.add(output);
				return;
			}
			int number = keys.charAt(index)-48;
			String value = mapping[number];
			for (int i = 0; i < value.length(); i++) {
				String output1 = output;
				output1+=value.charAt(i);
				solve(output1,mapping,index+1,keys,result);
			}
	}
	
	public static void main(String[] args) {
		//abc def ghi
		System.out.println(phoneKeyPadProblem("234"));
	}

}
