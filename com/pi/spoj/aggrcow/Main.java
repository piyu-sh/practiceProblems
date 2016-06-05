package com.pi.spoj.aggrcow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws NumberFormatException,
			IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCases = Integer.parseInt(br.readLine().trim());
		for (int i = 0; i < testCases; i++) {
			String[] split = br.readLine().trim().split(" ");
			int N = Integer.parseInt(split[0]);
			int C = Integer.parseInt(split[1]);
			int[] stalls = new int[N];
			for (int j = 0; j < N; j++) {
				stalls[j] = Integer.parseInt(br.readLine().trim());
			}
			Arrays.sort(stalls);
			int result = binary_search(stalls, N, C);
			System.out.println(result);
		}
	}

	private static int binary_search(int[] stalls, int N, int C) {
		int start = 0, end = stalls[stalls.length - 1];
		while (start < end) {
			int mid = (start + end) / 2;
			if (f(mid, stalls, N, C) == 1) {
				start = mid + 1;
			} else {
				end = mid;
			}
		}
		return start - 1;
	}

	private static int f(int x, int[] arr, int n, int c) {
		int cowsplaced = 1;
		long lastpos = arr[0];
		for (int i = 1; i < n; i++) {
			if (arr[i] - lastpos >= x) {
				cowsplaced++;

				if (cowsplaced == c)
					return 1;
				lastpos = arr[i];
			}
		}
		return 0;
	}

}
