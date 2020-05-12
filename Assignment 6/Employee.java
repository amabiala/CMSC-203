package first;
import java.text.DecimalFormat;

public class Employee extends Ticket {
	
	private final double RATE = 0.096;
	private final double DAYTIME = 10.50;
	private final double EVENING = 13.50;
	private final double IMAX = 3;
	private final double TRD = 2.50; // Constant for 3D
	private int id;
	private int times;
	
	public Employee() {
		id = 0;
	}
	
	public Employee(String name, String rating, int day, int time, String format , String type, int id) {
		
		super(name, rating, day, time, format, type, id);
		super.setType(Type.EMPLOYEE);
		this.id = id;
	}
	
	
	
	public Employee(String name, String rating, int day, int time, String format, int id, int times) {
		super();
		super.setType(Type.EMPLOYEE);
		this.id = id;
		this.times = times;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public void setTimes(int times) {
		this.times = times;
	}
	
	public int getTimes() {
		return times;
	}

	@Override
	public double calculateTicketPrice() {
		double price = 0;
		MovieTicketManager m = new MovieTicketManager();
		
		if (m.numVisits(id) > 2 || getTimes() > 2 )
		{
			if (getTime() < 18 ) 
				price += DAYTIME;
			else 
				price += EVENING;
			
			if(getFormat() == Format.THREE_D)
				price += TRD;
			else if(getFormat() == Format.IMAX)
				price += IMAX;
			
			price /= (double)2;
			
			double tax = price * RATE;
			price += tax;
			
			DecimalFormat money = new DecimalFormat("##0.00");
			double cost = Double.parseDouble(money.format(price));
		}
	
		return price;
	}

	@Override
	public int getId() {
		return id;
	}
	
public String toString() {
		
		String result;
		
		result = super.toString() + "ID: " + id + "Cost: " + calculateTicketPrice();
		
		return result;
	}
	
	
	
	
	
}
