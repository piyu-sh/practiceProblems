package com.pi.spoj.apGp;
import java.util.Scanner;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		long num1=0,num2 = 0,num3 = 0;
		while (true) {
			num1 = scan.nextInt();
			num2 = scan.nextInt();
			num3 = scan.nextInt();
			if(num1==0&&num2==0&&num3==0)
			{
				break;
			}
			printResult(num1,num2,num3);
		}
		scan.close();

	}

	private static void printResult(long num1, long num2, long num3) {
		long result = 0;
		if(num3-num2==num2-num1&& num3-num2!=0)
		{
			result=num1+3*(num2-num1);
			System.out.println("AP "+result);
		}
		else
		{
			result=(long) (num1*Math.pow(num2/num1, 3));
			System.out.println("GP "+result);
		}
	}


}
