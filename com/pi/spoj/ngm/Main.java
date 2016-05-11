package com.pi.spoj.ngm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long num = Long.parseLong(br.readLine().trim());
		if (num % 10 == 0) {
			System.out.println(2);
		} else {
			System.out.println(1);
			System.out.println(num % 10);
		}

	}

}
