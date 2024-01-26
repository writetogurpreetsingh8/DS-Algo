package recursion;

import java.util.HashMap;
import java.util.Map;

public class Knight_Probability_IN_Chessboard {

	private static int[][] dir = { { -2, -1 }, { -1, -2 }, { 1, -2 }, { 2, -1 }, { 2, 1 }, { 1, 2 }, { -1, 2 },
			{ -2, 1 } };

	public static double knight_Probability_IN_Chessboard1(int N, int K, int startingRow, int startingCol) {

		if (!isValid(N, startingRow, startingRow)) {
			return 0.0;
		}
		if (K == 0) {
			return 1.0;
		}

		double prob = 0.0;

		for (int i = 0; i < dir.length; i++) {
			prob += (knight_Probability_IN_Chessboard1(N, K - 1, startingRow + dir[i][0], startingCol + dir[i][1])
					/ 8.0);
		}
		return prob;
	}

	private static boolean isValid(int n, int startingRow, int startingCol) {
		if (startingRow < 0 || startingRow >= n || startingCol < 0 || startingCol >= n) {
			return false;
		}
		return true;
	}
	
	public static double knight_Probability_IN_Chessboard(int N, int K, int startingRow, int startingCol) {
		Map<String, Double> map = new HashMap<String, Double>();
		double doubleV = knight_Probability_IN_Chessboard2(N,K,startingRow,startingCol,map);
		System.out.printf("map size = %d \n ",map.size());
		return doubleV;
	}
	

	private static double knight_Probability_IN_Chessboard2(int N, int K, int startingRow, int startingCol,Map<String, Double> map) {

		double prob = 0.0;
		
		if (K == 0) {
			return 1;
		}
		
		String key = (startingRow+"prob"+startingCol+"kinght"+K);
		
		if(map.containsKey(key)) {
			return map.get(key);
		}

		if (isKnightMoveSafe1(N, startingRow - 1, startingCol + 2)) {
			prob += (knight_Probability_IN_Chessboard2(N, K - 1, startingRow - 1, startingCol + 2,map) / 8.0);
		}

		if (isKnightMoveSafe1(N, startingRow - 2, startingCol + 1)) {
			prob += (knight_Probability_IN_Chessboard2(N, K - 1, startingRow - 2, startingCol + 1,map) / 8.0);
		}

		if (isKnightMoveSafe1(N, startingRow + 1, startingCol + 2)) {
			prob += (knight_Probability_IN_Chessboard2(N, K - 1, startingRow + 1, startingCol + 2,map) / 8.0);
		}

		if (isKnightMoveSafe1(N, startingRow + 2, startingCol + 1)) {
			prob += (knight_Probability_IN_Chessboard2(N, K - 1, startingRow + 2, startingCol + 1,map) / 8.0);
		}

		if (isKnightMoveSafe1(N, startingRow - 1, startingCol - 2)) {
			prob += (knight_Probability_IN_Chessboard2(N, K - 1, startingRow - 1, startingCol - 2,map) / 8.0);
		}

		if (isKnightMoveSafe1(N, startingRow - 2, startingCol - 1)) {
			prob += (knight_Probability_IN_Chessboard2(N, K - 1, startingRow - 2, startingCol - 1,map) / 8.0);
		}

		if (isKnightMoveSafe1(N, startingRow + 1, startingCol - 2)) {
			prob += (knight_Probability_IN_Chessboard2(N, K - 1, startingRow + 1, startingCol - 2,map) / 8.0);
		}

		if (isKnightMoveSafe1(N, startingRow + 2, startingCol - 1)) {
			prob += (knight_Probability_IN_Chessboard2(N, K - 1, startingRow + 2, startingCol - 1,map) / 8.0);
		}
		
		map.put(key, prob);
		return prob;
	}

	private static boolean isKnightMoveSafe1(int N, int row, int col) {

		if (isValidBoard(N, row, col)) {
			return true;
		}
		return false;
	}

	private static boolean isValidBoard(int N, int row, int col) {

		if (row >= 0 && row < N && col >= 0 && col < N) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		// 0.06250
		System.out.println(knight_Probability_IN_Chessboard(3, 2, 0, 0)); // 0.21875
		System.out.println(knight_Probability_IN_Chessboard(8, 30, 6, 4)); // 0.21875

	}

}
