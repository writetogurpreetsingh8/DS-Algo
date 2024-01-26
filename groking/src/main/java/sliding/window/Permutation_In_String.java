package sliding.window;

import java.util.HashMap;
import java.util.Map;

public class Permutation_In_String {
	
	/**
	 * TC O(N)
	 * SC O(1)
	 * stack space O(1)
	 * fixed size window
	 */
	private static boolean permutationInString(String str,String pat) {
	
		if( (str == null || pat == null ) || (str.length() == 0 || pat.length() == 0)) {
			return false;
		}
		if(pat.length() > str.length()) {
			return false;
		}
		Map<Character,Integer> map = new HashMap<Character, Integer>();
		
		for(char c:pat.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0)+1);
		}
		
		int j=0,length = pat.length();
		char charr=0;
		for (int i = 0; i < str.length(); i++) {
			charr = str.charAt(i);
			if(map.containsKey(charr)) {
				if(map.get(charr) > 0)
					length--;
				map.put(charr, map.get(charr) - 1);
			}
			if(length == 0) {
				break;
			}
			if(i >= pat.length()-1) {
				charr = str.charAt(j);
				if(map.containsKey(charr)) {
					if(map.get(charr) >= 0)
					length++;
					map.put(charr, map.get(charr) + 1);
				}
				j++;
			}
		}
		return length == 0 ? true : false;
	}
	
	public static void main(String[] args) {
			
		System.out.println(permutationInString("ofghxoof","fox")); // false
		System.out.println(permutationInString("ofghxof","fox")); //true
		  System.out.println(permutationInString("oidbcaf","dc")); //false
		  System.out.println(permutationInString("oidbcaf","abc")); // true
		  System.out.println(permutationInString("bcdxabcdy","bcdyabcdx")); //true
		  System.out.println(permutationInString("aaacb","abac")); // true
		  System.out.println(permutationInString(
		  "orfforofrhjgforklkrofuifforklofrrroofor","for")); // true
		  System.out.println(permutationInString("for", 
		  "orfforofrhjgforklkrofuifforklofrrroofor")); //false
		  System.out.println(permutationInString("dcda","adc")); // true
		  System.out.println(permutationInString("ooolleoooleh","hello")); // false
		 		System.out.println(permutationInString("abcdeabcdx","abcdxabcde")); // true
		 		System.out.println(permutationInString("abbcabc","abc")); // true
	}

}
