package merge.intervals;

import java.util.ArrayList;
import java.util.List;

public class interval_intersactions {

	private static int[][] intervalIntersactions(int l1[][], int l2[][]){
		
		List<int[]> result = new ArrayList<int[]>();
		if(l1 == null || l2 == null || l1.length == 0 || l2.length == 0) {
			return result.toArray(new int[0][0]);
		}
		
		int i=0,j=0;int a=0,b=0;
		while(i < l1.length && j < l2.length) {
			
			if( (l1[i][0]<=l2[j][1] && l2[j][1] <= l1[i][1] ) 
					|| (l2[j][0] <= l1[i][1] && l1[i][1] <= l2[j][1])) {
				a = Math.max(l1[i][0], l2[j][0]);
				b = Math.min(l1[i][1], l2[j][1]);
				result.add(new int[]{a,b});
			}			
			if(l1[i][1] == l2[j][1]) {
				i++;j++;
			}
			else if(l1[i][1] < l2[j][1]) {
					i++;
			}else {
				j++;
			}
		}
		return result.toArray(new int[result.size()][]);
	}
	public static void main(String[] args) {
		int l1[][] = { { 0,2 }, {  5,10 }, { 13, 23 }, { 24, 25 }};
		int l2[][] = {  {  1,5 }, { 8, 12 },{15,24},{25,26}};
		int result[][] = intervalIntersactions(l1,l2);
		System.out.println("resutl "+result); //[[1, 2], [5, 5], [8, 10], [15, 23], [24, 24], [25, 25]]
		
		int l11[][] = { { 1,3 }, {  5,6 }, { 7, 9 }};
		int l22[][] = {  {  2,3 }, { 5, 7 }};
		int result1[][] = intervalIntersactions(l11,l22);
		System.out.println("resutl "+result1); //[[2, 3], [5, 6], [7, 7]]
		
		int l111[][] = { { 1,3 }, {  5,6 }, { 7, 9 }};
		int l222[][] = {};
		int result2[][] = intervalIntersactions(l111,l222);
		System.out.println("resutl "+result2); // []
		
		int l1111[][] = { { 1,3 }, {  5,7 }, { 9,12 }};
		int l2222[][] = {{5,10}};
		int result3[][] = intervalIntersactions(l1111,l2222);
		System.out.println("resutl "+result3); //[[5, 7], [9, 10]]
		
		

	}

}
