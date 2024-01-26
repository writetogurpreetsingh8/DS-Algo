package sliding.window;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Word_Concatation {

	
	
	private static List<Integer> wordContation(String s,String[] wordArray){
		
		 Map<String,Integer> words = new HashMap<String,Integer>();
	        
	        for(String word:wordArray){
	            words.put(word,(words.getOrDefault(word,0)+1));
	        }
	        
	        int len = wordArray.length * wordArray[0].length();
	        int index=0;String str="";
	        Map<String,Integer> wordFrequency=null;
	        List<Integer> results = new ArrayList<Integer>();
	        int j;
	        for(int k=0;k<=s.length()-len;k++){
	            wordFrequency = new HashMap<String,Integer>();
	            
	            for(j=0;j<wordArray.length;j++){
	                
	                index = k+j*wordArray[0].length();
	                str = s.substring(index,index+wordArray[0].length());
	                
	                if(!words.containsKey(str)){
	                    break;
	                }
	                
	                wordFrequency.put(str,wordFrequency.getOrDefault(str,0)+1);
	                if(wordFrequency.get(str) > words.get(str)){
	                	break;
	                }
	            }
	            // when j == words.size() equal we found the exact match
	            if(j == words.size()){
	            	results.add(k);
	            	k+=wordArray[0].length()-1; // this condition is just to jump the characters that has been found
	            }
	            else if( j != words.size()) { // if word isn't matched then jump the indexed characters
	            	k+=index-1;
	            }
	        }
	        return results;
	}
	
	
	
	public static void main(String[] args) {
		String words[]= {"foo","the","bar"};
		System.out.println(wordContation("barfoofoobarthefoobarman",words));
		
		String words1[]= {"cat","fox"};
		System.out.println(wordContation("catfoxcat",words1));

	}

}
