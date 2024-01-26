package hacker.rank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ShortestSubstring {

	public static void main(String[] args) {
		
		String str = "aba";
		List<Character> list = new ArrayList<Character>();
		for(Character c :str.toCharArray()){
			if(!list.contains(Character.toLowerCase(c))){
				list.add(c);
			}
		}
		Collections.sort(list);
		String k = new String(list.toString().replaceAll("\\[", "").replaceAll("\\]", "").replaceAll(",", "").replaceAll(" ",""));
		String finalOutput = null;
		System.out.println(k);
		char[] temp = null;
		for(int i = 0; i < str.toCharArray().length; i++){
			finalOutput = str.substring(i, k.length()+i);
			temp = finalOutput.toCharArray();
			Arrays.sort(temp);
			if(new String(temp).equalsIgnoreCase(k)){
				break;
			}
		}
		System.out.println("final result is "+finalOutput);
	}

}
