package sliding.window;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author Tony.Stark
 * https://aaronice.gitbook.io/lintcode/hash-table/shortest-word-distance-ii
 * https://www.programcreek.com/2014/07/leetcode-shortest-word-distance-ii-java/
 */
public class shortest_word_distance_ii {

	
	public static int shortest_word_distance_ii(String[] words, String word1, String word2) {
		
		final Map<String,List<Integer>> map = new HashMap<>();
		
		for (int i = 0; i < words.length; i++) {
            if (!map.containsKey(words[i])) {
                map.put(words[i], new ArrayList<Integer>());
            }
            map.get(words[i]).add(i);
        }
		return shortest(map,word1,word2);
	}
	
	/**
	 * shortest() takes O(p + q) time
	 * by using two pointer approach , we convert this problem into merge two sorted list algo 
	 */
	 private static int shortest(Map<String,List<Integer>> map,String word1, String word2) {
	        List<Integer> p1 = map.get(word1);
	        List<Integer> p2 = map.get(word2);
	        if (p1 == null || p2 == null) {
	            return -1;
	        }
	        int shortest = Integer.MAX_VALUE;
	        int i1 = 0;
	        int i2 = 0;
	        while (i1 < p1.size() && i2 < p2.size()) {
	            shortest = Math.min(Math.abs(p1.get(i1) - p2.get(i2)), shortest);
	            if (p1.get(i1) < p2.get(i2)) {
	                i1++;
	            } else {
	                i2++;
	            }
	        }
	        return shortest;
	    }
	
	public static void main(String[] args) {
			
		String str[]= {"can","this","problem","this","be","solved","test","problem"};
		System.out.println(shortest_word_distance_ii(str,"problem","solved"));
		
		String str1[]= {"practice","makes","perfect","coding","","","makes"};
		System.out.println(shortest_word_distance_ii(str1,"makes","coding"));
		System.out.println(shortest_word_distance_ii(str1,"makes","coding"));
	}

}
