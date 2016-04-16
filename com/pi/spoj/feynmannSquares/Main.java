package com.pi.spoj.feynmannSquares;
import java.util.Scanner;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		long num1;
		long result = 0;
		while ((num1 = scan.nextInt())!=0) {
			result = findSquares(num1);
			System.out.println(result);
		}
		scan.close();

	}

	private static long findSquares(long num1) {
		long result = 0;
		for(int i=1;i<=num1;i++)
		{
			result+=Math.pow(i, 2);
		}
		return result;
	}

}
