import java.util.Scanner;

public class SphereVolume {
	/*This program calculates the volume of sphere by using its radius. Helps practicing math functions
	 *and all other notions learned thus far.
	*/

	public static void main(String[] args) {
		double diameter;
		double radius;
		double volume;
		double radius_cube;//To store the value of the math power
		
		
		System.out.println("Welcome! This program helps calculating the volume of the sphere using the diameter."
				+"\nLet's start! Enter a diameter:");
		
		Scanner input = new Scanner(System.in);
		diameter = input.nextDouble();
		while ( diameter <= 0)
		{
			System.out.println("Please eneter a valid value, the diameter cannot be negative.");
			diameter = input.nextDouble();
		}
		
		radius = diameter/2;
		radius_cube = Math.pow(radius, 3);
		volume = (4.0/3.0)* Math.PI * radius_cube;
		System.out.println("The volume is "+ volume + ".\nThank you for using this program. Goodbye!");

	}

}
