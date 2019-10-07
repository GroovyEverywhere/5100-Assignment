package Assignment4;

import java.util.Arrays;

public class IDString {
	public static int[] Operation(String S) {
        int N = S.length();
        int low = 0; 
        int high = N;
        int[] ans = new int[N + 1];
        for (int i = 0; i < N; i++) {
            if (S.charAt(i) == 'I') {
                ans[i] = low++;
            }else {
                ans[i] = high--;
            }
        }

        ans[N] = low;
        return ans;
    }
	
	public static void main(String args[]) {
		String S = "DIIIDIDDIDIDDIDIDIID"; 
	    System.out.print(Arrays.toString(Operation(S))); 
	}
}
