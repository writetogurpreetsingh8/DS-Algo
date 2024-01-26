package recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * TC is O(N*N) or O(N!) system stack O(N*N) aux space O(N*N) + O(N) for taking
 * some extra space
 * 
 * @author Tony.Stark
 *
 */
class NQeenProblem2 {

	public static void nQeenProblem2(boolean[][] board, int N) {
		if (board == null || board.length == 0) {
			return;
		}
		placeNQueens(board, 0, N);
	}

	private static void placeNQueens(boolean[][] board, int col, int N) {

		if (N == col) {
			displayBoard(board);
			System.out.println("\n");
			return;
		}
		
		/*
		 * for (int row = 0; row < N; row++) {
		 * 
		 * if (isSafeToPlaceQueen(board, row, col, N)) { board[row][col] = true;
		 * placeNQueens(board, col + 1, N); board[row][col] = false; } }
		 */
		
		for (int row = 0; row < N; row++) {

			if (isSafeToPlaceQueen(board, row, col, N)) {
				board[row][col] = true;
				placeNQueens(board, col + 1, N);
				board[row][col] = false;
			}
		}
	}

	/**
	 * this below method has extra TC O(N) and if we take some extra space we can
	 * reduce it up O(1) see in above class named {@link NQueensProblem}
	 */
	private static boolean isSafeToPlaceQueen(boolean[][] board, int row, int col, int N) {
		int tempRow = row;
		int tempCol = col;
		// is it safe to place a new queen at the same row ?
		// check from right to left side <------
		while (tempCol >= 0) {
			if (board[tempRow][tempCol]) {
				return false;
			}
			tempCol--;
		}

		// is it safe to place a new queen at the same upper diagonal ?
		// check from right to left side
		tempCol = col;
		tempRow = row;
		while (tempRow >= 0 && tempCol >= 0) {
			if (board[tempRow][tempCol]) {
				return false;
			}
			tempRow--;
			tempCol--;
		}
		// is it safe to place a new queen at the same lower diagonal ?
		// check from right to left side
		tempCol = col;
		tempRow = row;
		while (tempRow < N && tempCol >= 0) {
			if (board[tempRow][tempCol]) {
				return false;
			}
			tempRow++;
			tempCol--;
		}
		return true;
	}
	
	private static void displayBoard(boolean[][] board) {
		for (boolean[] boardRow : board) {
			for (boolean cell : boardRow) {
				System.out.print(cell ? "Q" : ".");
			}
			System.out.println();
		}
	}

}

class Queen {

	private final static String QUEEN = "Q";
	int row;
	int col;
	String queen = Queen.QUEEN;

	@Override
	public String toString() {
		return "(row=" + row + ", col=" + col + ", queen=" + queen + ")";
	}
}

class Response {

	List<List<String>> resultList;
	List<List<Queen>> queenList;

	Response() {
		this.queenList = new ArrayList<>();
		this.resultList = new ArrayList<>();
	}

	List<List<String>> getResultList() {
		return resultList;
	}

	List<List<Queen>> getQueenList() {
		return queenList;
	}
}

/**
 * TC is O(N*N) or O(N!) system stack O(N*N) aux space O(N*N) + O(N) for taking
 * some extra space
 * 
 * @author Tony.Stark
 *
 */
class NQueensProblem {

	final static Response response = new Response();

	public static List<List<String>> nQueensProblem(int N) {

		response.resultList.clear();
		response.queenList.clear();

		if (N <= 0) {
			return response.getResultList();
		}

		if (N == 1) {
			response.resultList.add(Collections.singletonList("Q"));
			response.queenList.add(Collections.singletonList(new Queen()));
			return response.getResultList();
		}

		// prepare chess board for string as well as queen instances
		List<StringBuilder> strBoard = new ArrayList<>();
		List<Queen> queenBoard = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			strBoard.add(Collections.nCopies(N, ".").stream().collect(StringBuilder::new, StringBuilder::append,
					StringBuilder::append));
			queenBoard.add(new Queen());
		}

		boolean tracedRow[] = new boolean[N];
		boolean tracedLowerDiagonal[] = new boolean[(2 * N) - 1];
		boolean tracedUpperDiagonal[] = new boolean[(2 * N) - 1];

		placeNQueens(strBoard, queenBoard, 0, N, response, tracedRow, tracedLowerDiagonal, tracedUpperDiagonal);

