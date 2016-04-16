package com.pi.spoj.willitst;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long input = Long.parseLong(br.readLine().trim());
		
		 
		
		if((input&input-1) ==0)
		{
			System.out.println("TAK");
		}else
		{

			System.out.println("NIE");
		}

	}

}
