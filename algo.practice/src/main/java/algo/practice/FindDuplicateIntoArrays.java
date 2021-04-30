package algo.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


class FindDuplicateIntoArrays {
	
   public static void main(String []s)
   {
	   List<Integer> numbers = new ArrayList<>();
	   numbers.add(1);
	   numbers.add(2);
	   numbers.add(1);
	   numbers.add(2);
	   numbers.add(4);
	   numbers.add(3);
	   numbers.add(2);
	   numbers.add(3);

	   Collections.sort(numbers);
		//[1, 1, 2, 2, 2, 3, 3, 4]
	   int numDup = 0, dupCount = 0;
	   int previous = -1;
	   for (int i=0; i < numbers.size(); ++i) {
	       if (numbers.get(i) == previous) {
	           ++numDup;
	           if (numDup == 1) {
	               ++dupCount;
	               if (dupCount == 1) {
	                   System.out.print(numbers.get(i));
	               }
	               else {
	                   System.out.print(", " + numbers.get(i));
	               }
	           }
	       }
	       else {
	           previous = numbers.get(i);
	           numDup = 0;
	       }
	   }
	   System.out.println("\nNumber of duplicates values: " + dupCount);

   }
}