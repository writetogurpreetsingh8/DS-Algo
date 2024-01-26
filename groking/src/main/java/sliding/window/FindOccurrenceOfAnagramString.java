package sliding.window;

import java.util.HashMap;
import java.util.Map;

public class FindOccurrenceOfAnagramString {

	/**
	 * fixed size window
	 */
	private static int findOccurrenceOfAnagramString(String str,String pat) {
	
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		
		for(char c:pat.toCharArray()){
			Integer v = map.get(c);
			if(v == null) {
				map.put(c, 1);
			}else {
				map.put(c, ++v);
			}
			
		}
		
		int w = pat.length();
		int freq = 0,i=0,couter = map.size();
		for(int j=0; j<str.length();j++) {
			char c = str.charAt(j);
			Integer v = map.get(c);
			if(v != null) {
				
					map.put(c, --v);
				
				if(v == 0) {
					couter--;
				}
			}
			if( (j-i)+1 == w) { // 0 , 1 ,2 met true
				
				if(couter == 0) {
					freq++;
				}
				c = str.charAt(i);
				v = map.get(c);
				if(v!=null) {
					v = map.put(c, ++v);
					if(v == 0) {
						couter++;
					}
				}
				i++;
			}
		}
		return freq;
	}
	
	public static void main(String[] args) {
		System.out.println(FindOccurrenceOfAnagramString.findOccurrenceOfAnagramString("orfforofrhjgforklkrofuifforklofrrroofor", "for"));

	}

}
