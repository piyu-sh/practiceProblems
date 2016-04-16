package com.pi.gcj2016.qualification.C;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.math.BigInteger;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new FileReader(new File(
				"C:\\Users\\kille\\Desktop\\C-large.in")));
		System.setOut(new PrintStream(new File(
				"C:\\Users\\kille\\Desktop\\C-large.out")));
		int n;
		int j;
		String input;
		br.readLine();
		input = br.readLine().trim();
		String[] split = input.split(" ");
		n = Integer.valueOf(split[0]);
		j = Integer.valueOf(split[1]);
		System.out.println("Case #1: ");

		BigInteger num = findFirstNum(n);
		BigInteger lastNum = findLastNum(new BigInteger(String.valueOf(n)));
		String binNum;
		int limit = 0;
		for (BigInteger i = num; i.compareTo(lastNum) <= 0; i = i
				.add(new BigInteger("2"))) {
			binNum = i.toString(2);
			boolean valid = true;
			BigInteger convertedNum;
			BigInteger[] convertedNumDivisor = new BigInteger[9];
			for (int j1 = 2; j1 < 11; j1++) {
				if (!binNum.endsWith("1") || !binNum.startsWith("1")) {
					valid = false;
					break;
				}
				convertedNum = new BigInteger(binNum, j1);
				if (convertedNum.isProbablePrime(10)) {
					valid = false;
					break;
				}
				convertedNumDivisor[j1 - 2] = findDivisor(convertedNum);
				if (convertedNumDivisor[j1 - 2].equals(BigInteger.ZERO)) {
					valid = false;
					break;
				}
			}
			if (valid) {
				limit++;
				System.out
						.println(binNum + " " + convertedNumDivisor[0] + " "
								+ convertedNumDivisor[1] + " "
								+ convertedNumDivisor[2] + " "
								+ convertedNumDivisor[3] + " "
								+ convertedNumDivisor[4] + " "
								+ convertedNumDivisor[5] + " "
								+ convertedNumDivisor[6] + " "
								+ convertedNumDivisor[7] + " "
								+ convertedNumDivisor[8]);
				if (limit == j) {
					break;
				}
			}
		}
	}

	private static BigInteger findFirstNum(int n) {
		BigInteger result = BigInteger.ZERO;
		result = result.add(pow(new BigInteger("2"),
				new BigInteger(String.valueOf(n)).subtract(BigInteger.ONE)));
		result = result.add(BigInteger.ONE);
		return result;
	}

	private static BigInteger findLastNum(BigInteger n) {
		BigInteger result = BigInteger.ZERO;
		for (BigInteger i = BigInteger.ZERO; i.compareTo(n) < 0; i = i
				.add(BigInteger.ONE)) {
			result = result.add(pow(new BigInteger("2"), i));
		}
		return result;
	}

	static BigInteger findDivisor(BigInteger convertedNum) {
		BigInteger factor = new BigInteger("2");
		BigInteger limit = new BigInteger("100");
		while (!convertedNum.mod(factor).equals(BigInteger.ZERO)) {
			factor = factor.add(BigInteger.ONE);
			if (factor.equals(limit)) {
				factor = BigInteger.ZERO;
				break;
			}
		}
		return factor;
	}

	static BigInteger pow(BigInteger base, BigInteger exponent) {
		BigInteger result = BigInteger.ONE;
		while (exponent.signum() > 0) {
			if (exponent.testBit(0))
				result = result.multiply(base);
			base = base.multiply(base);
			exponent = exponent.shiftRight(1);
		}
		return result;
	}

}
