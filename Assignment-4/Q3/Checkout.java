package Assignment4;

import java.util.Vector;

public class Checkout{
	Vector <DessertItem> v = new Vector<>();
	DessertShop d = new DessertShop();
	public Checkout() {
		this.v = new Vector<>();
	}
	
	public int numberOfItems() {
		return this.v.size();
		
	}
	
	public void enterItem(DessertItem name) {
		 this.v.add(name);
	}

	public void clear() {
		this.v.clear();
	}

	public int totalCost() {
		int sum = 0;
		for(int i = 0; i<v.size(); i++) {
			sum = sum + v.get(i).getCost();
		}
		return sum;
		
	}
	public int totalTax() {
		return (int) Math.round(totalCost() * d.taxRate);
	}
	
	public String toString(){
		String head = "       M & M Dessert Shop" + '\n' + "      -------------------" + '\n';
		String result = "";
		for(int i = 0; i < v.size(); i++) {
			result = result + v.get(i).getName() +"       " +  d.cents2dollarsAndCentsmethod(v.get(i).getCost()) + '\n';
		}
		String cost = "Total Cost:     " + d.cents2dollarsAndCentsmethod(totalCost()+totalTax()) + '\n' + "Total Tax:      " + d.cents2dollarsAndCentsmethod(totalTax())+ '\n';
		
		return head + result + cost;
		
	}
}

