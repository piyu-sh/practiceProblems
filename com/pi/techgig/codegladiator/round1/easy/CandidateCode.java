package com.pi.techgig.codegladiator.round1.easy;
public class CandidateCode {

	public static void main(String[] args) {

		String[] input1 = { "5#8", "5#7", "6#0", "5#7" };
		int size1 = 4;
		String[] input2 = { "4#11", "6#0", "5#2", "6#1", "7#1", "5#11", "5#11",
				"5#10", "5#8" };
		int size2 = 9;
		System.out.println(getHeight(input2, size2));
	}

	public static int getHeight(String[] input1, int input2) {
		int result = 0;
		for (int i = 0; i < input1.length - 1 && result != -1; i++) {
			String[] split = input1[i].split("#");
			int parseInt = Integer.parseInt(split[0]);
			int parseInt2 = Integer.parseInt(split[1]);
			if (parseInt < 4 || parseInt > 7 || parseInt2 < 0 || parseInt2 > 11) {
				result = -1;
			} else {
				int a = parseInt * 12 + parseInt2;
				for (int j = i + 1; j < input1.length && result != -1; j++) {
					String[] split1 = input1[j].split("#");
					int parseInt1 = Integer.parseInt(split1[0]);
					int parseInt3 = Integer.parseInt(split1[1]);
					if (parseInt1 < 4 || parseInt1 > 7 || parseInt3 < 0 || parseInt3 > 11) {
						result = -1;
					}
					else if(a>(parseInt1*12+parseInt3))
					{
						result++;
					}
				}
			}
		}
		return result;
	}
}
