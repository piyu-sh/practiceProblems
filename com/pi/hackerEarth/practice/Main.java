package com.pi.hackerEarth.practice;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCases = Integer.parseInt(br.readLine().trim());
		String[] nums = br.readLine().trim().split(" ");
		for (String string : nums) {
			int num = Integer.parseInt(string);
			for (int i = 1; i <= num; i++) {
				if (i % 3 == 0) {
					System.out.print("Fizz");
					if (i % 5 == 0) {
						System.out.print("Buzz");
					}
					System.out.println();
				} else if (i % 5 == 0) {
					System.out.println("Buzz");
				} else {
					System.out.println(i);
				}

			}
		}
	}

}
