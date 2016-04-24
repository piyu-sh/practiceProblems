package com.pi.spoj.tricount;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {
	public static void main(String[] args) throws NumberFormatException,
			IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tC = Integer.parseInt(br.readLine().trim());
		for (int i = 0; i < tC; i++) {
			long N = Long.parseLong(br.readLine().trim());
			long j = (N*(N+2)*(2*N+1))/8;
			System.out.println(j);
		}
	}
}
