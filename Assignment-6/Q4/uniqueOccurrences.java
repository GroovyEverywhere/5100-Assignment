package Assignment6;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class uniqueOccurrences {
	public static boolean uniqueOccurrences(int[] arr) {
		  HashMap<Integer, Integer> map = new HashMap<>();
	        for(int i: arr) {
	            if(map.containsKey(i)) {
	            	map.put(i, map.get(i)+1);
	            }
	            else {
	            	map.put(i, 1);
	            }
	        }
	        Set<Integer> set = new HashSet<>();
	        for(int i: map.keySet()) {
	            if(set.contains(map.get(i))) {
	            	return false;
	            }
	            set.add(map.get(i));
	        }
	        return true;
	}
	public static void main(String args[]) {
		int[] arr = {1,2,3,2,1,5,6,6,6};
		int[] arr1 = {1,2,3,2,3,3,6,6,6,6};
		System.out.println(uniqueOccurrences(arr));
		System.out.println(uniqueOccurrences(arr1));
	}
}
