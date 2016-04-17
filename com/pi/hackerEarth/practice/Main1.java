package com.pi.hackerEarth.practice;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main1 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCases = Integer.parseInt(br.readLine().trim());
		for (int i = 0; i < testCases; i++) {
			
			String nums[]=br.readLine().trim().split(" ");
			int a=Integer.parseInt(nums[0]);
			int b=Integer.parseInt(nums[1]);
			System.out.println(a+b);
		}
	}

}
