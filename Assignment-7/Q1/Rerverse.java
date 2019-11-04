package Assignment7;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class Reverse {
	File file = new File("C:\\Users\\tan_b\\Documents\\Question1.txt");
	static String sentence = "";
	
	public void readFile() throws IOException{
		File file = new File("C:\\Users\\tan_b\\Documents\\Question1.txt");
		FileInputStream fis = new FileInputStream(file);
		readFromStream(fis);
		InputStream is = System.in;
	}
	private static void readFromStream(FileInputStream fis) throws IOException {
		while (true) {
			int x = fis.read();
			if (x == -1)
				break;
			char c = (char) x;
			sentence += Character.toString(c);
			//System.out.print(sentence);
		}
		fis.close();

	}
	public static String reverseWords(String sentence) {
		String [] str = sentence.split(" ");
		String [] s = new String[str.length];
		int count = 0;
		for(int i = str.length - 1; i >=0;) {
			s [count] = str[i];
			--i;
			count++;
		}
		String string = String.join(" ", s);
		return string;
	}
	
	public void writeFile() throws IOException{
		File file = new File("C:\\Users\\tan_b\\Documents\\res.txt");
		FileOutputStream fos = new FileOutputStream(file);
		String reverseWords = reverseWords(Reverse.sentence);
		fos.write(reverseWords.getBytes());
		System.out.println(reverseWords);
		fos.close();

	}
	
	public static void main(String args[]) throws IOException{
		Reverse test = new Reverse();
		test.readFile();
		test.writeFile();
	
	}
}
