package com.pi.spoj.hpynos;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {

	public static void main(String[] args) throws NumberFormatException,
			IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String num = br.readLine().trim();
		long result = 0;
		Set<Long> unique = new HashSet<Long>();
		long count = 0;

		while (result != 1) {
			unique.add(result);
			num = result == 0 ? num : String.valueOf(result);
			result = 0;
			for (int i = 0; i < num.length(); i++) {
				result += Math
						.pow(Integer.parseInt(num.substring(i, i + 1)), 2);
			}
			if (unique.contains(result)) {
				count = -1;
				break;
			}
			count++;

		}
		System.out.println(count);
	}

}
