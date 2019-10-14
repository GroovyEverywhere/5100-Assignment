package Assignment5;

public class Contractor extends Employee{
	Contractor(String name, int paymentPerHour, int workingHours) {
		super(name, paymentPerHour);
		// TODO Auto-generated constructor stub
	}

	private int workingHours;

	@Override
	public int calculateSalary() {
		
		return workingHours * paymentPerHour;
	}
	
}
