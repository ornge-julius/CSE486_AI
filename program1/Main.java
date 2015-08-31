/*
	Simple A.I. program that simulates a robot's performance
	vacuuming a floor of 4 inline squares.

*/
import java.util.Scanner;
import java.io.*;

public class Main{

	public static void main(String[] args){
		Robot myRobo = new Robot();
		int floor[] = new int[4];
		int trials = 0;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter number of trials: ");
		trials = sc.nextInt();
		
		for(int i = 0; i < trials; i++){
			//randomly dirty squares
			for(int j = 0; j < 4; j++){
				floor[j] = (int)(Math.random() * 2);
			}
			
			//robot clean or move
			if (floor[myRobo.getPos()] == 1)
				floor = myRobo.clean(floor);
			else 
				myRobo.move();
			for(int k: floor){
				if (i == 0)
				myRobo.tally();
			}
		}
	}
}

