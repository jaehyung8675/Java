import java.util.Scanner; // program uses class Scanner

public class Density {
	// application starting point
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the mass and volume for your 3 compounds.");
		
		// initializing two arrays
		double[] mass = new double[3];
		double[] volume = new double[3];
		
		// input two arrays of value from user
		for (int counter = 0; counter < 3; counter++) {
			
			System.out.print("\nEnter mass in grams: ");
			mass[counter] = input.nextDouble();
			
			System.out.print("\nEnter volume in milliliters: ");
			volume[counter] = input.nextDouble();
		
		}
		// pass two array reference
		calculateDensity(mass, volume);
		
	} // end main

	public static void calculateDensity(double[] mass, double[] volume) {
		
		// calucate density of two arrays and output the density
		for (int counter = 0; counter < 3; counter++) {
			double density = mass[counter] / volume[counter];
			System.out.printf("\nThe density for mass = %.2f g and volume = %.2f ml is: %.2f g/ml\n", mass[counter], volume[counter], density);
		}
	} // end method calculateDensity 

} // end class Density
