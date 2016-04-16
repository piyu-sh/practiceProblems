package com.pi.spoj.rectanglesFromSquares;
import java.util.Scanner;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int count = 0;
		for (int i = 1; i <= n; i++) {
			count+= findRectangles(i);
		}
		System.out.println(count);
	}

	private static int findRectangles(int n) {
		int count = 0;
		for (int i = 1; i <= Math.sqrt(n); i++) {
			if (n % i == 0) {
				count++;
			}
		}
		return count;
	}

}

// more efficient solution

//"int p = floor(sqrt(n)); 
//int sum=0; 
//for(int i=1;i<=p;i++){ 
//sum+=floor(n/i) - (i-1); 
//} 
//cout<<sum;"