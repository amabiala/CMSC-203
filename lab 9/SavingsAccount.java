
public class SavingsAccount extends BankAccount {
	
	private final double RATE = 0.025;
	private int savingsNumber = 0;
	private String accountNumber;
	
	
	public SavingsAccount(String name, double amount) {
		
		super(name, amount);
		accountNumber = super.getAccountNumber() + "-" + savingsNumber;
	}
	
	
	
	public void postInterest() {
		
		double monthly;
		
		double balance = super.getBalance();
		monthly = (balance * RATE)/12;
		super.deposit(monthly);
	}
	
	public String getAccountNumber() {
		
		return accountNumber;
	}
	
	public SavingsAccount(SavingsAccount account, double amount) {

		super(account, amount);
		
		savingsNumber = account.savingsNumber + 1;
		accountNumber = account.accountNumber + "-"+ savingsNumber;
		
		
	}
	
	

}
