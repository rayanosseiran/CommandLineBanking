import java.text.SimpleDateFormat;
import java.util.Calendar;


public class UserAccount {

	static String timeStamp = new SimpleDateFormat("dd/MM/yyyy - H:mm").format(Calendar.getInstance().getTime());
	private String email;
	private String password;
	private float chequingsBalance;
	private float savingsBalance;

	protected UserAccount(String email, String password, float chequingsBalance, float savingsBalance) {
		super();
		this.email = email;
		this.password = password;
		this.chequingsBalance = chequingsBalance;
		this.savingsBalance = savingsBalance;
	}
	
	protected String getEmail() {
		return email;
	}

	protected void setEmail(String email) {
		this.email = email;
	}

	protected String getPassword() {
		return password;
	}

	protected void setPassword(String password) {
		this.password = password;
	}

	protected float getChequingsBalance() {
		return chequingsBalance;
	}

	protected void setChequingsBalance(float chequingsBalance) {
		this.chequingsBalance = chequingsBalance;
	}

	protected float getSavingsBalance() {
		return savingsBalance;
	}

	protected void setSavingsBalance(float savingsBalance) {
		this.savingsBalance = savingsBalance;
	}
	
	// FACILITATES TRANSFERS WITHIN ACCOUNT 

	protected void moveTo(String accountType, float amount) {
		if (accountType.equalsIgnoreCase("Savings")) {
			this.setSavingsBalance(this.getSavingsBalance() + amount);
			this.setChequingsBalance(this.getChequingsBalance() - amount);
		}
		else if(accountType.equalsIgnoreCase("Chequings")) {
			this.setChequingsBalance(this.getChequingsBalance() + amount);
			this.setSavingsBalance(this.getSavingsBalance() - amount);
		}
		System.out.print(timeStamp + "\nTransaction Details: \nChequings Balance: $"
				+ this.getChequingsBalance() + "\nSavings Balance: $" + this.getSavingsBalance()
				+ "\nThank you for banking with us.\n");
	}
	
	// FACILITATES TRANSFERS TO OTHER USERS 
	
	protected void transfer(String accountType, float amount, UserAccount receiver) {
		if (accountType.equals("Chequings")) {
			this.setChequingsBalance(this.getChequingsBalance() - amount);
			receiver.setChequingsBalance((receiver.getChequingsBalance() + amount));

		} else if (accountType.equals("Savings")) {
			this.setSavingsBalance(this.getSavingsBalance() - amount);
			receiver.setChequingsBalance((receiver.getChequingsBalance() + amount));

		}
		

	}

}
