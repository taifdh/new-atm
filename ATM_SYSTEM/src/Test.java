import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;


public class Test {
	static String adminId="1234";
	static String adminPIN="0000";
	static ArrayList<User> users;
	static ArrayList<Withdraw> withdraws;
	static ArrayList<Deposit> deposits;
	static ArrayList<Transfer> transfers;
public static void main(String[] args) {
	
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
	Calendar calendar2 = Calendar.getInstance();
	calendar2.add(Calendar.DAY_OF_YEAR, 0);
	calendar2.set(Calendar.HOUR_OF_DAY, 0);
	calendar2.set(Calendar.MINUTE, 0);
	calendar2.set(Calendar.SECOND, 0);
	calendar2.set(Calendar.MILLISECOND, 0);

 Date date2= calendar2.getTime();


String todayAsString = dateFormat.format(date2);
	
	users=new ArrayList<User>();
	withdraws=new ArrayList<Withdraw>();
	deposits=new ArrayList<Deposit>();
	transfers=new ArrayList<Transfer>();
	boolean condtion1=true;
	
	do {
		
	System.out.println("***** ATM *****");
	System.out.println("1)Admin\n2)User\n3)Exit");
	Scanner input= new Scanner(System.in);
	String choice1= input.nextLine();
	if (choice1.equals("1")) {
		boolean condtion2=true;
		
		
			System.out.println("Enter Id: ");
			String id=input.nextLine();
			System.out.println("Enter PIN: ");
			String pin=input.nextLine();
			if (id.equals(adminId)&& pin.equals(adminPIN)) {
				do {
					System.out.println("***** Admin Interface *****");
					System.out.println("1)Create New User\n2)View Users\n3)Back to Menu");
					String choice2=input.nextLine();
					if (choice2.equals("1")) {
						System.out.println("Enter Id: ");
						String id2=input.nextLine();
						System.out.println("Enter PIN: ");
						int pin2=input.nextInt();
						input.nextLine();
						System.out.println("Enter Account Number: ");
						String No=input.nextLine();
						System.out.println("Enter Balance: ");
						double balance=input.nextDouble();
						input.nextLine();
						
						Account account= new Account(No,balance);
						User user= new User(id2, pin2, account);
						users.add(user);
						System.out.println("User is Added Successfully!");
						
					}
					else if (choice2.equals("2")) {
						for (int i = 0; i < users.size(); i++) {
							System.out.println("User("+(i+1)+") Details: "+"Id: "+users.get(i).getId()+", Pin: "+users.get(i).getPIN()+", Account Number: "+users.get(i).getAccount().getAccountNo()+", Balance: $"+users.get(i).getAccount().getBalance()+"\n");
						}
					}
					else if (choice2.equals("3")) {
						condtion2=false;
					}
				} while (condtion2);
			}
			
			else {
				System.out.println("Incorrect Id or Password!");
			}
			
	}
	else if (choice1.equals("2")) {
		System.out.println("Enter User Id: ");
		String id=input.nextLine();
		System.out.println("Enter User PIN: ");
		int pin=input.nextInt();
		input.nextLine();
		int index=-1;
		boolean userExists=false;
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getId().equals(id) && users.get(i).getPIN()==pin) {
				 index= users.indexOf(users.get(i));
				userExists=true;
				break;
			}
		}
		
		if (userExists) {
			boolean condtion3=true;
			do {
				System.out.println("***** User Interface *****");
				System.out.println("1)Transactions History\n2)Withdraw\n3)Deposit\n4)Transfer\n5)Quit");
				String choice=input.nextLine();
				if (choice.equals("1")) {
					
					System.out.println("Withdraws: ");
					for (int i = 0; i < withdraws.size(); i++) {
						System.out.println("("+(i+1)+") Account Number: "+withdraws.get(i).getAccountNo()+"  ,Amount: $"+withdraws.get(i).getValue()+"  ,Date: "+withdraws.get(i).getDate()+"\n");
					}
					System.out.println("Deposits: ");
					for (int i = 0; i < deposits.size(); i++) {
						System.out.println("("+(i+1)+") Account Number: "+deposits.get(i).getAccountNo()+"  ,Amount: $"+deposits.get(i).getValue()+"  ,Date: "+deposits.get(i).getDate()+"\n");
					}
					System.out.println("Transfers: ");
					for (int i = 0; i < transfers.size(); i++) {
						System.out.println("("+(i+1)+") Transferer Account Number: "+transfers.get(i).getAccountNoFrom()+"  ,Receiver Account Number: "+transfers.get(i).getAccountNoTo()+"  ,Amount: $"+transfers.get(i).getValue()+"  ,Date: "+transfers.get(i).getDate()+"\n");
					}
				}
				
				else if (choice.equals("2")) {
					System.out.println("Enter Amount of Money You Wish to Withdraw: ");
					double amount=input.nextDouble();
					input.nextLine();
					double balance=users.get(index).getAccount().getBalance();
					if (balance>=amount) {
						balance-=amount;
						users.get(index).getAccount().setBalance(balance);
						System.out.println("$"+amount+" Withdrawn >> Current Balance= "+"$"+balance);
						Withdraw withdraw= new Withdraw(users.get(index).getAccount().getAccountNo(), amount, todayAsString);
						withdraws.add(withdraw);
					}
					else {System.out.println("Not Enough Balance to Cover This Withdrawal!");}
				}
				
				else if (choice.equals("3")) {
					System.out.println("Enter Amount of Money You Wish to Deposit: ");
					double amount=input.nextDouble();
					input.nextLine();
					double balance=users.get(index).getAccount().getBalance();
					
						balance+=amount;
						users.get(index).getAccount().setBalance(balance);
						System.out.println("$"+amount+" Deposited >> Current Balance= "+"$"+balance);
						Deposit deposit= new Deposit(users.get(index).getAccount().getAccountNo(), amount, todayAsString);
						deposits.add(deposit);
						
				}
				
				else if (choice.equals("4")) {
					System.out.println("Enter Account Number You Wish to Transfer to:  ");
					int index2=-1;
					String No=input.nextLine();
					for (int i = 0; i < users.size(); i++) {
						if (users.get(i).getAccount().getAccountNo().equals(No)) {
							index2=i;
							break;
						}
					}
					if (index==-1) {
						System.out.println("Account Doesn't Exists!");
					}
					else {
						System.out.println("Enter Amount of Money You Wish to Transfer: ");
						double amount=input.nextDouble();
						input.nextLine();
						double balance2=users.get(index2).getAccount().getBalance();
						double balance=users.get(index).getAccount().getBalance();
						if (balance>=amount) {
							balance-=amount;
							balance2+=amount;
							users.get(index).getAccount().setBalance(balance);
							users.get(index2).getAccount().setBalance(balance2);
							System.out.println("$"+amount+" Transfered >> Current Balance= "+"$"+balance);
							Transfer transfer= new Transfer(users.get(index).getAccount().getAccountNo(),users.get(index2).getAccount().getAccountNo(), amount, todayAsString);
							transfers.add(transfer);
						}
						else {System.out.println("Not Enough Balance to Cover This Transfer!");}
					}
					
						
				}
				
				else if (choice.equals("5")) {
					condtion3=false;	
				}
				else {
					System.out.println("Bad Input! Please Enter a Number [1-5]");
				}
				
				
			} while (condtion3);
		}
		
	}
	
    else if (choice1.equals("3")) {
    	System.out.println("Good Bye!");
		condtion1=false;
	}
	
	else {
		System.out.println("Bad Input. Please Enter 1 or 2");
	}
	} while (condtion1);
}
}



