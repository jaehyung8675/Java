import java.util.Random; // program use Random

// declaration of class Ringer with extending Player
public class Ringer extends Player{

	// Ringer constructor
	public Ringer( String s, Base b ) {
		super(s, b);
	}
	
	// create roll method
	public int[] roll() {
		
		Random randomNumbers = new Random(); // random number generator
		
		// pick random integer from 1 to 3
		int rollOne = randomNumbers.nextInt(3) + 1;
		int rollTwo = randomNumbers.nextInt(3) + 1;
		
		int[] arrayRinger = new int[2];
		arrayRinger[0] = rollOne;
		arrayRinger[1] = rollTwo;
		
		return arrayRinger;
	} // end roll method
} // end class Ringer
