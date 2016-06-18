package com.pi.spoj.easyprob;

public class Main {

	public static void main(String[] args) {
		// break into power of two
		// 137=2(2(2)+2+2(0))+2(2+2(0))+2(0)
		// substitute 2(2) with 2^2
		System.out.print("137=");
		getResult(137);
		System.out.println();
		System.out.print("1315=");
		getResult(1315);
		System.out.println();
		System.out.print("73=");
		getResult(73);
		System.out.println();
		System.out.print("136=");
		getResult(136);
		System.out.println();
		System.out.print("255=");
		getResult(255);
		System.out.println();
		System.out.print("1384=");
		getResult(1384);
		System.out.println();
		System.out.print("16385=");
		getResult(16385);
	}

	private static void getResult(int i) {
		if (i > 0) {
			int b = i;
			while (b != 0) {
				int temp = 1;
				System.out.print("2");
				temp = getTwoPower(b);
				if (temp > 2) {
					System.out.print("(");
					getResult(temp);
					System.out.print(")");
				} else if(temp!=1) {
					System.out.print("(");
					System.out.print(temp + ")");
				}
				b -= Math.pow(2, temp);
				if (b != 0)
					System.out.print("+");
			}
		}
	}

	private static int getTwoPower(int a) {
		int i = 0;
		for (; Math.pow(2, i) <= a; ++i) {

		}
		return i - 1;
	}

}
