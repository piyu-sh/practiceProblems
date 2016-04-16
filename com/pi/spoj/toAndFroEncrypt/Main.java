package com.pi.spoj.toAndFroEncrypt;
import java.util.Scanner;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		char[] encryptedMessage;
		int columns;
		char[][] messageArray;
		while ((columns = scan.nextInt()) != 0) {
			encryptedMessage = scan.next().toCharArray();
			messageArray = new char[encryptedMessage.length / columns][columns];
			int row = 1;
			for (int i = 0; i < encryptedMessage.length; i++) {
				char cs = encryptedMessage[i];
				if (i + 1 > columns && i % columns == 0) {
					row++;
				}
				if (row > 1 && row % 2 == 0) {
					// even row
					messageArray[row - 1][columns - (i % columns) - 1] = cs;
				} else {
					// odd row
					messageArray[row - 1][i % columns] = cs;
				}
			}
			for (int j = 0; j < columns; j++) {
				for (int i = 0; i < messageArray.length; i++) {
					char[] cs = messageArray[i];
					System.out.print(cs[j]);
				}
			}
			System.out.println();
		}
		scan.close();

	}
}
