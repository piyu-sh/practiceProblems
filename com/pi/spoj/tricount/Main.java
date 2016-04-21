package com.pi.spoj.tricount;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException,
			IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCases = Integer.parseInt(br.readLine().trim());
		for (int i = 0; i < testCases; i++) {

			int N = Integer.parseInt(br.readLine().trim());

			long result = (long) (Math.pow(2, N + 1) - 1) - 2;
			System.out.println(result);

		}
	}

}
