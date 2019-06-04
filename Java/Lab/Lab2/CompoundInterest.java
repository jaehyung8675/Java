/*Name: Jaehyung Kim
ID Number: 47248972
Lab 2-Fall 2018*/

import java.util.Scanner; // program uses class Scanner
import java.lang.Math; // program uses class Math

public class CompoundInterest
{
  // application starting point
  public static void main(String[] args)
  {
    // create Scanner to obtain from command window
    Scanner input = new Scanner( System.in );

    System.out.println("Welcome to the compound interest calculator!"); // display comment
    System.out.print("Please enter the pricipal: "); // first prompt for input and obtain value
    int p = input.nextInt(); // input the pricipal value by user

 
    System.out.print("Please enter the annual interest rate: "); // second prompt for input and obtain value
    int r = input.nextInt(); // input the annual interest value by user
    
    System.out.print("Please enter the compounding periods per year: "); // third prompt for input and obtain value
    int n = input.nextInt(); // input the compounding year by user

    System.out.print("Please enter the term in years: "); // fourth prompt for input and obtain value
    int t = input.nextInt(); // input the term in years by user
    System.out.println(); // output a newline


    double result = Math.pow( 1 + (r * 0.01) / n, (n * t)); // calculate the part of result by using class Math
    double amount = p * result; // calculate the rest part of result by using multiplication

    System.out.printf("Amount Earned (A) : $%,.1f \n", amount); // display amount earned  
    System.out.printf( "Total Interest Earned: $%,.1f \n", amount - p); // display total interest earned by subtraction
  } // end main
} // end CompoundInterest