package Assignment7;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class CountLines {
    
	public void countLines(String fileName) throws Exception{
		String Path = "C:\\Users\\tan_b\\Documents\\" + fileName;
    	File file = new File(Path);
    	if(!file.exists()) {
    		throw new FileNotFoundException();
    	}
    	else{
    		int count = 0;
    		FileReader fr = new FileReader(Path);
    		BufferedReader br = new BufferedReader(fr);
    		while(br.readLine() != null){
    			count++;
    		}
    		System.out.println(fileName + " = " +count);
    		if(br.readLine() == null && count == 0) {
    			System.out.println(fileName + " = " + 0);
    		}
    		fr.close();
    		br.close();
    		}
    	}
	public static void main(String args[]) throws Exception{
		CountLines cl = new CountLines();
		System.out.println("Enter the file name, if you want to enter more than one file please spearated them by space");
		String file = null;
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		String [] setOfInput = input.split(" ");
		for(int i = 0;i < setOfInput.length;i++) {
			file = setOfInput[i];
			try{
				cl.countLines(file);
			}
			catch(Exception e){
				System.out.println(file + " does not exist.");
			}
		}
	}
	
}
