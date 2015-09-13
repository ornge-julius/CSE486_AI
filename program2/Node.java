

import java.util.Comparator;
import java.util.ArrayList;
public class Node{
	public static class CostComparator implements Comparator<Node>{
		public int compare(Node a, Node b){
			if(a.cost > b.cost){
				return -1;
			} else if (a.cost < b.cost){
				return 1;
			} else {
				return 0;
			}
		}	
	}
	public int row;
	public int col;
	public int pRow;
	public int pCol;
	public int depth;
	public double cost;
	boolean hasMessage;
	public int numMess;
	public Node parent;
	//not sure how to use this one
	public String action;
	public String state;

	public Node(int r, int c, int pr, int pc, double co){
		this.hasMessage = false;
		this.row = r;
		this.col = c;
		this.cost = co;
		this.pRow = pr;
		this.pCol = pc;
		this.depth = 0;
		this.action = "";
		this.parent = null;
		this.state = "";

	}

	public Node(int r, int c){
		this.hasMessage = false;
		this.row = r;
		this.col = c;
		this.cost = 0.0;
		this.pRow = 0;
		this.pCol = 0;
		this.depth = 0;
		this.action = "";
		this.parent = null;
		this.numMess = 0;
		this.state = "";

	}

	//must have proper getters and setters
	//due to the way the board has to be
	//parsed and set up.

	public int getRow(){
		return this.row;
	}

	public int getCol(){
		return this.col;
	}
	
	public void setCost(double cost){
		this.cost = cost;
	}

	public void setParent(int pRow, int pCol){
		this.pRow = pRow;
		this.pCol = pCol;
	}

	public Node getParent(){
		return this.parent;
	}

	public int getDepth(){
		return this.depth;
	}

	public double getCost(){
		return this.cost;
	}

	public boolean hasMessage(){
		return this.hasMessage;
	}

	public void setMessage(){
		this.hasMessage = true;
	}
	
	public void gotMessage(){
		this.numMess += 1;
		this.hasMessage = false;
	}
	
	public void setParent(Node parent){
		this.parent = parent;
	}
	
	public void setAction(String a){
		this.action = a;
	}
	
	public String getAction(){
		return this.action;
	}

	public void setState(int row, int col, int messages){
		this.state = Integer.toString(row) + Integer.toString(col) + Integer.toString(messages);
	}
	
	public String getState(){
		return this.state;
	}

}




