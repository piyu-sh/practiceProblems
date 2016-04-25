package com.pi.spoj.ap2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException,
			IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long testCases = Long.parseLong(br.readLine().trim());
		for (long i = 0; i < testCases; i++) {

			String[] split = br.readLine().trim().split(" ");
			long third = Long.parseLong(split[0]);
			long thirdLast = Long.parseLong(split[1]);
			long sum = Long.parseLong(split[2]);

			long n = (2 * sum) / (third + thirdLast);
			long d = (thirdLast - third) / (n - 5);
			long a = third - 2L * d;
			System.out.println(n);
			for (long j = 0; j < n; j++) {
				System.out.print(a+j*d+" ");
			}
			System.out.println();
		}
	}

}
