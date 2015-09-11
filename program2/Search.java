

import java.io.*;
import Node;

public class Search{
	
	
	public static void main(String[] args){
		
		String type = args[0];
		String fileName = args[1];
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		int row = Integer.parseInt(br.read());
		int col = Integer.parseInt(br.read());
		Node [][] board = new Node[row][col];

		//initialze board with empty nodes
		for(int i = row; i > 0; i--){
			for(int j = col; j > 0; j--){
				board[i][j] = new Node(i, j);
			}
		}


		
		//set messages
		for(int i = row; i > 0; i--){
			for(int j = col; j > 0; j--){
				if(br.read().equals("X")){
					board[i][j].hasMessage();
				}
			}
		}

	}
}
