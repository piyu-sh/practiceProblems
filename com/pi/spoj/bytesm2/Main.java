package com.pi.spoj.bytesm2;
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	// public static void main(String[] args) throws NumberFormatException,
	// IOException {
	//
	// Scanner scan = new Scanner(System.in);
	// int test = scan.nextInt();
	// for (int i = 0; i < test; i++) {
	// int h = scan.nextInt();
	// int w = scan.nextInt();
	// int[][] input = new int[h][w];
	// for (int j = 0; j < h; j++) {
	// for (int j2 = 0; j2 < w; j2++) {
	// input[j][j2] = scan.nextInt();
	// }
	// }
	//
	// for (int j = h - 2; j >= 0; j--) {
	// for (int j2 = 0; j2 < w; j2++) {
	// input[j][j2] += Math.max(
	// j2 == 0 ? 0 : input[j + 1][j2 - 1], Math.max(
	// input[j + 1][j2], j2 == w - 1 ? 0
	// : input[j + 1][j2 + 1]));
	// }
	// }
	// int max = input[0][0];
	// for (int j = 0; j < w; j++) {
	// max = max > input[0][j] ? max : input[0][j];
	// }
	// System.out.println(max);
	// }
	// scan.close();
	// }

	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
		int T = parseInt(f.readLine().trim());
		// long start = System.currentTimeMillis();
		// System.out.println(start);
		int w, h, i, j, max;
		StringTokenizer st;
		int[][] grid;
		while (T-- > 0) {
			st = new StringTokenizer(f.readLine());
			w = parseInt(st.nextToken().trim());
			h = parseInt(st.nextToken().trim());
			grid = new int[w][h + 2];
			for (i = 0; i < w; i++) {
				for (j = 1; j <= h; j++) {
					if (!st.hasMoreTokens())
						st = new StringTokenizer(f.readLine());
					grid[i][j] = parseInt(st.nextToken().trim());
				}
				grid[i][0] = grid[i][h + 1] = -100000000;
			}

			for (i = 1; i < w; i++)
				for (j = 1; j <= h; j++)
					grid[i][j] += max(grid[i - 1][j - 1], grid[i - 1][j],
							grid[i - 1][j + 1]);

			max = 0;
			for (j = 1; j <= h; j++)
				max = max(max, grid[w - 1][j]);

			System.out.println(max);
			System.out.flush();
			// System.exit(0);
		}
		// System.out.println(System.currentTimeMillis()-start);
	}

	private static int max(int... x) {
		int max = -Integer.MAX_VALUE;
		for (int i : x)
			if (max < i)
				max = i;
		return max;
	}
}
