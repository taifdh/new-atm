
public class Deposit {

	private String accountNo;
	private double value;
	private String date;
	public Deposit(String accountNo, double value, String date) {
		this.accountNo = accountNo;
		this.value = value;
		this.date = date;
	}
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = value;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
}