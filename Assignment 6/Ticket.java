package first;

public abstract class Ticket {
	
	private String name;
	private Rating rating;
	private Type type;
	private Format format;
	private String spec ; // The string for format, better for formatting
	private int day; // From 1-31
	private int time;// From 8AM to 11PM
	private int id;
	
	
	public abstract double calculateTicketPrice();
	public abstract int getId();
	
	
	public Ticket() {
		
		name = null;
		rating = Rating.R;
		type = null;
		spec = null;
		format = Format.NONE;
		day = 1;
		time = 8;
		id = -1;
	}
	
	public Ticket (String name, String rating, int day, int time, String format, String type, int id) {
		
		if (rating.equalsIgnoreCase("G"))
			this.rating = Rating.G;
		else if (rating.equalsIgnoreCase("PG"))
			this.rating = Rating.PG;
		else if (rating.equalsIgnoreCase("PG13"))
			this.rating = Rating.PG13;
		else if (rating.equalsIgnoreCase("PG-13")) 
			this.rating = Rating.PG13;
		else if (rating.equalsIgnoreCase("R"))
			this.rating = Rating.R;
		else 
			this.rating = Rating.NR;
		
		if (type.equalsIgnoreCase("adult"))
			this.type = Type.ADULT;
		else if (type.equalsIgnoreCase("child"))
			this.type = Type.CHILD;
		else if (type.equalsIgnoreCase("employee"))
			this.type = Type.EMPLOYEE;
		else if (type.equalsIgnoreCase("moviepass"))
			this.type = Type.MOVIEPASS;
		else
			throw new IllegalArgumentException("Invalid");
		
		if (format.equalsIgnoreCase("3d"))
			this.format = Format.THREE_D;
		else if (format.equalsIgnoreCase("imax"))
			this.format = Format.IMAX;
		else if (format.equalsIgnoreCase("none"))
			this.format = Format.NONE;
		
		
	}
	
	public Ticket(String name, Type type, Rating rating, Format format, int time, int id, int day) {
		
		this.name = name;
		this.type = type;
		this.rating = rating;
		this.format = format;
		this.day = day;
		this.time = time;
		this.id = id;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public void setRating(Rating rating) {
		this.rating = rating;
	}
	
	public Rating getRating() {
		return rating;
	}
	
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	
	public Format getFormat() {
		return format;
	}
	public void setFormat(Format format) {
		
	}
	public String getSpec() {
		return spec;
	}
	public void setSpec(String spec) {
		
		if (this.format == Format.THREE_D)
			spec = "3D";
		if(this.format == Format.IMAX)
			spec = "IMax"; 
		else 
			spec = "None";
		this.spec = spec;
	}
	public void setDay(int day) {
		if (time < 1 || time > 31)
			throw new IllegalArgumentException("Invalid date");
		this.day = day;
		
	}
	public int getDay() {
		
		return day;
	}
	public void setTime(int time) {
		if (time < 8 || time > 23)
			throw new IllegalArgumentException("Sorry the Movie Theater is closed");
		else
			this.time = time;
		
	}
	public int getTime() {
		return time;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	public String toString() {
		
		return " Movie name: " + name + " Rating: "+ rating + " Day: " + day+ " Time: " + time + "Specification: " + spec ;
		
	}
	
	
}

