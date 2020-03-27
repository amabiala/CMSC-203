
public class CryptoManager {
	private static final char LOWER_BOUND = ' ';
	private static final char UPPER_BOUND = '_';
	private static final int RANGE = UPPER_BOUND - LOWER_BOUND + 1;
	private int key = 0;
	private String text = null;
	private String bellaso = null;
	private static String encryptedCode = null;
	
	public CryptoManager(String plainText, int key, String bellasoStr, String encryptedCode){
		
		this.key = key;
		this.text = plainText;
		this.bellaso = bellasoStr;
		CryptoManager.encryptedCode = encryptedCode;
		
	}
	
	public void setEncryptedCode(String encryptedCode) {
		CryptoManager.encryptedCode = encryptedCode;
	}
	
	//Setter and getter for the text that will be used to do encryption
	public void setText(String plainText) {
		plainText = this.text;
	}
	
	public String getText() {
		return text;
	}

	//Give a value to key

	public void setKey(int key) {
		this.key = key;
	}
	
	//Putting the key in the range;
	
	public int getKeyInRange() {
		
		while ( key >= RANGE)
			key -= RANGE;
		return key;
	}
	
	//Make sure that all the characters of the string to be encrypted are in the range.;
	 

	public static boolean stringInBounds (String plainText) {
		
		boolean correct = true; //Will check if the string is correct, assuming it is unless proved otherwise;
		for (int i = 0; i < plainText.length(); i++)
		{
			if ( plainText.charAt(i) > UPPER_BOUND ||  plainText.charAt(i) < LOWER_BOUND )
				correct = false;
		}
		
		return correct;
	}

	//Actual encryption, using Caesar principles. Every character will be replaced by its offset.
	
	public static String encryptCaesar(String plainText, int key) {
		String cryptic = ""; //Represents the word that will come out after encryption;
		int change;
		char newChar;
		
		for (int i = 0; i < plainText.length(); i++)
		{
			  change = plainText.charAt(i) + key;
			  
			  while (change > UPPER_BOUND)
				  change -= RANGE;
			  
			  newChar = (char) change;
			  cryptic += newChar;
			  
				  
		}
		encryptedCode = cryptic;
		return cryptic;
		
	}
	//Setter and getter for the Bellaso key
	public void setBellaso(String bellasoStr) {
		this.bellaso = bellasoStr;
	}


	public String getBellaso() {
		return bellaso;
	}
 
 public String getEncryptedCode() {
		return encryptedCode;
	}
	
	//The inverse process of the Encryption. From a text obtained from encoded text, will obtain an "ordinary" string.
	
	public static String decryptCaesar(String encryptedText, int key) {
		
		String text = "";
		int change;
		char oldChar;
		
		for (int i = 0; i < encryptedText.length(); i++)
		{
			  change = encryptedText.charAt(i) - key;
			  while(change < LOWER_BOUND)
				  change += RANGE;
				  
			  oldChar = (char) change;
			   text += oldChar;
				  
		}
		
		return text;
	}
	
	static String encryptBellaso(String plainText, String bellasoStr) {
		 
		String cryptic = "";
		int length = bellasoStr.length();
		char nChar;
		 for (int i = 0; i < plainText.length(); i++)
		 {
			nChar = plainText.charAt(i);
			int nCharvalue = (int) nChar + (int) bellasoStr.charAt(i%length);
				
			while (nCharvalue > UPPER_BOUND)
			{
				nCharvalue -= RANGE;
			}
			
			cryptic += (char) nCharvalue;
				 
		 }
		 encryptedCode = cryptic;
		 return cryptic;
			 
		}
	
	public static String decryptBellaso(String encryptedText, String bellasoStr) {
		
		String text = "";
		int length = bellasoStr.length();
		char oldChar;
		 for (int i = 0; i < encryptedText.length(); i++)
		 {
			oldChar = encryptedText.charAt(i);
			int nCharvalue = (int) oldChar - (int) bellasoStr.charAt(i%length);
				
			while (nCharvalue < LOWER_BOUND)
			{
				nCharvalue += RANGE;
			}
			
		text += (char) nCharvalue;
				 
		 }
		 
		 return text;
			 
	}

}
