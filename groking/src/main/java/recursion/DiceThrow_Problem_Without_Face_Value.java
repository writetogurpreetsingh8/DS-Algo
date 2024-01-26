package recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class DiceThrow_Problem_With_Face_Value{
	
	public static List<String> diceThrow_Problem_With_Face_Value(int target, int faceValue){
		if(target <= 0) {
			return Collections.emptyList();
		}
		String output = "";
		List<String> result = new ArrayList<>();
		diceThrow_Problem_With_Face_Value0(target,output,result,faceValue);
		return result;
	}

	private static void diceThrow_Problem_With_Face_Value0(int target, String output, List<String> result,
			int faceValue) {
		
		// if target is 0 added into list
			if(target == 0) {
				result.add(output);
				return;
			}
			
			// loop will execute will 4 && target would be greater than i 
			for (int i = 1; (i <=faceValue && i <= target); i++) {
				String output1 = output;
				output1+=i;
				diceThrow_Problem_With_Face_Value0(target-i,output1,result,faceValue);
			}
		
	}
}
public class DiceThrow_Problem_Without_Face_Value {

	public static List<String> diceThrow_Problem_Without_Face_Value(int target){
		
		if(target <= 0) {
			return Collections.emptyList();
		}
		String output = "";
		List<String> result = new ArrayList<>();
		diceThrow_Problem_Without_Face_Value0(target,output,result);
		return result;
	}
	
	private static void diceThrow_Problem_Without_Face_Value0(int target, String output, List<String> result) {
			
		// if target is 0 added into list
			if(target == 0) {
				result.add(output);
				return;
			}
			
			// loop will execute will 4 && target would be greater than i 
			for (int i = 1; (i <=4 && i <= target); i++) {
				String output1 = output;
				output1+=i;
				diceThrow_Problem_Without_Face_Value0(target-i,output1,result);
			}
	}
	public static void main(String[] args) {
		System.out.println(diceThrow_Problem_Without_Face_Value(6).size());
		System.out.println(diceThrow_Problem_Without_Face_Value(6));
		
		System.out.println(DiceThrow_Problem_With_Face_Value.diceThrow_Problem_With_Face_Value(6, 10).size());
		System.out.println(DiceThrow_Problem_With_Face_Value.diceThrow_Problem_With_Face_Value(6, 10));
	}

}
