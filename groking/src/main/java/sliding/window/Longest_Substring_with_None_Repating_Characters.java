package sliding.window;

import java.util.HashMap;
import java.util.Map;

public class Longest_Substring_with_None_Repating_Characters {
	
	/**
	 * TC O(N)
	 * SC O(1) 
	 */
	private static int longesSubstring(final String str) {
		
		if(str == null || str.isEmpty()) {
			System.out.println("invalid string");
			return -1;
		}
		
		int i=0 , result = Integer.MIN_VALUE;
		Map<Character,Integer> map = new HashMap<>();
		Integer ch;
		for (int j = 0; j < str.length(); j++) {
			ch = map.get(str.charAt(j));
			ch = ch != null ? ++ch : 1;
			map.put(str.charAt(j), ch);
			
				while(map.size() < (j-i+1)) {
					ch = map.get(str.charAt(i));
					if(ch != null && ch > 1) {
						map.put(str.charAt(i), --ch);
					}else if(ch != null) {
						map.remove(str.charAt(i));
					}
					i++;
				}
			
			if(map.size() == (j-i+1)) {
				result = Math.max(result, ((j-i)+1));
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		System.out.println(longesSubstring("rpwwkewr"));

	}

}
