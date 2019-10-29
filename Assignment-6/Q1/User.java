package Assignment6;

public class User {
	private String name;
	private int age;
	private String address;
	private int phoneNumber;
	private int bankAccountNumber;
	
	public User(String name, int age, String address, int phoneNumber, int bankAccountNumber){
		this.setName(name);
		this.setAge(age);
		this.setAddress(address);
		this.setPhoneNumber(phoneNumber);
		this.setBankAccountNumber(bankAccountNumber);
	}
	
	 public String getName() {
		return name;
	}
	 void setName(String name) {
		 this.name = name;
	 }
	 public int getAge() {
		 return age;
	 }
	 void setAge(int age) {
		 this.age = age;
	 }
	 public String getAddress() {
		 return address;
	 }
	 void setAddress(String address) {
		 this.address = address;
	 }
	 public int getPhoneNumber() {
		 return phoneNumber;
	 }
	 void setPhoneNumber(int phoneNumber) {
		 this.phoneNumber = phoneNumber;
	 }
	 public int getBankAccountNumber() {
		 return bankAccountNumber;
	 }
	 void setBankAccountNumber(int bankAccountNumber) {
		 this.bankAccountNumber = bankAccountNumber;
	 }
}
