/*

This class hold the logic for a simple vacuuming robot

*/

public class Robot{

	public int score;
	public int position;
	public boolean moveRight;

	public Robot(){
		this.score = 0;
		this.position = 0;
		this.moveRight = true;

	}

	public int getScore(){
		return this.score;
	}

	public int getPos(){
		return this.position;
	}

	public void move(){
		if(this.position < 3 && moveRight){
			this.position++;
		} else if(this.position == 3 && moveRight){
			this.position--;
			this.moveRight = false;
		} else if(this.position > 0 && !moveRight){
			this.position--;
		} else {
			this.position ++;
			this.moveRight = true;
		}		
	}

	public int[] clean(int floor[]){
		 floor[this.position] = 0;
		 return floor;
		
	}

	public void tally(){
		this.score++;
	}
}
