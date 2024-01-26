package recursion;

/**
 * 100% Recursivee solution , TC , space and aux space complexity would be same as below
 * 
 * @author Tony.Stark
 * https://leetcode.com/problems/sudoku-solver/solutions/3469400/java-easiest-solution-step-by-step-explained/
 */
class Sodoku_Solver3{
	
	public static void sodoku_Solver3(char[][] board) {
		if (board == null) {
			return;
		}
		int rowLength = board.length;
		int colLength = board[0].length;
		// if row and col are not the same
		if (rowLength != colLength) {
			return;
		}
		calculateSodoku1(board,rowLength,colLength,0,0);
	}

	private static boolean calculateSodoku1(char[][] board, int rowLength, int colLength,int row,int col) {
		
		// when row reach total row available in the matrix that means we have found our answer and return true
		if(row == rowLength) {
			return true;
		}
		// when col reach at the end of the matrix than reset it to 0 and make row + 1 and make recursive call for the next row
		if(col == colLength) {
			return calculateSodoku1(board, rowLength, colLength, (row+1), 0);
		}
		// if current element of matrix is not '.' than skip it and make col + 1 and make it recursive call for next element in same row
		if(board[row][col] != '.') {
			return calculateSodoku1(board, rowLength, colLength, row,(col+1));
		}
		
		for (int k = 1; k <= rowLength; k++) {
			if(isValidDigit3(board, k, row, col, rowLength)) {
				board[row][col] = (char)(k+'0');
				if(calculateSodoku1(board, rowLength, colLength, row,(col+1))) {
					return true;
				}
				else {
					board[row][col] = '.';
				}	
			}
		}
		return false;
	}
	
	private static boolean isValidDigit3(char[][] board, int value, int row, int col, int rowLength) {
		int innerMatrixRow = (3 * (row / 3));
		int innerMatrixCol = (3 * (col / 3));

		for (int i = 0; i < rowLength; i++) {
			// checking in the row
			if (board[row][i] == (char) (value + '0')) {
				return false;
			}
			// checking in the col
			if (board[i][col] == (char) (value + '0')) {
				return false;
			}
			// checking in the 3X3 matrix
			if (board[innerMatrixRow + (i / 3)][innerMatrixCol + (i % 3)] == (char) (value + '0')) {
				return false;
			}
		}
		return true;
	}
}

/**
 * 100% Recursive solution , TC , space and aux space complexity would be same as below
 * 
 * @author Tony.Stark
 */
class Sodoku_Solver2 {

	public static void sodoku_Solver2(char[][] board) {
		if (board == null) {
			return;
		}
		int rowLength = board.length;
		int colLength = board[0].length;
		// if row and col are not the same
		if (rowLength != colLength) {
			return;
		}
		int totalElement = (rowLength * colLength);
		calculateSodoku(board, totalElement, rowLength, 0);
	}

	private static boolean calculateSodoku(char[][] board, int totalElement, int rowLength, int i) {

		if (i == totalElement) {
			return true;
		}
		int row = i / rowLength;
		int col = i % rowLength;
		
		if(board[row][col] != '.') {
			return calculateSodoku(board, totalElement, rowLength, (i+1));
		}
		
		for (int k = 1; k <= rowLength; k++) {
			if(isValidDigit2(board, k, row, col, rowLength)) {
				board[row][col] = (char)(k+'0');
				if(calculateSodoku(board, totalElement, rowLength, (i+1))) {
					return true;
				}
				else {
					board[row][col] = '.';
				}	
			}
		}
		return false;
	}

	private static boolean isValidDigit2(char[][] board, int value, int row, int col, int rowLength) {
		int innerMatrixRow = (3 * (row / 3));
		int innerMatrixCol = (3 * (col / 3));

		for (int i = 0; i < rowLength; i++) {
			// checking in the row
			if (board[row][i] == (char) (value + '0')) {
				return false;
			}
			// checking in the col
			if (board[i][col] == (char) (value + '0')) {
				return false;
			}
			// checking in the 3X3 matrix
			if (board[innerMatrixRow + (i / 3)][innerMatrixCol + (i % 3)] == (char) (value + '0')) {
				return false;
			}
		}
		return true;
	}

}

/**
 * single loop solution , TC , space and aux space complexity would be same as below
 * 
 * @author Tony.Stark
 */
