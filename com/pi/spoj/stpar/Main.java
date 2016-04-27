package com.pi.spoj.stpar;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws NumberFormatException,
			IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String numOfMobiles;
		while (!"0".equals((numOfMobiles = br.readLine().trim()))) {
			String[] inputOrderString = br.readLine().trim().split(" ");
			int[] inputOrder = new int[inputOrderString.length];
			for (int j = 0; j < inputOrderString.length; j++) {
				inputOrder[j] = Integer.parseInt(inputOrderString[j]);
			}
			Stack<Integer> lane = new Stack<Integer>();
			int need = 1;
			boolean valid = true;
			for (int i = 0; i < inputOrder.length; i++) {
				while (!lane.empty() && lane.peek() == need) {
					need++;
					lane.pop();
				}
				if (inputOrder[i] == need) {
					need++;
				} else if (!lane.empty() && lane.peek() < inputOrder[i]) {
					valid = false;
					break;
				} else {
					lane.push(inputOrder[i]);
				}
			}
			System.out.println(valid ? "yes" : "no");
		}
	}
}
