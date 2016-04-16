package com.pi.spoj.overHangCards;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		float overhang;
		long numCards;
		while ((overhang = scan.nextFloat()) != 0.00) {
			numCards = findNumCards(overhang);
			System.out.println(numCards+" card(s)");
		}
	}

	private static long findNumCards(float overhang) {
		long numCards = 0;
		float sum = 0;
		for (int i = 0;; i++) {
			sum += 1.0 / (2 + i);
			if (sum >= overhang) {
				numCards=i+1;
				break;
			}
		}
		return numCards;
	}

}
