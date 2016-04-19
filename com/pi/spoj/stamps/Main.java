package com.pi.spoj.stamps;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

	public static void main(String[] args) throws NumberFormatException,
			IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCases = Integer.parseInt(br.readLine().trim());
		for (int i = 0; i < testCases; i++) {
			String party[] = br.readLine().trim().split(" ");
			int required = Integer.parseInt(party[0]);
			int friends = Integer.parseInt(party[1]);
			String[] stampString = br.readLine().trim().split(" ");
			List<Integer> stamps = new ArrayList<Integer>();
			for (int j = 0; j < friends; j++) {
				stamps.add(Integer.parseInt(stampString[j]));
			}
			Collections.sort(stamps);
			Collections.reverse(stamps);
			long sum = 0;
			int count = 0;
			for (Integer integer : stamps) {
				sum += integer;
				if (sum >= required) {
					break;
				}
				count++;
			}
			System.out.println("Scenario #" + (i + 1) + ":");
			System.out.println(count == friends ? "impossible" : count + 1);
			System.out.println();
		}
	}

}
