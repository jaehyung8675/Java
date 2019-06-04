import java.util.Scanner;

public class Triangle
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);

		int base;
		int height;
		double sum;
		
		System.out.print("Please enter a value for the base of a triangle? ");
		base = input.nextInt();

		System.out.print("Please enter a value for the height of a triangle? ");
		height = input.nextInt();

		sum = (double)base*height/2;

		System.out.printf("The area of the triangle is %.1f \n", sum);
	}

}
