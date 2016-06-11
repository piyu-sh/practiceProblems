package com.pi.spoj.ny10a;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

	public static void main(String[] args) throws NumberFormatException,
			IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCases = Integer.parseInt(br.readLine().trim());
		for (int i = 0; i < testCases; i++) {
			br.readLine();
			String input = br.readLine().trim();
			Map<String, Integer> count = new HashMap<String, Integer>();
			for (int j = 0; j < input.length() - 2; j++) {
				String three = input.substring(j, j + 3);
				if (count.get(three) != null) {
					count.put(three, count.get(three) + 1);
				} else {
					count.put(three, 1);
				}
			}
			String[] outcomes = { "TTT", "TTH", "THT", "THH", "HTT", "HTH",
					"HHT", "HHH" };
			System.out.print(i + 1);
			for (int j = 0; j < outcomes.length; j++) {
				System.out.print(" "
						+ (null != count.get(outcomes[j]) ? count
								.get(outcomes[j]) : 0));
			}
			System.out.println();
		}
	}

}
