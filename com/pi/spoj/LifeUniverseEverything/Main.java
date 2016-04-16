package com.pi.spoj.LifeUniverseEverything;
import java.util.Scanner;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		while(sc.hasNextInt())
		{
			int num=sc.nextInt();
			if(num==42)
			{
				break;
			}
			System.out.println(num);
		}
	}

}
