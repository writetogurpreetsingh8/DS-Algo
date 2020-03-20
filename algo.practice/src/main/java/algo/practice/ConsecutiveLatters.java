package algo.practice;

public class ConsecutiveLatters {

	public static void main(String[] args) {

		int a = 11;
		int b = 7;
		
		int remainingA = a;
		int remainingB = b;
		int countForA = 0;
		int countForB = 0;
		boolean isAddedA = false;
		boolean isAddedB = false;
		
		StringBuilder sb = new StringBuilder();
		
		if(a > b) {
			if(a>1) {
				sb.append("aa");
				countForA += 2;
				remainingA = a - countForA;
				isAddedA = true;
			}
			else if(a == 1) {
				sb.append("a");
				countForA += 1;
				remainingA = a - countForA;
				isAddedA = true;
			}
		}
		else {
			if(b>1) {
				sb.append("bb");
				countForB += 2;
				remainingB = b - countForB;
				isAddedB = true;
			}
			else if(b == 1) {
				sb.append("b");
				countForB += 1;
				remainingB = b - countForB;
				isAddedB = true;
			}
		}
		
		while(true) {
		
			if(countForA != a) {
				
				if(!isAddedA) {
					
				if(remainingA > 1) {
					sb.append("aa");
					countForA += 2;
					remainingA = a - countForA;
					isAddedB = false;
					
				}else if(remainingA == 1) {
					countForA += 1;
					remainingA = a - countForA;
					sb.append("a");
					isAddedB = false;
				}
			}
			}
			
			if(countForB != b) {
				
				if(!isAddedB) {
				if(remainingB > 1) {
					sb.append("bb");
					countForB += 2;
					remainingB = b - countForB;
					
				}else if(remainingB == 1) {
					countForB += 1;
					remainingB = b - countForB;
					sb.append("b");
				}
				}
			}
			isAddedA = false; isAddedB = false;
			if( (countForB == b)  && (countForA == a) ) {
				break;
			}
			
		}
		System.out.println(sb);
	}
}
