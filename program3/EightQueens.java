/**
 * There are three EightQueens "solutions". Only one of them is correct.
 * Figure out which one. Notice that there is only one board that
 * is recursively altered. This means the memory requirements are linear.  
 */
import java.util.*;
public class EightQueens {
	public static final int N = 6;
	enum Square { EMPTY, QUEEN };
	public static Square [][] brd = new Square [N][N];
	
	/**
	 * Determines if a square contains a queen
	 * @param brd Board
	 * @param r row
	 * @param c column
	 * @return true if the square contains a queen, false if the square
	 *       is empty or not a valid location
	 */
	public static boolean hasQueen(Square [][] brd, int r, int c)
	{ return r >= 0 && r < N && c >= 0 && c < N && brd[r][c] == Square.QUEEN; }
	/**
	 * Determines if a queen is attacked by another queen. Not really
	 * done efficiently.
	 * @param brd Board
	 * @param r row
	 * @param c column
	 * @return true if the queen at (r, c) is attacked by another queen
	 */
	public static int numAttacked(Square [][] brd, int r, int c)
	{	int value = 0;
		for (int i=0; i<N; i++) {
			if (hasQueen(brd, r, c-i) ||hasQueen(brd, r-i, c-i) ||
				hasQueen(brd, r+i, c-i)) {
						value++;
			}
		}
		return value;
	}

	/**

	 * Determines if a queen is attacked by another queen. Not really

	 * done efficiently.

	 * @param brd Board

	 * @param r row

	 * @param c column

	 * @return true if the queen at (r, c) is attacked by another queen

	 */

	public static boolean attacked(Square [][] brd, int r, int c)

	{

		for (int i=1; i<N; i++) {

			if (hasQueen(brd, r-i, c) || hasQueen(brd, r+i, c) ||

				hasQueen(brd, r, c-i) || hasQueen(brd, r, c+i) ||

				hasQueen(brd, r-i, c-i) || hasQueen(brd, r+i, c+i) ||

				hasQueen(brd, r+i, c-i) || hasQueen(brd, r-i, c+i)) {

						return true;

			}

		}

		return false;

	}


	/**
	 * Returns true if the brd has N queens placed, without
	 * any of them attacking each other.
	 * @param brd Chess board
	 * @return true if board configuration is N-Queens solution
	 */
	public static boolean isSolution(Square [][] brd)
	{ 
		int cnt = 0;
		for (int r=0; r<N; r++) {
			for (int c=0; c<N; c++) {
				if (brd[r][c] == Square.QUEEN) {
					if (attacked(brd, r, c)) {
						return false;
					} else {
						cnt++;
					}
				}
			}
		}
		return cnt == N;
	}
	/**
	 * Prints out the board to the console
	 * @param brd Chess board
	 */
	public static void print(Square [][] brd)
	{
		String str = ".Q";
		for (int r=0; r<N; r++) {
			for (int c=0; c<N; c++) {
				System.out.print(str.charAt(brd[r][c].ordinal()));
			}
			System.out.println();
		}
		System.out.println();
	}
	/**
	 * Sets the chess board to all empty squares
	 * @param brd Chess board to be cleared
	 */
	public static void clearBoard(Square [][] brd)
	{
		for (int r=0; r<N; r++) {
			for (int c=0; c<N; c++) {
				brd[r][c] = Square.EMPTY;
			}
		}
	}

	public static void clearCol(Square [][] brd, int c){
		
			for(int r=0; r<N; r++) {
				brd[r][c] = Square.EMPTY;
			}
	}
	
	/** eightQueens*
	 * Prints out all N-Queen solutions
	 * @param col next column to place queen
	 * @param brd chess board
	 * @return number of solutions
	 */
		
	public static int eightQueens(int col, Square [][] brd)
	{
		int cnt = 0;
		if (col == N) {
			if (isSolution(brd)) {
				cnt = 1;
				print(brd);
			}
		} else {
			for (int row=0; row<N; row++) {
				brd[row][col] = Square.QUEEN;
				cnt += eightQueens(col+1, brd);
				brd[row][col] = Square.EMPTY;
			}
		}
		return cnt;
	}
	public static int eightQueens()
	{
		clearBoard(brd);
		return eightQueens(0, brd);
	}

	public static void main(String[] args)
	{
		/*int nSolutions;
		System.out.println(N + " Queens #1");
		nSolutions = eightQueens();
		System.out.println(nSolutions);*/
		Random rand = new Random();
		Square [][] brd = new Square [6][6];
		int tally = 0;
		for(int count = 0; count < 10000; count++){
				for(int i = 0; i < 6; i ++){
					for(int j = 0; j < 6; j++){
						brd[i][j] = Square.EMPTY;
					}
				}
				int value = 0;
				for(int i = 0; i < 6; i++){
					value = rand.nextInt(6);
					brd[value][i] = Square.QUEEN;
				}
				
				//EightQueens.print(brd);
				int minAttack = 100;
				int x = 0;
				int y = 0;
				for(int j = 0; j < 6; j++){
					minAttack = 100;
					for(int i = 0; i<6; i++){
						if(EightQueens.numAttacked(brd, i,j)  < minAttack){
							minAttack = EightQueens.numAttacked(brd, i, j);
							x = i;
							y = j;
						}
						//System.out.println(brd[j][0]);	
					}
					EightQueens.clearCol(brd, y);
					brd[x][y] = Square.QUEEN;
				}
				if(EightQueens.isSolution(brd))
					tally++;
				//EightQueens.clearCol(brd, 1);
				//EightQueens.print(brd);
			}
			System.out.println(tally);
	}
}
