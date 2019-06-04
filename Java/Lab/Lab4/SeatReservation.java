/*Name: Jaehyung Kim
ID Number: 47248972
Lab 4-Fall 2018*/

import java.util.Scanner; // program uses class Scanner

public class SeatReservation {
	// application starting point 
	
	public static void main(String[] args) {

		// create Scanner to obtain input from command window
		Scanner input = new Scanner( System.in );
	
		// initialize arrays, price values, and total
		String[] rowASeats = {"1A", "2A", "3A"}; 
		String[] rowBSeats = {"1B", "2B", "3B"};
		double[] rowAPrices = {99.99, 110.99, 99.99};
		double[] rowBPrices = {75.99, 85.99, 75.99};
		double total = 0;
	
		display( rowASeats, rowBSeats, rowAPrices, rowBPrices ); // execute display method
		System.out.println("How many seats do you want to reserve? "); // prompt and input number of seats
		int numSeats = input.nextInt();
	
		// for loop to reserve number of seats
		for ( int i = 0; i < numSeats; i++ ) {
			
			System.out.print("Enter the row for the seat you want to reserve: (A/B)");
			String row = getRow(input);
		
			if ( row.equals("A") ) 
				total += makeReservation(rowASeats, rowAPrices, row, input);

			if ( row.equals("B") ) 
				total += makeReservation(rowBSeats, rowBPrices, row, input);
			
			System.out.printf("Your subtotal is: $%.2f\n", total);
			System.out.println("-----");
		} // end for loop
		
		printReceipt(numSeats, total); // print out receipt
	
	} // end main
	
	// declaration of method printing row of seats
		public static void printRowSeat(String[] rowSeats) {
			System.out.print("|");
			for ( int i = 0; i < rowSeats.length; i++) {
				System.out.printf("%-11s", rowSeats[i]);
			}
			System.out.print("|\n");
		} // end method printRowSeat
		
		// declaration of method printing row of prices
		public static void printRowPrices(double[] rowPrices) {
			System.out.print("|");
			for ( int i = 0; i < rowPrices.length; i++) {
				System.out.printf("$%-10.2f", rowPrices[i]);
			}
			System.out.print("|\n");
		} // end method printRowPrices

		// declaration of method getting row
		public static String getRow( Scanner scan ) {
			String row = scan.next(); 
			return row;
		} // end method getRow
	
	// declaration of method making reservation
	public static double makeReservation(String[] rowSeats, double[] prices, String row, Scanner scan) {
		
		// printing row of seats and prices for user
		System.out.println("===================================");
		printRowSeat( rowSeats );
		printRowPrices( prices );
		System.out.println("===================================");
		
		// prompt for selecting seat numbers to user
		System.out.println("Which seat number do you want?");
		int seatNum = scan.nextInt();
		
		// printing the selecting seat number and price
		System.out.println("The seat you selected is: " + seatNum + row);
		System.out.println("The price of the seat is: $" + prices[seatNum - 1]);

		// updating seat of chart
		updateSeatingChart( rowSeats, seatNum );
		
		// displaying updated row chart with "x" 
		System.out.println("Updated row chart: ");
		System.out.println("===================================");
		printRowSeat( rowSeats );
		printRowPrices( prices );
		System.out.println("===================================");

		return prices[seatNum - 1]; // return value of price
		
	} // end method makeReservation
	
	// declaration of method making reservation
	public static void updateSeatingChart(String[] rowSeats, int seatNum) {
		
		rowSeats[seatNum - 1] = "X";
	} // end method updateSeatingChart
	
	// declaration of method printing receipt
	public static void printReceipt(int numSeats, double total) {
		
		// initialization fees, taxes, and sum
		double fees = numSeats * 14.99;
		
		// question taxes
		double taxes = 16.99;
		double sum = total + fees + taxes;
		
		System.out.println("Thank you for reserving with us. Here's your receipt:");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.printf("Subtotal: $%.2f", total);
		System.out.println();
		System.out.printf("Fees: %d x $14.99 = $%.2f", numSeats, fees);
		System.out.println();
		System.out.printf("Taxes: $%.2f", taxes);
		System.out.println();
		System.out.println("=====================================================");
		System.out.printf("Taxes: $%.2f", sum);
		System.out.println();
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	} // end method printReceipt
	
	// declaration of method display row of seats and prices
	public static void display(String[] rowASeats, String[] rowBSeats, double[] rowAPrices, double[] rowBPrices) {
		
		System.out.print("Welcome to our event! Here's our seating chart with prices:\nSeating Chart\n");
		System.out.println("===================================");
		printRowSeat( rowASeats );
		printRowPrices( rowAPrices );
		System.out.println("-----------------------------------");
		printRowSeat( rowBSeats );
		printRowPrices( rowBPrices );
		System.out.println("===================================");
		
	} // end method display

} // end class SeatReservation


