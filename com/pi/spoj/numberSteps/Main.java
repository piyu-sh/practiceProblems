package com.pi.spoj.numberSteps;
import java.util.Scanner;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		int cases = scan.nextInt();
		int i = 0;
		long num1;
		long num2;
		long result = 0;
		while (i < cases) {
			num1 = scan.nextInt();
			num2 = scan.nextInt();
			result=result(num1,num2);
			System.out.println(result==-1?"No Number":result);
			i++;
		}
		scan.close();

	}

	private static long result(long num1, long num2) {
		long result=0;
		if(num1==num2||num1-num2==2)
		{
			result=num1+num2;
			if(num1%2!=0)
			{
				result-=1;
			}
		}
		else
		{
			result= -1;
		}
		return result;
	}

}
