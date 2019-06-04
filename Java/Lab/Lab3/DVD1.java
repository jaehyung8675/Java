/*Name: Jaehyung Kim
ID Number: 47248972
Lab 3-Fall 2018*/

import java.util.Scanner; // program uses class Scanner

public class DVD1
{
// application starting point 
public static void main(String[] args)
{

// create Scanner to obtain input from command window
Scanner input = new Scanner( System.in );

int numOfDvds = 10; // initailize current number of DVD
double cashOnHand = 100; // initialize cash on hand
int buyDvdPrice = 9; // initialize buying the price of DVD from supplier 
int sellDvdPrice = 10; // initialize selling each DVD to customer
int option; // initialize option

// prompt and display options
System.out.println("Welcome to DVDs R Us. Please choose from the options below: "); 
System.out.println("1 – Buy DVDs");
System.out.println("2 – Sell DVDs");
System.out.println("3 – Check how many DVDs we have in stock"); 
System.out.println("4 – Check how much cash we have"); 
System.out.println("9 – Exit the program");
System.out.print("Enter Option: ");

option = input.nextInt(); // input option prompt from user
System.out.println(" "); // output a newline

while ( option != 9 ) // loop until sential value from user
{

if( option == 1 )
{

System.out.print("Enter the numbers of DVDs to buy: "); // option 1 prompt for owner
int numBuy = input.nextInt(); // input numbers of dvds to buy from user

  if ( cashOnHand >= numBuy * buyDvdPrice )
  {    
    numOfDvds += numBuy;
    cashOnHand = cashOnHand - numBuy * buyDvdPrice;

    System.out.printf("Number of DVDs: %d\n", numOfDvds); // calculate total number of DVDs
    System.out.printf("Cash available: $%.2f \n", cashOnHand); // calculate total cash available
  } else
  {
    System.out.print("You do not have enough money for this transaction \n");
  }

} else if( option == 2 ) // select option 2
{

System.out.print("How many Dvds to sell? "); // option 2 prompt for owner
int numSell = input.nextInt(); // input numbers of dvds to buy from user

  if ( numOfDvds >= numSell )
  {
    numOfDvds -= numSell;
    cashOnHand = cashOnHand + sellDvdPrice * numSell;

    System.out.printf("Number of DVDs: %d\n", numOfDvds); // calculate total number of DVDs
    System.out.printf("Cash available: $%.2f \n", cashOnHand); // calculate total cash available
  } else 
  {
    System.out.print("You do not have enough DVDs for this transaction \n");
  }


} else if( option == 3 ) // select option 3
{

System.out.printf("Number of DVDs: %d\n", numOfDvds); // display total number of DVDs

} else if( option == 4 ) // select option 4
{

System.out.printf("Cash available: $%.2f \n", cashOnHand); // display total cash available

} else 
{
  System.out.println("This option is not acceptable"); // display user enters wrong option
}

System.out.println(); // output a newline

System.out.println("Welcome to DVDs R Us. Please choose from the options below: "); 
System.out.println("1 – Buy DVDs");
System.out.println("2 – Sell DVDs");
System.out.println("3 – Check how many DVDs we have in stock"); 
System.out.println("4 – Check how much cash we have"); 
System.out.println("9 – Exit the program");
System.out.print("Enter Option: ");
option = input.nextInt(); // input option prompt from user

System.out.println(); // output a newline

} // end while

System.out.println("Thank you for shoppingwith us! Please return soon!."); // display a message for ending of the program

  } // end main
} // end DVD class