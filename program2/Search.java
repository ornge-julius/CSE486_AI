

import java.io.*;
import java.util.*;
public class Search{
	
	
	public static void main(String[] args){
		
		String type = args[0];
		String fileName = args[1];
		//BufferedReader br = new BufferedReader(new FileReader(fileName));
		Scanner in = new Scanner(fileName);
		int row = in.nextInt();
		int col = in.nextInt();
		Node [][] board = new Node[row][col];
		ArrayList<Integer> costList = new ArrayList<Integer>();

		//initialze board with empty nodes
		for(int i = row; i > 0; i--){
			for(int j = col; j > 0; j--){
				board[i][j] = new Node(i, j);
			}
		}
		
		
		//set messages
		for(int i = row; i > 0; i--){
			for(int j = col; j > 0; j--){
				if(in.next().equals("X")){
					board[i][j].setMessage();
				}
			}
		}

		//read costs
		String[][] strCosts = new String[row][col];
		int y = row;
		String strline ="";
		while(in.hasNextLine()){
			strline = in.nextLine();
			strCosts[y] = strline.split(" ");
			y--;
		
		}

		
		//parse and set costs
		for(int i = row; i > 0; i--){
			for(int j = col; j > 0; j--){
				board[i][j].setCost(Double.parseDouble(strCosts[i][j]));		
			}
		}


	}
}
