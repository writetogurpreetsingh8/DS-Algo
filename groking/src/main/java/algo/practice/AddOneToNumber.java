package algo.practice;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AddOneToNumber {

public static int[] plusOne(int[] array) {
        
        List<Integer> list = new ArrayList<Integer>();
        
        for(Integer i :array) {
            list.add(i);
        }
        
        int carray = 1; int rem = 0; int value = 0;
        for(int i=list.size() - 1; i>=0; i--) {
            
            value = list.get(i) + carray;
            
            carray = value / 10;
            rem = value % 10;
            
            list.set(i, rem);
            
            if(carray == 0) {
                break;
            }
            
        }
          if(carray == 1) {
        	  list.add(0, carray); 
        }
        
          Iterator<Integer> itr = list.iterator();
        while(itr.hasNext()) {
            if(itr.next() > 0) {
                break;
            }
            else {
                itr.remove();
            }
        }
        int tempArray[] = new int [list.size()];
        for(int i=0;i<list.size();i++) {
            tempArray[i] =  list.get(i);
        }
    return tempArray;
        
    }
	
	public static void main(String[] args) {
		int[] a={1,2,3};
		plusOne(a);
	}

}
