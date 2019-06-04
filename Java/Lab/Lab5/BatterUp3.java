/*Name: Jaehyung Kim
ID Number: 47248972
Lab 5-Fall 2018*/

import java.util.Random; // program uses class Random

public class BatterUp3 {
	
	// initializing players and store names
	static String[] players = {"Odor", "Choo", "Gallo", "Andrus", "Profar", "Mazara", "Colon", "Minor", "Guzman"};
	
	public static void main(String[] args) {
				
		int outs = 0; // initialize outs
		
		// while loop until 3 outs
		while ( outs < 3 ) {
			
				// for loop through the players array
				for( int i = 0; i < players.length; i++ ) {
					
					System.out.printf("%s is at bat with %d outs\n", players[i], outs);
					
					// if the player's turn over by strike out, increment outs value
					if ( batterTakeTurn() == true )						
						outs++;
					
					// if outs equal three, break out of loop
					if ( outs == 3 )
						break;
				} // end for loop
					
			} // end while loop
							
		System.out.printf("%d outs - next team!", outs); // display 3 outs and next team
		
	} // end main method
	
	// declaration of method bat
	public static int bat() {
		
		Random randomNumbers = new Random(); // random number generator
		
		// pick random integer from 1 to 6
		int rollOne = 1 + randomNumbers.nextInt(6);
		int rollTwo = 1 + randomNumbers.nextInt(6);
		
		// print two roll values
		System.out.printf("  Rolled %d %d ", rollOne, rollTwo);
		
		int sum = rollOne + rollTwo; // initialize the total to store the sum of two values
		
		// if else to return the value based on the table
		if ( rollOne == 1 && rollTwo == 1 ) {
			return 1;
		} else if ( rollOne == 2 && rollTwo == 2 ) {
			return 2;
		} else if ( rollOne == 3 && rollTwo == 3 ) {
			return 3;
		} else if ( sum % 2 == 0 ) {
			return -1;
		} else {
			return -2;
		}
	} // end method bat
	
	// declaration of method boolean batter take turn
	public static boolean batterTakeTurn() {
		
		int ball = 0; // initialize ball
		int strike = 0; // initialize strike
		
		while ( true ) {
			
			int batting = bat(); // execute bat method and stores each return value generated  
				
				// if else to print the results of swing of the bat  
				if ( batting == 1 ) {
					System.out.print(" Single!\n");
					break; // terminate loop
					
				} else if ( batting == 2 ) {
					System.out.print(" Double!\n");
					break; // terminate loop
					
				} else if ( batting == 3 ) {
					System.out.print(" Triple!\n");
					break; // terminate loop
					
				} else if ( batting == 4 ) {
					System.out.print(" Home run!\n");
					break; // terminate loop
					
				} else if ( batting == -1 ) {
					System.out.print(" Strike!\n");
					strike++;
					
						// if 3 strike, terminate loop 
						if ( strike == 3 ) {
							System.out.println("  Strike out!!");
							return true;
						} // end if nested another if...else
					
				} else {
					System.out.print(" Ball!\n");
					ball++;
						
						// if 4 ball, terminate loop 
						if ( ball == 4 ) {
							System.out.println("  Walk");
							break;
						} // end if nested another if...else
				} // end if loop
		} // end while 
		
		return false;
		
	} // end method batterTakeTurn

} // end class BatterUp3
