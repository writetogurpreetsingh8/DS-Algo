package algo.practice;

public class FactorialWithRecursion {

	static int fact(int i){
		
		if(i <=0 ){
			return 0;
		}
		if(i == 1){
			return 1;
		}
		return fact(i-1) * i;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(fact(5));
	}

}
