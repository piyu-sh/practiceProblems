package com.pi.spoj.party;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;
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
			int fee[]=new int[party];
			int fun[]=new int[party];
			int dp[][]=new int[party+1][money+1];
			for (int i = 0; i < party+1; i++) {
				dp[i][0]=0;
				String[] split2 = br.readLine().trim().split(" ");
				fee[i]=Integer.parseInt(split2[0]);
				fun[i]=Integer.parseInt(split2[1]);
			}
			for (int i = 0; i < money+1; i++) {
				dp[0][i]=0;
			}
			
			for (int i = 1; i <= party; i++) {
				for (int j = 1; j <= money; j++) {
					if(fee[i-1]<=j)
					{
				          dp[i][j]=Math.max(fun[i-1]+dp[i-1][j-fee[i-1]],dp[i-1][j]);
					}else
					{
				          dp[i][j]=dp[i-1][j];
					}
						
				}
			}
			 System.out.println(j+" "+ar[n][budget]);
		}
	}

}
