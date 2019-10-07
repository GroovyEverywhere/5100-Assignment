package Assignment4;

public class Candy extends DessertItem{
	double weight;
	int PricePerPound;
	
	 Candy(String name, double weight, int PricePerPound) {
		super(name);
		this.weight = weight;
		this.PricePerPound = PricePerPound;
		
	}
	@Override
	public int getCost() {
		// TODO Auto-generated method stub
		return (int) Math.round(weight * PricePerPound);
	}

}
