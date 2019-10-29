package Assignment6;

import java.util.Arrays;

public class isAnagram {
	public static boolean isAnagram(String s, String t) {
		if(s.length() != t.length()) {
			return false;
		}
		else {
			char[] sa = s.toCharArray();
			char[] ta =t.toCharArray();
			Arrays.sort(sa);
			Arrays.sort(ta);
			if(Arrays.equals(sa, ta)) {
				return true;
			}
			else {
				return false;
			}
		
	}
 }
	
	public static void main(String args[]) {
		String s ="cat";
		String t ="cta";
		System.out.println(isAnagram(s,t));
	}
}
