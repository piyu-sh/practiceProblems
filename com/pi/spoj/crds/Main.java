package com.pi.spoj.crds;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException,
			IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCases = Integer.parseInt(br.readLine().trim());
		for (int i = 0; i < testCases; i++) {
			long level=Integer.parseInt(br.readLine().trim());
			long cards=(((level*(level+1)/2)*3)-level)%1000007;
			System.out.println(cards);
		}
	}

}
