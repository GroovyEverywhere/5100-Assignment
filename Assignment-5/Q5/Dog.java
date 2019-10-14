package Dog;

import Boardable.Boardable;
import Pet.Pet;

public class Dog extends Pet implements Boardable{

	
	private String size;
	int startDay;
	int startMonth;
	int startYear;
	int endDay;
	int endMonth;
	int endYear;
	

	public Dog(String petName, String ownerName, String color,String size) {
		super(petName, ownerName, color);
		this.size = size;
		// TODO Auto-generated constructor stub
	}
	String getSize() {
		return size;
	}

	public String toString() {
		return "DOG:" + '\n' + super.toString() + '\n' + "Size: " + this.getSize();
	}
	
	void setBoardStart(int month, int day, int year) {
		this.startDay = day;
		this.startMonth = month;
		this.startYear = year;			
	}
	 void setBoardEnd(int month, int day, int year) {
		this.endDay = day;
		this.endMonth = month;
		this.endYear = year;
	 }
	 boolean boarding(int month, int day, int year) {
		 if(year > startYear && year < endYear) {
			 return true;
		 }
		 else if(year == startYear) {
			 if(month > startMonth && year < endMonth) {
				 return true;
			 }
			 else if(month == startMonth) {
				 if(day >= startDay &&  day <= endDay) {
					 return true;
				 }
			 }
		 }
		 else if(year == endYear) {
			 if(month > startMonth && year < endMonth) {
				 return true;
			 }
			 else if(month == startMonth) {
				 if(day >= startDay && day <= endDay) {
					 return true;
				 }
			 }
		 }
		 
			 return false;
		 
	 }
	
	
	public static void main(String args[]) {
		Dog d = new Dog("Ted","Bruno","Black", "Medium");
		d.sex = FEMALE;
		d.setBoardStart(10, 1, 2020);
		d.setBoardEnd(10, 8, 2020);
		System.out.println(d);
		System.out.println(d.boarding(10, 7, 2020));
	}
}
