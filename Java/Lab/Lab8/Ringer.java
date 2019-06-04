import java.util.Random; // program use Random

// declaration of class Ringer with extending Player
public class Ringer extends Player {

	// Ringer constructor
	public Ringer( String s, Base b ) {
		super(s, b);
	}
	
	// create roll method
	public RollResult roll() {
		
		int[] vals = new int[2];
		Random randomNumbers = new Random(); // random number generator
	
		// pick random integer from 1 to 3
		vals[0] = randomNumbers.nextInt(3) + 1;
		vals[1] = randomNumbers.nextInt(3) + 1;
		
		String str = "  Rolled " + vals[0] + " " + vals[1];
		return new RollResult(vals, str);
	} // end roll method
} // end class Ringer
