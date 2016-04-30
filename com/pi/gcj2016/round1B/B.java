package com.pi.gcj2016.round1B;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
//wrong answer because cSmall not set properly, faulty testcase ?6? 287
public class B {

	public static void main(String[] args) throws NumberFormatException,
			IOException {

		BufferedReader br = new BufferedReader(new FileReader(new File(
				"C:\\Users\\kille\\Desktop\\B-small-attempt0.in")));
		System.setOut(new PrintStream(new File(
				"C:\\Users\\kille\\Desktop\\B-small-attempt0.out")));
		int testCases = Integer.parseInt(br.readLine().trim());
		for (int i = 0; i < testCases; i++) {
			String[] split = br.readLine().trim().split(" ");
			char[] coders = split[0].toCharArray();
			char[] jammers = split[1].toCharArray();
			boolean isComplementary = false;
			boolean firstFound = false;
			char[] cCoders = coders.clone();
			char[] cJammers = jammers.clone();
			boolean isCSmall = false;
			for (int j = 0; j < jammers.length; j++) {
				if (coders[j] != '?' || jammers[j] != '?') {

					if (!firstFound) {
						if (Character.isDigit(coders[j])) {
							if (Character.isDigit(jammers[j])) {
								if (coders[j] < jammers[j]) {
									isCSmall = true;
								}
							} else {
								cJammers[j] = coders[j];
								jammers[j] = coders[j];
							}
						} else {
							cCoders[j] = jammers[j];
							coders[j] = jammers[j];
						}
					}
					firstFound = true;
				}
				if (firstFound) {
					if (!(Character.isDigit(coders[j]) && Character
							.isDigit(jammers[j]))) {
						if (isCSmall) {
							if (coders[j] == '?') {
								coders[j] = '9';
								cCoders[j] = jammers[j];
							}
							if (jammers[j] == '?') {
								jammers[j] = '0';
								cJammers[j] = coders[j];
							}
						} else {
							if (coders[j] == '?') {
								coders[j] = '0';
								cCoders[j] = jammers[j];
							}
							if (jammers[j] == '?') {
								jammers[j] = '9';
								cJammers[j] = coders[j];
							}
						}
					}
				}
			}

			String cCoderString = String.valueOf(cCoders).replace('?', '0');
			String cJammerString = String.valueOf(cJammers).replace('?', '0');
			String coderString = String.valueOf(coders).replace('?', '0');
			String jammerString = String.valueOf(jammers).replace('?', '0');

			int c = Math.abs(Integer.parseInt(cCoderString)
					- Integer.parseInt(cJammerString));
			int d = Math.abs(Integer.parseInt(coderString)
					- Integer.parseInt(jammerString));
			if (c < d) {
				System.out.println("Case #" + (i + 1) + ": " + cCoderString
						+ " " + cJammerString);
			} else {

				System.out.println("Case #" + (i + 1) + ": " + coderString
						+ " " + jammerString);
			}

		}
	}

}
