import java.util.Random; // program use Random

//declaration of class Player
public class Player {

	// initializing player name, strikes, and balls
	private String name;
	private int strikes = 0;
	private int balls = 0;
	
	private int hits;
	private int atBats;
	
	// initialize reference attribute for location
	private Base location;
	
	// Player constructor
	public Player( String s, Base b ) {
		
		location = new Base("Dugout");
		name = s;
		location = b;
		
		hits = 0;
		atBats = 0;
		
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
	
	// create roll method
	public int[] roll() {
		
		Random randomNumbers = new Random(); // random number generator
		
		// pick random integer from 1 to 6
		int rollOne = 1 + randomNumbers.nextInt(6);
		int rollTwo = 1 + randomNumbers.nextInt(6);
		
		int[] array = new int[2];
		array[0] = rollOne;
		array[1] = rollTwo;
		
		return array;
	} // end roll method
	
	// create getBattingAverage method
	public double getBattingAverage() {
		return (double)hits / atBats; // calculate of the total atBats by the total hits
	} 
	
	// create takeTurn method
	public int takeTurn() {
		
		// set the values of strikes and balls attributes
		strikes = 0;
		balls = 0;
		atBats++;
		
		// create while loop until the player gets a hit, four balls, or three strikes
		while ( true ) {
			
			int batting = bat(); // initialize batting 
				
			if ( batting > 0 ) {
				hits++; 
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
	} // end takeTurn method
	
	// create bat method
	public int bat() {
		
		//Random randomNumbers = new Random(); // random number generator
		
		// pick random integer from 1 to 6
		//int rollOne = 1 + randomNumbers.nextInt(6);
		//int rollTwo = 1 + randomNumbers.nextInt(6);
		
		int array[] = roll();
		
		// print two roll values
		System.out.printf("  Rolled %d %d ", array[0], array[1]);
		
		int sum = array[0] + array[1]; // initialize the total to store the sum of two values
		
		// if else to return the value based on the table
		if ( array[0] == 1 && array[1] == 1 ) {
			System.out.print(" Single!\n");
			return 1;
		} else if ( array[0] == 2 && array[1] == 2 ) {
			System.out.print(" Double!\n");
			return 2;
		} else if ( array[0] == 3 && array[1] == 3 ) {
			System.out.print(" Triple!\n");
			return 3;
		} else if ( array[0] == 4 && array[1] == 4 ) {
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
	
	// create toString method
	public String toString() {
		return name;
	}
	
	// create a getter and setter method
	public void setHits( int x ) {
		hits = x;
	}
	
	public int getHits() {
		return hits;
	}
	
	public void setAtBats( int y ) {
		atBats = y;
	}
	
	public int getAtBats() {
		return atBats;
	}
	
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
} // end class Player
