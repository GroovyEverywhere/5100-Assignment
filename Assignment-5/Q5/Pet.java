package Pet;

public class Pet {
	String petName;
	String ownerName;
	String color;
	protected int sex;
	public static final int MALE = 1;
	public static final int FEMALE = 2;
	public static final int SPAYED = 3;
	public static final int NEUTERED = 4;
	
	public Pet(String petName, String ownerName, String color){
		this.petName = petName;
		this.ownerName = ownerName;
		this.color = color;
	}
	
	String getName() {
		return petName;
	}
	
	String getOwnerName() {
		return ownerName;
	}

	String getColor() {
		return color;
	}
	
	void setSex(int sexid) {
		this.sex = sexid;
	}
	
	public String getSex() {
		if(this.sex == MALE) {
			return "MALE";
		}
		if(this.sex == 2) {
			return "FEMALE";
		}
		if(this.sex == 3) {
			return "SPAYED";
		}
		if(this.sex == 4) {
			return "NEUTERED";
		}
		else {
			return null;
		}
	}
	
	public String toString() {
		return this.getName() + " owned by " + this.getOwnerName() + '\n' + "Color: " + this.getColor() + '\n' + "Sex: " + this.getSex();
	}
	
	public static void main(String args[]) {
		Pet p = new Pet("Ted","Bruno","Black");
		p.sex = MALE;
		System.out.println(p);
	}
}
