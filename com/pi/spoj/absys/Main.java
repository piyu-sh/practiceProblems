package com.pi.spoj.absys;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCases = Integer.parseInt(br.readLine().trim());
		for (int i = 0; i < testCases; i++) {
			String equation;
			while (true) {
				equation = br.readLine().trim();
				if (equation.length() > 0)
					break;
			}
			String[] split = equation.split("\\+");
			String[] split2 = split[1].split("=");
			int pos = 0;
			String a = split[0];
			String b = split2[0];
			String c = split2[1];
			int num[] = new int[3];
			num[0] = a.contains("m") ? 0 : Integer.parseInt(a.trim());
			num[1] = b.contains("m") ? 0 : Integer.parseInt(b.trim());
			num[2] = c.contains("m") ? 0 : Integer.parseInt(c.trim());
			int result = 0;
			if (num[0] == 0) {
				result = num[2] - num[1];
				pos = 0;
			} else if (num[1] == 0) {
				result = num[2] - num[0];
				pos = 1;
			} else if (num[2] == 0) {
				result = num[0] + num[1];
				pos = 2;
			}
			num[pos] = result;
			System.out.println(num[0] + " + " + num[1] + " = " + num[2]);
		}
	}

}
