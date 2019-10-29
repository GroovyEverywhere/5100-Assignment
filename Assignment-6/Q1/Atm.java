package Assignment6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Atm {
	private int availableAmountInMachine;
	private int transactionFee;	
	private int bankAccountNumber;
	private int password;
	private int avaliableBalance;
	private int deposit;
	private int withDrawal;
	ArrayList<String> transactions = new ArrayList<String>();
	private ArrayList<ArrayList<User>> userData = new ArrayList<ArrayList<User>>();
	ArrayList<User> userInfo = new ArrayList<User>();   //Stores user's personal information
	HashMap<Integer, Integer> userAccount = new HashMap<Integer, Integer>();  //Stores user's account information
	
	Atm(int availableAmountInMachine, int transactionFee, ArrayList<User> userInfo, ArrayList<ArrayList<User>> userData, HashMap<Integer, Integer> userAccount){
		this.availableAmountInMachine = availableAmountInMachine;
		this.transactionFee = transactionFee;
		this.userInfo = userInfo;
		this.userData = userData;
		this.userAccount = userAccount;
		for(int key: userAccount.keySet()) {
			this.bankAccountNumber = key;
			System.out.println("Your bank account number is "+ this.bankAccountNumber);
			this.password = userAccount.get(key);
			System.out.println("Your password is "+ this.password);
		}
	}
	
	int getAvaliableAmountInMachine() {
		return this.availableAmountInMachine;
	}
	void setAvaliableAmountInMachine(int availableAmountInMachine) {
		this.availableAmountInMachine = availableAmountInMachine;
	}
	int getTransactionFee() {
		return this.transactionFee;
	}
	void setTransactionFee(int transactionFee) {
		this.transactionFee = transactionFee;
	}
	
	//-----------------------------------------------------------------------------------------------------
	
	public void greetingPage() {  //start
		System.out.println("Dear customer: Welcome and please enter the code right in front of the action you want to do with us today" + '\n' + "1. Login" + '\n' +"2. Create Account");
		Scanner scanner = new Scanner(System.in);
		String line = scanner.nextLine();
		if(line.equals("1")) {
			Login();
		}
		else if(line.equals("2")) {
			createAccount();
		}
	}
	
	//------------------------------------------------------------------------------------------------------
	
	public void Login() {
		System.out.print("Please enter your bank account number and password to login splitted by ','");
		Scanner scanner = new Scanner(System.in);
		String line = scanner.nextLine();
		String [] lines = line.split(",");
		this.bankAccountNumber = Integer.parseInt(lines[0]);
		this.password = Integer.parseInt(lines[1]);
		//----------------------------------------------------------------------
		if(userAccount.containsKey(this.bankAccountNumber)) {
			if(this.password == userAccount.get(this.bankAccountNumber)) {
				System.out.println("Login success!");
				accountOptions();
			}
			else {
				System.out.println("Password is not correct and please enter the code right in front of the action you want to do" + '\n' + "1. Login again" + '\n' + "2. Forget password and help me to reset");
				Scanner scanner1 = new Scanner(System.in);
				String line1 = scanner.nextLine();
				if(line1.equals("1")) {
					Login();
				}
				else if(line1.equals("2")){
					resetPassword(this.bankAccountNumber);
				}
			}
		}
		else {
			System.out.println("The account does not exist and please enter the code right in front of the action you want to do" + '\n' + "1. Login again" + '\n' + "2. Sign up");
			Scanner scanner2 = new Scanner(System.in);
			String line2 = scanner.nextLine();
			if(line2.equals("1")) {
				Login();
			}
			else if(line2.equals("2")) {
				createAccount();
			}
		}
	}
	
	//-------------------------------------------------------------------------------------------------
	
	public void createAccount() {
		int accountNumber = (int) (Math.random()*100000);
		System.out.println("Please enter your preferred password");
		Scanner scanner = new Scanner(System.in);
		String line = scanner.nextLine();
		this.password = Integer.parseInt(line);
		this.bankAccountNumber = accountNumber;
		userAccount.put(this.bankAccountNumber,this.password);
		//---------------------------------------------------------
		System.out.println("Please provide your name, age, address, phone number and split them by ','");
		Scanner scanner2 = new Scanner(System.in);
        String line2 = scanner.nextLine();
        String[] lines = line2.split(",");
        userInfo.add(new User(lines[0], Integer.parseInt(lines[1]), lines[2],Integer.parseInt(lines[3]), this.bankAccountNumber));
        System.out.println("Sign up successful. Your bank account number is "+ this.bankAccountNumber + "Your password is " + this.password);
        accountOptions();
	}
	
	//------------------------------------------------------------------------------------------------
	
	public User locateUser(int bankAccountNumber) {
		for(User user : userInfo) {
			if(user.getBankAccountNumber() == bankAccountNumber) {
				return user;
			}
		}
		return null;
	}
	
	//-----------------------------------------------------------
	
	public boolean userAuthorityCheck(User currUser) {
		System.out.println("Please enter your name, age and phone number to reset your password splitted by ','");
		Scanner scan = new Scanner(System.in);
		String line = scan.nextLine();
		String[] lines = line.split(",");
		String name = lines[0];
		int age = Integer.parseInt(lines[1]);
		int phoneNumber = Integer.parseInt(lines[2]);
		if(name.equals(currUser.getName()) && age == currUser.getAge() && phoneNumber == currUser.getPhoneNumber()){
			System.out.println("Please enter your new password");
			Scanner scanner = new Scanner(System.in);
			String line1 = scanner.nextLine();
			this.password = Integer.parseInt(line1);
			userAccount.put(bankAccountNumber, this.password);
			System.out.println("Your password has been resetted as " + this.password);
			return true;
		}
		else {
			return false;
		}
	}
	
	//----------------------------------------------------------------------------------------------------------
	
	public void resetPassword(int bankAccountNumber) {
		User currUser = locateUser(bankAccountNumber);
		if(currUser == null) {
			return;
		}
		else {
			boolean userAuthorityCheck = userAuthorityCheck(currUser);
			if(userAuthorityCheck) {
				Login();
			}
			else {
				System.out.println("Information you entered is not matched, please try again");
				userAuthorityCheck(currUser);
			}
		}
	}
	
	//------------------------------------------------------
	
	public void accountOptions() {
		System.out.println("Please select the option you want to do" + '\n' + "1. Available balance" + '\n' + "2. With draw" + '\n' + "3. Deposit" + '\n'+"4. Recent transactions"+'\n'+ "5. Change password" +'\n'+ "6. Exit");
		Scanner scanner = new Scanner(System.in);
		String line = scanner.nextLine();
		if(line.equals("1")) {
			System.out.println("Your avaliable balance is " + this.avaliableBalance);
			accountOptions();
		}
		else if(line.equals("2")) {
			withDrawal();
		}
		else if(line.equals("3")) {
			deposit();
		}
		else if(line.equals("4")) {
			recentTransactions();
		}
		else if(line.equals("5")) {
			resetPassword(this.bankAccountNumber);
		}
		else if(line.equals("6")) {
			exit();
		}
	}
	
	//------------------------------------------------------------
	
	public void exit() {
		System.out.println("You have been logged out Thank you");
		greetingPage();       //Back to here is because usually the customer will leave so that we can always let another customer start with greeting page.
	}
	
	//---------------------------------------------------------------------
	
	public int withDrawal() {
		System.out.println("Please enter the amount of money you wan to withdraw");
		Scanner scanner = new Scanner(System.in);
		String line = scanner.nextLine();
		int withDraw = Integer.parseInt(line);
		this.withDrawal = withDraw;
		if(this.withDrawal <= this.avaliableBalance && this.withDrawal <= this.availableAmountInMachine) {
			this.avaliableBalance = this.avaliableBalance - this.withDrawal - this.transactionFee;
			this.availableAmountInMachine = this.availableAmountInMachine - this.withDrawal + this.transactionFee;
			System.out.println("Withdraw has been made successfully");
			transactions.add("With Draw"+this.withDrawal);
			accountOptions();
		}
		else {
			System.out.println("Withdraw did not process. Please check your withdraw amount and try again");
			accountOptions();
		}
		return this.avaliableBalance;
	}
	
	//------------------------------------------------------------------------------
	
	public int deposit() {
		System.out.println("Please enter the amount of money you want to deposit");
		Scanner scanner = new Scanner(System.in);
		String line = scanner.nextLine();
		int deposit = Integer.parseInt(line);
		this.deposit = deposit;
		this.avaliableBalance = this.avaliableBalance + this.deposit - this.transactionFee;
		this.availableAmountInMachine = this.availableAmountInMachine + this.deposit;
		System.out.println("Deposit has been made successfully");
		transactions.add("Deposit"+this.deposit);
		accountOptions();
		return this.avaliableBalance;
		
	}
	
	//---------------------------------------------------------------------------
	
	public void recentTransactions() {
		if(transactions.size() < 10) {
			for(int i = 0; i <transactions.size();i++) {
				System.out.println(transactions);
				accountOptions();
			}
		}
		else {
			for(int i = transactions.size();i < 10;i--) {
				System.out.println(transactions);
				accountOptions();
		}
	}
		
		
	}

	
	public static void main(String args[]) {
		User user1 = new User("Bruno", 24, "Pontius AVE", 123456, 456);
		ArrayList<User> users = new ArrayList<>();
		users.add(user1);
		ArrayList<ArrayList<User>> userData = new ArrayList<ArrayList<User>>();
		userData.add(users);
		HashMap<Integer, Integer> userAccount = new HashMap<Integer, Integer>();
		userAccount.put(456, 111);
		Atm atm1 = new Atm(99999, 3, users, userData, userAccount);
		atm1.greetingPage();
	}
}
