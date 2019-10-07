package Assignment4;

public class Sundae extends IceCream {
	String topping;
	double toppingCost;
	
	Sundae(String name, double cost, String topping, double toppingCost) {
		super(name, cost);
		this.topping = topping;
		this.toppingCost = toppingCost;
	}
	
	public String getName() {
		return super.name + " with " + this.topping;
		
	}
	
	public int getCost() {
		// TODO Auto-generated method stub
		return (int) Math.round(super.getCost() + toppingCost);
	}

}
