package recursion;

import java.util.ArrayList;
import java.util.List;

public class PascalTrigleI {

	private static void generatePascalTrigal(List<List<Integer>> row, int index, int size) {

		if (row.get(index - 1).size() == size) {
			List<Integer> col = new ArrayList<Integer>();
			col.add(1);
			row.add(col);
			return;
		}
		generatePascalTrigal(row, index, size + 1);
		int value1 = row.get(index - 1).get(size);
		int value2 = row.get(index - 1).get(size - 1);
		row.get(index).add((value1 + value2));
	}

	private static List<List<Integer>> pascalTrigle10(int k, List<List<Integer>> row) {

		if (k == 0) {
			List<Integer> col = new ArrayList<Integer>();
			col.add(1);
			row.add(col);
			return row;
		}

		pascalTrigle10(k - 1, row);
		generatePascalTrigal(row, k, 1);
		row.get(k).add(1);
		return row;
	}

	static List<List<Integer>> pascalTrigle1(int k) {

		List<List<Integer>> list = new ArrayList<List<Integer>>();

		if (k == 0) {
			List<Integer> col = new ArrayList<Integer>();
			col.add(1);
			List<List<Integer>> row = new ArrayList<List<Integer>>();
			row.add(col);
			return row;
		}

		return pascalTrigle10(k, list);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<List<Integer>> list = pascalTrigle1(0);
		System.out.println("pascal - tringle for 0 " + list);

		
		  list = pascalTrigle1(1); System.out.println("pascal - tringle for 1 "+list);
		  
		  list = pascalTrigle1(2); System.out.println("pascal - tringle for 2 "+list);
		  
		  list = pascalTrigle1(3); System.out.println("pascal - tringle for 3 "+list);
		  
		  list = pascalTrigle1(4); System.out.println("pascal - tringle for 4 "+list);
		  
		  list = pascalTrigle1(5); System.out.println("pascal - tringle for 5 "+list);
		  
		  list = pascalTrigle1(6); System.out.println("pascal - tringle for 6 "+list);
		  
		  list = pascalTrigle1(7); System.out.println("pascal - tringle for 7 "+list);
		  
		  list = pascalTrigle1(8); System.out.println("pascal - tringle for 8 "+list);
		  
		  list = pascalTrigle1(9); System.out.println("pascal - tringle for 9 "+list);
		  
		  list = pascalTrigle1(10);
		  System.out.println("pascal - tringle for 10 "+list);
		  
		  list = pascalTrigle1(11);
		  System.out.println("pascal - tringle for 11 "+list);
		  
		  list = pascalTrigle1(12);
		  System.out.println("pascal - tringle for 12 "+list);
		  
		  list = pascalTrigle1(13);
		  System.out.println("pascal - tringle for 13 "+list);
		  
		  list = pascalTrigle1(14);
		  System.out.println("pascal - tringle for 14 "+list);
		  
		  list = pascalTrigle1(15);
		  System.out.println("pascal - tringle for 15 "+list);
		  
		  list = pascalTrigle1(16);
		  System.out.println("pascal - tringle for 16 "+list);
		  
		  list = pascalTrigle1(17);
		  System.out.println("pascal - tringle for 17 "+list);
		  
		  list = pascalTrigle1(18);
		  System.out.println("pascal - tringle for 18 "+list);
		  
		  list = pascalTrigle1(19);
		  System.out.println("pascal - tringle for 19 "+list);
		  
		  list = pascalTrigle1(20);
		  System.out.println("pascal - tringle for 20 "+list);
		  
		  list = pascalTrigle1(21);
		  System.out.println("pascal - tringle for 21 "+list);
		  
		  list = pascalTrigle1(22);
		  System.out.println("pascal - tringle for 22 "+list);
		  
		  list = pascalTrigle1(23);
		  System.out.println("pascal - tringle for 23 "+list);
		  
		  list = pascalTrigle1(24);
		  System.out.println("pascal - tringle for 24 "+list);
		  
		  list = pascalTrigle1(25);
		  System.out.println("pascal - tringle for 25 "+list);
		  
		  list = pascalTrigle1(26);
		  System.out.println("pascal - tringle for 26 "+list);
		  
		  list = pascalTrigle1(27);
		  System.out.println("pascal - tringle for 27 "+list);
		  
		  list = pascalTrigle1(28);
		  System.out.println("pascal - tringle for 28 "+list);
		  
		  list = pascalTrigle1(29);
		  System.out.println("pascal - tringle for 29 "+list);
		  
		  list = pascalTrigle1(30);
		  System.out.println("pascal - tringle for 30 "+list);
		  
		  list = pascalTrigle1(31);
		  System.out.println("pascal - tringle for 31 "+list);
		  
		  list = pascalTrigle1(32);
		  System.out.println("pascal - tringle for 32 "+list);
		  
		  list = pascalTrigle1(33);
		  System.out.println("pascal - tringle for 33 "+list);
		 
	}

}
