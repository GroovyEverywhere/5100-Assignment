package Assignment5;

public abstract class Employee {
	String name;
	int paymentPerHour;
	
	 Employee(String name, int paymentPerHour) {
		
	}
	 public abstract int calculateSalary();
	 
	 public String getName() {
		return name;
		 
	 }
	 public void setName(String name) {
		 
	 }
	 public int getPaymentPerHour(){
		return paymentPerHour;
		 
	 }
	 public void setPaymentPerHour(int paymentPerHour) {
		 
	 }
}
