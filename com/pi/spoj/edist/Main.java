package com.pi.spoj.edist;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException,
			IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCases = Integer.parseInt(br.readLine().trim());
		for (int i = 0; i < testCases; i++) {
			char[] a=br.readLine().trim().toCharArray();
			char[] b=br.readLine().trim().toCharArray();
			
			int dp[][]=new int[a.length+1][b.length+1];
			
			for (int j = 0;  j<= a.length; j++) {
				for (int k = 0; k <= b.length; k++) {
					if(j==0)
					{
						dp[j][k]=k;
					}
					else if(k==0)
					{
						dp[j][k]=j;
					}
					else if(a[j-1]==b[k-1])
					{
						dp[j][k]=dp[j-1][k-1];
					}
					else {
						dp[j][k]=1+min(dp[j-1][k],dp[j][k-1],dp[j-1][k-1]);
					}
				}
			}
			System.out.println(dp[a.length][b.length]);
		}
	}

	private static int min(int i, int j, int k) {
		return Math.min(i, Math.min(j, k));
	}

}
