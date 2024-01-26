package patterns;

/**
 * 
 * @author Tony.Stark
 * Below is the link that explain about patterns problem with easy manner
 * https://www.youtube.com/watch?v=M2ofZTiLuBs&list=PL7ersPsTyYt2prN058WfA_j3ElgwD1bht&index=18
 *
 */
public class Patterns {

	/**
	 * for given input n=3
	 * 1 2 3
	 * 4 5 6
	 * 7 8 9
	 * @param n
	 */
	public static void pattern_1(int n) {
		
		if(n <=0 ) {
			System.out.println("invalid given pattern value");
			return;
		}
		int r=1,c=1,t=0;
		while(r<=n) {
			t = r*n;
			while(c<=t) {
				System.out.print(c+"\t");
				c++;
			}
			r++;
			System.out.println();
		}
	}
	
	/**
	 * for given input n=5
	 * pattern would be *
	 * 					**
	 * 					***
	 * 					****	
	 * 					*****
	 */
	public static void pattern_2(int n) {
		if(n<=0) {
			System.out.println("invalid given pattern value");
			return;
		}
		for(int row=1;row<=n;row++) {
			for(int col=1;col<=row;col++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	/**
	 * for given input n=5
	 * pattern would be  *****
	 * 				     ****
	 * 					 ***
	 *   				 **
	 *   			     *
	 * @param n
	 */
	public static void pattern_2_Rev(int n) {
		
		if(n<=0) {
			System.out.println("invalid given pattern value");
			return;
		}
		for(int row=n;row>0;row--) {
			for(int col=1;col<=row;col++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	/**
	 * for given input n=5
	 * pattern would be  1
	 * 					 22
	 * 					 333
	 * 					 4444
	 *                   55555
	 * @param n
	 */
	public static void pattern_3(int n) {
		if(n<=0) {
			System.out.println("invalid given pattern value");
			return;
		}
		for(int row=1;row<=n;row++) {
			for(int col=1;col<=row;col++) {
				System.out.print(row);
			}
			System.out.println();
		}
	}
	
	/**
	 * for given input n=5
	 * pattern would be  55555
	 * 				     4444
	 * 					 333
	 *   				 22
	 *   			     1
	 * @param n
	 */
	public static void pattern_3_Rev(int n) {
		if(n<=0) {
			System.out.println("invalid given pattern value");
			return;
		}
		for(int row=n;row>0;row--) {
			for(int col=1;col<=row;col++) {
				System.out.print(row);
			}
			System.out.println();
		}
	}
	
	/**
	 * for given input n=5
	 * pattern would be  1
	 * 				     2  3
	 * 					 4  5  6
	 *   				 7  8  9  10
	 *   			     11 12 13 14 15
	 * @param n
	 */
	public static void pattern_4(int n) {
		if(n<=0) {
			System.out.println("invalid given pattern value");
			return;
		}
		int count=1;
		for(int row=1;row<=n;row++) {
			for(int col=1;col<=row;col++,count++) {
				System.out.print(count+"\t");
			}
			System.out.println();
		}
	}
	
	/**
	 * for given input n=5
	 * pattern would be  1 
	 * 					 2  3
	 * 					 3  4  5
	 * 					 4  5  6  7	
	 * 					 5  6  7  8  9
	 * @param n
	 */
	public static void pattern_5(int n) {
		if(n<=0) {
			System.out.println("invalid given pattern value");
			return;
		}
		for(int row=1;row<=n;row++) {
			for(int col=0;col<row;col++) {
				System.out.print((row+col)+"\t");
			}
			System.out.println();
		}
	}
	
	/**
	 * for given input n=5
	 * pattern would be  1 
	 * 					 2  1
	 * 					 3  2  1
	 * 					 4  3  2  1	
	 * 					 5  4  3  2  1
	 * @param n
	 */
	public static void pattern_6(int n) {
		if(n<=0) {
			System.out.println("invalid given pattern value");
			return;
		}
		for(int row=1;row<=n;row++) {
			for(int col=0;col<row;col++) {
				System.out.print((row-col)+"\t");
			}
			System.out.println();
		}
	}
	
	/**
	 * for given input n=3
	 * pattern would be  A	A	A  
	 * 					 B  B	B
	 * 					 C	C	C
	 * @param n
	 */
	public static void pattern_7(int n) {
		if(n<=0) {
			System.out.println("invalid given pattern value");
			return;
		}
		for(int row=1;row<=n;row++) {
			for(int col=1;col<=n;col++) {
				System.out.print((char)('A'+row-1)+"\t");
			}
			System.out.println();
		}
	}
	
	/**
	 * for given input n=3
	 * pattern would be  A	B	C  
	 * 					 A  B	C
	 * 					 A	B	C
	 * @param n
	 */
	public static void pattern_8(int n) {
		if(n<=0) {
			System.out.println("invalid given pattern value");
			return;
		}
		for(int row=1;row<=n;row++) {
			for(int col=1;col<=n;col++) {
				System.out.print((char)('A'+(col-1))+"\t");
			}
			System.out.println();
		}
	}
	
	/**
	 * for given input n=3
	 * A B C
	 * D E F
	 * G H I
	 * @param n
	 */
	public static void pattern_9(int n) {
		
		if(n <=0 ) {
			System.out.println("invalid given pattern value");
			return;
		}
		int r=1,c=1,t=0;
		while(r<=n) {
			t = r*n;
			while(c<=t) {
				System.out.print((char)('A'+(c-1))+"\t");
				c++;
			}
			r++;
			System.out.println();
		}
	}
	
	/**
	 * for given input n=3
	 * A B C
	 * B C D
	 * C D E
	 * @param n
	 */
	public static void pattern_10(int n) {
		
		if(n <=0 ) {
			System.out.println("invalid given pattern value");
			return;
		}
		for(int row=1; row<=n; row++) {
			for(int col=1;col<=n;col++) {
				System.out.print((char)('A'+(row+col-2))+"\t");
			}
			System.out.println();
		}
	}
	
	/**
	 * for given input n=3
	 * A
	 * B B
	 * C C C
	 * @param n
	 */
	public static void pattern_11(int n) {
		
		if(n <=0 ) {
			System.out.println("invalid given pattern value");
			return;
		}
		for(int row=1; row<=n; row++) {
			for(int col=1;col<=row;col++) {
				System.out.print((char)('A'+(row-1))+"\t");
			}
			System.out.println();
		}
	}
	
	/**
	 * for given input n=5
	 * A
	 * B C
	 * D E F
	 * G H I J
	 * @param n
	 */
	public static void pattern_12(int n) {
		
		if(n <=0 ) {
			System.out.println("invalid given pattern value");
			return;
		}
		char value = 'A';
		for(int row=1; row<=n; row++) {
			for(int col=1;col<=row;col++) {
				System.out.print((value++)+"\t");
			}
			System.out.println();
		}
	}
	
	/**
	 * for given input n=5
	 * A
	 * B C
	 * C D E
	 * D E F G
	 * E F G H I
	 * @param n
	 */
	public static void pattern_13(int n) {
		
		if(n <=0 ) {
			System.out.println("invalid given pattern value");
			return;
		}
		for(int row=1; row<=n; row++) {
			for(int col=1;col<=row;col++) {
				System.out.print((char)('A'+col+row-2)+"\t");
			}
			System.out.println();
		}
	}
	
	/**
	 * for given input n=4
	 * D
	 * C B
	 * B C D
	 * A B C D
	 * @param n
	 */
	public static void pattern_14(int n) {
		
		if(n <=0 ) {
			System.out.println("invalid given pattern value");
			return;
		}
		char value;
		for(int row=1; row<=n; row++) {
			value = (char) ('A'+(n-row));
			for(int col=1;col<=row;col++) {
				System.out.print(value+"\t");
				value++;
			}
			System.out.println();
		}
	}
	
	/**
	 * for given input n=5
	 *      *
	 *     **
	 *    ***
	 *   ****
	 *  *****  
	 * @param n
	 */
	public static void pattern_15(int n) {
		
		if(n <=0 ) {
			System.out.println("invalid given pattern value");
			return;
		}
		for(int row=1; row<=n; row++) {
			for(int space=1;space<=(n-row);space++) {
				System.out.print(" ");
			}
			for(int col=1;col<=row;col++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	/**
	 * for given input n=5
	 *  $$$$*
	 *  $$$**
	 *  $$***
	 *  $****
	 *  *****  
	 * @param n
	 */
	public static void pattern_16(int n) {
		
		if(n <=0 ) {
			System.out.println("invalid given pattern value");
			return;
		}
		for(int row=1; row<=n; row++) {
			for(int space=1;space<=(n-row);space++) {
				System.out.print("$");
			}
			for(int col=1;col<=row;col++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	/**
	 * for given input n=5
	 *   *****
	 *    ****
	 *     ***
	 *      **
	 *       *
	 * @param n
	 */
	public static void pattern_17(int n) {
		
		if(n <=0 ) {
			System.out.println("invalid given pattern value");
			return;
		}
		for(int row=1; row<=n; row++) {
			for(int space=1;space<row;space++) {
				System.out.print(" ");
			}
			for(int col=1;col<=(n-row);col++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	/**
	 * for given input n=5
	 *   *****
	 *   $****
	 *   $$***
	 *   $$$**
	 *   $$$$*
	 * @param n
	 */
	public static void pattern_18(int n) {
		
		if(n <=0 ) {
			System.out.println("invalid given pattern value");
			return;
		}
		for(int row=1; row<=n; row++) {
			for(int space=1;space<row;space++) {
				System.out.print("$");
			}
			for(int col=1;col<=(n-row);col++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	/**
	 * for given input n=5
	 *   11111
	 *    2222
	 *     333
	 *      44
	 *       5
	 * @param n
	 */
	public static void pattern_19(int n) {
		
		if(n <=0 ) {
			System.out.println("invalid given pattern value");
			return;
		}
		for(int row=1; row<=n; row++) {
			for(int space=1;space<=(row-1);space++) {
				System.out.print(" ");
			}
			for(int col=1;col<=(n-row)+1;col++) {
				System.out.print(row);
			}
			System.out.println();
		}
	}
	
	/**
	 * for given input n=5
	     11111
		 12222
		 12333
		 12344
		 12345
	 * @param n
	 */
	public static void pattern_20(int n) {
		
		if(n <=0 ) {
			System.out.println("invalid given pattern value");
			return;
		}
		for(int row=1; row<=n; row++) {
			for(int space=1;space<=(row-1);space++) {
				System.out.print(space);
			}
			for(int col=1;col<=(n-row)+1;col++) {
				System.out.print(row);
			}
			System.out.println();
		}
	}
	
	/**
	 * for given input n=5
	 *       1
	 *   	22
	 *     333
	 *    4444
	 *   55555
	 * @param n
	 */
	public static void pattern_21(int n) {
		
		if(n <=0 ) {
			System.out.println("invalid given pattern value");
			return;
		}
		for(int row=1; row<=n; row++) {
			for(int space=1;space<=(n-row);space++) {
				System.out.print(" ");
			}
			for(int col=1;col<=row;col++) {
				System.out.print(row);
			}
			System.out.println();
		}
	}
	
	/**
	 * for given input n=5
	 *       12345
	 *   	  2345
	 *         345
	 *          45
	 *           5
	 * @param n
	 */
	public static void pattern_22(int n) {
		
		if(n <=0 ) {
			System.out.println("invalid given pattern value");
			return;
		}
		int value=0;
		for(int row=1; row<=n; row++) {
			for(int space=1;space<row;space++) {
				System.out.print(" ");
			}
			value = row;
			for(int col=1;col<=(n-row+1);col++) {
				System.out.print(value);
				value++;
			}
			System.out.println();
		}
	}
	
	/**
	 * for given input n=5
	 * pattern would be  	1
	 * 				     2  3
	 * 				  4  5  6
	 *   		  7  8  9  10
	 *   	   11 12 13 14 15
	 * @param n
	 */
	public static void pattern_23(int n) {
		if(n<=0) {
			System.out.println("invalid given pattern value");
			return;
		}
		int count=1;
		for(int row=1;row<=n;row++) {
			for(int space=1;space<=(n-row);space++) {
				System.out.print(" ");
			}
			for(int col=1;col<=row;col++,count++) {
				System.out.print(count);
			}
			System.out.println();
		}
	}
	
	/**
	 * for given input n=4
	 * pattern would be  	1
	 * 				      1 2 1
	 * 				  	1 2	3 2 1
	 * 				  1	2 3 4 3 2 1
	 * @param n
	 */
	public static void pattern_24(int n) {
		if(n<=0) {
			System.out.println("invalid given pattern value");
			return;
		}
		int col=1;
		for(int row=1;row<=n;row++) {
			for(int space=1;space<=(n-row);space++) {
				System.out.print(" ");
			}
			for(col=1;col<=row;col++) {
				System.out.print(col);
			}
			for(int col1=(col-2);col1>=1;col1--) {
				System.out.print(col1);
			}
			System.out.println();
		}
	}
	
	
	/**
	 * for given input n=3
	 * pattern would be  	*
	 * 				      * * *
	 * 				  	* *	* * *
	 * @param n
	 */
	public static void pattern_26(int n) {
		if(n<=0) {
			System.out.println("invalid given pattern value");
			return;
		}
		int col=1;
		for(int row=1;row<=n;row++) {
			for(int space=1;space<=(n-row);space++) {
				System.out.print(" ");
			}
			for(col=1;col<=(2*row-1);col++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	/**
	 * for given input n=3
	 * pattern would be  	
	 * 					* *	* * *
	 * 				      * * *
	 * 						*
	 * @param n
	 */
	public static void pattern_26_Rev(int n) {
		if(n<=0) {
			System.out.println("invalid given pattern value");
			return;
		}
		int col=1;
		for(int row=n;row>=1;row--) {
			for(int space=1;space<=(n-row);space++) {
				System.out.print(" ");
			}
			for(col=1;col<=(2*row-1);col++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	/**
	 * for given input n=5
	 * pattern would be  	
	 *  
	 *  1 2 3 4 5 5 4 3 2 1 
	 *  1 2 3 4 * * 4 3 2 1
	 *  1 2 3 * * * * 3 2 1
	 *  1 2 * * * * * * 2 1
	 *  1 * * * * * * * * 1
	 * @param n It's called Dabangg Pattern
	 */
	public static void pattern_27(int n) {
		if(n<=0) {
			System.out.println("invalid given pattern value");
			return;
		}
		int col=1;
		for(int row=0;row<n;row++) {
			
			for(col=1;col<=n-row;col++) {
				System.out.print(col);
			}
			for(int astrick=1;astrick<=((n-(n-row))*2);astrick++) {
				System.out.print("*");
			}
			for(int col1=col-1;col1>=1;col1--) {
				System.out.print(col1);
			}
			System.out.println();
		}
	}
	
	/**
	 * for given input n=5
	 *      *
	 *      **
	 *      ***
	 *      ****
	 *      *****
	 *      ****
	 *      ***
	 *      **
	 *      *  
	 * @param n
	 */
	public static void pattern_28(int n) {
		
		if(n <=0 ) {
			System.out.println("invalid given pattern value");
			return;
		}
		int noOStar=0;
		for(int row=1; row<(n*2); row++) {
			noOStar = row > n ? (n*2-row) : row;
			for(int col=1;col<=noOStar;col++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	/**
	 * for given input n=5
	 * pattern would be  	*
	 *                     * *
	 * 				      * * *
	 * 					 * * * *
	 * 				  	* *	* * *
	 *                   * * * *
	 *                    * * *
	 *                     * *
	 *                      *
	 * @param n
	 */
	public static void pattern_29(int n) {
		if(n<=0) {
			System.out.println("invalid given pattern value");
			return;
		}
		int noOfStars=0,noOfSpaces=0;
		for(int row=1;row<(n*2);row++) {
			
			noOfStars = (row > n) ? (2*n-row) : row;
			noOfSpaces = n - noOfStars;
			
			for(int space=1;space<=noOfSpaces;space++) {
				System.out.print(" ");
			}
			for(int col=1;col<=noOfStars;col++) {
				System.out.print("* ");
			}
			System.out.println();
		}
	}
	
	/**
	 * for given input n=5
	 * pattern would be  	1
	 * 				      2 1 2
	 * 				  	3 2	1 2 3
	 * 				  4	3 2 1 2 3 4
	 *        		5 4 3 2 1 2 3 4 5
	 * @param n
	 */
	public static void pattern_30(int n) {
		if(n<=0) {
			System.out.println("invalid given pattern value");
			return;
		}
		
		for(int row=1;row<=n;row++) {
			
			for(int space=1;space<=(n-row);space++) {
				System.out.print(" ");
			}
			
			for(int col=row;col>=1;col--) {
				System.out.print(col);
			}
			
			for(int col1=2;col1<=row;col1++) {
				System.out.print(col1);
			}
			System.out.println();
		}
	}
	
	/**
	 * for given input n=4
	 * pattern would be  	
	 *  
	 *  0 0 0 0 0 0 0 
	 *  0 1 1 1 1 1 0
	 *  0 1 2 2 2 1 0
	 *  0 1 2 3 2 1 0
	 *  0 1 2 2 2 1 0
	 *  0 1 1 1 1 1 0
	 *  0 0 0 0 0 0 0
	 *  
	 * @param n It's called Dabangg Pattern
	 */
	public static void pattern_31(int n) {
		if(n<=0) {
			System.out.println("invalid given pattern value");
			return;
		}
		
		int diff1=0, diff2=0;
		for(int row=1;row<=(2*n-1);row++) {
			
			diff1 = Math.min(row-1, (((n*2)-1)-row));
			
			for(int col=1;col<=(2*n-1);col++) {
				diff2 = Math.min(col-1, (((n*2)-1)-col));
				System.out.print(Math.min(diff2, diff1)+" ");
			}
			System.out.println();
		}
	}
	
	// now with the help of above patten/output create below pattern
	
	/**
	 * for given input n=4
	 * pattern would be  	
	 *  
	 *  4 4 4 4 4 4 4 
	 *  4 3 3 3 3 3 4
	 *  4 3 2 2 2 3 4
	 *  4 3 2 1 2 3 4
	 *  4 3 2 2 2 3 4
	 *  4 3 3 3 3 3 4
	 *  4 4 4 4 4 4 4
	 *  
	 * @param n It's called Dabangg Pattern
	 */
	public static void pattern_32(int n) {
		if(n<=0) {
			System.out.println("invalid given pattern value");
			return;
		}
		
		int diff1=0, diff2=0;
		for(int row=1;row<=(2*n-1);row++) {
			
			diff1 = Math.min(row-1, (((n*2)-1)-row));
			
			for(int col=1;col<=(2*n-1);col++) {
				diff2 = Math.min(col-1, (((n*2)-1)-col));
				
				System.out.print((n-Math.min(diff2, diff1))+" ");
			}
			System.out.println();
		}
	}
	
	/**
	 * for given input n=4
	 *                   * * * *
	 *                    * * *
	 *                     * *
	 *                      *
	 *                      *
	 *                     * *
	 * 				      * * *
	 * 					 * * * *
	 * @param n
	 */
	public static void pattern_33(int n) {
		if(n<=0) {
			System.out.println("invalid given pattern value");
			return;
		}
		int noOfStars=0,noOfSpaces=0;
		for(int row=1;row<=(n*2);row++) {
			
			noOfStars = (n >=row) ? (n-row)+1 : row - n;
			noOfSpaces = n - noOfStars;
			
			for(int space=1;space<=noOfSpaces;space++) {
				System.out.print(" ");
			}
			for(int col=1;col<=noOfStars;col++) {
				System.out.print("* ");
			}
			System.out.println();
		}
	}
	
	/**
	 * for given input n=5
	 *      *        *
	 *      **      **
	 *      ***    ***
	 *      ****  ****
	 *      **********
	 *      ****  ****
	 *      ***    ***
	 *      **      **
	 *      *        *
	 * @param n
	 */
	public static void pattern_34(int n) {
		
		if(n <=0 ) {
			System.out.println("invalid given pattern value");
			return;
		}
		int stars=0,spaces=0;
		for(int row=1; row<(n*2); row++) {
			stars = row < n ? row : (2*n-row);
			spaces = (2*n)-(2*stars);
			
			for(int col=1;col<=stars;col++) {
				System.out.print("*");
			}
			
			for (int s = 1; s<=spaces; s++) {
				System.out.print(" ");
			}

			for(int col=1;col<=stars;col++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	/**
	 * for given input n=5
	     **********
	     ****  ****
		 ***    ***
		 **      **
	     *		  *
	     *		  *	
		 **      **
		 ***    ***
		 ****  ****
		 **********
	 * @param n
	 */
	public static void pattern_35(int n) {
		
		if(n <=0 ) {
			System.out.println("invalid given pattern value");
			return;
		}
		int stars=0,spaces=0;
		for(int row=1; row<=(n*2); row++) {
			stars = row <= n ? (n-row+1) : (row-n);
			spaces = (2*n)-(2*stars);
			
			for(int col=1;col<=stars;col++) {
				System.out.print("*");
			}
			
			for (int s = 1; s<=spaces; s++) {
				System.out.print(" ");
			}

			for(int col=1;col<=stars;col++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	/**
	 * for given input n=5
	 *      *        *
	 *      **      **
	 *      * *    * *
	 *      *  *  *  *
	 *      *   **   *
	 *      *   **   *
	 *      *  *  *  *
	 *      * *    * *
	 *      **      **
	 *      *		 *
	 * @param n
	 */
	public static void pattern_36(int n) {
		
		if(n <=0 ) {
			System.out.println("invalid given pattern value");
			return;
		}
		int stars=0,spaces=0,flowExeution=0;
		for(int row=1; row<=(n*2); row++) {
			
			//calculate total number of stars need to be printed at each row
			stars = row <= n ? row : ((2*n-row)+1);
			
			//calculate total number of space that need to be printed in b/w two X 
			spaces = ((2*n)-(2*stars));
			
			//flowExecution used to repeat the entire process for right part of the pattern
			// instead of duplicate the code just put loop here
			flowExeution = 2;
			
			while(flowExeution>=1) {
				
				//printing first * at each row
				System.out.print("*");
				
				//printing spaces b/w two *
				for(int col=1;col<stars-1;col++) {
					if(row > 2 && row <= (2*n-2)) {
						System.out.print(" ");
					}
				}
				
				//printing second * at each row just after the spaces
				if(row > 1 && row < (2*n)) {
					System.out.print("*");
				}
				
				//printing spaces b/w two X
				for (int s = 1; s<=(spaces); s++) {
					System.out.print(" ");
				}
				//decrease the flowExecution value by 1 just to repeat the entire process for right side of pattern
				flowExeution--;
			}
			System.out.println();
		}
	}
	
	/**
	 * for given input n=5
						*
					   * *    
					  *   *   
					 *     *  
					*       * 
					 *     *  
					  *   *   
					   * *    
					    *
	 * @param n
	 */
	public static void pattern_37(int n) {
		
		if(n <=0 ) {
			System.out.println("invalid given pattern value");
			return;
		}
		int placeHolder1=n+1,placeHolder2=n-1;
		
		for(int row=1; row<(n*2); row++) {
			
			placeHolder1 = row<=n ? (placeHolder1 - 1) : (placeHolder1 + 1);
			placeHolder2 = row<=n ? (placeHolder2 + 1) : (placeHolder2 - 1);
			
			for(int col=1; col<=(n*2); col++) {
				
				if(col == placeHolder1 || col == placeHolder2) {
					System.out.print("*");
				}else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}
	
	/**
	 * for given input n=5
						 1
						 0 1
						 1 0 1
						 0 1 0 1
						 1 0 1 0 1 		
	 * @param n
	 * using bit toggling approach here,
	 */
	public static void pattern_38(int n) {
		
		if(n <=0 ) {
			System.out.println("invalid given pattern value");
			return;
		}

		int flipBit = 0;
		
		for(int row=1; row<=n; row++) {
			
			if(row % 2 != 0) {
				flipBit = 1;
			}else {
				flipBit = 0;
			}
			
		for(int col=1; col<=row; col++) {
			System.out.print(flipBit);
			flipBit^=1;
		}
			System.out.println();
		}
	}
	
	/**
	 * for given input n=5
						 1
						 0 1
						 1 0 1
						 0 1 0 1
						 1 0 1 0 1 		
	 * @param n
	 * using row+col and then checking their values at every cell
	 * if value is odd then print 1 else 0,
	 */
	public static void pattern_38_different_approach(int n) {
		
		if(n <=0 ) {
			System.out.println("invalid given pattern value");
			return;
		}

		for(int row=1; row<=n; row++) {
		for(int col=1; col<=row; col++) {
			if((row+col) % 2 != 0) {
				System.out.print(0);
			}else {
				System.out.print(1);
			}
		}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		System.out.println("pattern 1"+"\n");
		Patterns.pattern_1(5);
		
		System.out.println("\n pattern 2"+"\n");
		Patterns.pattern_2(5);
		
		System.out.println("\n pattern 2_Rev"+"\n");
		Patterns.pattern_2_Rev(5);
		
		System.out.println("\n pattern 4"+"\n");
		Patterns.pattern_3(5);
		
		System.out.println("\n pattern 3"+"\n");
		Patterns.pattern_3_Rev(5);
		
		System.out.println("\n pattern 4"+"\n");
		Patterns.pattern_4(5);
		
		System.out.println("\n pattern 5"+"\n");
		Patterns.pattern_5(5);
		
		System.out.println("\n pattern 6"+"\n");
		Patterns.pattern_6(5);
		
		System.out.println("\n pattern 7"+"\n");
		Patterns.pattern_7(5);
		
		System.out.println("\n pattern 8"+"\n");
		Patterns.pattern_8(3);
		
		System.out.println("\n pattern 9"+"\n");
		Patterns.pattern_9(3);
		
		System.out.println("\n pattern 10"+"\n");
		Patterns.pattern_10(3);
		
		System.out.println("\n pattern 11"+"\n");
		Patterns.pattern_11(5);
		
		System.out.println("\n pattern 12"+"\n");
		Patterns.pattern_12(5);
		
		System.out.println("\n pattern 13"+"\n");
		Patterns.pattern_13(5);
		
		System.out.println("\n pattern 14"+"\n");
		Patterns.pattern_14(4);
		
		System.out.println("\n pattern 15"+"\n");
		Patterns.pattern_15(5);
		
		System.out.println("\n pattern 16"+"\n");
		Patterns.pattern_16(5);
		
		System.out.println("\n pattern 17"+"\n");
		Patterns.pattern_17(5);
		
		System.out.println("\n pattern 18"+"\n");
		Patterns.pattern_18(5);
		
		System.out.println("\n pattern 19"+"\n");
		Patterns.pattern_19(5);
		
		System.out.println("\n pattern 20"+"\n");
		Patterns.pattern_20(5);
		
		System.out.println("\n pattern 21"+"\n");
		Patterns.pattern_21(5);
		
		System.out.println("\n pattern 22"+"\n");
		Patterns.pattern_22(5);
		
		System.out.println("\n pattern 23"+"\n");
		Patterns.pattern_23(3);
		
		System.out.println("\n pattern 24"+"\n");
		Patterns.pattern_24(5);
		
		System.out.println("\n pattern 26"+"\n");
		Patterns.pattern_26(5);
		
		System.out.println("\n pattern 26_Rev"+"\n");
		Patterns.pattern_26_Rev(5);
		
		System.out.println("\n pattern 27"+"\n");
		Patterns.pattern_27(5);

		System.out.println("\n pattern 28"+"\n");
		Patterns.pattern_28(6);
		
		System.out.println("\n pattern 29"+"\n");
		Patterns.pattern_29(5);
		
		System.out.println("\n pattern 30"+"\n");
		Patterns.pattern_30(5);
		
		System.out.println("\n pattern 31"+"\n");
		Patterns.pattern_31(4);
		
		System.out.println("\n pattern 32"+"\n");
		Patterns.pattern_32(4);
		
		System.out.println("\n pattern 33"+"\n");
		Patterns.pattern_33(4);
		
		System.out.println("\n pattern 34"+"\n");
		Patterns.pattern_34(5);
		
		System.out.println("\n pattern 35"+"\n");
		Patterns.pattern_35(5);

		System.out.println("\n pattern 36"+"\n");
		Patterns.pattern_36(5);
		
		System.out.println("\n pattern 37"+"\n");
		Patterns.pattern_37(5);
		
		System.out.println("\n pattern 38"+"\n");
		Patterns.pattern_38(5);
		
		System.out.println("\n pattern 38_with_different_approach"+"\n");
		Patterns.pattern_38_different_approach(5);
		
		int k = 4;
		int kk = 4;
		System.out.println("k is "+(3 & 2-1));
		System.out.println("k is "+(3 % 2));
		
	}

}
