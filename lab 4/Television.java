/**
 * The purpose of this class is to model a television
 * @author: Andrea Mabiala
 * Date: 03/08/2020
 * 
 * */
public class Television {
	
	private final int SCREEN_SIZE; 
	/*The size of the television. Because it cannot be changed once you have the television,
	  it will therefore be a constant*/
	
	
	private final String MANUFACTURER;
	//Also a constant, represents the brand name;
	
	private boolean powerOn;
	/* As we can expect, it is a boolean because the TV is either on or off (True/False).
	 * There is not other outcomes to this variable.*/
	private int channel;
	/* A variable too, because the user will choose what channels 
	 * they will have and which one they are willing to watch, and that particular choice may change.*/
	
	private int volume;
	//Variable too, because the user may want to increase or decrease the volume according to their preferences.

	
	/**
	 * This is the constructor. It will settle the desired default values for our fields. 
	 * Or else every constant will be initialized to 0 and/or null.
	 * 
	 * */
	public Television( String brand, int size ) {
		
		this.MANUFACTURER = brand;
		this.SCREEN_SIZE = size;
		this.powerOn = false;
		this.volume = 20;
		this.channel = 2;
		
	}
	
	/**
	 * Accessor method, will allow us to get the value stored in volume.
	 * 
	 * */
	
	public int getVolume(){
		
		return volume;
	}
	
	/**
	 * Accessor method, will allow us to get the value stored in channel.
	 * 
	 * */
	
    public int getChannel(){
		
		return channel;
	}
	
    /**
	 * Accessor method, will allow us to get the value stored in SCREEN_SIZE.
	 * 
	 * */
    
    public int getScreenSize(){
		
		return SCREEN_SIZE;
	}
    
    /**
	 * Accessor method, will allow us to get the value stored in MANUFACTURER.
	 * 
	 * */
   public String getManufacturer(){
		
		return MANUFACTURER;
	}
	
   /**
	 * Mutator method, unlike an accessor, will allow us to modify the value stored in channel
	 * 
	 * */
   public void setChannel(int station) {
	   
	   this.channel = station;
   }
   
   /**
	 * Mutator method, unlike an accessor, will allow us to switch the value stored in powerOn.
	 * 
	 * */
	
   public void power() {
	   
	   powerOn = !powerOn;
   }
   
   /**
	 * Mutator method, unlike an accessor, will allow us to increment the value stored in channel.
	 * 
	 * */

   public void increaseVolume() {
	   
	   ++volume;
   }
   
   /**
	 * Mutator method, unlike accessor, will allow us to increment the value stored in channel.
	 * 
	 * */
   public void decreaseVolume() {
	   
	   --volume;
   }

}
