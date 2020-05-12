package first;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class MovieTicketManager implements MovieTicketManagerInterface {
	
	private static ArrayList<Ticket> ticketList = new ArrayList<Ticket>();
	
	public MovieTicketManager(){
		
	}
	
	public int numVisits (int id) {
		
		int visits = 0;
		
		for (Ticket ticket : ticketList) {
            if (ticket.getId() == id) 
                visits++;
        }

        return visits;
	}
	
	public boolean visits(int id) {
		boolean excess = false;
		if(numVisits(id) > 2)
			excess = true;
		
		return excess;
	}
	
	public int numThisMovie(int id, String m) {
		int movie = 0;
		
		for (Ticket ticket : ticketList) {
            if (ticket.getName() == m && ticket.getId() == id) 
                movie++;
        }
		
		return movie;
	}
	
	public int numMoviesToday(int id, int date) {
		int today = 0;
		
		for (Ticket ticket : ticketList) {
            if (ticket.getDay() == date && ticket.getId() == id) 
                today++;
		}
		return today;
	}
	
	public static boolean moviesToday(int id, int date) {
		
		boolean plural = false;
		int today = 0;
		
		for (Ticket ticket : ticketList) {
            if (ticket.getDay() == date && ticket.getId() == id) 
                today++;
		}
		if (today > 1)
			plural = true;
		return plural;
	}
	
	public double addTicket(String movieN,  String rating, int day, int time, String f, String type, int id, int times) {
		
		Ticket ticket = null;
		double price = 0;

		if (type.toLowerCase().equals("adult")) {
			ticket = new Adult(movieN, rating, day, time, f, type, id);
			price = ticket.calculateTicketPrice();
		}
		
		else if (type.toLowerCase().equals("child")) {
			ticket = new Child(movieN, rating, day, time, f, type, id);
			price = ticket.calculateTicketPrice();
		}
		
		else if (type.toLowerCase().equals("employee")) {
			ticket = new Employee(movieN, rating, day, time, f, type, id);
			price = ticket.calculateTicketPrice();
		}
		
		else if (type.toLowerCase().equals("moviepass")) {
			ticket = new MoviePass(movieN, rating, day, time, f, type, id);
			price = ticket.calculateTicketPrice();
		}
		
		else
			price = -1;
		
		ticketList.add(ticket);
		
		return price;
	}
	
	public double totalSalesMonth() {
		double total = 0;

		for (int i = 0; i < ticketList.size(); i++) {
			
			Ticket ticket = ticketList.get(i);
			total += ticket.calculateTicketPrice();
			
			}
	        
	    return total;
	    
	    }
	
	public String monthlySalesReport() {
		
		int countA = 0;
		int countC = 0;
		int countE = 0;
		int countM = 0;
		//A is for Adult, E for Employee, C for Child and M for MoviePass
		
	    double salesA = 0, salesC = 0, salesE = 0, salesM = 0;
	    
	    for(int i = 0; i < ticketList.size(); i++) {
	    	
	        if(ticketList.get(i).getType() == Type.ADULT) {
	        	
	        	salesA += ticketList.get(i).calculateTicketPrice();
	            countA++;
	        }
	 
	        else if(ticketList.get(i).getType() == Type.CHILD) {
	        	
	            salesC += ticketList.get(i).calculateTicketPrice();
	            countC++;
	        }
	        
	        else if(ticketList.get(i).getType() == Type.EMPLOYEE) {
	             salesE += ticketList.get(i).calculateTicketPrice();
	             countE++;
	        }
	
	        else  if(ticketList.get(i).getType() == Type.MOVIEPASS) {
	             salesM += ticketList.get(i).calculateTicketPrice();
	             countM++;
	               }
	   }
	
	   double sales = salesA + salesC + salesE + salesM;
	   return "\t\tMonthly Sales Report\n\n" + "\t\tSales Number\t\tSales Amount\n" + "ADULT:\t\t"
			   + countA + "\t\t\t$" + salesA + "CHILD:\t\t" + countC + "\t\t\t$" + salesC + "EMPLOYEE:\t\t"
			   + countE + "\t\t\t$" + salesE + "MOVIEPASS:\t\t" + countM + "\t\t\t$" + salesM 
			   + "\nTotal Monthly Sales : " + sales;
	}
	
	public ArrayList<String> get3DTickets() {
		
		ArrayList<String> tickets3D = new ArrayList<String>();
		sortByDay();
		for (int i = 0; i < ticketList.size(); i++) {
			if((ticketList.get(i).getFormat()==Format.THREE_D)) {
				tickets3D.add(ticketList.get(i).toString());
			}
		}	
		return tickets3D;
		
	}
	
	public ArrayList<String> getAllTickets() {
		
		ArrayList<String> tickets = new ArrayList<String>();
		
		sortByDay();
		
		for (int i = 0; i < ticketList.size(); i++)
			tickets.add(ticketList.get(i).toString());
		
		return tickets;
	}
	
	public ArrayList<String> getMoviePassTickets() {
		
		ArrayList<String> moviePassTickets = new ArrayList<String>();
		
		sortById();
		
		for (int i = 0; i < ticketList.size(); i++) {
			
			if((ticketList.get(i).getType() == Type.MOVIEPASS)) 
				moviePassTickets.add(ticketList.get(i).toString());
			
		}	
		
		return moviePassTickets;
	}
	
	public void readFile(File file) throws FileNotFoundException {

        Scanner sc = new Scanner(file);
        
        while(sc.hasNextLine()) {
        	
            String[] category = sc.nextLine().split(":");
            String name = category[0];
            String rating = category[1];
            int day = Integer.parseInt(category[2]);
            int time = Integer.parseInt(category[3]);
            String format = category[4];
            String type = category[5];
            int id = Integer.parseInt(category[6]);
            addTicket(name, rating, day, time, format, type, id);
        }
    }
	
	 private void sortByDay() {
		 
	    Ticket ticket;
	        
	    for (int i = 1; i < ticketList.size(); i++) {
	        for (int j = i; j > 0; j--) {
	        	
	            if (ticketList.get(j).getDay() < ticketList.get(j - 1).getDay()) {
	                 
	            	ticket = ticketList.get(j);
	            	
	                 ticketList.set(j, ticketList.get(j - 1));
	                 ticketList.set(j - 1, ticket);
	            }
	        }
	    }

	}
	 
	 
	 private void sortById() {
		 
		    Ticket ticket;
		        
		    for (int i = 1; i < ticketList.size(); i++) {
		        for (int j = i; j > 0; j--) {
		        	
		            if (ticketList.get(j).getId() < ticketList.get(j - 1).getId()) {
		                 
		            	ticket = ticketList.get(j);
		            	
		                 ticketList.set(j, ticketList.get(j - 1));
		                 ticketList.set(j - 1, ticket);
		            }
		        }
		    }

		}

	@Override
	public double addTicket(String movieN, String rating, int d, int t, String f, String type, int id) {
		// TODO Auto-generated method stub
		return 0;
	}


	
	
}

