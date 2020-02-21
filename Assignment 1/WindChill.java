import java.util.Scanner;
public class WindChill {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Welcome to this program! " 
				+"This program will helpe determine the wind chill by using " +
				"temperature and wind speed ");
		
		final double constantV = 0.4275;
		//Constant that will be multiplied with the temperature
		final double constantT = 0.6215;
		//Constant that will be multiplied with the wind speed
		final double constant1 = 35.74;
		final double constant2 = 35.75;
		double temp, windSpeed, windChill, expSpeed;
		String name = "Andrea Mabiala";
		int value;
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter the temperature (must be between -45F and 40 F)");
		temp = input.nextDouble();
		
		while (temp < -45 || temp > 40  )
		{
			System.out.println("This temperature is not in the range, please give another number)");
			temp = input.nextDouble();
		}
		
		System.out.println("Good! Now enter the wind speed");
		windSpeed = input.nextDouble();
		 
		while (windSpeed < 5 || windSpeed >  60 )
		{
			System.out.println("This value is not allowed, please give another number)");
			temp = input.nextDouble();
		}
		expSpeed = Math.pow(windSpeed, 0.16);
		windChill = constant1 + (constantT * temp) - (constant2 * expSpeed) + (constantV * expSpeed * temp);
		System.out.println("Thank you! The wind chill is " + windChill);
		
		System.out.println("Thank you for using this program!\n"+
		"Programmer:" + name);
		input.close();
	}

}
	
