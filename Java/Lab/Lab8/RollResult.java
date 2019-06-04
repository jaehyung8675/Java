

public class RollResult {

	private int[] vals;
	private String output;
	
	public RollResult( int[] vals, String output ) {
		
		this.vals = vals;
		this.output = output;
	}
	
	
	// add getters and setters
	public void vals( int[] x ) {
		vals = x;
	}
	
	public int[] vals() {
		return vals;
	}
	
	public void output( String s ) {
		output = s;
	}
	
	public String output() {
		return output;
	}

}
