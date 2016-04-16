package com.pi.spoj.addReverse;
import java.util.Scanner;

public class Main {

	
	public static void main(String[] args) {

		Scanner scan=new Scanner(System.in);
		int cases=scan.nextInt();
		int i=0;
		while(i<cases)
		{
			int num1=scan.nextInt();
			int num2=scan.nextInt();
			int result=reverseNumber(reverseNumber(num1)+reverseNumber(num2));
			System.out.println(result);
			i++;
		}
		scan.close();
	}

	public static int reverseNumber(int n) {
	       int result = 0;
	       int rem;
	       while (n > 0) {
	           rem = n % 10;
	           n = n / 10;
	           result = result * 10 + rem;
	       }
	       return result;
	   }

}
