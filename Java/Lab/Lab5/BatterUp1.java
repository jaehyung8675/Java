/*Name: Jaehyung Kim
ID Number: 47248972
Lab 5-Fall 2018*/

import java.util.Random; // program uses class Random

public class BatterUp1 {

	public static void main(String[] args) {
		
		// loop 10 times
		for (int counter = 0; counter < 10; counter++) {
			
			int batting = bat(); // execute bat method and stores each return value generated  
			
			// if else to print the results of swing of the bat  
			if ( batting == 1 ) {
				System.out.print(" Single\n");
			} else if ( batting == 2 ) {
				System.out.print(" Double\n");
			} else if ( batting == 3 ) {
				System.out.print(" Triple\n");
			} else if ( batting == 4 ) {
				System.out.print(" Home run\n");
			} else if ( batting == -1 ) {
				System.out.print(" Strike!\n");
			} else {
				System.out.print(" Ball!\n");
			}
		} // end for loop

	} // end main method
	
	public static int bat() {
		
		Random randomNumbers = new Random(); // random number generator
		
		// pick random integer from 1 to 6
		int rollOne = 1 + randomNumbers.nextInt(6);
		int rollTwo = 1 + randomNumbers.nextInt(6);
		
		// print two roll values
		System.out.printf("Rolled %d %d ", rollOne, rollTwo);
		
		int sum = rollOne + rollTwo; // initialize the total to store the sum of two values
		
		// if else to return the value based on the table
		if ( rollOne == 1 && rollTwo == 1 ) {
			return 1;
		} else if ( rollOne == 2 && rollTwo == 2 ) {
			return 2;
		} else if ( rollOne == 3 && rollTwo == 3 ) {
			return 3;
		} else if ( sum % 2 == 0 ) {
			return -1;
		} else {
			return -2;
		}
		
	} // end method bat

} // end class BatterUp1
