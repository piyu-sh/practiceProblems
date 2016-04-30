package com.pi.techgig.codegladiator.round1.medium;
public class CandidateCode {

	public static void main(String[] args) {
		String[] input1 = { "5#7#2#4", "1#8#1#3", "6#2#9#5", "1#6#2#8" };
		int row1 = 4;
		String[] input2 = { "3#2#8", "1#9#7", "0#5#2", "6#4#3" };
		int size2 = 4;

		System.out.println(minimumCost(input1, row1));
	}

	private static int[][] parseInput(String[] input1, int size1) {
		// int columns = input1.length * 2 / size1;
		int[][] matrix = new int[size1][];
		int i = 0;
		try {
			for (i = 0; i < input1.length; i++) {
				String[] split = input1[i].split("#");
				if (i > 0 && matrix[i - 1].length != split.length) {
					System.out.println("NA");
					System.exit(0);
				}
				matrix[i] = new int[split.length];
				for (int j = 0; j < split.length; j++) {
					matrix[i][j] = Integer.parseInt(split[j]);
				}
			}
			if (i != size1) {
				System.out.println("NA");
				System.exit(0);
			}
		} catch (NumberFormatException e) {
			System.out.println("NA");
			System.exit(0);
		}
		return matrix;
	}

	static int minCost(int cost[][], int m, int n, StringBuilder path) {
		int i, j;

		int tc[][] = new int[m + 1][n + 1];

		String pathMatrix[][] = new String[m + 1][n + 1];
		tc[0][0] = cost[0][0];

		/* Initialize first column of total cost(tc) array */
		for (i = 1; i <= m; i++) {
			tc[i][0] = tc[i - 1][0] + cost[i][0];
			pathMatrix[i][0] = "B"
					+ (pathMatrix[i - 1][0] == null ? "" : pathMatrix[i - 1][0]);
		}
		/* Initialize first row of tc array */
		for (j = 1; j <= n; j++) {
			tc[0][j] = tc[0][j - 1] + cost[0][j];
			pathMatrix[0][j] = "R"
					+ (pathMatrix[0][j - 1] == null ? "" : pathMatrix[0][j - 1]);
		}
		/* Construct rest of the tc array */
		for (i = 1; i <= m; i++)
			for (j = 1; j <= n; j++) {
				String[] minPathCost = min(tc[i - 1][j - 1], tc[i - 1][j],
						tc[i][j - 1]);
				tc[i][j] = Integer.parseInt(minPathCost[1]) + cost[i][j];
				if (minPathCost[0] == "D") {
					pathMatrix[i][j] = (pathMatrix[i - 1][j - 1] == null ? ""
							: pathMatrix[i - 1][j - 1]) + "D";
				} else if (minPathCost[0] == "R") {
					pathMatrix[i][j] = (pathMatrix[i][j - 1] == null ? ""
							: pathMatrix[i][j - 1]) + "R";
				} else {
					pathMatrix[i][j] = (pathMatrix[i - 1][j] == null ? ""
							: pathMatrix[i - 1][j]) + "B";
				}
			}
		path.append(pathMatrix[m][n]);
		return tc[m][n];
	}

	static String[] min(int x, int y, int z) {
		// x->D , y->B, z->R
		String[] result = new String[2];
		if (x < y) {
			if (x < z) {
				result[0] = "D";
				result[1] = String.valueOf(x);
			} else {
				result[0] = "R";
				result[1] = String.valueOf(z);
			}
		} else {
			if (y < z) {
				result[0] = "B";
				result[1] = String.valueOf(y);
			} else {
				result[0] = "R";
				result[1] = String.valueOf(z);
			}
		}
		return result;
	}

	public static String minimumCost(String[] input1, int input2) {
		String result = null;
		int costMatrix[][] = parseInput(input1, input2);
		int column = costMatrix[0].length;
		StringBuilder path = new StringBuilder();
		int cost = minCost(costMatrix, input2 - 1, column - 1, path);
		result = cost + "," + path.toString().trim();
		return result;
	}
}