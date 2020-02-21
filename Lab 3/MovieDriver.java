import java.util.Scanner;

public class MovieDriver {
	public static void main (String[] args) {
		String movieTitle;
		String rating;
		int ticket;
		int choice;
		
		do {
		
		System.out.println("Enter the Movie title: ");
		Scanner input = new Scanner(System.in);
		movieTitle = input.nextLine();
		
		System.out.println("Enter the Movie rating: ");
		rating = input.nextLine();
		
		System.out.println("Enter the number of tickets sold: ");
		ticket = input.nextInt();
		
		Movie info = new Movie();
		info.setTitle(movieTitle);
		info.setRating(rating);
		info.setSoldTickets(ticket);
		
		System.out.println(info.toString());
		
		System.out.println("Do you want to continue ? If yes, press 1. if not, press 0 to exit. ");
		choice = input.nextInt();
		while (choice != 0 && choice != 1)
		{
			System.out.println("Wrong value !!!  Press 1 to continue or press 0 to exit. ");
			choice = input.nextInt();
		}
		
		} while (choice == 1);
		
		
		
	}
	

}
