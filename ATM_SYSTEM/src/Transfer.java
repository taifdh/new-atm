
public class Transfer {

	private String accountNoFrom;
	private String accountNoTo;
	private double value;
	private String date;
	
	public Transfer(String accountNoFrom, String accountNoTo, double value, String date) {
		super();
		this.accountNoFrom = accountNoFrom;
		this.accountNoTo = accountNoTo;
		this.value = value;
		this.date = date;
	}
	public String getAccountNoFrom() {
		return accountNoFrom;
	}
	public void setAccountNoFrom(String accountNoFrom) {
		this.accountNoFrom = accountNoFrom;
	}
	public String getAccountNoTo() {
		return accountNoTo;
	}
	public void setAccountNoTo(String accountNoTo) {
		this.accountNoTo = accountNoTo;
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