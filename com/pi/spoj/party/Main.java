package com.pi.spoj.party;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String num;
		while (!"0 0".equals((num = br.readLine().trim()))) {
			if ("".equals(num)) {
				continue;
			}
			String[] split = num.split(" ");
			int money = Integer.parseInt(split[0].trim());
			int party = Integer.parseInt(split[1].trim());
			int fee[] = new int[party];
			int fun[] = new int[party];
			int dp[][] = new int[party + 1][money + 1];
			for (int i = 0; i < party; i++) {
				String[] split2 = br.readLine().trim().split(" ");
				fee[i] = Integer.parseInt(split2[0].trim());
				fun[i] = Integer.parseInt(split2[1].trim());
			}
			for (int i = 0; i < party + 1; i++) {
				for (int j = 0; j < money + 1; j++) {
					if (i == 0 || j == 0) {
						dp[i][j] = 0;
					} else if (fee[i - 1] <= j) {
						dp[i][j] = Math.max(fun[i - 1]
								+ dp[i - 1][j - fee[i - 1]], dp[i - 1][j]);
					} else {
						dp[i][j] = dp[i - 1][j];
					}

				}
			}

			int i = party, b = money;
			while (dp[i][b] == dp[i][b - 1]) {
				b--;
			}
			System.out.println(b + " " + dp[party][money]);
		}
	}

}
