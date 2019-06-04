import java.util.ArrayList; // program use class ArrayList

import java.util.Scanner; // program use class Scanner
import java.io.PrintWriter; // program use class PrintWriter
import java.io.File; // program use class File

// declaration of class BatterUp
public class BatterUp {

	// initializing player name, strikes, balls, and store values 
	private int outs = 0;
	private int score = 0;
	private int nextPlayerIndex = 0;
	
	private ArrayList<Player> players = new ArrayList<Player>(); // create players ArrayList
	private Field theField; // initialize reference attribute for theField
	
	// BatterUp constructor
	public BatterUp() {
		
		theField = new Field();
		createPlayers(); // calling createPlayer method to create players
	}
	
	// create nine player's instances with two values and add to the ArrayList
	public void createPlayers() {
		
		// handling exceptions
		try {
			// read in text from external text file
			Scanner input = new Scanner(new File("players.txt"));
			
			while( input.hasNext() ) {
				
				input.useDelimiter(",|\n"); // multiple delimiters
				
				String name = input.next();
				String type = input.next();
				
				// if statements to create instance of Player, Dud, or Ringer
				if ( type.equalsIgnoreCase("Average") )
					players.add(new Player(name, theField.getDugout()));
				if ( type.equalsIgnoreCase("Dud") )
					players.add(new Dud(name, theField.getDugout()));
				if ( type.equalsIgnoreCase("Ringer") )
					players.add(new Ringer(name, theField.getDugout()));
		}

		} catch(Exception e) {
			System.out.print("Error reading file");
		}
	}
	
	// create getNextPlayer method
	public Player getNextPlayer() {
	
		// retrieve Player object from players ArrayList
		Player nextPlayer = players.get(nextPlayerIndex);
		nextPlayerIndex++; // increment the value of nextPlyaerIndex
		// if incrementing exceed the size, set it back
		if ( nextPlayerIndex >= players.size() ) {
			nextPlayerIndex = 0;
		}
		return nextPlayer;
	}
	
	// create play method
	public String play( int numberOfInnings ) {
		
		String str = ""; 
		
		for( int i = 1; i <= numberOfInnings; i++ ) {
			
			str += "Inning " + i + "\n"; // display inning
			
			// create while loop until three outs
			while ( outs != 3 ) {
				
				str += "\n" + "SCORE: " + score + "\n"; // display score
				str += "\n" + displayField() + "\n"; // execute displayField method to show current bases
				
				Player p = getNextPlayer();
				// System.out.printf( "%s is batting\n", p.getName() ); 
				str += p.getName() + " is batting" + "\n"; 
				
				// set the current player’s location to Base 
				p.setLocation(theField.getBatterBox());
				
				int bat = p.takeTurn(); // declare variable from takeTurn method
				str += p.getOutput();
				
				// if 0, increment outs and set the player’s location to Dugout
				if ( bat == 0 ) {
					outs++;
					p.setLocation(theField.getDugout());
					
				} else {
					str += movePlayers(bat); // else call the movePlayers
				} // end if loop
				
				p.resetOutput();
			
			} // end while loop
			
			// after 3outs, reset all players to Dugout
			for ( int j = 0; j < players.size(); j++ ) {
				Player p = getNextPlayer();
				p.setLocation(theField.getDugout());
			}
		
			outs = 0; // reset outs to zero
			str += "\n" + "THREE OUTS!" + "\n" + "INNING " + i + " OVER WITH A SCORE OF " + score + "\n" + "\n";
			
		} // end for loop
		
		printStats();
		score = 0;
		return str;
	}
	
	// create movePlayers method 
	public String movePlayers( int x ) {
		
		String str = "";
		
		// for loops through each players
		for ( int i = 0; i < players.size(); i++ ) {
			
			// if player do nothing and  continue the loop
			if ( players.get(i).isNotInDugout() == true ) { 
				
				Base newLocation = theField.moveAhead(players.get(i).getLocation(), x);
				players.get(i).setLocation( newLocation );
				
			// if player is the home, increment score, display that player scored, and put back to the Dugout
			if ( players.get(i).getLocation().isHome() == true ) {
					
				score++;
				str += players.get(i) + " scored!!" + "\n";
				players.get(i).setLocation(theField.getDugout());
				}
			} // end if loop
		} // end for loop
		
		return str;
	}

	// declaration of method displayField
	public String displayField () {
		
		String str = "";
		
		// initializing three bases with empty values
		String firstBase = "empty";
		String secondBase = "empty";
		String thirdBase = "empty";
		
		// for loop to locate player on three bases
		for ( int i = 0; i < players.size(); i++) {

			if ( players.get(i).getLocation() == theField.getFirst())
				firstBase = players.get(i).getName();
				
			if ( players.get(i).getLocation() == theField.getSecond())
				secondBase = players.get(i).getName();
				
			if ( players.get(i).getLocation() == theField.getThird())
				thirdBase = players.get(i).getName();
	
		} // end for loop
		
		str += "[ 1 ] " + firstBase + "  [ 2 ] " + secondBase + "  [ 3 ] " + thirdBase + "\n";
		
		return str;

	} // end method displayField
	
	// create printStats method to export text file
		public void printStats() {
			
			try {
				PrintWriter f = new PrintWriter("GAMESTATS.txt");
		
				f.println("GAME STATS: ");
				f.println("**************************************");
				f.printf("%-14s%-5s%-9s%s\n", "PLAYER", "HITS", "AT-BATS", "AVERAGE");
			
				for( int i = 0; i < players.size(); i++ ) {
					
					String name = players.get(i).getName();
					int hits = players.get(i).getHits();
					int atBats = players.get(i).getAtBats();
					double average = players.get(i).getBattingAverage();
			
					f.printf("%-14s%-5d%-9d%.3f\n", name, hits, atBats, average);
				}
				f.println("**************************************");
				f.close();
			}
			
			catch (Exception e) {
				System.out.println("Error writing file");
			}
		}
	
} // end class BatterUp
