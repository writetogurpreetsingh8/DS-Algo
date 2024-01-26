package recursion;

/**
 * TC is O(N*N) or O(N!) system stack O(N*N) aux space O(N*N) + O(N) for taking
 * some extra space
 * 
 * @author Tony.Stark
 *
 */
class NQueensProblemII {

	public static int nQueensProblem(int N) {

		if (N <= 0) {
			return N;
		}

		if (N == 1) {
			return N;
		}

		boolean tracedRow[] = new boolean[N];
		boolean tracedLowerDiagonal[] = new boolean[(2 * N) - 1];
		boolean tracedUpperDiagonal[] = new boolean[(2 * N) - 1];

		int result = placeNQueens(0, N, tracedRow, tracedLowerDiagonal, tracedUpperDiagonal, 0);

		return result;
	}

	private static int placeNQueens(int col, int N, boolean tracedRow[], boolean tracedLowerDiagonal[],
			boolean tracedUpperDiagonal[], int sum) {

		if (N == col) {
			sum += 1;
			return sum;
		}

		for (int row = 0; row < N; row++) {

			if (isSafeToPlaceQueen(row, col, N, tracedRow, tracedLowerDiagonal, tracedUpperDiagonal)) {
				tracedRow[row] = true;
				tracedLowerDiagonal[row + col] = true;
				tracedUpperDiagonal[(N - 1) + (col - row)] = true;
				sum = placeNQueens(col + 1, N, tracedRow, tracedLowerDiagonal, tracedUpperDiagonal, sum);
				tracedRow[row] = false;
				tracedLowerDiagonal[row + col] = false;
				tracedUpperDiagonal[(N - 1) + (col - row)] = false;
			}
		}
		return sum;
	}

	private static boolean isSafeToPlaceQueen(int row, int col, int N, boolean tracedRow[],
			boolean tracedLowerDiagonal[], boolean tracedUpperDiagonal[]) {

		// checking for same row
		if (tracedRow[row]) {
			return false;
		}

		// checking for down/lower diagonal
		if (tracedLowerDiagonal[row + col]) {
			return false;
		}

		// checking for upper daigonal

		if (tracedUpperDiagonal[(N - 1) + (col - row)]) {
			return false;
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println("4 board size " + NQueensProblemII.nQueensProblem(4));
	}

}
