package com.pi.spoj.lastdig2;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCases = Integer.parseInt(br.readLine().trim());
		for (int i = 0; i < testCases; i++) {
			String[] split = br.readLine().trim().split(" ");
			String a = split[0].substring(split[0].length() - 1);
			String b = split[1];
			BigInteger a1 = new BigInteger(a);
			BigInteger modPow = a1.modPow(new BigInteger(b), BigInteger.TEN);
			System.out.println(b == "0" ? 1 : (b == "1" ? a : modPow));
		}
	}

}