class Sodoku_Solver1 {

	public static void sodoku_Solver1(char[][] board) {
		if (board == null) {
			return;
		}
		int rowLength = board.length;
		int colLength = board[0].length;
		// if row and col are not the same
		if (rowLength != colLength) {
			return;
		}
		findSodoku1(board, rowLength, (rowLength * colLength), 0);
	}

	private static boolean findSodoku1(char[][] board, int rowLength, int totalElements, int i) {

		while (i < totalElements && board[i / rowLength][i % rowLength] != '.') {
			i++;
		}
		if (i == totalElements) {
			return true;
		}

		int p = i / rowLength;
		int q = i % rowLength;

		for (int k = 1; k <= rowLength; k++) {
			if (isValidDigit1(board, k, p, q, rowLength)) {
				board[p][q] = (char) (k + '0');
				if (findSodoku1(board, rowLength, totalElements, (i + 1))) {
					return true;
				} else {
					board[p][q] = '.';
				}
			}
		}
		return false;
	}

	private static boolean isValidDigit1(char[][] board, int value, int row, int col, int rowLength) {
		int innerMatrixRow = (3 * (row / 3));
		int innerMatrixCol = (3 * (col / 3));

		for (int i = 0; i < rowLength; i++) {
			// checking in the row
			if (board[row][i] == (char) (value + '0')) {
				return false;
			}
			// checking in the col
			if (board[i][col] == (char) (value + '0')) {
				return false;
			}
			// checking in the 3X3 matrix
			if (board[innerMatrixRow + (i / 3)][innerMatrixCol + (i % 3)] == (char) (value + '0')) {
				return false;
			}
		}
		return true;
	}
}

/**
 * TC would be O(9^(N*N))
 * aux space O(1)
 * system stack O(9*9) means constant because matrix would be always 9*9 so O(1)
 * otherwise system stack would be O(N*N)
 * @author Tony.Stark
 *
 */
class Sodoku_Solver0 {
	

	public static void sodoku_Solver(char[][] board) {

		if (board == null) {
			return;
		}
		int rowLength = board.length;
		int colLength = board[0].length;
		// if row and col are not the same
		if (rowLength != colLength) {
			return;
		}
		findSodoku(board, 0, 0, rowLength, colLength);
	}

	private static boolean findSodoku(char[][] board, int indexOfRow, int indexOfCol, int row, int col) {

		// [5, 3, 1, 2, 4, 6, 7, 9, 8]
		for (int i = indexOfRow; i < row; i++, indexOfCol = 0) {
			for (int j = indexOfCol; j < col; j++) {
				// checking for empty cell in the board
				if (board[i][j] == '.') {
					// if cell is empty , check for whether we can put digit in the empty cell
					// or not digits would be in the range of 1 to row or 1 to col, row and col
					// would be same
					for (int k = 1; k <= row; k++) {
						if (isValidDigit(i, j, board, k, row)) {
							board[i][j] = (char) (k + '0');
							if (findSodoku(board, indexOfRow, j + 1, row, col)) {
								return true;
							} else {
								board[i][j] = '.';
							}
						}
					}
					return false;
				}
			}
		}
		return true;
	}

	private static boolean isValidDigit(int row, int col, char[][] board, int value, int rowSize) {

		int innerMatrixRow = (3 * (row / 3));
		int innerMatrixCol = (3 * (col / 3));

		for (int i = 0; i < rowSize; i++) {
			// checking in the row
			if (board[row][i] == (char) (value + '0')) {
				return false;
			}
			// checking in the col
			if (board[i][col] == (char) (value + '0')) {
				return false;
			}
			// checking in the 3X3 matrix
			if (board[innerMatrixRow + (i / 3)][innerMatrixCol + (i % 3)] == (char) (value + '0')) {
				return false;
			}
		}
		return true;
	}
}
/**
 * TC would be O(9^(N*N))
 * aux space O(1)
 * system stack O(9*9) means constant because matrix would be always 9*9 so O(1)
 * otherwise system stack would be O(N*N)
 * @author Tony.Stark
 *
 */
public class Sodoku_Solver {

	public static void sodoku_Solver(char[][] board) {

		if (board == null) {
			return;
		}
		int rowLength = board.length;
		int colLength = board[0].length;
		// if row and col are not the same
		if (rowLength != colLength) {
			return;
		}
		findSodoku(board);
	}
	
