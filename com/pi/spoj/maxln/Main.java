package com.pi.spoj.maxln;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

public class Main {

	public static void main(String[] args) throws NumberFormatException,
			IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCases = Integer.parseInt(br.readLine().trim());
		for (int i = 0; i < testCases; i++) {
			double r = Double.parseDouble(br.readLine().trim());
			double temp = 4 * r * r;
			double result = temp;
			for (int j = 1; j < 100; j++) {
				double temp1 = (double) j / 100;
				double temp2 = temp + temp1 * (1 - temp1);
				result = temp2 > result ? temp2 : result;
			}
			DecimalFormat newFormat = new DecimalFormat("0.00");
			String finalValue = newFormat.format(result);
			System.out.println("Case "+(i+1)+": "+finalValue);
		}
	}

}
