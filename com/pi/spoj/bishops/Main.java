package com.pi.spoj.bishops;

import java.io.IOException;
import java.math.BigInteger;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(System.in);
		String num;
		while (scan.hasNextBigInteger()) {
			num = scan.nextLine().trim();
			if ("0".equalsIgnoreCase(num)) {
				System.out.println("0");
				continue;
			} else if ("1".equalsIgnoreCase(num)) {
				System.out.println("1");
				continue;
			}
			BigInteger num1 = new BigInteger(num);
			BigInteger result = (num1.subtract(BigInteger.ONE))
					.multiply(BigInteger.valueOf(2));
			System.out.println(result);
		}
		scan.close();
	}

}
