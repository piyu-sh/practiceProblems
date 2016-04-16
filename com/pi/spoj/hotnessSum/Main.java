package com.pi.spoj.hotnessSum;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int cases = scan.nextInt();
		int couples;
		int coupleArray[][];
		for (int i = 0; i < cases; i++) {
			couples = scan.nextInt();
			coupleArray = new int[2][couples];
			for (int j = 0; j < 2; j++) {
				int[] is = coupleArray[j];
				for (int k = 0; k < is.length; k++) {
					coupleArray[j][k] = scan.nextInt();
				}
			}
			Arrays.sort(coupleArray[0]);
			Arrays.sort(coupleArray[1]);
			int hotnessSum = 0;
			for (int k = 0; k < coupleArray[0].length; k++) {
				hotnessSum += coupleArray[0][k] * coupleArray[1][k];
			}
			System.out.println(hotnessSum);
		}
		scan.close();

	}

}
