/*
	Simple A.I. program that simulates a robot's performance
	vacuuming a floor of 4 inline squares.

*/
import java.util.Scanner;
import java.util.Random;
import java.io.*;

public class Main{

	public static void main(String[] args){
		double S = Double.parseDouble(args[0]) * 1000;
		double D = Double.parseDouble(args[1]) * 1000;
		Robot myRobo = new Robot();
		int floor[] = new int[4];
		int trials = 0;
		int Sx = (int)S;
		int Dx = (int)D;
		trials = 10000;
		
		for(int i = 0; i < trials; i++){
			//randomly dirty squares
			//need to randomly generate dirt based on D
			for(int j = 0; j < floor.length; j++){
				int result = (int)(Math.random()*100);
				if(result < Dx){
					//tile is dirty D % of the time
					floor[j] = 1;
				} else {
					floor[j] = 0;
				}
			}
			
			//robot clean or move
				
				if (floor[myRobo.getPos()] == 1){
					//clean should take an argument S for a suck percentage
					int result2 = (int)(Math.random()*100);
					if(result2 < Sx)
						//clean works S% of the time
						floor = myRobo.clean(floor);
				} else { 
					myRobo.move();
				for(int k = 0; k < floor.length; k++){
					// for every clean tile, add to the 
					// robot's score
					if (floor[k] == 0)
					myRobo.tally();
				}
			}
		}

	System.out.println("Robot Score: " + myRobo.getScore());
	}
}
