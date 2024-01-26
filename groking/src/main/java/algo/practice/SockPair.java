package hacker.rank;

import java.util.HashSet;
import java.util.Set;

public class SockPair {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			int array[]={1,2,1,2,3,2,4};
			int pairs = 0;
			Set<Integer> set = new HashSet<>();
			for(int i=0; i<array.length; i++){
				if(!set.contains(array[i])){
					set.add(array[i]);
				}
				else{
					pairs++;
					set.remove(array[i]);
				}
			}
			System.out.println(pairs);
	}

}
