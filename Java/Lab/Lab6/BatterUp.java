import java.util.ArrayList; // program use class ArrayList

//declaration of class BatterUp
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
		
		players.add(new Player("Odor", theField.getDugout()));
		players.add(new Player("Choo", theField.getDugout()));
		players.add(new Player("Gallo", theField.getDugout()));
		players.add(new Player("Andrus", theField.getDugout()));
		players.add(new Player("Profar", theField.getDugout()));
		players.add(new Player("Mazara", theField.getDugout()));
		players.add(new Player("Colon", theField.getDugout()));
		players.add(new Player("Minor", theField.getDugout()));
		players.add(new Player("Guzman", theField.getDugout()));
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
	public void play() {
		
		// create while loop until three outs
		while ( outs != 3 ) {
			
			System.out.printf("SCORE: %d\n", score); // display score
			System.out.println();
			
			displayField(); // execute displayField method to show current bases
			
			Player p = getNextPlayer();
			System.out.printf( "%s is batting\n", p.getName() ); // display player's bat
			
			// set the current player’s location to Base 
			p.setLocation(theField.getBatterBox());
			
			int bat = p.takeTurn(); // declare variable from takeTurn method
			
			// if 0, increment outs and set the player’s location to Dugout
			if ( bat == 0 ) {
				outs++;
				p.setLocation(theField.getDugout());
				
			} else {
				movePlayers(bat); // else call the movePlayers
			} // end if loop
			
			System.out.println();
			
		} // end while loop
		
		System.out.printf("THREE OUTS!\nGAME OVER WITH A SCORE OF %d", score); // display 3 outs with score
	}
	
	// create movePlayers method 
	public void movePlayers( int x ) {
		
		// for loops through each players
		for ( int i = 0; i < players.size(); i++ ) {
			
			// if player do nothing and  continue the loop
			if ( players.get(i).isNotInDugout() == true ) { 
				
				Base newLocation = theField.moveAhead(players.get(i).getLocation(), x);
				players.get(i).setLocation( newLocation );
				
				// if player is the home, increment score, display that player scored, and put back to the Dugout
				if ( players.get(i).getLocation().isHome() == true ) {
					
					score++;
					System.out.printf("%s scored!!\n", players.get(i));
					players.get(i).setLocation(theField.getDugout());
				}
			} // end if loop
		} // end for loop
	}

	// declaration of method displayField
	public void displayField () {
		
		// initializing three bases with empty values
		String firstBase = "empty";
		String secondBase = "empty";
		String thirdBase = "empty";
		
		// for loop to locate player on three bases
		for ( int i = 0; i < players.size(); i++) {

			if ( players.get(i).getLocation().getName().equalsIgnoreCase("First"))
				firstBase = players.get(i).getName();
				
			if ( players.get(i).getLocation().getName().equalsIgnoreCase("Second"))
				secondBase = players.get(i).getName();
				
			if ( players.get(i).getLocation().getName().equalsIgnoreCase("Third"))
				thirdBase = players.get(i).getName();
	
		} // end for loop
		
		// display player's name on bases 
		System.out.printf("[ 1 ] %s  [ 2 ] %s  [ 3 ] %s \n", firstBase, secondBase, thirdBase);
		System.out.println();
		} // end method displayField

}
