
public class CheckingAccount extends BankAccount{
	
	static final double FEE = 0.15;
	
	public CheckingAccount(String name, double amount){
		
		super(name, amount);
		
		String accountNumber = super.getAccountNumber() + "-10";
		super.setAccountNumber(accountNumber);
	}
		
	public boolean withdraw(double amount) {
			
			boolean done = true;
			
			amount+=FEE;
			done = super.withdraw(amount);
			
			return done;
		}
	
		
}


