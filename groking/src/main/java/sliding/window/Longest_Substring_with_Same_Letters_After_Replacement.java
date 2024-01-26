package sliding.window;

import java.util.HashMap;
import java.util.Map;

public class Longest_Substring_with_Same_Letters_After_Replacement {
	
	/**
	 * Brute force approach
	 * TC O(N^2)
	 * SC O(1)
	 * stack space O(1)
	 * variable size window
	 */
	private static int longest_Substring_with_Same_Letters_After_ReplacementBruteForceApproach(String str,int k) {
		
		int  result = Integer.MIN_VALUE,maxChar=0;
		Map<Character,Integer> map;
		
		for (int i = 0; i < str.length(); i++) {
			
			map = new HashMap<Character, Integer>();
			
			for (int j = i; j < str.length(); j++) {
				map.put(str.charAt(j),map.getOrDefault(str.charAt(j),0)+1);
				maxChar = Math.max(maxChar, map.get(str.charAt(j)));
				if((((j-i)+1) - maxChar > k)) {
					break;
				}
				result = Math.max(result, (j-i)+1);
			}
			
		}
		return  result;
	}

	
	
	/**
	 * TC O(N)
	 * SC O(1)
	 * stack space O(1)
	 * variable size window
	 */
	private static int longest_Substring_with_Same_Letters_After_Replacement(String str,int k) {
		
		int j=0 , result = Integer.MIN_VALUE,maxChar=0;;
		int map[] = new int[26];
		
		for (int i = 0; i < str.length(); i++) {
			
			map[(str.charAt(i) - 97)]++;
			maxChar = Math.max(maxChar, map[(str.charAt(i) - 97)]);
			
			while(((i-j+1) - maxChar) > k) {
				map[(str.charAt(j) - 97)]--;
				j++;
				maxChar = Math.max(maxChar, map[(str.charAt(j) - 97)]);
			}
			// OR , while or if both are correct here!!
			/*if( ((i-j+1) - maxChar) > k) {
				map[(str.charAt(j) - 97)]--;
				j++;
			}*/
			result = Math.max(result, ((i-j)+1));
		}
		return  result;
	}
	
	public static void main(String[] args) {
		System.out.println(longest_Substring_with_Same_Letters_After_Replacement("aacccxb",2));
		System.out.println(longest_Substring_with_Same_Letters_After_Replacement("abbcb",1));
		System.out.println(longest_Substring_with_Same_Letters_After_Replacement("abccde",1));
		
		System.out.println("Brute-Force Approach "+longest_Substring_with_Same_Letters_After_ReplacementBruteForceApproach("aacccxb",2));
		System.out.println("Brute-Force Approach "+longest_Substring_with_Same_Letters_After_ReplacementBruteForceApproach("abbcb",1));
		System.out.println("Brute-Force Approach "+longest_Substring_with_Same_Letters_After_ReplacementBruteForceApproach("abccde",1));

	}
}
