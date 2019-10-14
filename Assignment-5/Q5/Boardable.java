package Boardable;

public interface Boardable {

	static void setBoardStart(int month, int day, int year){
		if(month < 1 || month > 12 || day < 1 || day >31 || year <1000 || year >9999) {
			return;
		}
	}
	
	static void setBoardEnd(int month, int day, int year) {
		if(month < 1 || month > 12 || day < 1 || day >31 || year <1000 || year >9999) {
			return;
		}
	}
	
	static boolean boarding(int month, int day, int year) {
		if(month < 1 || month > 12 || day < 1 || day >31 || year <1000 || year >9999) {
			return false;
		}
		else{
			return true;
		}
		
	}
}
