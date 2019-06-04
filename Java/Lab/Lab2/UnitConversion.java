/*Name: Jaehyung Kim
ID Number: 47248972
Lab 2-Fall 2018*/

import java.util.Scanner; // program uses class Scanner

public class UnitConversion
{
  // application starting point
  public static void main(String[] args)
  {
    // create Scanner to obtain from command window
    Scanner input = new Scanner( System.in );
    
    double gallon = 0.264172; // initailize gallon
    double liter = 3.78541; // initailize liter
    double mile = 0.621; // initailize mile
    double kilometer = 1.609; // initailize kilometer

    System.out.println("1. liters to gallons: "); // first prompt 
    System.out.print("Please enter a value for liters: "); // nextline first prompt for input from user
    double liters = input.nextInt(); // input liters

    System.out.printf("%.1f liters  =  %.2f gallons\n", liters, liters * gallon); // calculate from liter to gallon and display value 
    System.out.println(); // output a newline


    System.out.println("2. gallons to liters: "); // second prompt
    System.out.print("Please enter a value for gallons: "); // nextline second prompt for input from user
    double gallons = input.nextInt(); // input gallons

    System.out.printf("%.1f gallons  =  %.2f liters\n", gallons, gallons * liter); // calculate from gallon to liter and display value 
    System.out.println(); // output a newline


    System.out.println("3. km to miles: "); // third prompt
    System.out.print("Please enter a value for kilometers: "); // nextline third prompt for input from user
    double kilometers = input.nextInt(); // input kilometers

    System.out.printf("%.1f km  =  %.2f miles\n", kilometers, kilometers * mile); // calculate from kilometers to miles and display value 
    System.out.println(); // output a newline


    System.out.println("4. miles to km: "); // fourth prompt
    System.out.print("Please enter a value for miles: "); // nextline fourth prompt for input from user 
    double miles = input.nextInt(); // input miles

    System.out.printf("%.1f miles  =  %.2f km\n", miles, miles * kilometer); // calculate from miles to kilometers and display value 
  } // end main
} // end UnitConversion


