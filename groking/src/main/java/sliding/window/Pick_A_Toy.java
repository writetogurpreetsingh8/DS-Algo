package sliding.window;

import java.util.HashMap;
import java.util.Map;

public class Pick_A_Toy {

	private static int pickAToy(String toyRack) {
		
		if(toyRack == null || toyRack.isEmpty()) {
			System.out.println("invalid input toyRacking ");
			return -1;
		}
		
		int i=0 , result = (1<<31); // Integer.MIN_VALUE;
		Map<Character,Integer> map = new HashMap<>();
		Integer ch;
		for (int j = 0; j < toyRack.length(); j++) {
			ch = map.get(toyRack.charAt(j));
			ch = ch != null ? ++ch : 1;
			map.put(toyRack.charAt(j), ch);
			
			while(map.size() > 2) {
				ch = map.get(toyRack.charAt(i));
				if(ch != null && ch > 1) {
					map.put(toyRack.charAt(i), --ch);
				}else if(ch != null) {
					map.remove(toyRack.charAt(i));
				}
				i++;
			}
			if(map.size() == 2) {
				result = Math.max(result, ((j-i)+1));
			}
		}
		return result == (1<<31) ? toyRack.length() : result;
	}
	
	public static void main(String[] args) {
		System.out.println(pickAToy("aanacvvvvv")); // 4 a c c a
	}

}
