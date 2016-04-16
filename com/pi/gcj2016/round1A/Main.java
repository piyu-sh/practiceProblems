package com.pi.gcj2016.round1A;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new FileReader(new File(
				"C:\\Users\\kille\\Desktop\\A-large.in")));
		System.setOut(new PrintStream(new File(
				"C:\\Users\\kille\\Desktop\\A-large.out")));
		int testCases = Integer.parseInt(br.readLine().trim());
		String code;
		for (int i = 0; i < testCases; i++) {
			code = br.readLine().trim();

			String result = findLastWord(code);
			System.out.println("Case #" + (i + 1) + ": " + result);

		}
	}

	private static String findLastWord(String code) {
		String result = null;
		int lastBigPosition = FindLastBigPosition(code);
		if (lastBigPosition == 0) {
			result = code;
		} else {
			result = code.substring(lastBigPosition,lastBigPosition+1)+findLastWord(code.substring(0, lastBigPosition))
					+ code.substring(lastBigPosition+1);
		}
		return result;
	}

	private static int FindLastBigPosition(String code) {
		char[] charArray = code.toCharArray();
		int pos = 0;
		for (int i = 0; i < charArray.length; i++) {
			if (charArray[i] >= charArray[pos]) {
				pos = i;
			}
		}
		return pos;
	}

}
