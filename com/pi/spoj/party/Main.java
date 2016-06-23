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
			TreeSet<InputData> inputDataSet = new TreeSet<InputData>(
					new MyComp());
			for (int i = 0; i < party; i++) {
				String trim[] = br.readLine().trim().split(" ");
				InputData inputData = new InputData();
				inputData.fee = Double.parseDouble(trim[0].trim());
				inputData.fun = Double.parseDouble(trim[1].trim());
				inputData.weight = (double) (inputData.fee / inputData.fun);
				inputDataSet.add(inputData);
			}

			int sumFee = 0;
			int sumFun = 0;
			for (Iterator iterator = inputDataSet.descendingIterator(); iterator
					.hasNext();) {
				InputData inputData = (InputData) iterator.next();
				if (inputData.fee <= money - sumFee) {
					sumFee += inputData.fee;
					sumFun += inputData.fun;
				}
			}
			System.out.println(sumFee + " " + sumFun);
		}
	}

}

class MyComp implements Comparator<InputData> {

	public int compare(InputData i1, InputData i2) {
		return i2.weight.compareTo(i1.weight);
	}
}

class InputData {
	Double fee, fun, weight;
}