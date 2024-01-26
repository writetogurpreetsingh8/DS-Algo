package geeksforgeeks.bitprogramming;

import java.util.BitSet;

public class BitwiseQuestions {

	/**
	 * with << shift operator 
	 */
	private static void checkKthBitSetORNot_With_Left_Shift(int n,int k) {
		int result = (n & 1<<(k-1));
		if(result !=0 ) {
			System.out.println("yes, bit is set!!");
		}
		else {
			System.out.println("no, bit is not set!!");
		}
	}
	
	/**
	 * with >> shift operator 
	 */
	private static void checkKthBitSetORNot_With_Right_Shift(int n,int k) {
		int result = ((n >> k-1) & 1);
		if(result !=0 ) {
			System.out.println("yes, bit is set!!");
		}
		else {
			System.out.println("no, bit is not set!!");
		}
	}
	
	/**
	 *  naive approach , TC O(logN)
	 */
	private static int naiveSolution_count_set_bit(int n) {
			
		int count = 0;
		while(n >0 ) {
			
			if( (n & 1) != 0 ) {  // actually here we do like n%2 != 0 inside with the help of bitwise operators
				count++;
			}
			n>>=1; // actually we do here divided by 2 like n = n/2 inside  with the help of bitwise operators 
		}
		return count;
	}
	
	/**
	 *  brain's approach , TC O(set bit count)
	 */
	private static int brainSAlgo_for_count_set_bit(int n) {
	
		int count=0;
		
		while(n > 0 ) {
			n = (n & (n-1));
			count++;
		}
		return count;
	}
	
	/**
	 * 
	 */
	
	private static void find_Two_Odd_Ocurring(int arr[]) {
	
		int xor=0,res1=0,res2=0;
		for (int i = 0; i < arr.length; i++) {
			xor  = xor ^ arr[i];
		}
		
		int sm = (xor-1);
		System.out.println("sm is "+sm);
		sm = ~sm;
		System.out.println("sm is "+sm);
		sm = xor & sm;
		System.out.println("sm is "+sm);
		
		for (int i = 0; i < arr.length; i++) {
			if((arr[i] & sm) !=0 ) {
				res1 = res1 ^ arr[i];
			}
			else {
				res2 = res2 ^ arr[i];
			}
		}
		System.out.println("res1 "+res1+" and res2 "+res2);
	}
	
	private static void find_Two_Odd_Ocurring1(int arr[]) {
		
		int xor=0,res1=0,res2=0,xor1=0;
		for (int i = 0; i < arr.length; i++) {
			xor  = xor ^ arr[i];
		}
		xor1=xor;
		for (int i = 0; i < arr.length; i++) {
			res1 = xor;
			xor = xor^arr[i];
			if(xor == 0) {
				break;
			}
		}
		for (int i = arr.length-1; i >0; i--) {
			res2 = xor1;
			xor1 = xor1^arr[i];
			if(xor1 == 0) {
				break;
			}
		}
		
		System.out.println("res1 "+res1+" and res2 "+res2);
	}
	
	/**
	 * by getting lowest sit bit of a xor number 
	 */
	private static void find_Two_Odd_Ocurring2(int arr[]) {
		
		int xor=0,res1=0,res2=0;
		for (int i = 0; i < arr.length; i++) {	
			xor  = xor ^ arr[i];
		}
		
		int sm = -xor; // 2's compliments
		System.out.println("sm is "+sm);
		sm = sm & xor;
		System.out.println("sm is "+sm);
		
		for (int i = 0; i < arr.length; i++) {
			if((arr[i] & sm) !=0 ) {
				res1 = res1 ^ arr[i];
			}
			else {
				res2 = res2 ^ arr[i];
			}
		}
		System.out.println("res1 "+res1+" and res2 "+res2);
	}
	
