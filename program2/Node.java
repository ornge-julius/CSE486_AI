

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
	ArrayList<String> message;
	//not sure how to use this one
	String action;

	public Node(int r, int c, int pr, int pc, double co){
		this.hasMessage = false;
		this.row = r;
		this.col = c;
		this.cost = co;
		this.pRow = pr;
		this.pCol = pc;
		this.depth = 0;
		this.action = "";
		this.message = new ArrayList<String>();

	}

	public Node(int r, int c){
		this.hasMessage = false;
		this.row = r;
		this.col = c;
		this.cost = 0;
		this.pRow = 0;
		this.pCol = 0;
		this.depth = 0;
		this.action = "";
		this.message = new ArrayList<String>();

	
	}

	//must have proper getters and setters
	//due to the way the board has to be
	//parsed and set up.

	public void setCost(int cost){
		this.cost = cost;
	}

	public void setParent(int pRow, intpCol){
		this.pRow = pRow;
		this.pCol = pCol;
	}

	public int[] getParent(){
		int [] par = {this.pRow, this.pCol};
		return par;
	}

	public int getDepth(){
		return this.depth;
	}

	public double getCost(){
		return this.cost;
	}

	public void gotMessage(String s){
		this.message.add(s);
	}

	public Object[] messages(){
		//return array of messages gotten
		return this.message.toArray();
	}

}




