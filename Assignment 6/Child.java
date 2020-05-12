package first;
import java.text.DecimalFormat;

public class Child extends Ticket {

	private static String type;
	private static int id;
	private final double RATE = 0.096;
	private final double DAYTIME = 5.75;
	private final double EVENING = 10.75;
	private final double IMAX = 2;
	private final double TRD = 1.50; // Constant for 3D
	
	public Child() {
		
	}
	
	public Child(String name, String rating, int day, int time, String format , String type, int id) {
		
		super(name, rating, day, time, format, type, id);
		super.setType(Type.CHILD);
		if(super.getRating().equals(Rating.PG) || super.getRating().equals(Rating.PG13))
			throw new IllegalArgumentException("Children cannot watch movies of R rating or PG-13 rating");
	}

	public Child(String name, String rating, int day, int time, String format) {
		super(name, rating, day, time, format, type, id);
		super.setType(Type.CHILD);
		if(super.getRating().equals(Rating.PG) || super.getRating().equals(Rating.PG13))
			throw new IllegalArgumentException("Children cannot watch movies of R rating or PG-13 rating");
	}

	@Override
	public double calculateTicketPrice() {
		
		double tax;
		double price = 0;
		
		if (getTime() < 18 ) 
			price += DAYTIME;
		else 
			price += EVENING;
		
		if(getFormat() == Format.THREE_D)
			price += TRD;
		else if(getFormat() == Format.IMAX)
			price += IMAX;
		 
		tax = price * RATE;
		price += tax;
		
		DecimalFormat money = new DecimalFormat("##0.00");
		double cost = Double.parseDouble(money.format(price));
		
		return cost;
	}

	@Override
	public int getId() {
		
		return -1;
	}
	
	public String toString() {
		
		String result;
		
		result = super.toString() + "Cost: " + calculateTicketPrice();
		
		return result;
	}
	
}
