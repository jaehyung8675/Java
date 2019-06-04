import java.util.Random; // program use Random

//declaration of class Ringer with extending Player
public class Dud extends Player {

	// Dud constructor
	public Dud( String s, Base b ) {
		super(s, b);
	}
	
	// create roll method
	public int[] roll() {
		
		Random randomNumbers = new Random(); // random number generator
		
		// pick random integer from 1 to 10
		int rollOne = randomNumbers.nextInt(10) + 1;
		int rollTwo = randomNumbers.nextInt(10) + 1;
		
		int[] arrayDud = new int[2];
		arrayDud[0] = rollOne;
		arrayDud[1] = rollTwo;
		
		return arrayDud;
	} // end roll method
} // end class Dud 
