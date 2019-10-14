package Assignment5;

public class FullTime extends Employee{

	FullTime(String name, int paymentPerHour) {
		super(name, paymentPerHour);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int calculateSalary() {
		// TODO Auto-generated method stub
		return 8*paymentPerHour;
	}

}
