package first;
import java.text.DecimalFormat;

public class Adult extends Ticket {
	
	private final double RATE = 0.096;
	private final double DAYTIME = 13.50;
	private final double EVENING = 10.50;
	private final double IMAX = 3;
	private final double TRD = 2.50; // Constant for 3D
	
	public Adult() {
		
	}
	
	public Adult(String name, String rating, int day, int time, String format , String type, int id ) {
		
		super(name, rating, day, time, format, type, id);
		super.setType(Type.ADULT);
		
	}
	

	@Override
	public double calculateTicketPrice() {
		
		double price = 0;
		
		if (getTime() < 18 ) 
			price += DAYTIME;
		else 
			price += EVENING;
		
		if(getFormat() == Format.THREE_D)
			price += TRD;
		else if(getFormat() == Format.IMAX)
			price += IMAX;
		 
		double tax = price * RATE;
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
