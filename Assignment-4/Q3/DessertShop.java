package Assignment4;

public class DessertShop {
	double taxRate = 0.065;
	final String shopName = "M & M Dessert Shop";
	
	DessertShop(){
		
	}
	public String cents2dollarsAndCentsmethod(int price) {
		return String.valueOf((float)price/100);
		
	}
}
