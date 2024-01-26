package sliding.window;

import java.util.HashMap;
import java.util.Map;

public class Minimum_Substring_Window {

	/**
	 * variable size window 
	 */
	private static int minimumSubstringWindo(final String str,final String pat) {
	
		if( (str == null || pat == null ) || (str.isEmpty() || pat.isEmpty()) || (pat.length() > str.length())) {
			System.out.println("Invalid string or pattern!!");
			return -1;
		}
		
		final Map<Character,Integer> data = new HashMap<Character, Integer>();
		Integer v;
		for(char p:pat.toCharArray()) {
			v = data.get(p);
			v = v != null ? ++v : 1;
			data.put(p,v);
		}
		
		Character c;int counter = data.size(),i=0,start=0,end=0;
		int ans = Integer.MAX_VALUE;
		for(int j=0; j < str.length(); j++) {
			c = str.charAt(j);
			v = data.get(c);
			if(v != null) {
				data.put(c, --v);
				if(v == 0) {
					counter--;
				}
			}
			
				while(counter == 0) {
					if(ans > (j-i+1)) {
						ans = (j-i)+1;
						start = i;end=j;
					}
					c = str.charAt(i);
					v = data.get(c);
					if(v != null) {
						if(v == 0) {
							counter++;
						}
						data.put(c, ++v);
					}
					i++;
				}
			
		}
		System.out.println("range of minimum substrig window is "+str.substring(start,end+1));
		return ans;
	}
	public static void main(String[] args) {
		System.out.println(minimumSubstringWindo("TATTT","TTA"));
		System.out.println(minimumSubstringWindo("aa","a")); // a
		System.out.println(minimumSubstringWindo("ab","a")); //a
		System.out.println(minimumSubstringWindo("a","c"));
		System.out.println(minimumSubstringWindo("cabwefgewcwaefgcf","cae")); // cwae 9-12
		System.out.println(minimumSubstringWindo("aabdec","abc")); //abdec
		System.out.println(minimumSubstringWindo("abdabca","abc")); //abc
		System.out.println(minimumSubstringWindo("adcad","abc")); // ""

	}

}
