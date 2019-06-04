/*Name: Jaehyung Kim
ID Number: 47248972
Lab 3-Fall 2018*/

import java.util.Scanner; // program uses class Scanner

public class DVD2
{

static int numOfDvds = 10; // initialize the current number of DVDs as class member variable
static double cashOnHand = 100; // initialize cash on hand in field
static int buyDvdPrice = 9; // initialize buying the price of DVD from supplier 
static int sellDvdPrice = 10; // initialize selling each DVD to customer
static int option; // initialize option

// application starting point 
public static void main(String[] args)
{

// create Scanner to obtain input from command window
Scanner input = new Scanner( System.in );

int num = input.nextInt();

displayMenu( input ); // execute displayMenu method
method(int a)
while ( option != 9 ) // loop until sential value from user
{
if( option == 1 ) // select option 1
{
buyDVD( input );
} else if( option == 2 ) // select option 2
{
sellDVD( input );
} else if( option == 3 ) // select option 3
{
getNumberOfDVDs();
} else if( option == 4 ) // select option 4
{
getCashOnHand();
} else 
{
System.out.println("This option is not acceptable"); // display user enters wrong option
}

System.out.println(); // output a newline
displayMenu( input ); // execute displayMenu method
 

} // end while

System.out.println("Thank you for shoppingwith us! Please return soon!."); // display a message for ending of the program

} // end main



// prompt and display options with Scanner parameter
public static int displayMenu( Scanner a )
{

// prompt and display options
System.out.println("Welcome to DVDs R Us. Please choose from the options below: "); 
System.out.println("1 – Buy DVDs");
System.out.println("2 – Sell DVDs");
System.out.println("3 – Check how many DVDs we have in stock"); 
System.out.println("4 – Check how much cash we have"); 
System.out.println("9 – Exit the program");
System.out.print("Enter Option: ");

option = a.nextInt(); // input option prompt from user
System.out.println(" "); // output a newline

return option;

} // end method displayMenu with int value


// declaration of method buyDVD with Scanner parameter
public static void buyDVD( Scanner a )
{

System.out.print("Enter the numbers of DVDs to buy: "); // option 1 prompt for owner
int numBuy = a.nextInt(); // input numbers of dvds to buy from user

  if ( cashOnHand >= numBuy * buyDvdPrice )
  {    
    numOfDvds += numBuy;
    cashOnHand = cashOnHand - numBuy * buyDvdPrice;

    getInventory(); 

  } else
  {
    System.out.print("You do not have enough money for this transaction \n");
  }
} // end buyDVD


// declaration of method getInventory
public static void getInventory()
{

System.out.printf("Number of DVDs: %d\n", numOfDvds); // calculate total number of DVDs
System.out.printf("Cash available: $%.2f \n", cashOnHand); // calculate total cash available

} // end getInventory


// declaration of method sellDVD with Scanner parameter
public static void sellDVD( Scanner a )
{

System.out.print("How many Dvds to sell? "); // option 2 prompt for owner
int numSell = a.nextInt(); // input numbers of dvds to buy from user

  if ( numOfDvds >= numSell )
  {
    numOfDvds -= numSell;
    cashOnHand = cashOnHand + sellDvdPrice * numSell;

    getInventory();

  } else 
  {
    System.out.print("You do not have enough DVDs for this transaction \n");
  }

} // end sellDVD


// declaration of method getNumberOfDVDs
public static void getNumberOfDVDs()
{

System.out.printf("Number of DVDs: %d\n", numOfDvds); // display total number of DVDs

} // end getNumberOfDVDs


// declaration of method getCashOnHand
public static void getCashOnHand()
{

System.out.printf("Cash available: $%.2f \n", cashOnHand); // display total cash available

} // end getCashOnHand


} // end DVD2 class