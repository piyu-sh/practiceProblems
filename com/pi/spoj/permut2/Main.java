package com.pi.spoj.permut2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String num;
		while (!"0".equals((num = br.readLine().trim()))) {
			String[] originalString = br.readLine().trim().split(" ");
			int original[] = new int[originalString.length], inversePermute[] = new int[originalString.length];
			for (int i = 0; i < originalString.length; i++) {
				original[i] = Integer.parseInt(originalString[i]);
			}
			boolean isAmbiguous = true;
			for (int i = 0; i < original.length; i++) {
				if (original[original[i] - 1] != i + 1) {
					isAmbiguous = false;
				}
			}
			System.out.println(isAmbiguous ? "ambiguous" : "not ambiguous");
		}
	}

}
