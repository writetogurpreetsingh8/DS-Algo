package algo.practice;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class ArrayManipulation {

	public static void main(String[] args) throws IOException {
		
		// BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
		    final Scanner scanner = new Scanner(new FileInputStream(new File("C:\\Users\\91783\\Desktop\\inputfile.txt")));

	        String[] nm = scanner.nextLine().split(" ");

	        int n = Integer.parseInt(nm[0]);

	        int m = Integer.parseInt(nm[1]);

	        int[][] queries = new int[m][3];

	        for (int i = 0; i < m; i++) {
	            String[] queriesRowItems = scanner.nextLine().split(" ");
	            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

	            for (int j = 0; j < 3; j++) {
	                int queriesItem = Integer.parseInt(queriesRowItems[j]);
	                queries[i][j] = queriesItem;
	            }
	        }

		
		int array[] = new int[n];
		//int cmd[][]= {{1,5,3},{4,8,7},{6,9,1}};
		//int cmd[][]= {{2,6,8},{3,5,7},{1,8,1},{5,9,15}};
		//int cmd[][]= {{1,2,100},{2,5,100},{3,4,100}};
		int cmd[][]= queries;
		long max = 0;
		int lo = 0;
		int hi = 0;
		for(int i=0;i<cmd.length;i++){
			lo = (cmd[i][0] - 1);
			hi = (cmd[i][1] - 1);
			array[lo] += (cmd[i][2]);
					if(hi+1 < array.length){
						hi++;
						array[hi] -= (cmd[i][2]);
					}else{
						array[hi] -= (cmd[i][2]);
					}
			
		}
		
		for(int i=1;i<array.length;i++){
			array[i] += array[i-1];
			max=Math.max(array[i],max);
		}
		long s = 7542539201L;
		for(int i=0;i<array.length;i++){
			if(array[i] == s){
				System.out.println("find element is "+array[i]);
			}
		}
		
		System.out.println("max value is "+max);
	
	}

}
