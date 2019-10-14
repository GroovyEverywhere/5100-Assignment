package Assignment5;

public class Number {

	public static void count(int numerator, int denominator) throws denominatorException{
		if(denominator != 0) {
			System.out.println( numerator / denominator);
		}
		else {
			throw new denominatorException ();
		}
		
	}
	
	public static void main(String args[]) {
		try {
			count(5,0);
		}
		catch(denominatorException de) {
			System.out.println("denominator cannot be 0");
			
		}
		finally {
			System.out.println("Operation Done");
		}
	}
	
	
}


	class denominatorException extends Exception{
	
}
