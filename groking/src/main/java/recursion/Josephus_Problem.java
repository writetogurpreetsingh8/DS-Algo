package recursion;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Josephus_Problem {

	public static int josephus_Problem(int n, int k) {
		if( n<=0 || k<=0) {
			return -1;
		}
		List<Integer> list = IntStream.rangeClosed(1, n).boxed().collect(Collectors.toList());
		return josephus0(list,k-1,0);
	}

	private static int josephus0(List<Integer> list, int k,int index) {
		if(list.size() == 1) {
			return list.get(0);
		}
		index = (k+index)%list.size();
		list.remove(index);
		return josephus0(list,k,index);
	}
	
	public static void main(String[] args) {
			System.out.println(josephus_Problem(5,3));
	}
}
