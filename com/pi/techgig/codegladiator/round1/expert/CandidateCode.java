package com.pi.techgig.codegladiator.round1.expert;

import java.util.Arrays;

public class CandidateCode {
	public static void main(String[] args) {

		int input1[] = { 3, 4, 2, 3, 3, 3, 3 };
		int input2[] = { 0, 1, 0, 0, 0, 1, 1, 0, 1, 0, 1, 0 };

		int input3[] = { 3, 4, 2, 3, 3, 3, 4 };
		int input4[] = { 0, 1, 0, 0, 0, 1, 1, 0, 1, 0, 1, 0 };

		System.out.println(Arrays.toString(survivalcells(input3, input4)));// check
																			// invalid
																			// input
	}

	public static int[] survivalcells(int[] input1, int[] input2) {
		int R = input1[0], C = input1[1], S1 = input1[2], S2 = input1[3], B1 = input1[4], B2 = input1[5], G = input1[6];
		int[] result = new int[R * C];
		int[][] simulationMatrix = new int[R][C];
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				simulationMatrix[i][j] = input2[C * i + j];// validate input
			}
		}

		for (int i = 0; i < G; i++) {
			simulationMatrix = simulateGeneration(simulationMatrix, S1, S2, B1,
					B2, R, C);
		}

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				result[C * i + j] = simulationMatrix[i][j];
			}
		}
		return result;
	}

	private static int[][] simulateGeneration(int[][] simulationMatrix, int s1,
			int s2, int b1, int b2, int R, int C) {

		int[][] resultMatrix = deepCopyIntMatrix(simulationMatrix);

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				int aliveNeighbours = aliveNeighbours(i, j, 0, 0, R - 1, C - 1,
						simulationMatrix);
				if (simulationMatrix[i][j] == 1) {
					if (aliveNeighbours < s1 || aliveNeighbours > s2) {
						resultMatrix[i][j] = 0;
					}
				} else {
					if (aliveNeighbours >= b1 && aliveNeighbours <= b2) {
						resultMatrix[i][j] = 1;
					}
				}
			}
		}

		return resultMatrix;
	}

	public static int[][] deepCopyIntMatrix(int[][] input) {
		if (input == null)
			return null;
		int[][] result = new int[input.length][];
		for (int r = 0; r < input.length; r++) {
			result[r] = input[r].clone();
		}
		return result;
	}

	static int aliveNeighbours(int thisPosX, int thisPosY, int MIN_X,
			int MIN_Y, int MAX_X, int MAX_Y, int[][] grid) {
		int count = 0;
		int startPosX = (thisPosX - 1 < MIN_X) ? thisPosX : thisPosX - 1;
		int startPosY = (thisPosY - 1 < MIN_Y) ? thisPosY : thisPosY - 1;
		int endPosX = (thisPosX + 1 > MAX_X) ? thisPosX : thisPosX + 1;
		int endPosY = (thisPosY + 1 > MAX_Y) ? thisPosY : thisPosY + 1;

		// See how many are alive
		for (int rowNum = startPosX; rowNum <= endPosX; rowNum++) {
			for (int colNum = startPosY; colNum <= endPosY; colNum++) {
				// All the neighbors will be grid[rowNum][colNum]
				if (!(rowNum == thisPosX && colNum == thisPosY)
						&& grid[rowNum][colNum] == 1) {
					count++;
				}
			}
		}
		return count;
	}
}