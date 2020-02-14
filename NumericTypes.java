/*This program demonstrates how numeric types and operators behave in Java
*/
import java.util.Scanner;

public class NumericTypes {
	public static void main(String[] args) {
		//TASK #2 Create a Scanner object here 
				//identifier declarations
				final int NUMBER = 2; // number of scores
				int score1; // first test score
				int score2; // second test score
				final int BOILING_IN_F = 212; // boiling temperature
				double temperature;//In Fahrenheit
				double fToC; // temperature in Celsius
				double average; // arithmetic average
				String output; // line of output to print out
		
				Scanner input = new Scanner(System.in);
				
				System.out.println("Enter the 1st score:");
				score1 = input.nextInt();
				System.out.println("Enter the 2nd score:");
				score2 = input.nextInt();
				average = (double) (score1 + score2) / NUMBER;
				output = score1 + " and " + score2 + " have an average of " + average;
				System.out.println(output);
				
				fToC = (double)5/9 * (BOILING_IN_F - 32);
				output = BOILING_IN_F + " in Fahrenheit is " + fToC + " in Celsius.";
				System.out.println(output);
				// Convert Fahrenheit temperatures to Celsius
				System.out.println("Give me a tenperature in Fahrenheit:");
				temperature = input.nextDouble();
				fToC = (5.0/9.0) * (temperature - 32);
				output = temperature + " in Fahrenheit is " + fToC + " in Celsius.";
				System.out.println(output);
				
				System.out.println("Goodbye"); // to show that the program is ended

	}
}