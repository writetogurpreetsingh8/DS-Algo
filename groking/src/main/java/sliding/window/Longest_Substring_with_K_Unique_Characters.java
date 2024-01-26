package sliding.window;

import java.util.HashMap;
import java.util.Map;

public class Longest_Substring_with_K_Unique_Characters {
	
	/**
	 * TC O(N)
	 * SC O(1) 
	 */
	private static int longesSubstring(final String str, final int k) {
		
		if(str == null || str.isEmpty() || str.length() < k) {
			System.out.println("invalid string or k");
			return -1;
		}
		
		int i=0 , result = Integer.MIN_VALUE;
		Map<Character,Integer> map = new HashMap<>();
		char c; Integer ch;
		for (int j = 0; j < str.length(); j++) {
			c = str.charAt(j);
			ch = map.get(c);
			ch = ch != null ? ++ch : 1;
			map.put(c, ch);
			
				while(map.size() > k) {
					c = str.charAt(i);
					ch = map.get(c);
					if(ch != null && ch > 1) {
						map.put(c, --ch);
					}else if(ch != null) {
						map.remove(c);
					}
					i++;
				}
			
			if(map.size() == k) {
				result = Math.max(result, ((j-i)+1));
			}
		}
		return result;
	}
	
	/**
	 * TC O(N)
	 * SC O(1) 
	 */
	private static int longesSubstringWithOutMapWithArray(final String str, final int k) {
		
		if(str == null || str.isEmpty() || str.length() < k) {
			System.out.println("invalid string or k");
			return -1;
		}
		
		int size=0,ans = Integer.MIN_VALUE,charr,j=0;
		int map[] = new int[58];
		
		for (int i = 0; i < str.length(); i++) {
			
			charr = (str.charAt(i) - 65);
			if(map[charr] == 0) {
				size++;
			}
			map[charr]+=1;
			
			if(size == k) {
				ans = Math.max(ans, (i-j)+1);
			}
			while(size > k) {
				charr = (str.charAt(j) - 65);
				map[charr]-=1;
				if(map[charr] == 0) {
					size--;
				}
				j++;
			}
		}
		return ans;
	}

	/**
	 * TC O(L^2)
	 * SC O(L)
	 * stack space O(1)
	 * Here L means length of given String named abc
	 */
	public static int longesSubstringBruteForce(String abc,int k){
		
		Map<Character, Integer> map = null;

		int max = Integer.MIN_VALUE;
		for (int i = 0; i < abc.length(); i++) {
			map = new HashMap<Character, Integer>();
			for (int j = i; j < abc.length(); j++) {
		
				Integer v = map.get(abc.charAt(j));
				if(v == null) {
					map.put(abc.charAt(j), 1);
				}else {
					map.put(abc.charAt(j), ++v);
				}
				
				if(map.size() == k) {
					max = Math.max(max, (j-i)+1);
				}
				if(map.size() > k) {
					break;
				}
			}
		}
		return max;
	}
	
	public static void main(String[] args) {
		System.out.println(longesSubstring("aabacbebebe",3));
		System.out.println(longesSubstringWithOutMapWithArray("aabacbebebe",3));
		System.out.println(longesSubstring("AAbacbEbebE",3));
		System.out.println(longesSubstringWithOutMapWithArray("AAbacbEbebE",3));
		System.out.println("df" +longesSubstring("araaci",2));
		System.out.println(longesSubstringWithOutMapWithArray("araaci",2));
		System.out.println("test "+longesSubstring("arxaci",1));
		System.out.println(longesSubstringWithOutMapWithArray("araaci",1));
		System.out.println(longesSubstring("cbbebi",3));
		System.out.println(longesSubstringWithOutMapWithArray("cbbebi",3));
		
		
		System.out.println(longesSubstringBruteForce("AAbacbEbebE",3));

	}

}
