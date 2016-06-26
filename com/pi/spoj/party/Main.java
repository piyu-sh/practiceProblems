package com.pi.spoj.party;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String num;
		while (!"0 0".equals((num = br.readLine().trim()))) {
			if ("".equals(num)) {
				continue;
			}
			String[] split = num.split(" ");
			int money = Integer.parseInt(split[0].trim());
			int party = Integer.parseInt(split[1].trim());
		}
	}

}
