package com.pi.spoj.palindrome;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException,
			IOException {

		
		BufferedReader inp = new BufferedReader(
				new InputStreamReader(System.in));
		long cases = Long.parseLong(inp.readLine());
		String k;
		for (long i = 0; i < cases; i++) {

			k = inp.readLine();
			String result = findNextPalindrome(k);
			System.out.println(result);
		}
		inp.close();
	}

	private static String findNextPalindrome(String k) {

		char[] originalChar = k.trim().toCharArray();
		String result = null;
		if (k.length() == 1) {
			result = String.valueOf(Integer.valueOf(k) + 1);
		}
		if ("10".equals(result)) {
			result = "11";
		}
		if (result == null) {
			originalChar = increment(originalChar, originalChar.length - 1);
			int left = originalChar.length / 2 - 1;
			int right = (int) Math.ceil((double) originalChar.length / 2);
			//

			while (right < originalChar.length) {
				if (originalChar[right] > originalChar[left]) {
					originalChar = increment(originalChar,
							(int) Math
									.ceil((double) originalChar.length / 2 - 1));
					break;
				} else if (originalChar[right] < originalChar[left]) {
					break;
				} else if (originalChar[right] == originalChar[left]) {
					left--;
					right++;
				}
			}
			left = originalChar.length / 2 - 1;
			right = (int) Math.ceil((double) originalChar.length / 2);
			mirrorLeftToRight(originalChar, left, right);
			result = String.valueOf(originalChar);
		}
		return result;

	}

	//got wa due to recursion
	
	
	
	// private static char[] increment(char[] originalChar, int pos) {
	//
	// if (pos >= 0) {
	// if (originalChar[pos] == '9') {
	// originalChar[pos] = '0';
	// originalChar = increment(originalChar, pos - 1);
	// } else {
	// originalChar[pos] = (char) (originalChar[pos] + 1);
	// }
	// }
	// if (pos < 0) {
	// originalChar = shiftCharArray(originalChar);
	// }
	// return originalChar;
	// }

	private static char[] increment(char[] originalChar, int pos) {

		for (; pos >= -1; pos--) {
			if (pos < 0) {
				originalChar = shiftCharArray(originalChar);
				break;
			}
			if (originalChar[pos] == '9') {
				originalChar[pos] = '0';
				if (pos - 1 >= 0 && originalChar[pos - 1] != '9') {
					originalChar[pos - 1] = (char) (originalChar[pos - 1] + 1);
					break;
				}

			} else {
				originalChar[pos] = (char) (originalChar[pos] + 1);
				break;
			}

		}
		return originalChar;
	}

	private static char[] shiftCharArray(char[] originalChar) {

		char temp[] = new char[originalChar.length + 1];

		for (int i = 0; i < originalChar.length; i++) {
			temp[i + 1] = originalChar[i];
		}
		temp[0] = '1';
		originalChar = temp;
		return originalChar;

	}

	private static void mirrorLeftToRight(char[] originalChar, int left,
			int right) {
		for (; right < originalChar.length; left--, right++) {
			originalChar[right] = originalChar[left];
		}
	}

}
