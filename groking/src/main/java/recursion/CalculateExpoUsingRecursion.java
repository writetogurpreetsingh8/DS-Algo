package recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


class TTest{
	String abc;
}
public class CalculateExpoUsingRecursion {

	private static int calculateExpoUsingRecursion(int base,int expo) {
		
		if(base <=1 || expo < 0) {
			System.out.println("invalid base or expo or both!!!!!1");
			return -1;
		}
		if(expo == 0) {
			return 1;
		}
		if(expo == 1) {
			return base;
		}
		
		return calculateExpoUsingRecursion0(base,expo);
		
	}
	
	/**
	 * TC is O(N),
	 * stack-space is O(N)
	 * aux-space is (1)
	 */
	private static int calculateExpoUsingRecursion0(int base,int expo) {
	
		if(expo == 1) {
			return base;
		}
		int ex = calculateExpoUsingRecursion0(base,expo-1);
		return ex*base;
	}
	
	public static void main(String[] args) {

		System.out.println(CalculateExpoUsingRecursion.calculateExpoUsingRecursion(5,2));
		StringBuilder sb = new StringBuilder("....");
		//sb.append(".").append(".").append(".").append(".");
		System.out.println(sb.toString());
		
		List<StringBuilder> list = new ArrayList<StringBuilder>();
		list.add(sb);
		System.out.println("list is "+list);
		sb.setCharAt(2, 'Q');
		System.out.println(sb.toString());
		System.out.println("list is "+list);
		
		TTest obj1 = new TTest();
		obj1.abc="1";
		
		TTest obj2 = new TTest();
		obj2.abc="2";
		
		List<TTest> l = new ArrayList<>();
		l.add(obj1);l.add(obj2);
		System.out.println("l is "+l);
		
		List<TTest> result = l.stream().map(o-> {
			TTest instance = new TTest();
			instance.abc = o.abc;
			return instance;
		}).collect(Collectors.toList());
		System.out.println("result is "+result);

		
	}

}
