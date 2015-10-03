

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
				in.next();
				in.next();
				for(int i = row; i > 0; i--){
					for(int j = 0; j < col; j++){
						if(in.next().equals("X")){
							board[i-1][j].setMessage();
					}
					}
				}

				//set costs
				for(int i = row; i > 0; i--){
					for(int j = 0; j < col; j++){
						board[i-1][j].setCost(in.nextDouble());		
					}
				}
				//test setMessage
					for(int i = 0; i < row; i++){
							for(int j = 0; j < col; j++){
								System.out.println(i +", " +j+ ":" + board[i][j].getCost());
							}
				}
					//test setMessage
					for(int i = 0; i < row; i++){
							for(int j = 0; j < col; j++){
								System.out.println(i +", " +j+ ":" + board[i][j].hasMessage());
							}
				}
				
				//implement BFS
				boolean goalState = false;
				ArrayList<Node> frontier = new ArrayList<Node>();
				ArrayList<String> explored = new ArrayList<String>();
				frontier.add(board[0][0]);
				int numMess = 0;
				board[0][0].setState(0,0,0);
				System.out.println(board[0][0].getState());
				do{
					System.out.println(frontier.get(0).getState());
					//System.out.println("debug");
					//check to see if explored
					if(!explored.contains(frontier.get(0).getState())){
						//collect message, update state
						Iterator itr = frontier.iterator();
						int x = frontier.get(0).getRow();
						int y = frontier.get(0).getCol();
						Node temp = frontier.get(0);
						if(frontier.get(0).hasMessage()){
							numMess++;
							//todo: check logic here, might need to add more for adding to explored
							//this could be a problem
							//might just be changing a copy of the node
							//Node temp = new Node(frontier.get(0).getRow(), frontier.get(0).getCol());
							board[x][y].setState(board[x][y].getRow(), board[x][y].getCol(), numMess);
							board[x][y].gotMessage();
						} 

						//is it the goalState??
						//todo: create goaState from number of messages on the board
						// right now just assuming number of messages is 3
						if(frontier.get(0).getState().equals("002")){
							Node thisNode = frontier.get(0);
							goalState = true;
							ArrayList<String> path = new ArrayList<String>();
							while(thisNode.getParent() != null){
								path.add(thisNode.getAction());
								thisNode = thisNode.getParent();

							}
							System.out.println(Arrays.toString(path.toArray()));
							return;
						}

						//expand and set states for new nodes/children
						if(x+1 < board.length){
							board[x+1][y].setParent(frontier.get(0));
							board[x+1][y].setAction("N");
							board[x+1][y].setState(x+1,y,numMess);
							frontier.add(board[x+1][y]);
						}
						if(y+1 < board[0].length){
							board[x][y+1].setParent(frontier.get(0));
							board[x][y+1].setAction("E");
							board[x][y+1].setState(x,y+1,numMess);
							frontier.add(board[x][y+1]);
						}
						if(x-1 >=0){
							board[x-1][y].setParent(frontier.get(0));
							board[x-1][y].setAction("S");
							board[x-1][y].setState(x-1,y,numMess);
							frontier.add(board[x-1][y]);
						}
						if(y-1 >=0){
							board[x][y-1].setParent(frontier.get(0));
							board[x][y-1].setAction("W");
							board[x][y-1].setState(x,y-1,numMess);
							frontier.add(board[x][y-1]);
						}

						//add state to explored
						explored.add(frontier.get(0).getState());
						frontier.remove(0);
					}
					//go to next node
					frontier.remove(0);	
				} while(!goalState);


			} catch (Exception ex){
			ex.printStackTrace();
			
			}
	}
}
