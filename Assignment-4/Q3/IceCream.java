package Assignment4;

public class IceCream extends DessertItem {
	double cost;
	IceCream(String name, double cost){
		super(name);
		this.cost = cost;
	}
	@Override
	public int getCost() {
		// TODO Auto-generated method stub
		return (int) Math.round(cost);
	}

}
