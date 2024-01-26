package sliding.window;

import java.util.ArrayList;
import java.util.List;

public class FindOccurrenceOfAnagramString2 {

	/**
	 * fixed size window
	 */
	private static List<Integer> findIndexsOfAnagramString(String str,String pat) {
	
		Integer array[] = new Integer[26];
		int counter = 0;
		for(int i=0;i<pat.length();i++){
			int cha = pat.charAt(i);
			if( array[cha-97] == null) {
				counter++;
				array[cha-97] = 1;
			}
			else {
				array[cha-97]++;
			}
		}
		
		int w = pat.length();
		int i=0; List<Integer> list = new ArrayList<Integer>();
		
		for(int j=0; j<str.length();j++) {
			
			Integer v = array[((int)str.charAt(j)) - 97];
			if(v != null) {
				array[((int)str.charAt(j)) - 97]--;				
				if(v == 1) {
					counter--;
				}
			}
			if( (j-i)+1 == w) { 
				
				if(counter == 0) {
					list.add(i);
				}
				v = array[((int)str.charAt(i)) - 97];
				if(v!=null) {
					array[((int)str.charAt(i)) - 97]++;
					if(v == 0) {
						counter++;
					}
				}
				i++;
			}
		}
		return list;
	}
	
	/**
	 * fixed size window
	 */
	private static int findOccurrenceOfAnagramString(String str,String pat) {
	
		Integer array[] = new Integer[26];
		int counter = 0;
		for(int i=0;i<pat.length();i++){
			int cha = pat.charAt(i);
			if( array[cha-97] == null) {
				counter++;
				array[cha-97] = 1;
			}
			else {
				array[cha-97]++;
			}
		}
		
		int w = pat.length();
		int freq = 0,i=0;
		for(int j=0; j<str.length();j++) {
			
			Integer v = array[((int)str.charAt(j)) - 97];
			if(v != null) {
				array[((int)str.charAt(j)) - 97]--;				
				if(v == 1) {
					counter--;
				}
			}
			if( (j-i)+1 == w) { 
				
				if(counter == 0) {
					freq++;
				}
				v = array[((int)str.charAt(i)) - 97];
				if(v!=null) {
					array[((int)str.charAt(i)) - 97]++;
					if(v == 0) {
						counter++;
					}
				}
				i++;
			}
		}
		return freq;
	}
	
	public static void main(String[] args) {
		System.out.println("count "+FindOccurrenceOfAnagramString2.findOccurrenceOfAnagramString("orfforofrhjgforklkrofuifforklofrrroofor", "for"));
		System.out.println(FindOccurrenceOfAnagramString2.findIndexsOfAnagramString("orfforofrhjgforklkrofuifforklofrrroofor", "for"));
		
		System.out.println("count "+FindOccurrenceOfAnagramString2.findOccurrenceOfAnagramString("cbaebabacd", "abc"));
		System.out.println(FindOccurrenceOfAnagramString2.findIndexsOfAnagramString("cbaebabacd", "abc"));
		
		System.out.println("count "+FindOccurrenceOfAnagramString2.findOccurrenceOfAnagramString("abab", "ab"));
		System.out.println(FindOccurrenceOfAnagramString2.findIndexsOfAnagramString("abab", "ab"));
		System.out.println("abck".substring(2));
		System.out.println("abckthyjil".substring(2,5));
	}

}
