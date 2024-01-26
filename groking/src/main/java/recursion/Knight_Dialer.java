package recursion;

import java.util.HashMap;
import java.util.Map;

public class Knight_Dialer {

	private static long mod = 1000000007;
	public static int knight_Probability_IN_Chessboard(int N) {
		int row = 4; int col=3;
		Map<String,Long> holder = new HashMap<>();
		return knight_Probability_IN_Chessboard2(N,row,col,holder);
	}
	

	private static int knight_Probability_IN_Chessboard2(int N, int row,int col,Map<String,Long> holder) {

		long count = 0;
		
		for(int i=0; i<row; i++) {
			
			for(int j=0; j<col; j++) {
				
				count+=calculateMoves(i,j,N,row,col,holder);
			}
		}
		return (int)(count%mod);
	}

	private static long calculateMoves(int i, int j,int N, int row, int col,Map<String,Long> holder) {
		
		if(i == 3 && (j == 0 || j == 2 )) {
			return 0;
		}
		
		if (i < 0 || i >=row
				|| j<0 || j>=col) {
			return 0;
		}
		
		String key = (+i+"knight"+j+"dialer"+N);
		if(N == 1) {
			return 1;
		}
		
		if(holder.containsKey(key)) {
			return holder.get(key);
		}
		
		long result = calculateMoves(i - 1, j + 2,N-1,row,col,holder) +
				calculateMoves(i - 2, j + 1,N-1,row,col,holder) +
				calculateMoves(i + 1, j + 2,N-1,row,col,holder) +
				calculateMoves(i + 2, j + 1,N-1,row,col,holder) +
				calculateMoves(i - 2, j - 1,N-1,row,col,holder) +
				calculateMoves(i + 1, j - 2,N-1,row,col,holder) +
				calculateMoves(i + 2, j - 1,N-1,row,col,holder) +
				calculateMoves(i - 1, j - 2,N-1,row,col,holder);
		holder.put(key, (result%mod));
		return (result%mod);
	}


	public static void main(String[] args) {
		
		System.out.println(knight_Probability_IN_Chessboard(1)); 
		System.out.println(knight_Probability_IN_Chessboard(2)); 
		System.out.println(knight_Probability_IN_Chessboard(3)); 
		System.out.println(knight_Probability_IN_Chessboard(4));
		System.out.println(knight_Probability_IN_Chessboard(5));
		System.out.println(knight_Probability_IN_Chessboard(6));
		System.out.println(knight_Probability_IN_Chessboard(3131)); //136006598
		//System.out.println(knight_Probability_IN_Chessboard(5000)); //406880451

	}

}
