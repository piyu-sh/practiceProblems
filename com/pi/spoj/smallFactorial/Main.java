package com.pi.spoj.smallFactorial;

import java.math.BigInteger;
import java.util.Scanner;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {


		Scanner scan=new Scanner(System.in);
		int cases=scan.nextInt();
		for (int i=0;i<cases;i++)
		{
			int num1=scan.nextInt();
			BigInteger result=factorial(num1);
			System.out.println(result);
		}
		scan.close();
	
	}

	private static BigInteger factorial(int num1) {
		BigInteger result = BigInteger.valueOf(num1);
		for(int i=num1-1;i>0;i--)
		{
			result=result.multiply(BigInteger.valueOf(i));
		}
		return result;
	}

}
