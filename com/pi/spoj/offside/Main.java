package com.pi.spoj.offside;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String num;
		while (!"0 0".equals((num = br.readLine().trim()))) {
			String[] split = num.split(" ");
			int A = Integer.parseInt(split[0]);
			int D = Integer.parseInt(split[1]);
			split = br.readLine().trim().split(" ");
			int a[] = new int[A];
			int d[] = new int[D];
			for (int i = 0; i < split.length; i++) {
				a[i] = Integer.parseInt(split[i]);
			}
			split = br.readLine().trim().split(" ");
			for (int i = 0; i < split.length; i++) {
				d[i] = Integer.parseInt(split[i]);
			}
			Arrays.sort(a);
			Arrays.sort(d);
			System.out.println(a[0] < d[1] ? "Y" : "N");
		}

	}

}
