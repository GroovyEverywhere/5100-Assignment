package Assignment7;

import java.util.ArrayDeque;
import java.util.Deque;

public class Decode {
	public static String decode(String s) {
		if(s == null || s.length() == 0) {
			return "";
		}
    
		int num = 0;
		Deque<Object> stack = new ArrayDeque<>();
		for(char c : s.toCharArray()){
			if(Character.isDigit(c)){
				num = num*10 + (c - '0');
			}else if(c == '['){
				stack.push(Integer.valueOf(num));
				num = 0;
			}else if(c == ']'){
				stack.push(popString(stack));
			}else{
				stack.push(String.valueOf(c));
			}
		}
    return popString(stack);        
}

	public static String popString(Deque<Object> s){
		StringBuilder sb = new StringBuilder();
		String result = "";
		Integer num = new Integer(1);
    
		while(!s.isEmpty() && s.peek() instanceof String){
			sb.insert(0, s.pop());
		}
		if(s.peek() instanceof Integer){
			num = (Integer) s.pop();
		}
    
		for(int i = 0; i < num; i++){
			result += sb.toString();
		}
    
		return result;
	}
	public static void main(String args[]) {
		String s = "3[a]2[bc]";
		System.out.println(decode(s));
	}

}
