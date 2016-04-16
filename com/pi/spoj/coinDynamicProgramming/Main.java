package com.pi.spoj.coinDynamicProgramming;
import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		long num;
		long result;
		Map<Long, Long> lookupTable = new Hashtable<Long, Long>();
		while (scan.hasNextLong()) {
			num = scan.nextLong();
			result = maxDollars(num, lookupTable);
			System.out.println(result);
		}

	}

	private static long maxDollars(long num, Map<Long, Long> lookupTable) {
		long result;
		if (lookupTable.get(num) != null) {
			result = lookupTable.get(num);
		} else {
			result = num;
			long num2 = num / 2;
			long num3 = num / 3;
			long num4 = num / 4;
			if ((num2 + num3 + num4) > num) {
				result = maxDollars(num2, lookupTable)
						+ maxDollars(num3, lookupTable)
						+ maxDollars(num4, lookupTable);
				lookupTable.put(num, result);
			}
		}
		return result;
	}

}
