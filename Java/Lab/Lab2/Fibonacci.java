/*Name: Jaehyung Kim
ID Number: 47248972
Lab 2-Fall 2018*/

import java.util.Scanner; // program uses class Scanner

public class Fibonacci
{
  // application starting point
  public static void main(String[] args)
  {
    // create Scanner to obtain input from command window
    Scanner input = new Scanner(System.in);

    System.out.println("Fibonacci sequence: "); // display the tile of application
    System.out.print("How many numbers do you want to have in the sequence?\n"); // first prompt
    System.out.print("(It must be greater than 2.)\n"); // nextline first prompt for input from user
    int total = input.nextInt(); // input total sequence

    System.out.print("Do you want to skip the odd numbers? 1=yes,2=no \n"); // second prompt for input and obtain value from user
    int user = input.nextInt(); // input odd number or not by user
    
    int a = 0; // initialization first value
    int b = 1; // initialization second value
    int sum; // initialization sum

    // determine odd number by user
    if(user == 1) // if result 1,
    {
      System.out.printf("%5d %10d\n", 1, a); // display first line
      System.out.printf("%5d %10s\n", 2, " "); // display second line 
     
      // for statement inlcudes inlcudes sequence initialization
      // loop-continuation condition, loop as total times and increment 
      for(int sequence = 3; sequence <= total; sequence++ )
      {
        sum = a + b; // add first value to second value

        // if...else nested in for
        if( sum % 2 == 0 ) // determine the odd number
        {
          System.out.printf("%5d %10d\n", sequence, sum); // termination phase : display odd numbers
        } else // else result is not odd numbers
        {
          System.out.printf("%5d %10s\n", sequence, " "); // termination phase : empty space in unodd
        } // end if

        a = b; // replace second value to first value
        b = sum; // replace sum to second value

      } // end for
    } // end if

    // determine not odd number by user
    if(user == 2) // if result 2,
    {
      System.out.printf("%5d %10d\n", 1, a); // display first line
      System.out.printf("%5d %10d\n", 2, b); // display second line

      // for statement inlcudes sequence initialization
      // loop-continuation condition, loop as total times and increment
      for(int sequence = 3; sequence <= total; sequence++ )
      {
        sum = a + b; // add first value to second value
        System.out.printf("%5d %10d\n", sequence, sum); // termination phase : display third squence with value
        a = b; // replace second value to first value
        b = sum; // replace sum to second value
      }//end for
    }

  } // end main
} // end Fibonacci