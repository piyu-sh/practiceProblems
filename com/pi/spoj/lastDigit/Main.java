package com.pi.spoj.lastDigit;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int cases = scan.nextInt();
		BigInteger a;
		BigInteger b;
		BigInteger c;
		for (int i = 0; i < cases; i++) {
			a = scan.nextBigInteger();
			b = scan.nextBigInteger();
			c = a.modPow(b, new BigInteger("10"));
			System.out.println(c);
		}
		scan.close();

	}

}
