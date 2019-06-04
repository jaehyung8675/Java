import java.util.ArrayList; // program use class ArrayList

//declaration of class Field
public class Field {

	private ArrayList<Base> bases = new ArrayList<Base>(); // create bases ArrayList
	
	// Create six Base instances and add to the ArrayList
	public Field() {
		bases.add(new Base("Dugout"));
		bases.add(new Base("BatterBox"));
		bases.add(new Base("First"));
		bases.add(new Base("Second"));
		bases.add(new Base("Third"));
		bases.add(new Base("Home"));
	}
	
	// getter Base named Dugout
	public Base getDugout() {
		return bases.get(0);
	}
	
	// getter Base named getBatterBox
	public Base getBatterBox() {
		return bases.get(1);
	}
	
	public Base getFirst() {
		return bases.get(2);
	}
	
	public Base getSecond() {
		return bases.get(3);
	}
	
	public Base getThird() {
		return bases.get(4);
	}
	
	// determine Base with two parameters
	public Base moveAhead( Base startingBase, int numberOfBases ) {
		
		int startingBaseIndexNumber = bases.indexOf( startingBase );
		// move ahead the number of bases, but don't exceed index location 5(home)
		int newBaseIndexNumber = Math.min(startingBaseIndexNumber + numberOfBases, 5);
		Base newBase = bases.get(newBaseIndexNumber);
		return newBase;
		
	} // end moveAhead method
} // end class Field
