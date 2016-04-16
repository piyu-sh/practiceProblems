package com.pi.spoj.bigIntCandy;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int cases = scan.nextInt();

		BigInteger children;
		BigInteger total;
		for (int i = 0; i < cases; i++) {
			scan.nextLine();
			children = scan.nextBigInteger();
			total = BigInteger.ZERO;
			for (BigInteger bi = BigInteger.ZERO; bi.compareTo(children) < 0; bi = bi
					.add(BigInteger.ONE)) {
				BigInteger totalModChildren = total.mod(children);
				BigInteger candyModChildren = scan.nextBigInteger().mod(
						children);
				total = (totalModChildren.add(candyModChildren)).mod(children);
			}
			if (total.compareTo(BigInteger.ZERO) == 0) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}

	}
}
