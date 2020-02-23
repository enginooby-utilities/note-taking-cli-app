package mainpack;

public class Payment {
	private int idPayment, amount, accountNumber;
	private String accountType, timePaid;

	// CONSTRUCTOR
	public Payment(int idPayment, String accountType, int accountNumber, int amount, String timePaid) {
		this.idPayment = idPayment;
		this.accountType = accountType;
		this.accountNumber = accountNumber;
		this.amount = amount;
		this.timePaid = timePaid;
	}

	// BORING GETTER-SETTER STUFF BLA BLA
	public int getIdPayment() {
		return idPayment;
	}

	public int getAmount() {
		return amount;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public String getAccountType() {
		return accountType;
	}

	public String getTimePaid() {
		return timePaid;
	}

	public void setIdPayment(int idPayment) {
		this.idPayment = idPayment;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public void setTimePaid(String timePaid) {
		this.timePaid = timePaid;
	}
}
