package com.pi.spoj.easyprob;

public class Main {

	public static void main(String[] args) {
		// break into power of two
		// 137=2(2(2)+2+2(0))+2(2+2(0))+2(0)
		// substitute 2(2) with 2^2
		getResult(137);
	}

	private static void getResult(int i) {
//		int a = i;
//		int twoPow = 0;
//		System.out.print("2(");
//		while (twoPow != i) {
//			int twoPower = getTwoPower(a);
//			twoPow += Math.pow(2,twoPower);
//			System.out.println(twoPower);
//			a=i-twoPow;
//			if(a==i)
//			{
//				System.out.print(")");
//			}
//		}
		
		if(i>0)
		{
			int b=0;
			while(i-b!=0)
			{
				System.out.print("2(");
				int temp = getTwoPower(i);
				if(temp>2)
				{
					getResult(temp);
				}
				else
				{
					System.out.print(temp+")");
				}
				b+=Math.pow(2,temp);
			}
		}
	}

	private static int getTwoPower(int a) {
		int i = 0;
		for (; Math.pow(2, i) < a; ++i) {
			
		}
		if(i-1>2)
		{
			System.out.print("2(");
			System.out.print(getTwoPower(i-1));
			System.out.print(")");
		}
		return i-1;
	}

}
