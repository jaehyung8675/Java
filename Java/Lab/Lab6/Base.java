// declaration of class Base
public class Base {

	private String name; // initialize name attribute
	
	// Base constructor
	public Base( String s ) {
		name = s;
	} // end Base constructor
	
	// create a getter and setter method
	public void setName( String s ) {
		name = s;
	}

	public String getName() {
		return name;
	}
	
	// boolean method isDugout and isHome
	public boolean isDugout() {
		
		// if the value is Dugout return true, otherwise return false
		if ( name == "Dugout" ) {
			return true;
		} 
		return false;
		
	} // end boolean method isDugout
	
	public boolean isHome() {
		
		// if the value is Home return true, otherwise return false
		if ( name == "Home" ) {
			return true;
		} 
		return false;
		
	} // end boolean method isHome
	
	// create toString method
	public String toString() {
		return name;
	} // end toString method
} // end class Base
