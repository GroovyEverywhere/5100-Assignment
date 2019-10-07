package Assignment4;


public class Matrices{
public static int[][] compute(int[][] A, int[][] B) {

 
    int[][] C = new int[A.length][B[0].length];
 
    for(int i=0; i<C.length; i++){
        for(int j=0; j<C[0].length; j++){
            int sum=0;
            for(int k=0; k<A[0].length; k++){
                sum += A[i][k]*B[k][j];
            }
            C[i][j] = sum;
        }
    }
 
    return C;
}
public static void main(String args[]) {
	int [][] A = {{1,0,0},{-1,0,3}};
	int [][] B = {{7,0,0},{0,0,0},{0,0,1}};
	for (int i = 0; i < compute(A,B).length; i++) 
		  
        
        for (int j = 0; j < compute(A,B)[i].length; j++) 
            System.out.print(compute(A,B)[i][j] + " "); 
}
}
