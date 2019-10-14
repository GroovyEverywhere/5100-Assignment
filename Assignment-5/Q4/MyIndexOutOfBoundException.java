package Assignment5;

public class MyIndexOutOfBoundException {
	
	
	public static void main(String args[]) {
		int [] ar = {1,2,3,4};
		for(int i = 0; i < ar.length+2; i++) {
		try {
			
			if(i > ar.length){
				throw new indexOutOfBoundException(0, ar.length-1, i);
				
			}else {
				System.out.println(ar[i]);
			}
		}
		catch(Exception e) {
			System.out.println(" ");
		}
		}
	}
	}




	class indexOutOfBoundException extends Exception{
		int lowerBound;
		int upperBound;
		int index;
		
		indexOutOfBoundException(int lowerBound, int upperBound, int index){
			this.lowerBound = lowerBound;
			this.upperBound = upperBound;
			this.index = index;
			System.out.println("Error Message: Index: " + index + " but Lower bound: " + lowerBound + ", Upper bound: " + upperBound );
		}
	}
