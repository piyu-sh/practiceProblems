package com.pi.spoj.canton;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException,
			IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCases = Integer.parseInt(br.readLine().trim());
		for (int i = 0; i < testCases; i++) {
			int parseInt = Integer.parseInt(br.readLine().trim());
			System.out.println("TERM " + parseInt + " IS "
					+ print_fraction(parseInt));
		}
	}

	private static String print_fraction(int n) {
		int d = (int) ((-1 + Math.sqrt(1 + 8 * n)) / 2); /* Diagonals to skip */
		int e = n - d * (d + 1) / 2; /*
									 * Extra steps after the skip.
									 */
		int v1 = e <= 1 ? d + e : d + 2 - e;
		int v2 = e <= 1 ? 1 : e;

		return String.valueOf(d % 2 == 0 ? v1 : v2) + "/"
				+ String.valueOf(d % 2 == 0 ? v2 : v1);
	}

}