		return response.getResultList();
	}

	private static void placeNQueens(List<StringBuilder> strBoard, List<Queen> queenBoard, int col, int N,
			Response response, boolean tracedRow[], boolean tracedLowerDiagonal[], boolean tracedUpperDiagonal[]) {

		if (N == col) {
			response.resultList.add(contructResult(strBoard));
			response.queenList.add(contructQueenResult(queenBoard));
			return;
		}

		for (int row = 0; row < N; row++) {

			if (isSafeToPlaceQueen(row, col, N, tracedRow, tracedLowerDiagonal, tracedUpperDiagonal)) {
				StringBuilder board = strBoard.get(row);
				board.setCharAt(col, 'Q');
				Queen queen = queenBoard.get(row);
				queen.row = row;
				queen.col = col;
				tracedRow[row] = true;
				tracedLowerDiagonal[row + col] = true;
				tracedUpperDiagonal[(N - 1) + (col - row)] = true;
				placeNQueens(strBoard, queenBoard, col + 1, N, response, tracedRow, tracedLowerDiagonal,
						tracedUpperDiagonal);
				board.setCharAt(col, '.');
				tracedRow[row] = false;
				tracedLowerDiagonal[row + col] = false;
				tracedUpperDiagonal[(N - 1) + (col - row)] = false;
			}
		}
	}

	private static List<Queen> contructQueenResult(List<Queen> queenBoard) {
		return queenBoard.stream().map(queen -> {
			Queen newQueen = new Queen();
			newQueen.col = queen.col;
			newQueen.row = queen.row;
			return newQueen;
		}).collect(Collectors.toList());
	}

	private static List<String> contructResult(List<StringBuilder> strBoard) {
		return strBoard.stream().map(builder -> builder.toString()).collect(Collectors.toList());
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

}

/**
 * TC is O(N*N) or O(N!) system stack O(N*N) aux space O(N*N)
 * 
 * @author Tony.Stark
 *
 */
public class NQueensProblemI {

	private final static Response response = new Response();

	public static List<List<String>> nQueensProblem(int N) {

		response.resultList.clear();
		response.queenList.clear();

		if (N <= 0) {
			return response.getResultList();
		}

		if (N == 1) {
			response.resultList.add(Collections.singletonList("Q"));
			response.queenList.add(Collections.singletonList(new Queen()));
			return response.getResultList();
		}

		// prepare chess board for string as well as queen instances
		List<StringBuilder> strBoard = new ArrayList<>();
		List<Queen> queenBoard = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			strBoard.add(Collections.nCopies(N, ".").stream().collect(StringBuilder::new, StringBuilder::append,
					StringBuilder::append));
			queenBoard.add(new Queen());
		}
		placeNQueens(strBoard, queenBoard, 0, N, response);

		return response.getResultList();
	}

	private static void placeNQueens(List<StringBuilder> strBoard, List<Queen> queenBoard, int col, int N,
			Response response) {

		if (N == col) {
			response.resultList.add(contructResult(strBoard));
			response.queenList.add(contructQueenResult(queenBoard));
			return;
		}

		for (int row = 0; row < N; row++) {

			if (isSafeToPlaceQueen(strBoard, row, col, N)) {
				StringBuilder board = strBoard.get(row);
				board.setCharAt(col, 'Q');
				Queen queen = queenBoard.get(row);
				queen.row = row;
				queen.col = col;
				placeNQueens(strBoard, queenBoard, col + 1, N, response);
				board.setCharAt(col, '.');
			}
		}
	}

	/**
	 * this below method has extra TC O(N) and if we take some extra space we can
	 * reduce it up O(1) see in above class named {@link NQueensProblem}
	 */
	private static boolean isSafeToPlaceQueen(List<StringBuilder> strBoard, int row, int col, int N) {
		int tempRow = row;
		int tempCol = col;
		// is it safe to place a new queen at the same row ?
		// check from right to left side <------
		while (tempCol >= 0) {
			StringBuilder sb = strBoard.get(tempRow);
			if (sb.charAt(tempCol) == 'Q') {
				return false;
			}
			tempCol--;
		}

		// is it safe to place a new queen at the same upper diagonal ?
		// check from right to left side
		tempCol = col;
		tempRow = row;
		while (tempRow >= 0 && tempCol >= 0) {
			StringBuilder sb = strBoard.get(tempRow);
			if (sb.charAt(tempCol) == 'Q') {
				return false;
			}
			tempRow--;
			tempCol--;
		}
		// is it safe to place a new queen at the same lower diagonal ?
		// check from right to left side
		tempCol = col;
		tempRow = row;
		while (tempRow < N && tempCol >= 0) {
			StringBuilder sb = strBoard.get(tempRow);
			if (sb.charAt(tempCol) == 'Q') {
				return false;
			}
			tempRow++;
			tempCol--;
		}
		return true;
	}

	private static List<Queen> contructQueenResult(List<Queen> queenBoard) {
		return queenBoard.stream().map(queen -> {
			Queen newQueen = new Queen();
			newQueen.col = queen.col;
			newQueen.row = queen.row;
			return newQueen;
		}).collect(Collectors.toList());
	}

	private static List<String> contructResult(List<StringBuilder> strBoard) {
		return strBoard.stream().map(builder -> builder.toString()).collect(Collectors.toList());
	}

	public static void main(String[] args) {

		System.out.println("4 board size " + NQueensProblemI.nQueensProblem(2));
		//System.out.println("4 board size " + NQueensProblemI.response.getQueenList());

		System.out.println("4 board size " + NQueensProblem.nQueensProblem(2));
		//System.out.println("4 board size " + NQueensProblem.response.getQueenList());
		
		boolean[][] board = new boolean[4][4];
		NQeenProblem2.nQeenProblem2(board, 4);

	}

}
