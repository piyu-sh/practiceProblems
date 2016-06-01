import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException,
			IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCases = Integer.parseInt(br.readLine().trim());
		for (int i = 0; i < testCases; i++) {
			String split[] = br.readLine().trim().split(" ");
			int h = Integer.parseInt(split[0]);
			int w = Integer.parseInt(split[1]);
			int[][] input = new int[h][w];
			for (int j = 0; j < h; j++) {
				split = br.readLine().trim().split(" ");
				for (int j2 = 0; j2 < w; j2++) {
					input[j][j2] = Integer.parseInt(split[j2]);
				}
			}
			int[][][] output = new int[h][w][2];
			for (int j = 0; j < h; j++) {
				for (int j2 = 0; j2 < w; j2++) {
					if (j == 0) {
						output[j][j2][0] = j2;
						output[j][j2][1] = input[j][j2];
					} else {
						int wOfMax = 0;
						int wLeft = j2 == 0 ? -1 : j2 - 1;
						int wCenter = j2;
						int wRight = j2 == w - 1 ? -1 : j2 + 1;
						if (wLeft != -1) {
							if (wRight != -1) {
								if (input[j][wLeft] > input[j][wCenter]) {
									if (input[j][wLeft] > input[j][wRight]) {
										wOfMax = wLeft;
									} else {
										wOfMax = wRight;
									}
								} else {
									if (input[j][wCenter] > input[j][wRight]) {
										wOfMax = wCenter;
									} else {
										wOfMax = wRight;
									}
								}
							} else {
								if (input[j][wLeft] > input[j][wCenter]) {
									wOfMax = wLeft;
								} else {
									wOfMax = wCenter;
								}
							}
						} else {
							if (input[j][wCenter] > input[j][wRight]) {
								wOfMax = wCenter;
							} else {
								wOfMax = wRight;
							}
						}

						output[j][j2][0] = wOfMax;
						output[j][j2][1] = output[j-1][j2][1]+input[j][wOfMax];
					}
				}
			}
			int maxStones = output[0][0][1];
			for (int j = 0; j < w; j++) {
				if (output[h - 1][j][1] > maxStones) {
					maxStones = output[h - 1][j][1];
				}
			}
			System.out.println(maxStones);
			// instead take max for each cell
		}
	}

}
