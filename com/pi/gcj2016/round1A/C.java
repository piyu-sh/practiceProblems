package com.pi.gcj2016.round1A;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
// couldn't complete on time
public class C {

	public static void main(String[] args) throws NumberFormatException,
			IOException {

		BufferedReader br = new BufferedReader(new FileReader(new File(
				"C:\\Users\\kille\\Desktop\\input.txt")));
		System.setOut(new PrintStream(new File(
				"C:\\Users\\kille\\Desktop\\output.txt")));
		int testCases = Integer.valueOf(br.readLine().trim());
		int[][] input;
		int[][] output;
		for (int i = 1; i <= testCases; i++) {
			int N = Integer.parseInt(br.readLine().trim());
			input = new int[2 * N - 1][N];
			output = new int[N][N];
			for (int j = 0; j < 2 * N - 1; j++) {
				String[] split = br.readLine().trim().split(" ");
				for (int j2 = 0; j2 < N; j2++) {
					input[j][j2] = Integer.parseInt(split[j2]);
				}
			}

			int findSmallestRow = findSmallestRow(input);
			output[0] = input[findSmallestRow];
			for (int i1 = 0; i1 < input[0].length; i1++) {
				input[findSmallestRow][i1]=-1;
			}
			for (int j = 1; j <= N; j++) {
				for (int j2 = 1; j2 <= N; j2++) {
					int pos = findRowWithMatching(input, output, j2);

					if (pos != -1) {
						fillColumn(input, output, pos, j2);
					}
				}
			}
			for (int j = 1; j <= N; j++) {
				for (int j2 = 1; j2 <= N; j2++) {

					int pos = findColumnWithMatching(input, output, j2);

					if (pos != -1) {
						fillRow(input, output, pos, j2);
					}
				}
			}
			System.out.println();

		}
	}

	private static void fillRow(int[][] input, int[][] output, int pos, int j2) {

		for (int i = 0; i < output.length; i++) {
			output[j2][i]=input[pos][i];
			input[pos][i]=-1;
		}

	
		
	}

	private static int findRowWithMatching(int[][] input, int[][] output,
			int pos) {
		int result=-1;
		int count=0;
		for (int i = 0; i < input.length; i++) {
			boolean match=true;
			for (int j = 0; j < input[i].length; j++) {
				if(output[j][pos]!=0&&output[j][pos]!=input[j][i])
				{
					match=false;
					break;
				}
				else {
					result=i;
				}
			}
			if(match=true)
			{
				i++;
			}
			if(count>1)
			{
				result=-1;
				break;
			}
		}
		if(count==0)
		{
			result=-1;
		}
		return result;
	}

	private static void fillColumn(int[][] input, int[][] output, int pos,
			int j2) {
		for (int i = 0; i < output.length; i++) {
			output[i][j2]=input[pos][i];
			input[pos][i]=-1;
		}

	}

	private static int findColumnWithMatching(int[][] input, int[][] output,
			int pos) {
		
		int result=-1;
		int count=0;
		for (int i = 0; i < input.length; i++) {
			boolean match=true;
			for (int j = 0; j < input[i].length; j++) {
				if(output[pos][j]!=0&&output[pos][j]!=input[i][j])
				{
					match=false;
					break;
				}
				else {
					result=i;
				}
			}
			if(match=true)
			{
				i++;
			}
			if(count>1)
			{
				result=-1;
				break;
			}
		}
		if(count==0)
		{
			result=-1;
		}
		return result;
	}

	private static int findSmallestRow(int[][] input) {
		int pos = 0;
		for (int j = 0; j <input.length - 1; j++) {
			boolean isGreater = true;
			for (int i = 0; i < input[0].length; i++) {
				if (input[j][i] > input[pos][i]) {
					isGreater = false;
					break;
				}
				if (isGreater) {
					pos = j;
				}
			}
		}
		
		return pos;
	}

}
