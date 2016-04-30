package com.pi.spoj.pt07y;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
//copied from codechef, couldn't solve
public class Main {
	static boolean moi[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String nm[] = br.readLine().trim().split(" ");
		int n = Integer.parseInt(nm[0].trim());
		int m = Integer.parseInt(nm[1].trim());
		moi = new boolean[n];
		List<List<Integer>> g = new ArrayList<List<Integer>>();
		for (int i = 0; i < n; i++)
			g.add(new ArrayList<Integer>());
		for (int i = 0; i < m; i++) {
			String[] split = br.readLine().split(" ");
			g.get(Integer.parseInt(split[0]) - 1).add(
					Integer.parseInt(split[1]) - 1);
		}
		boolean isTree = true;
		for (int i = 0; i < n; i++) {
			moi[i] = true;
			for (int a : g.get(i)) {
				if (!moi[a])
					moi[a] = true;
				else {
					isTree = false;
				}
			}
		}

		System.out.println(!isTree ? "NO" : "YES");

	}
}