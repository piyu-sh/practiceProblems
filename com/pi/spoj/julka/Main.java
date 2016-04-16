package com.pi.spoj.julka;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		BigInteger total;
		BigInteger more;
		BigInteger klaudia;
		BigInteger natalie;
		for (int i = 0; i < 10; i++) {
			total = scan.nextBigInteger();
			more = scan.nextBigInteger();
			natalie=(total.subtract(more)).divide(new BigInteger("2"));
			klaudia=natalie.add(more);
			System.out.println(klaudia);
			System.out.println(natalie);
		}
		scan.close();

	}

}
