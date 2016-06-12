package com.pi.spoj.arith2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException,
			IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCases = Integer.parseInt(br.readLine().trim());
		for (int i = 0; i < testCases; i++) {
			br.readLine();
			String[] split = br.readLine().trim().split(" ");
			long result = 0;
			String operator = "";
			long num = 0;
			for (int j = 0; j < split.length; j++) {
				String literal = split[j].trim();
				if ("".equals(literal)) {
					continue;
				}
				if (Character.isDigit(literal.toCharArray()[0])) {
					num = Long.parseLong(literal);
					if ("*".equals(operator)) {
						result *= num;
					} else if ("/".equals(operator)) {
						result /= num;
					} else if ("+".equals(operator)) {
						result += num;
					} else if ("-".equals(operator)) {
						result -= num;
					} else if ("=".equals(operator)) {
						break;
					} else {
						result = num;
					}
					operator = "";
				} else {
					operator = literal;
				}
			}
			System.out.println(result);
		}
	}
}
