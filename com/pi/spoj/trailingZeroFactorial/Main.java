package com.pi.spoj.trailingZeroFactorial;
import java.util.Scanner;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception  {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		long cases = scan.nextInt();
		long i = 0;
		long num1;
		while (i < cases) {
			num1 = scan.nextInt();
			System.out.println(findTrailingZeros(num1));
			i++;
		}
		scan.close();

	}
	
	public  static  long  findTrailingZeros(long  number)  {

		long count = 0;

		if(number == 5){
		return 1; 
		}
		for ( long j = 5; number/j >= 1; j *= 5 )
		{
	
		count  +=  number  /  j;
		}

		return count;
		}
}