	/**
	 * by striping the bit of a xor number 
	 */
	private static void find_Two_Odd_Ocurring3(int arr[]) {
		
		int xor=0,res1=0,res2=0;
		for (int i = 0; i < arr.length; i++) {	
			xor  = xor ^ arr[i];
		}
		
		int sm = (xor-1);
		System.out.println("sm is "+sm);
		sm = sm & xor;
		System.out.println("sm is "+sm);
		for (int i = 0; i < arr.length; i++) {
			if((arr[i] & sm) !=0 ) {
				res1 = res1 ^ arr[i];
			}
			else {
				res2 = res2 ^ arr[i];
			}
		}
		System.out.println("res1 "+res1+" and res2 "+res2);
	}
	
	
	private static int divide_With_Out_Division_Operator(int divident,int divisor) {
		
		int eq=0,i=0,absDivident=0,absDivisor=0;
		 //Integer.Min_value
		if((divident == 1<<31 ) && divisor == -1) 
			return ~(1<<31); // Integer.Max_value;
        
		if((divident == (1<<31) || divident == ~(1<<31)) && divisor == 1) {
			return divident;
		}
		if(divisor == 0 ) {
			return (1<<31);
		}
		
		absDivident = divident;
		absDivisor = divisor;
		if(divident < 0 ) {
			absDivident = ~(divident)+1; // Math.abs(divident);
		}
		if(divisor < 0 ) {
			absDivisor = ~(divisor)+1; // Math.abs(divident);
		}
        
        while((absDivident - absDivisor) >=0){
            i=0;
            while((absDivident - (absDivisor<<(i+1)))>0){
                i++;
            }
            eq+=(1<<i);
            absDivident-=(absDivisor<<i);
        }
        return ((divident>0) == (divisor>0)) ? eq : ~(eq)+1;
       
   }
     
  private static void find_power_set_for_characters(String abc) {
	
	  if(abc == null || abc.trim().isEmpty()) {
		  System.out.println("invalid string given!!");
	  }
	  
	  int index=0,counter=(int)Math.pow((int)2,(int)abc.length());
	  for (int i = 0; i < counter; i++) {
		  index=0;
		for (int j = abc.length()-1; j>=0; j--) {
			
			if( (1 & (i>>j)) !=0 ) {
				System.out.print(abc.charAt(index));
			}
			index++;
		}
		System.out.println("\n");
	}
  }
  
  private static int calculate_Square_Of_Number_With_BitWise(int n) {
	  
	  if( n == 0 || n == 1) {
		  return n;
	  }
	  
	  if(n<0) {
		  n = (~(n)+1); // making it positive like Math.abs(n);
	  }
	  
	  int temp = n;
	  int res = 0,i=0;
	  while( temp > 0) {
		  
		  if( ((1<<i) & n ) != 0 ) {
			res+= n<<i;
		  }
		 i++;
		 temp>>=1;
	  }
	  System.out.println("i is "+i);
	  System.out.println("temp is "+temp);
	  return res;
  }
/**
 * TC O(NlogN)
 */
  private static int count_total_set_bits_into_n(int n) {
	  
	  if(n <=0 ) {
		  return 0;
	  }
	  int count=0,bit=0;
	  for (int i = 1; i <= n; i++) {
		  bit = i;
		while(bit > 0) {
			count+= (bit & 1);
	  		bit>>=1;
		}
	}
	  return count;
  }
  /**
   * TC O(1)
   */
    private static int count_total_set_bits_into_n1(int n) {
  	  
  	  if(n <=0 ) {
  		  return 0;
  	  }
  	  n++;
  	  int currentValue=0,k=0,p=0,l=0,result=0;
  	  for (int i = 1; i <= 31; i++) {
  		  if(currentValue>n)
  			  break;
  		  k = (1<<(i-1)); // calculate group's
  		  l = (n>>i); // calculate 1's into group's
  		  result+=(l*k);
  		  if(((n>>(i-1)) & 1) !=0 ) {
  			  result+=(n & (k-1)); // calculating mode by bitwise operators like n % k -> n & (k-1) 
  		  }
  		  currentValue = 1<<i;
  	 }
  	  return result;
    }
    /**
     * O(r) treated as Constant O(1)
     */
    private static int copy_set_bit_with_in_given_range(int x,int y,int l, int r) {
    	
    	if(x <=0 || y <=0 || l <=0 || r<=0 ) {
    		return 0;
    	}
    	if( l<1 && r>32) {
    		return 0;
    	}
    	int setBit=0;
    	while(l<=r) {
    		setBit = ((y>>(l-1)) & 1);
    		if((setBit & 1) == 1) // checking if setbit is 0 or 1
    		x = (x|setBit<<(l-1));
    		l++;
    	}
    	return x;
    }
    /**
     * Constant O(1)
     */
    private static int copy_set_bit_with_in_given_range1(int a,int b,int l, int r) {
    	
    	if(a <=0 || b <=0 || l <=0 || r<=0 ) {
    		return 0;
    	}
    	if( l<1 && r>32) {
    		return 0;
    	}
    	int masking=0;
    	
    	masking = 1<<(r-l+1);
    	masking--;
    	masking = masking<<(l-1);
    	masking = a & masking;
    	b = b|masking;
    	return b;
    	
    }
    
