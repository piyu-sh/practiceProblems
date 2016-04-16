package com.pi.spoj.equalCandies;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		int packets;
		int[] candies;
		int moves = 0;
		while ((packets = scan.nextInt()) != -1) {
			candies = new int[packets];
			moves = 0;
			for (int i = 0; i < packets; i++) {
				candies[i] = scan.nextInt();
			}
			Arrays.sort(candies);
			int sum = 0;
			for (int d : candies)
				sum += d;
			double average = 1.0d * sum / candies.length;
			if (average % 1 == 0) {
				while (candies[0]!=candies[candies.length-1]) {
					if(candies[candies.length-1]-average>=average-candies[0])
					{
						moves+=average-candies[0];
						candies[candies.length-1]-=average-candies[0];
						candies[0]=(int) average;
					}
					else
					{
						moves+=candies[candies.length-1]-average;
						candies[0]+=candies[candies.length-1]-average;
						candies[candies.length-1]=(int) average;
					}
					Arrays.sort(candies);
					
				}
			} else {
				moves = -1;
			}
			System.out.println(moves);
		}
		scan.close();

	}
}
