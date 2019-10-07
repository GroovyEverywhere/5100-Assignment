package Assignment4;

public class Cookie extends DessertItem{
	int number;
	double PricePerDozen;
	
	Cookie(String name, int number, double PricePerDozen){
		super(name);
		this.number = number;
		this.PricePerDozen = PricePerDozen;
	}
	@Override
	public int getCost() {
		// TODO Auto-generated method stub
		return (int) Math.round(number * PricePerDozen/12);
	}

}
