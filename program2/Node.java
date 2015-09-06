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
	ArrayList<String> message;
	//not sure how to use this one
	String action;

	public Node(int r, int c, int pr, int pc, double co){
		this.row = r;
		this.col = col;
		this.cost = co;
		this.pRow = pr;
		this.pCol = pc;
		this.depth = 0;
		this.action = "";
		this.message = new ArrayList<String>();

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
		return this.message.toArray();
	}

}




