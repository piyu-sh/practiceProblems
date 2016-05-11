package com.pi.spoj.girlsnbs;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String num;
		while (!"-1 -1".equals((num = br.readLine().trim()))) {
			String[] split = num.split(" ");
			double a = Double.parseDouble(split[0]);
			double b = Double.parseDouble(split[1]);
			System.out.println(a > b ? (int)Math.ceil(a / (b + 1)) : (int)Math.ceil(b
					/ (a + 1)));
		}
	}
}
