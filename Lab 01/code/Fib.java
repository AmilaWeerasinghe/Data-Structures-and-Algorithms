import java.util.Arrays;

class Fib {

    public static int fib_r(int x) {
	if(x <= 2) return 1;
	return fib_r(x-1) + fib_r(x-2);
    }

    public static int fib_i(int x) {
	int a=1, b=1, fib=1, i=2;
	while(i<x) {
	    fib = a + b;
	    a = b;
	    b = fib;
	    i+=1;
	}
	return fib;
    }


    public static void main(String [] args) {
	int x = 10;
	int a[]=new int[40];
	float time[]=new float[40];


	/*for(int i=1;i<41;i++) {
		//measure time for executing using recursion java
		long startTime_r = System.nanoTime();
		System.out.println("Fib of " + i + " = " + fib_r(i));
		long stopTime_r = System.nanoTime();
		long elapsedTime_r = stopTime_r - startTime_r;
		a[i-1]=i;
		time[i-1]=elapsedTime_r;
		System.out.println("Java recursion time, number = " + i + " time in (nano sec) = " + elapsedTime_r);

	}

		System.out.println(Arrays.toString(time));*/

		//measure time for executing using iteration java
		for(int j=1;j<41;j++) {
			long startTime_i = System.nanoTime();
			System.out.println("Fib of " + j + " = " + fib_i(j));
			long stopTime_i = System.nanoTime();
			long elapsedTime_i = stopTime_i - startTime_i;
			a[j-1]=j;
			time[j-1]=elapsedTime_i;
			System.out.println("Java iteration time, number = " + j + " time in (nano sec) = " + elapsedTime_i);
		}

		System.out.println(Arrays.toString(time));
    }
}

	
