import java.util.Random; // program use Random

//declaration of class Player
public class Player {

	// initializing player name, strikes, and balls
	private String name;
	private int strikes = 0;
	private int balls = 0;
	
	// initialize reference attribute for location
	private Base location;
	
	// Player constructor
	public Player( String s, Base b ) {
		
		location = new Base("Dugout");
		name = s;
		location = b;
	} // end Player constructor
	
	// boolean method isNotInDugout
	public boolean isNotInDugout() {
		/*
		if ( location.isDugout() != true ) {
			return true;
		} else {
			return false;
		}
		*/
		
		return !location.isDugout();
	} // end boolean method
	
	// create bat method
	public int bat() {
		
		Random randomNumbers = new Random(); // random number generator
		
		// pick random integer from 1 to 6
		int rollOne = 1 + randomNumbers.nextInt(6);
		int rollTwo = 1 + randomNumbers.nextInt(6);
		
		// print two roll values
		System.out.printf("  Rolled %d %d ", rollOne, rollTwo);
		
		int sum = rollOne + rollTwo; // initialize the total to store the sum of two values
		
		// if else to return the value based on the table
		if ( rollOne == 1 && rollTwo == 1 ) {
			System.out.print(" Single!\n");
			return 1;
		} else if ( rollOne == 2 && rollTwo == 2 ) {
			System.out.print(" Double!\n");
			return 2;
		} else if ( rollOne == 3 && rollTwo == 3 ) {
			System.out.print(" Triple!\n");
			return 3;
		} else if (rollOne == 4 && rollTwo == 4 ) {
			System.out.print(" Home run!\n");
			return 4;
		} else if ( sum % 2 == 0 ) {
			System.out.print(" Strike!\n");
			strikes++;
			return 0;
		} else {
			System.out.print(" Ball!\n");
			balls++;
			return 0;
		}
	} // end bat method
	
	// create takeTurn method
	public int takeTurn() {
		
		// set the values of strikes and balls attributes
		strikes = 0;
		balls = 0;
		
		// create while loop until the player gets a hit, four balls, or three strikes
		while ( true ) {
				
			int batting = bat(); // initialize batting 
				
			if ( batting > 0 ) {
				return batting;
			} else {
				
				// if 4 balls, display walk and return value  
				if ( balls == 4 ) {
					System.out.println("  Walk!!");
					return 1;
				}
				// if 3 strike, display strike out and return value  
				if ( strikes == 3 ) {
					System.out.println("  Strike out!!");
					return 0;
				}
			} // end if loop
		} // end while loop
	}
	
	// create toString method
	public String toString() {
		return name;
	}
	
	// create a getter and setter method
	public void setName( String s ) {
		name = s;
	}
	
	public String getName() {
		return name;
	}
	
	public void setLocation( Base b ) {
		location = b;
	}
	
	public Base getLocation() {
		return location;
	}
	
}
