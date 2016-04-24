package com.pi.spoj.fence1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String num;
		while (!"0".equals((num = br.readLine().trim()))) {

			double result = Math.pow(Integer.parseInt(num), 2) / (2 * Math.PI);
			DecimalFormat newFormat = new DecimalFormat("0.00");
			String finalValue = newFormat.format(result);
			System.out.println(finalValue);
		}
	}

}
