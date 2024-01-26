package recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * reference 
 * https://www.youtube.com/watch?v=bLGZhJlt4y0
 * 
 */
/**
 * 1) TC O(M*N)^4 => M*N is 2D array , 
 * Recursion is end when we reach at M*N location and we try to find every possible path/direction for each 2D array
 * and we have 4 possible direction for each cell .ie LEFT, RIGHT, UP & DOWN
 * so total TC would be (M*N)^4
 * 
 * 2) AUX SPACE TC => O(M*N) because we taken extra space 2D array for visited and 
 * O(P*L) for result list because P is the number paths( that we have found ) and X is the length of each path
 * so Total Aux space would be O(M*N) + O(P*L)
 * 
 * 3) System stack => M*N because the height of tree would be M*N at worst case 
 * @author Tony.Stark
 *
 */
class Rat_In_Maze_Problem1{
	
	public static List<String> rat_In_Maze_Problem(int[][] maze) {
		if(maze == null || maze.length == 0) {
			return Collections.emptyList();
		}
		
		if(maze[0][0] == 0) {
			return Collections.emptyList();
		}
		
		int m = maze.length;// denote row
		int n = maze[0].length; // denote col
		
		if(maze[m-1][n-1] == 0) {
			return Collections.emptyList();
		}
		
		List<String> directions = new ArrayList<String>(); // containing result
		String direction = "";
		boolean[][] visited = new boolean[m][n];
		int row = 0, col = 0;
		int drow[] = {1,0,0,-1};
		int dcol[] = {0,-1,1,0};
		String positions = "DLRU";
		findAllPossibleDirections(maze,visited,directions, direction,row,col,m,n,drow,dcol,positions);
		return directions;
	}

	private static void findAllPossibleDirections(int[][] maze, boolean[][] visited, List<String> directions,
			String direction, int row, int col, int m, int n,int drow[],int dcol[],String positions) {
			
		// first check is direction valid to move or not
		if(!isDirectionValid(visited,row,col,m,n,maze)) {
			return;
		}
		// rat has reached end
		if(row == m-1 && col == n-1) {
			directions.add(direction);
			return;
		}
		
		visited[row][col] = true;
		
		for (int i = 0; i < positions.length(); i++) {
			int idrow = row + drow[i];
			int idcol = col + dcol[i];
			findAllPossibleDirections(maze, visited, directions, direction+positions.charAt(i), idrow, idcol, m, n, drow, dcol, positions);
		}
		
		visited[row][col] = false;
					
	}
	
	private static boolean isDirectionValid(boolean[][] visited, int row, int col, int m, int n, int[][] maze) {
		return ((row < m && row >=0) && (col < n && col >=0) && (maze[row][col] == 1) && !visited[row][col]) ? true : false; 
	}
	
}

/**
 * 1) TC O(M*N)^4 => M*N is 2D array , 
 * Recursion is end when we reach at M*N location and we try to find every possible path/direction for each 2D array
 * and we have 4 possible direction for each cell .ie LEFT, RIGHT, UP & DOWN
 * so total TC would be (M*N)^4
 * 
 * 2) AUX SPACE TC => O(M*N) because we taken extra space 2D array for visited and 
 * O(P*L) for result list because P is the number paths( that we have found ) and L is the length of each path
 * so Total Aux space would be O(M*N) + O(P*L)
 * 
 * 3) System stack => M*N because the height of tree would be M*N at worst case 
 * @author Tony.Stark
 *
 */
public class Rat_In_Maze_Problem {

	public static List<String> rat_In_Maze_Problem(int[][] maze){
	
		if(maze == null || maze.length == 0) {
			return Collections.emptyList();
		}
		
		if(maze[0][0] == 0) {
			return Collections.emptyList();
		}
		
		int m = maze.length;// denote row
		int n = maze[0].length; // denote col
		
		if(maze[m-1][n-1] == 0) {
			return Collections.emptyList();
		}
		
		List<String> directions = new ArrayList<String>(); // containing result
		String direction = "";
		boolean[][] visited = new boolean[m][n];
		int row = 0, col = 0;
		findAllPossibleDirections(maze,visited,directions, direction,row,col,m,n);
		return directions;
	}
	

	private static void findAllPossibleDirections(int[][] maze, boolean[][] visited, List<String> directions,
															String direction, int row, int col, int m, int n) {
		
			// first check is direction valid to move or not
			if(!isDirectionValid(visited,row,col,m,n,maze)) {
				return;
			}
			// rat has reached end
			if(row == m-1 && col == n-1) {
				directions.add(direction);
				return;
			}
			// mark true to the visited cell
			visited[row][col] = true;
			
			// Direction - DOWN
			String newDirection = direction;
			newDirection+= "D"; // down move
			findAllPossibleDirections(maze, visited, directions, newDirection, row+1, col, m, n);

			// Direction - LEFT
			newDirection = direction;
			newDirection+= "L"; // left move
			findAllPossibleDirections(maze, visited, directions, newDirection, row, col-1, m, n);

			// Direction - RIGHT
			newDirection = direction;
			newDirection+= "R"; // right move
			findAllPossibleDirections(maze, visited, directions, newDirection, row, col+1, m, n);

			// Direction - UP
			newDirection = direction;
			newDirection+= "U"; // up move
			findAllPossibleDirections(maze, visited, directions, newDirection, row-1, col, m, n);
			visited[row][col] = false;
	}


	private static boolean isDirectionValid(boolean[][] visited, int row, int col, int m, int n, int[][] maze) {

		return ((row < m && row >=0) && (col < n && col >=0) && (maze[row][col] == 1) && !visited[row][col]) ? true : false; 
	}

	public static void main(String[] args) {
			int [][] maze = {{1,0,0,0},{1,1,0,0},{1,1,0,0},{0,1,1,1}};
			System.out.println(rat_In_Maze_Problem(maze));
			System.out.println(Rat_In_Maze_Problem1.rat_In_Maze_Problem(maze));
	}

}
