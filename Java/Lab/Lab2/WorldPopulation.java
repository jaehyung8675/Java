/*Name: Jaehyung Kim
ID Number: 47248972
Lab 2-Fall 2018*/

public class WorldPopulation
{
  // application starting point
  public static void main(String[] args)
  {
    double population = 7.6440; // initialize population

    System.out.printf("%4s %20s (billions) \n", "Year", "World Population"); // displace contents on first line
    System.out.println("-------------------------------------------"); // display straight line

    // for repetition statement includes year initialization from 2018 to 2043
    for(int year = 2018; year <= 2043; year++)
    {
      System.out.printf("%d %20f\n", year, population); // display increasing year and population
      population = 1.0109 * population; // calculate population with annual growth rate of per year
    } // end for

  } // end main
} // end WorldPopulation