    private static int find_log_base_2_of_number(int n) {
    	
    	if(n==0) {
    		return 0;
    	}
    	n = (n < 0 ? (~(n)+1) : n);
    	int temp = n;
    	n--;
    	temp&= n;
    	n = temp;
    	temp--;
    	n^= temp;
    	n--;
    	n>>=1;
    	return n;
    }
    
    private static void findSubSet(String abc) {
    	
    	int index=0,j=0;
    	for (int i = 0; i < Math.pow(2,abc.length()); i++) {
			index =0;j=i;
			while(j>0) {
				if((j&1) !=0) {
					System.out.print(abc.charAt(index));
				}
				index++;
				j>>=1;
			}
			System.out.print("\n");
    		
		}
    }
    
	public static void main(String[] args) {
		
		checkKthBitSetORNot_With_Left_Shift(5,1);
		checkKthBitSetORNot_With_Left_Shift(8,3);
		
		System.out.println("naive-solutions "+naiveSolution_count_set_bit(8));
		System.out.println("brain-solutions "+brainSAlgo_for_count_set_bit(Integer.MAX_VALUE));
		int arr[]= {3, 4, 3, 4, 8, 4, 4, 32, 7, 7}; //21,8
		find_Two_Odd_Ocurring2(arr);
		System.out.println("multiply "+divide_With_Out_Division_Operator(10,3));
		System.out.println("find square with bitwise "+calculate_Square_Of_Number_With_BitWise(6));
		System.out.println("count_total_set_bits_into_n "+count_total_set_bits_into_n(4));
		System.out.println("count_total_set_bits_into_n1 "+count_total_set_bits_into_n1(23));
		System.out.println("copy set bits within given range "+copy_set_bit_with_in_given_range(10,13,2,3));
		System.out.println("copy set bits within given range1 "+copy_set_bit_with_in_given_range1(13,10,2,3));
		System.out.println("find_log_base_2_of_number "+find_log_base_2_of_number(25));
		findSubSet("abc");
		
		System.out.println("max "+(1<<31));
		System.out.println("max "+~(1<<31));
		System.out.println(" 7%7 "+(7^7));
		System.out.println(" 100%100 "+(35^100));
		System.out.println(" 16%2 "+(16&1));
		int kk = -0;
		int re = (~(1<<31)) - (1<<31);
		System.out.println("re is "+re);
		re+=1;
		System.out.println("re is "+re);

		if(kk >re) {
			System.out.println("positive");
		}
		else if(kk<re) {
			System.out.println("negative");
		}else {
			System.out.println("zero");
		}
		 BitSet bitSet = new BitSet();

		System.out.println("bitset "+bitSet);
		bitSet.set(1);
		System.out.println("bitset after value as 1"+bitSet);
		System.out.println("bitset is empty after set value "+bitSet.isEmpty());
		System.out.println("bitset length "+bitSet.length());
		System.out.println("bitset size "+bitSet.size());
		bitSet.clear();
		System.out.println("bitset after clear "+bitSet);
		System.out.println("bitset is empty after clear set value "+bitSet.isEmpty());
		
	}

}

