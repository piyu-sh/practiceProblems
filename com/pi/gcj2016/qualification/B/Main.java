package com.pi.gcj2016.qualification.B;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;

public class Main {

	public static void main(String[] args) throws NumberFormatException,
			IOException {

		BufferedReader br = new BufferedReader(new FileReader(new File(
				"C:\\Users\\kille\\Desktop\\B-large.in")));
		System.setOut(new PrintStream(new File(
				"C:\\Users\\kille\\Desktop\\B-large.out")));
		Integer testCases = Integer.valueOf(br.readLine());
		long count;
		char[] input;
		for (int i = 0; i < testCases; i++) {
			count = 0;
			input = br.readLine().trim().toCharArray();
			int bottomBlankPos;
			while (true) {
				if (isValid(input)) {
					break;
				} else {
					bottomBlankPos = findBottomBlank(input);
					if (input[0] == '+' && input[bottomBlankPos] == '-') {
						input = flip(input,
								findBottomHappyBefore(input, bottomBlankPos));
						count++;

					}
					input = flip(input, bottomBlankPos);
					count++;
				}
			}

			System.out.println("Case #" + (i + 1) + ": " + count);
		}

	}

	private static int findBottomHappyBefore(char[] input, int bottomBlankPos) {
		int pos = 0;
		for (int i = bottomBlankPos - 1; i >= 0; i--) {
			char c = input[i];
			if (c == '+') {
				pos = i;
				break;
			}

		}
		return pos;
	}

	private static char[] flip(char[] input, int bottomBlankPos) {
		char[] result = input.clone();
		int i = bottomBlankPos;
		int j = 0;
		while (i >= 0) {
			result[j] = input[i];
			result[j] = result[j] == '+' ? '-' : '+';
			i--;
			j++;
		}
		return result;
	}

	private static int findBottomBlank(char[] input) {
		int pos = 0;
		for (int i = input.length - 1; i >= 0; i--) {
			char c = input[i];
			if (c == '-') {
				pos = i;
				break;
			}

		}
		return pos;
	}

	private static boolean isValid(char[] input) {
		boolean valid = true;
		for (char c : input) {
			if (c == '-') {
				valid = false;
				break;
			}
		}
		return valid;
	}

}
