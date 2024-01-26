package geeksforgeeks.mathematics;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Find_sqrt_root {
	
	 String abc;
	
	

	@Override
	public int hashCode() {
		int h = 0;
        if (h == 0 && abc.length() > 0) {
            char val[] = abc.toCharArray();

            for (int i = 0; i < val.length; i++) {
                h = 31 * h + val[i];
            }
        }
        return h;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		Find_sqrt_root k = (Find_sqrt_root) obj;
		if(abc != null) {
			return abc.equals(k.abc.toString());
		}
		return false;
	}
	// TC O(root N)
	private static int findSqrt(int n) {
		
		if(n<=1) {
			return n;
		}
		int counter=0;
		while(n>1) {
			n/=2;
			if(n%2==0) {
				counter++;
			}
		}
		return counter;
	}
	public static void main(String[] args) {
			System.out.println(findSqrt(9));
			
			Set<Find_sqrt_root> set = new HashSet<Find_sqrt_root>();
			Find_sqrt_root l1 = new Find_sqrt_root();
			l1.abc="key1";
			set.add(l1);
			
			Find_sqrt_root l2 =  new Find_sqrt_root();
			l2.abc="key2";
			set.add(l2);
			
			System.out.println(set.contains("key1"));
			
			List<Find_sqrt_root> list = new ArrayList<Find_sqrt_root>();
			list.add(l1);
			list.add(l2);
			System.out.println(list);
			Find_sqrt_root k = new Find_sqrt_root();
			k.abc="key1";
			System.out.println(list.contains(k));
			
			test t = new test();
			t.abc="key2";
			System.out.println(list.contains(t));
	}
	
	

}

class test{
	String abc;


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		
		Find_sqrt_root other = (Find_sqrt_root) obj;
		if (abc == null) {
			if (other.abc != null)
				return false;
		} else if (!abc.equals(other.abc))
			return false;
		return true;
	}
	
	
	
}
