package Cat;

import Boardable.Boardable;
import Pet.Pet;

public class Cat extends Pet implements Boardable{
	
	private String hairLength;
	int startDay;
	int startMonth;
	int startYear;
	int endDay;
	int endMonth;
	int endYear;
	

	Cat(String petName, String ownerName, String color, String hairLength) {
		super(petName, ownerName, color);
		this.hairLength = hairLength;
		// TODO Auto-generated constructor stub
	}
	String getHairLength() {
		return hairLength;
	}

	public String toString() {
		return "CAT:" + '\n' + super.toString() + '\n' + "Hair: " + this.getHairLength();
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
		Cat c = new Cat("Ted","Bruno","Black", "Short");
		c.sex = FEMALE;
		c.setBoardStart(10, 1, 2020);
		c.setBoardEnd(10, 8, 2020);
		System.out.println(c);
		System.out.println(c.boarding(10, 7, 2020));
	}
}
