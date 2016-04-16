package com.pi.spoj.findPrime;
import java.util.Scanner;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception  {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		int cases = scan.nextInt();
		int i = 0;
		long num1;
		long num2;
		int result = 0;
		while (i < cases) {
			num1 = scan.nextInt();
			num2 = scan.nextInt();
			for (long j = num1; j <= num2; j++) {
				if (isPrime(j)) {
					System.out.println(j);
				}
			}
			i++;
		}
		scan.close();

	}

	private static boolean isPrime(long n) {
	    if(n < 2) return false;
	    if(n == 2 || n == 3) return true;
	    if(n%2 == 0 || n%3 == 0) return false;
	    long sqrtN = (long)Math.sqrt(n)+1;
	    for(long i = 6L; i <= sqrtN; i += 6) {
	        if(n%(i-1) == 0 || n%(i+1) == 0) return false;
	    }
	    return true;
	}

}
