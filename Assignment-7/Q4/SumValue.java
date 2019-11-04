package Assignment7;

import java.util.Random;

public class SumValue {
	 /*generate array of random numbers*/
    static void generateRandomArray(int[] arr){
    	//Random rand = new Random();
    	if(arr.length <= 0) {
    		return;
    	}
    	for(int i = 0; i < arr.length;i++) {
    		arr[i] = (int) (Math.random()*(9));
    		//System.out.print((int) (Math.random()*(9)));
    	}
    	
    }

    /*get sum of an array using 4 threads*/
    static long sum(int[] arr){
    	Runner r1 = new Runner(arr,0,1000000);
    	Runner r2 = new Runner(arr,1000000, 2000000);
    	Runner r3 = new Runner(arr,2000000, 3000000);
    	Runner r4 = new Runner(arr,3000000, 4000000);
    	Thread t1 = new Thread(r1);
    	Thread t2 = new Thread(r2);
    	Thread t3 = new Thread(r3);
    	Thread t4 = new Thread(r4);
    	t1.start();
    	t2.start();
    	t3.start();
    	t4.start();
    	
    	try {
    		t1.join();
    		t2.join();
    		t3.join();
    		t4.join();
    	}
    	catch(Exception ex) {}
    	return r1.getSum()+r2.getSum()+ r3.getSum()+ r4.getSum();
    }
    static class Runner implements Runnable {
    	long sum = 0;
    	int[] arr;
    	int start;
    	int end;
    	public Runner(int[] arr, int start, int end) {
			this.arr=arr;
			this.start = start;
			this.end = end;
		}

		public void computation(int[] arr) {
			for(int i = start;i < end;i++) {
	    		sum += arr[i];
	    	}
		}
		@Override
		public void run() {
			computation(arr);
		
		}
		public long getSum() {
			return sum;
			
		}

	}
    

    public static void main(String[] args){
        int[] arr = new int[4000000];
        generateRandomArray(arr);
        long sum = sum(arr);
        System.out.println("Sum: " + sum);
        
    }
}
