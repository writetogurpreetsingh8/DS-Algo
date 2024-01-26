package stacks;

import java.util.Stack;

/**
 * Leet-Code# 85
 * @author Tony.Stark
 * 
 *  TC O(N^2)
 *  aux space O(N)
 *  system space O(1)
 */
public class Max_Area_Rectangle_In_Binary_Matrix {

	public static int max_Area_Rectangle_In_Binary_Matrix(char[][] matrix) {
		
		if(matrix == null || matrix.length == 0) {
			return -1;
		}
		
		int heights[] = new int [matrix[0].length];
		int k=0;
		int maxArea = (1<<31); // INTEGER.MIN_VALUE
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if(matrix[i][j] == '0') {
					heights[k] = 0;
				}
				else {
					heights[k] = heights[k]+(matrix[i][j]-'0');
				}
				k++;
			}
			k=findMaxAreaOfHistogram(heights);
			if(maxArea < k) {
				maxArea = k;
			}
			k=0;
		}
		return maxArea;
	}
	
	private static int findMaxAreaOfHistogram(int[] heights) {
		
		/*
		 * calculation of NSR
		 */
		int pesoduIndexForNSR = heights.length;
		int NSRArray[] = new int[heights.length];
		int NSRIndex = heights.length-1;
		Stack<Integer> stackNSR = new Stack<>();
		
		/*
		 * calculate NSL
		 */
		int NSLArray[] = new int[heights.length];
		int pesoduIndexForNSL = -1;
		int NSLIndex = 0;
		Stack<Integer> stackNSL = new Stack<>();
		
		for (int j=0, i = heights.length-1; i >= 0; i--,j++) {
			/**
			 * logic of NSR 
			 */
			while(!stackNSR.isEmpty() && heights[stackNSR.peek()] >= heights[i]) {
				stackNSR.pop();
			}
			
			if(stackNSR.isEmpty()) {
				NSRArray[NSRIndex--] = pesoduIndexForNSR;
			}
			else {
				NSRArray[NSRIndex--] = stackNSR.peek();
			}
			stackNSR.push(i);
			
			
			/**
			 * logic of NSL 
			 */
			while(!stackNSL.isEmpty() && heights[stackNSL.peek()] >= heights[j]) {
				stackNSL.pop();
			}
			if(stackNSL.isEmpty()) {
				NSLArray[NSLIndex++] = pesoduIndexForNSL;
			}
			else {
				NSLArray[NSLIndex++] = stackNSL.peek();
			}
			stackNSL.push(j);
		}
		
		/**
		 * now calculate the maximum area of Histogram/Rectangle 
		 */
		int maxRectangle = (1<<31);
		int diff=0;
		for (int i = 0; i < heights.length; i++) {
			
			diff = (((NSRArray[i] - NSLArray[i]) - 1) * heights[i]);
			if(diff > maxRectangle) {
				maxRectangle = diff;
			}
		}
		
		return maxRectangle;
	}
	
	public static void main(String[] args) {
		
		char[][] matrix = {
				{'0','1','1','0'},
				{'1','1','1','1'},
				{'1','1','1','1'},
				{'1','1','0','0'}
				};
		
		char[][] matrix1 = {
							{'1','0','1','0','0'},
							{'1','0','1','1','1'},
							{'1','1','1','1','1'},
							{'1','0','0','1','0'}
							};
		//System.out.println(max_Area_Rectangle_In_Binary_Matrix(matrix));
		System.out.println(max_Area_Rectangle_In_Binary_Matrix(matrix1));
	}

}
