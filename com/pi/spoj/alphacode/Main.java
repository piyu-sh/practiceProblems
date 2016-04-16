package com.pi.spoj.alphacode;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static long totalDecodings = 0;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String num;
		while (!"0".equals((num = br.readLine().trim()))) {
			// totalDecodings = 0;
			// findDecodings(num);
			System.out.println(findDecodings3(num));
		}

	}
	private static long findDecodings3(String input) {
		long decodings[]=new long[input.length()];
		decodings[0]=1;
		char[] charArray = input.toCharArray();
		if(input.length()==2&&Integer.parseInt(input)<10)
		{
			return 0;
		}
		for (int i = 1; i < input.length(); i++) {
			if(charArray[i]-'0'>0)
			{
				decodings[i]=decodings[i-1];
			}
			if(Integer.parseInt(input.substring(i-1, i+1))>9&&Integer.parseInt(input.substring(i-1, i+1))<27)
			{
				decodings[i]+=decodings[i-2<0?0:i-2];
			}
		}
		
		return decodings[input.length()-1];

	}

	private static long findDecodingFor12(String input) {
		long decodings = 0;

		if (input.length() == 1 && Integer.valueOf(input) != 0) {
			decodings = 1;
		} else if (input.length() == 2) {
			char[] charArray = input.toCharArray();
			if (charArray[0] == '0') {
				decodings = 0;
			} else if (charArray[1] == '0') {
				if (Integer.valueOf(input) > 26) {
					decodings = 0;
				} else {
					decodings = 1;
				}
			} else if (Integer.valueOf(input) <= 26) {
				decodings = 2;
			} else {
				decodings = 1;
			}
		}

		return decodings;

	}

	private static long findDecodings2(String num) {
		long decodings[] = { 0, 0 };
		String startString = num.length() == 1 || num.length() == 2 ? num : num
				.substring(num.length() - 2);

		decodings[0] = findDecodingFor12(startString);

		if (num.length() > 2) {
			decodings[1] = num.substring(num.length() - 2, num.length() - 1) == "0" ? 0
					: findDecodingFor12(num.substring(num.length() - 1));// test 1024
			char[] charArray = num.toCharArray();
			for (int i = num.length() - 3; i >= 0; i--) {
				String a = String.valueOf(charArray[i]);
				String b=String.valueOf(charArray[i + 1]);
				String c = String.valueOf(charArray[i + 2]);
				long temp;
				if (findDecodingFor12(a+b) != 0 && Integer.valueOf(a+b)<27) {
					if (findDecodingFor12(b+c) != 0 && Integer.valueOf(b+c)<27) {
						temp = decodings[0];
						decodings[0] += decodings[1];
						decodings[1] = temp;
					} else {
						temp = decodings[0];
						decodings[0] = decodings[0] * 2;
						decodings[1] = temp;
					}
				} else {
					decodings[1] = decodings[0];
				}

			}
		}

		return decodings[0];
	}

	private static long findDecodings(String input) {
		long result = 0;
		String left1 = input.substring(0, 1);
		String right1 = input.substring(1, input.length());
		String left2 = input.length() == 2 ? input : null;
		String right2 = null;

		if (input.length() > 2) {
			left2 = input.substring(0, 2);
			right2 = input.substring(2, input.length());
		}
		if (left1 != null && legal(left1)) {
			if (right1.length() != 1) {
				if (right1.length() == 2 && legal(right1)) {
					totalDecodings++;
					findDecodings(right1);
				} else if (right1.length() == 0) {
					totalDecodings++;
				} else {
					findDecodings(right1);
				}
			} else if (right1.length() == 1 && legal(right1)) {
				totalDecodings++;
			}
		}
		if (left2 != null && legal(left2)) {
			if (right2 == null) {
				totalDecodings++;
			} else if (right2.length() != 1) {
				if (right2.length() == 2 && legal(right2)) {
					totalDecodings++;
				}
				findDecodings(right2);
			} else if (right2.length() == 1 && legal(right2)) {
				totalDecodings++;
			}
		}

		return result;

	}

	private static boolean legal(String input) {
		boolean result = false;

		if (input.length() == 1) {
			if ("0".equals(input)) {
				result = false;
			} else {
				result = true;
			}
		} else if (input.length() == 2) {
			if ("0".equals(input.substring(0, 1)) || input.contains("a")
					|| Integer.valueOf(input) > 26) {
				result = false;
			} else {
				result = true;
			}
		}
		return result;
	}

	private static long findDecodings1(String input) {
		long result = 0;
		char[] inputArray = input.toCharArray();
		int[] decodings = { 0, 0 };
		char a, b, c;
		int temp;
		for (int i = inputArray.length - 1; i >= 0; i--) {
			a = inputArray[i];
			b = i < inputArray.length - 1 ? inputArray[i + 1] : 'a';
			c = i < inputArray.length - 2 ? inputArray[i + 1] : 'a';
			String abString = b == ' ' ? String.valueOf(a) : String.valueOf(a)
					+ String.valueOf(b);
			if (b == 'a' && c == 'a' && legal(String.valueOf(a))) {
				decodings[0] = 1;
			}
			if (legal(abString)) {
				String bcString = b == ' ' ? "" : c == ' ' ? String.valueOf(b)
						: String.valueOf(b) + String.valueOf(c);
				if (c == ' ' || !legal(bcString)) {
					decodings[1] = decodings[0];
					decodings[0] *= 2;
				} else {
					temp = decodings[0];
					decodings[0] = decodings[0] + decodings[1];
					decodings[1] = temp;
				}
			} else {
				decodings[1] = decodings[0];
			}
		}
		return decodings[0];

	}

}
