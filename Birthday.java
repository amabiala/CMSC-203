import javax.swing.JOptionPane;
import java.text.DecimalFormat;
import java.util.Random;

public class Birthday {
	
	/**
		 * @author Andrea Mabiala
		 *
		 */
	public @interface JavadocBirthday {

	}

	/** A class that allows the user to choose what could be the best toy for a child
		 * Will be the driver and will enable to access the Toy objects.
		 */


	public static void main(String[] args)
	   {
		
				
		  String name;		/*name of the child */
		  String toy = null;		/*one of the three toys available*/
		  String askAge;	/*number from keyboard as a string*/
		  String yesOrNo;	/*user response from keyboard*/
		  String plus;		/*yes or no to add a card or balloon*/
		  String ageCheck; /*yes or no from the keyboard*/
		  int age = 0;			/*numeric input for age*/
		  double cost = 0.0; /*running total cost for the order*/
		  double surplus; //Additional cost of card/balloon;
		  double price;   //Main cost, coming from the price of the toy
		  
		  JOptionPane.showMessageDialog(null,"Welcome to this program. We will help you pick the "
		  		+ "best gifts for your kid(s)");
		  
		  
		  	/**Later will be used for the price so it can have a consistent formatting*/
		  DecimalFormat dollar = new DecimalFormat("#,##0.00");
	      
	      do
	      {		
	    	  name = JOptionPane.showInputDialog("Enter the name of the child");
	    	  
	    	  askAge = JOptionPane.showInputDialog("How old is the child?");
	    	  age = Integer.parseInt(askAge);
	    	  
	    	  Toy jouet = new Toy(); //Jouet means toy in French;
	    	  
	    	  /** Opening the jouet object that will store all the information that will follow*/
	    	  jouet.setAge(age); 
	    	  
	    	do
	    	{
	    			
	    		
	    	  toy = JOptionPane.showInputDialog("Choose a toy: Plushie, Blocks, or Book");

	    	  while (!(toy.equalsIgnoreCase("plushie")||toy.equalsIgnoreCase("blocks")
	    			  ||toy.equalsIgnoreCase("book"))) 
	    	  {
	    		  /**
	    		   * Making sure the Input of the user is correct and so the program will not crash if
	    		   * incorrect input occurs
	    		   * */
	    		  JOptionPane.showMessageDialog(null,"Invalid choice\nPlease choose again");
	    		  toy = JOptionPane.showInputDialog("Choose a toy: Plushie, Blocks or Book");
	    		  
	    	  }
	    	  
	    	  jouet.setToy(toy);
	    	  
	    	  
	    	 
	    	   	  	/**Making sure the toy is appropriate for the child, let you still choose what is best*/
	    	  if (jouet.ageOK())
	    	  {
	    		  JOptionPane.showMessageDialog(null,"Great");
	    		  ageCheck = "no";
	    	  }
	    	  else
	    	  {
	    		  ageCheck = JOptionPane.showInputDialog("Toy is not age-appropriate\n"
	    				  + "Do you want to buy a different toy? Yes or No ");
	    		  
	    	  }
	    	  
	    	  jouet.setCost(toy);
	    	  
	    	  
	    	 }while (ageCheck.equalsIgnoreCase("yes")); 
	    	/**Opening the possibility to get another toy for another kid */
	    	
	    	 
	    	 plus = JOptionPane.showInputDialog("Do you want a card with the gift? Yes or No");
	    	 jouet.addCard(plus);
	    	  
	    	 plus = JOptionPane.showInputDialog("Do you want a balloon with the gift? Yes or No");
	    	 jouet.addBalloon(plus);
	    	 
	    	 price = jouet.getCost();
	    	   
	   		  
	   		 cost += price ;		//Running total for the cost
	   		  
	   		JOptionPane.showMessageDialog(null, "The toy of " + name + jouet.toString()); 
	   		/**
	   		 * toString: instead of writing long statements using the toString method from the Toy class allows 
	   		 * to get the same information with less hassle. There is a reason why it has been provided so why 
	   		 * not take advantage of it? 
	   		 * */
	   		
	    	  yesOrNo = JOptionPane.showInputDialog("Do you want another toy? Yes or No ");
	      }while(yesOrNo.equalsIgnoreCase("yes"));
	      
	      JOptionPane.showMessageDialog(null,"\nThe total cost of your order is $" + dollar.format(cost) );
	      
	      Random rand = new Random();
	      int order = rand.nextInt(899999) + 100000; 
	      
	      /**
	       * At last random help us generating an order number that hopefully will be different each time.
	       * In my case I wanted a 6-digit number. Less probability of running on the same number by chance.
	       * I consider it more esthetic too*/
	      
	      JOptionPane.showMessageDialog(null,"\nOrder number is " + order);
	      
	      JOptionPane.showMessageDialog(null,"Programmer: Andrea Mabiala");
	      
	      System.exit(0);
	   }

}
