package com.pi.spoj.easyprob;

public class Main {

	public static void main(String[] args) {
		// break into power of two
		// 137=2(2(2)+2+2(0))+2(2+2(0))+2(0)
		// substitute 2(2) with 2^2
		getResult(137);
	}

	private static String getResult(int i) {
		String result = "2(";

		int a = i;
		int twoPow = 0;
		System.out.print("2(");
		while (twoPow != i) {
			int twoPower = getTwoPower(a);
			twoPow += twoPower;
			System.out.println(twoPower);
			a=i-twoPow;
			if(a==i)
			{
				System.out.print(")");
			}
		}

		return result;
	}

	private static int getTwoPower(int a) {
		int i = 0;
		for (; Math.pow(2, i) < a; ++i) {
			
		}
		if(i-1>2)
		{
			System.out.print("2(");
			System.out.println(getTwoPower(i-1));
			System.out.print(")");
		}
		return i-1;
	}

}
