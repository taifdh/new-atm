
public class User {
	private String Id;
	private int PIN;
	private Account account;
	
	public User(String Id, int PIN, Account account) {
		this.Id = Id;
		this.PIN = PIN;
		this.account = account;
	}

	public String getId() {
		return Id;
	}

	public void setId(String Id) {
		this.Id = Id;
	}

	public int getPIN() {
		return PIN;
	}

	public void setPIN(int pIN) {
		this.PIN = pIN;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
	

}