	private static boolean findSodoku(char[][] board) {

		// [5, 3, 1, 2, 4, 6, 7, 9, 8]
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				// checking for empty cell in the board
				if (board[i][j] == '.') {
					// if cell is empty , check for whether we can put digit in the empty cell
					// or not digits would be in the range of 1 to row or 1 to col, row and col
					// would be same
					for (int k = 1; k <= 9; k++) {
						if (isValidDigit(i, j, board, k)) {
							board[i][j] = (char) (k + '0');
							if (findSodoku(board)) {
								return true;
							} else {
								board[i][j] = '.';
							}
						}
					}
					return false;
				}
			}
		}
		return true;
	}
	
	private static boolean isValidDigit(int row, int col, char[][] board, int value) {

		int innerMatrixRow = (3 * (row / 3));
		int innerMatrixCol = (3 * (col / 3));

		for (int i = 0; i < 9; i++) {
			// checking in the row
			if (board[row][i] == (char) (value + '0')) {
				return false;
			}
			// checking in the col
			if (board[i][col] == (char) (value + '0')) {
				return false;
			}
			// checking in the 3X3 matrix
			if (board[innerMatrixRow + (i / 3)][innerMatrixCol + (i % 3)] == (char) (value + '0')) {
				return false;
			}
		}
		return true;
	}
		

	public static void main(String[] args) {

		char board[][] = { { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
				{ '6', '.', '.', '1', '9', '5', '.', '.', '.' }, { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
				{ '8', '.', '.', '.', '6', '.', '.', '.', '3' }, { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
				{ '7', '.', '.', '.', '2', '.', '.', '.', '6' }, { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
				{ '.', '.', '.', '4', '1', '9', '.', '.', '5' }, { '.', '.', '.', '.', '8', '.', '.', '7', '9' } };

		sodoku_Solver(board);
		System.out.println(board);

		// Sodoku_Solver1.sodoku_Solver1(board);
		System.out.println(board);

		char board1[][] = { { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
				{ '6', '.', '.', '1', '9', '5', '.', '.', '.' }, { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
				{ '8', '.', '.', '.', '6', '.', '.', '.', '3' }, { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
				{ '7', '.', '.', '.', '2', '.', '.', '.', '6' }, { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
				{ '.', '.', '.', '4', '1', '9', '.', '.', '5' }, { '.', '.', '.', '.', '8', '.', '.', '7', '9' } };

		Sodoku_Solver2.sodoku_Solver2(board1);
		// [[5, 3, 4, 6, 7, 8, 9, 1, 2], [6, 7, 2, 1, 9, 5, 3, 4, 8],
		// [1, 9, 8, 3, 4, 2, 5, 6, 7], [8, 5, 9, 7, 6, 1, 4, 2, 3],
		// [4, 2, 6, 8, 5, 3, 7, 9, 1], [7, 1, 3, 9, 2, 4, 8, 5, 6],
		// [9, 6, 1, 5, 3, 7, 2, 8, 4], [2, 8, 7, 4, 1, 9, 6, 3, 5],
		// [3, 4, 5, 2, 8, 6, 1, 7, 9]]
		System.out.println(board1);
		
		char board2[][] = { { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
				{ '6', '.', '.', '1', '9', '5', '.', '.', '.' }, { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
				{ '8', '.', '.', '.', '6', '.', '.', '.', '3' }, { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
				{ '7', '.', '.', '.', '2', '.', '.', '.', '6' }, { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
				{ '.', '.', '.', '4', '1', '9', '.', '.', '5' }, { '.', '.', '.', '.', '8', '.', '.', '7', '9' } };
		
		Sodoku_Solver2.sodoku_Solver2(board2);
		System.out.println(board2);
		
		char board3[][] = { { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
				{ '6', '.', '.', '1', '9', '5', '.', '.', '.' }, { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
				{ '8', '.', '.', '.', '6', '.', '.', '.', '3' }, { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
				{ '7', '.', '.', '.', '2', '.', '.', '.', '6' }, { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
				{ '.', '.', '.', '4', '1', '9', '.', '.', '5' }, { '.', '.', '.', '.', '8', '.', '.', '7', '9' } };
		Sodoku_Solver0.sodoku_Solver(board3);
		System.out.println(board3);
	}

}
