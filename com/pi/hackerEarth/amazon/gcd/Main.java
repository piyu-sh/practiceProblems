package com.pi.hackerEarth.amazon.gcd;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine().trim());
		String numString[] = br.readLine().trim().split(" ");
		int nums[] = new int[num];
		for (int i = 0; i < numString.length; i++) {
			nums[i] = Integer.parseInt(numString[i]);
		}
		int queries = Integer.parseInt(br.readLine().trim());
		Map<String, Long> memory = new Hashtable<String, Long>();
		for (int i = 0; i < queries; i++) {
			String query[] = br.readLine().trim().split(" ");
			String type = query[0].trim();
			int X = Integer.parseInt(query[1]);
			int Y = Integer.parseInt(query[2]);
			long result;
			if ("C".equals(type)) {
				result = computeCXY(X, Y, nums, memory)
						% ((long) Math.pow(10, 9) + 7);
				System.out.println(result);
			} else {
				nums[X - 1] = Y;
			}
		}
	}

	private static long phi(long n) {
		long result = n; // Initialize result as n

		// Consider all prime factors of n and subtract their
		// multiples from result
		for (long p = 2; p * p <= n; ++p) {
			// Check if p is a prime factor.
			if (n % p == 0) {
				// If yes, then update n and result
				while (n % p == 0)
					n /= p;
				result -= result / p;
			}
		}

		// If n has a prime factor greater than sqrt(n)
		// (There can be at-most one such prime factor)
		if (n > 1)
			result -= result / n;
		return result;
	}

	private static long computeCXY(int x, int y, int[] nums,
			Map<String, Long> memory) {

		long result = 0;
		for (int i = x; i <= y; i++) {
			String key = String.valueOf(nums[i - 1]) + "fx";
			Long long1 = memory.get(key);
			if (long1 != null) {
				result += long1;
			} else {
				long computeFX;
				if (isPrime(nums[i - 1])) {
					computeFX = (2 * nums[i - 1]) - 1;
				} else {
					computeFX = computeFX1(nums[i - 1], memory);
				}
				result += computeFX;
				memory.put(key, computeFX);
			}
		}

		return result;
	}

	private static Integer[] findDivisors(int num)
	{
		List<Integer> divisors = new ArrayList<Integer>();
		 for (int i = 2; i <= num / 2; i++) {
	            if (num % i == 0) {
	                divisors.add(i);
	            }
	        }
		return (Integer[]) divisors.toArray(new Integer[divisors.size()]);
	}
	
	private static long computeFX1(int i, Map<String, Long> memory) {
		long result = 1;

		Integer[] findDivisors = findDivisors(i);
		for (Integer integer : findDivisors) {
			result+=(phi(integer)/integer);
		}
		return result*i;
	}

	private static boolean isPrime(long n) {
		if (n < 2)
			return false;
		if (n == 2 || n == 3)
			return true;
		if (n % 2 == 0 || n % 3 == 0)
			return false;
		long sqrtN = (long) Math.sqrt(n) + 1;
		for (long i = 6L; i <= sqrtN; i += 6) {
			if (n % (i - 1) == 0 || n % (i + 1) == 0)
				return false;
		}
		return true;
	}

	private static long computeFX(int x, Map<String, Long> memory) {
		long result = 0;
		for (int i = 1; i <= x; i++) {
			String key = String.valueOf(i) + "," + String.valueOf(x) + "gcd";
			Long long1 = memory.get(key);
			if (long1 != null) {
				result += long1;
			} else {
				long gcd = gcd(i, x);
				result += gcd;
				memory.put(key, gcd);
			}
		}
		return result;
	}

	private static long gcd(long a, long b) {
		while (a != 0 && b != 0) {
			long c = b;
			b = a % b;
			a = c;
		}
		return a + b;
	}
}
