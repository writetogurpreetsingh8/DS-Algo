package sliding.window;

import java.util.ArrayList;
import java.util.List;

public class shortest_word_distance_iii {

	/**
	 * sliding window variable size
	 * TC O(N), SC O(1) , stack space O(1)
	 */
	public static int shortest_word_distance_iii(String[] arr, String word1, String word2) {
			
		if(arr == null || arr.length <=1 || (word1 == null || word1.trim().isEmpty())
				|| (word2 == null || word2.trim().isEmpty())) {
			return -1;
		}
		
		List<Integer> indexs = new ArrayList<Integer>(2);
		int min = ~(1<<31);
		for (int i = 0; i < arr.length; i++) {
			
			if(word1.equals(arr[i]) || word2.equals(arr[i])) {
				indexs.add(i); // TC O(1) // here we will never cross the size limit , so TC is always O(1)
			}
			if(indexs.size() == 2 ) {
				min = Math.min(min,Math.abs(indexs.get(0) - i));
				indexs.remove(0); // TC O(1) , to remove the data from list is O(1) and after that 
				//shifting of all the remaining elements would take O(N-1) shifting but
				// here we always have only 2 elements so there is only one shifting 
				// so overall TC always would be O(1) in all the cases
			}
		}
		return min;
	}
	
	public static void main(String[] args) {
		String str[]= {"can","this","problem","this","be","solved","test","problem"};
	    System.out.println(shortest_word_distance_iii(str,"problem","problem"));
		
		String str1[]= {"practice","makes","perfect","coding","","","makes"};
		System.out.println(shortest_word_distance_iii(str1,"makes","coding"));
		
		String str2[]= {"practice","makes","perfect","coding","","","makes","makes","makes"};
		System.out.println(shortest_word_distance_iii(str2,"makes","makes"));
		
		String str3[]= {"can","this","problem","this","be","solved","test","problem"};
	    System.out.println(shortest_word_distance_iii(str3,"this","this"));
	}

}
