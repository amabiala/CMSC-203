package first;

public class MoviePass extends Ticket{
	
	private final double COST = 9.99;
	private int id;
	private int day;
	private String name;
	
	public MoviePass() {
		
	}
	
	public MoviePass(String name, String rating, int day, int time, String format , String type, int id) {
		
		super(name, rating, day, time, format, type, id);
		super.setType(Type.MOVIEPASS);
		this.id = id;
		this.day = day;
		if (super.getFormat() != Format.NONE)
			super.setType(Type.ADULT);
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public boolean HasSeen(String n, int id) {
		boolean seen = false;
		
		if (super.getName() == n && getId() == id)
			seen = true;
		return seen;
	}
	
	@Override
	public double calculateTicketPrice() {
		double price = 0;
		
		if (MovieTicketManager.moviesToday(id, day) || HasSeen(name, id) )
			super.setType(Type.ADULT);
		else 
			price = COST;
		// TODO Auto-generated method stub
		return price;
	}
	@Override
	public int getId() {
		return id;
	}

}
