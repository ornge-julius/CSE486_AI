

import java.io.*;
import java.util.*;
public class Search{
	
	
	public static void main(String[] args){
		
		String type = args[0];
		String fileName = args[1];
		//BufferedReader br = new BufferedReader(new FileReader(fileName));
		try{
			File myFile = new File(fileName);
			Scanner in = new Scanner(myFile);
			int row = in.nextInt();
			int col = in.nextInt();
			//System.out.println(row + " " +col);
			Node [][] board = new Node[row][col];
			ArrayList<Integer> costList = new ArrayList<Integer>();

				//initialze board with empty nodes
				for(int i = 0; i < row; i++){
					for(int j = 0; j < col; j++){
						board[i][j] = new Node(i, j);
					}
				}
				
				//set messages
				for(int i = row; i > 0; i--){
					for(int j = col; j > 0; j--){
						if(in.next().equals("X")){
							board[i-1][j-1].setMessage();
						}
					}
				}

				//set costs
				for(int i = row; i > 0; i--){
					for(int j = col; j > 0; j--){
						board[i-1][j-1].setCost(in.nextDouble());		
					}
				}


			} catch (Exception ex){
			ex.printStackTrace();
			
			}
	}
}
