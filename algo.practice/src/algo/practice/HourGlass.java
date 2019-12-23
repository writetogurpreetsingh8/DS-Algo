package algo.practice;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;


class Execute{
	
	public int execute(int[][] array){
		
		List<Integer> sumOfHourGlass = new LinkedList<>();
		
		if(array.length < 3 || array[0].length < 3 ){
			System.out.println("Invalid arrays, Row & Col of arrays must be same,,....");
			return 0;
		}
		else{
				int colCounter = 0;
				int exitOnCols = 0;
				int sum = 0;
				for(int r = 0; r < (array.length - 2); r++){
					
					for(int c = 0; c < array[r].length; c++){
						
						sum+=array[r][c];
						if(!  ((colCounter == 0) || (colCounter == 2)) ) {
							sum+=array[r + 1][c];
						}
						sum+=array[r + 2][c];
						colCounter++;
						if(colCounter == 3){
							c = c - 2;
							colCounter = 0;
							exitOnCols++;
							sumOfHourGlass.add(sum);
							sum = 0;
						}
						if(exitOnCols == (array[r].length - 2)){
							colCounter = 0;
							exitOnCols = 0;
							break;
						}
					}
					
				}
				System.out.println(sumOfHourGlass);
				Collections.sort(sumOfHourGlass);
				System.out.println(sumOfHourGlass.get(sumOfHourGlass.size()-1));
				return sumOfHourGlass.get(sumOfHourGlass.size()-1);
		}
	}
	
}

public class HourGlass {

	public static void main(String[] args) {

		int array[][]={{1,2,3,4,5,6,7,8,9,10,11},{12,13,14,15,16,17,18,19,20,21,22},
				 	   {23,24,25,26,27,28,29,30,31,32,33},{34,35,36,37,38,39,40,41,42,43,44}};
		
		new Execute().execute(array);
		
	}
}
