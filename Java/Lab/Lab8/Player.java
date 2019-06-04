import java.util.Random; // program use Random

//declaration of class Player
public class Player {

	// initializing player name, strikes, balls, and output
	private String name;
	private int strikes = 0;
	private int balls = 0;
	
	private int hits;
	private int atBats;
	
	private String output;
	
	// initialize reference attribute for location
	private Base location;
	
	// Player constructor
	public Player( String s, Base b ) {
		
		location = new Base("Dugout");
		name = s;
		location = b;
		
		hits = 0;
		atBats = 0;
		
		output = "";
		
	} // end Player constructor
	
	// create getter and setter output
	public String getOutput() {
		return output;
	}
	
	public void resetOutput() {
		output = "";
	}
	
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
	
	// create getBattingAverage method
	public double getBattingAverage() {
		return (double)hits / atBats; // calculate of the total atBats by the total hits
	} 
	
	// create roll method
	public RollResult roll() {
				
		int[] vals = new int[2];
		Random randomNumbers = new Random(); // random number generator
		
		// pick random integer from 1 to 6
		vals[0] = randomNumbers.nextInt(6) + 1;
		vals[1] = randomNumbers.nextInt(6) + 1;
				
		String str = "  Rolled " + vals[0] + " " + vals[1];
		return new RollResult(vals, str);
				
	} // end roll method
		
	// create bat method
	public int bat() {
			
		RollResult result = roll();
			
		// print two roll values
		// System.out.printf("  Rolled %d %d ", array[0], array[1]);
			
		int sum = result.vals()[0] + result.vals()[1]; // initialize the total to store the sum of two values
		
		// if else to return the value based on the table
		if ( result.vals()[0] == 1 && result.vals()[1] == 1 ) {
			// System.out.print(" Single!\n");
			output += result.output() + " Single!\n";
			return 1;
		} else if ( result.vals()[0] == 2 && result.vals()[1] == 2 ) {
			// System.out.print(" Double!\n");
			output += result.output() + " Double!\n";
			return 2;
		} else if ( result.vals()[0] == 3 && result.vals()[1] == 3 ) {
			// System.out.print(" Triple!\n");
			output += result.output() + " Triple!\n";
			return 3;
		} else if ( result.vals()[0] == 4 && result.vals()[1] == 4 ) {
			// System.out.print(" Home run!\n");
			output += result.output() + " Home run!\n";
			return 4;
		} else if ( sum % 2 == 0 ) {
			// System.out.print(" Strike!\n");
			output += result.output() + " Strike!\n";
			strikes++;
			return 0;
		} else {
			// System.out.print(" Ball!\n");
			output += result.output() + " Ball!\n";
			balls++;
			return 0;
		}
	} // end bat method
	
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
					// System.out.println("  Walk!!");
					output += "  Walk!!\n";
					return 1;
				}
				// if 3 strike, display strike out and return value  
				if ( strikes == 3 ) {
					// System.out.println("  Strike out!!");
					output += "  Strike out!!\n";
					return 0;
				}
			} // end if loop
		} // end while loop
	} // end takeTurn method
	
	// create toString method
	public String toString() {
		return name;
	}
	
	// create getter and setter methods
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

	public int getStrikes() {
		return strikes;
	}
	
	public int getBalls() {
		return balls;
	}
} // end class Player
