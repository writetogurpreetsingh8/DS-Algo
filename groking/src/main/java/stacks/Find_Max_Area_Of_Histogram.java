package stacks;

import java.util.Stack;

/*
 * TC O(N)
 * aux space O(N)
 * system stack O(1)
 * In this ALGO we tried to reduce the iteration over height array by combining the calculation of NSR + NSL within same array
 */
class Find_Max_Area_Of_Histogram_1{
	
	public static int find_Max_Area_Of_Histogram(int[] heights) {
		
		if(heights == null || heights.length == 0) {
			return -1;
		}
		
		if(heights.length == 1) {
			return heights[0];
		}
		
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
		
		/**
		 * combine logic of NSR + NSL 
		 */
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
}

/*
 * TC O(N)
 * aux space O(N)
 * system stack O(1)
 * in the below ALGO we need to traverse the give array named height 3 times
 * i.e 1st calculate the NSR , 2nd calculate NSR and 3rd than find the maximum Rectangle
 * but we we want we can reduce the iteration over height array by combining the calculation of NSR + NSL within same array
 * for that pl see above ALGO
 */
public class Find_Max_Area_Of_Histogram {

	public static int find_Max_Area_Of_Histogram(int[] heights) {
	
		if(heights == null || heights.length == 0) {
			return -1;
		}
		
		if(heights.length == 1) {
			return heights[0];
		}
		
		/*
		 * first calculation of NSR
		 */
		int pesoduIndexForNSR = heights.length;
		int NSRArray[] = new int[heights.length];
		int NSRIndex = heights.length-1;
			
		Stack<Integer> stack = new Stack<>();
		
		/**
		 * logic of NSR 
		 */
		for (int i = heights.length-1; i >= 0; i--) {
			
			while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
				stack.pop();
			}
			
			if(stack.isEmpty()) {
				NSRArray[NSRIndex--] = pesoduIndexForNSR;
			}
			else {
				NSRArray[NSRIndex--] = stack.peek();
			}
			stack.push(i);
		}
	
		/**
		 * second calculate NSL,
		 * logic of NSL 
		 */
		
		// either create new fresh stack or re-using previous stack clear it by using stack.clear();
		int NSLArray[] = new int[heights.length];
		int pesoduIndexForNSL = -1;
		int NSLIndex = 0;
		
		stack.clear();
		 
		for (int i = 0; i < NSRArray.length; i++) {
		
			while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
				stack.pop();
			}
			
			if(stack.isEmpty()) {
				NSLArray[NSLIndex++] = pesoduIndexForNSL;
			}
			else {
				NSLArray[NSLIndex++] = stack.peek();
			}
			stack.push(i);
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
			
		int height[]= {6,2,5,4,5,1,6};
		//System.out.println(find_Max_Area_Of_Histogram(height));
		//System.out.println(Find_Max_Area_Of_Histogram_1.find_Max_Area_Of_Histogram(height));
		
		int height1[]= {0,1,1,0};
		System.out.println(find_Max_Area_Of_Histogram(height1));
	}

}
