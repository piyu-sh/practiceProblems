package com.pi.spoj.reversePolishNotation;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int cases = scan.nextInt();
		for (int i = 0; i < cases; i++) {
			char[] originalExpression = scan.next().toCharArray();
			String result = transformToRpn(originalExpression);
			System.out.println(result);
		}
		scan.close();

	}

	private static String transformToRpn(char[] originalExpression) {
		String result = "";
		Stack operatorStack = new Stack();
		for (char c : originalExpression) {
			if (c == ')' && !operatorStack.isEmpty()) {
				result += operatorStack.pop();
			}
			if (Arrays.asList(new Character[] { '/', '+', '-', '*', '^' })
					.contains(c)) {
				operatorStack.push(c);
			}
			if (String.valueOf(c).matches("[a-zA-Z]")) {
				result += c;
			}
		}

		return result;
	}
}
