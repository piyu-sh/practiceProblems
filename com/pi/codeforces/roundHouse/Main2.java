package com.pi.codeforces.roundHouse;
import java.util.Scanner;

public class Main2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);

		int n = scan.nextInt();
		int a = scan.nextInt();
		int b = scan.nextInt();

		int result = a;
	
		for (int i = 1; i <= Math.abs(b); i++) {
			if(b<0)
			{
				result--;
				if(result<1)
				{
					result=n;
				}
			}
			else
			{
				result++;
				if(result>n)
				{
					result=1;
				}
			}
		}
		System.out.print(Math.abs(result));
	}

}
