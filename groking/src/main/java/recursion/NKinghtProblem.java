package recursion;

public class NKinghtProblem {

	private static int total=0;
	
	public static void nKinghtProblem(boolean[][] board,int knights) {
		if(knights <=0 || board == null || board.length == 0) {
			return;
		}
		int row = board.length;
		//nKinghtProblem1(board,row,0,knights);
		nKinghtProblem(board,row,0,knights);
	}
	
	private static void nKinghtProblem(boolean[][] board, int row, int col, int knights) {
		if(knights == 0) {
			total++;
			displayBoard(board);
			System.out.println("\n");
			return;
		}
		// below condition would only be applicable in case of number of knight is more than matrix of board
		// i.e board 3X3 & knight is 3 or board is 4X4 & knight is 4 than this condition will not applicable
		// i.e board 3X3 & knight is 4 or board is 4X4 & knight is 3 than this condition will applicable
		//if(col >= board.length) {
		//	col=0;
		//}
		for (int i = 0; i < row; i++) {
			if(isKnightMoveSafe(board,i,col)) {
				board[i][col] = true;
				nKinghtProblem(board,row,col+1,knights-1);
				board[i][col] = false;
			}
		}
	}
	
	private static void nKinghtProblem1(boolean[][] board,int col, int row, int knights) {
		if(knights == 0) {
			total++;
			displayBoard(board);
			System.out.println("\n");
			return;
		}
		// below condition would only be applicable in case of number of knight is more than matrix of board
		// i.e board 3X3 & knight is 3 or board is 4X4 & knight is 4 than this condition will not applicable
		// i.e board 3X3 & knight is 4 or board is 4X4 & knight is 3 than this condition will applicable
		//if(col >= board.length) {
		//	col=0;
		//}
			for(int j=0;j<col;j++) {
				if(isKnightMoveSafe(board,row,j)) {
					board[row][j] = true;
					nKinghtProblem1(board,col,row+1,knights-1);
					board[row][j] = false;
				}
			
				
		}
	}

	private static boolean isKnightMoveSafe(boolean[][] board, int row, int col) {
			
		if(isValidBoard(board, row, col)) {
			// 1st move of knight
			if(board[row][col]) {
				return false;
			}
		}
		
			if(isValidBoard(board, row-2, col+1)) {
				// 1st move of knight
				if(board[row-2][col+1]) {
					return false;
				}
			}
			if(isValidBoard(board, row-1, col+2)) {
				// 2nd move of knight
				if(board[row-1][col+2]) {
					return false;
				}
			}
			if(isValidBoard(board, row+1, col+2)) {
				// 3rd move of knight
				if(board[row+1][col+2]) {
					return false;
				}
			}
			if(isValidBoard(board, row+2, col+1)) {
				// 4th move of knight
				if(board[row+2][col+1]) {
					return false;
				}
			}
			if(isValidBoard(board, row-2, col-1)) {
				// 5th move of knight
				if(board[row-2][col-1]) {
					return false;
				}
			}
			if(isValidBoard(board, row-1, col-2)) {
				// 6th move of knight
				if(board[row-1][col-2]) {
					return false;
				}
			}
			if(isValidBoard(board, row+1, col-2)) {
				// 7th move of knight
				if(board[row+1][col-2]) {
					return false;
				}
			}
			if(isValidBoard(board, row+2, col-1)) {
				// 8th move of knight
				if(board[row+2][col-1]) {
					return false;
				}
			}
		return true;
	}
	
	private static boolean isValidBoard(boolean[][] board,int row,int col) {
		
		if(row>=0 && row < board.length && col>=0 && col < board.length) {
			return true;
		}
		return false;
	}

	private static void displayBoard(boolean[][] board) {
			for (boolean[] boardRow:board) {
				for(boolean cell:boardRow) {
					System.out.print(cell ? "K":".");
				}
				System.out.println();
			}
	}

	public static void main(String[] args) {
		boolean[][] knight = new boolean[4][4];
		nKinghtProblem(knight,4);
		System.out.println(total);
	}

}
