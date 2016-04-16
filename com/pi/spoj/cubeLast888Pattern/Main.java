package com.pi.spoj.cubeLast888Pattern;

import java.util.Scanner;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		long cases = scan.nextLong();
		long num;
		long result;
		for (int i = 0; i < cases; i++) {
			num = scan.nextLong();
			result = FindKth888cube(num);
			System.out.println(result);
		}
		scan.close();
	}

	private static long FindKth888cube(long num) {
		long result = 0;
		result = 192 + 250 * (num - 1);
		return result;
	}

}
