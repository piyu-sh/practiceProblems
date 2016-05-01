package com.pi.hackerEarth.mmt.patternOccurence;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

// wrong answer
public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int length = Integer.parseInt(br.readLine().trim());
		String input = br.readLine().trim();
		int queries = Integer.parseInt(br.readLine().trim());
		String regex;
		for (int i = 0; i < queries; i++) {
			String[] split = br.readLine().split(" ");
			String substring = input.substring(input.indexOf(split[0]),
					input.lastIndexOf(split[1]) + 1);
			List<Integer> findAllOccurenceOfA = findAllOccurence(substring,
					split[0]);
			List<Integer> findAllOccurenceOfB = findAllOccurence(substring,
					split[1]);
			int count = 0;
			for (Integer bInteger : findAllOccurenceOfB) {
				int j = 0;
				for (Integer aInteger : findAllOccurenceOfA) {
					if (aInteger < bInteger) {
						j++;
					} else {
						break;
					}
				}
				count += j;
			}
			System.out.println(count);
		}
	}

	static List<Integer> findAllOccurence(String word, String ch) {
		List<Integer> occurenceList = new ArrayList<Integer>();
		for (int index = word.indexOf(ch); index >= 0; index = word.indexOf(ch,
				index + 1)) {
			occurenceList.add(index);
		}

		return occurenceList;
	}

	// public static int allMatches1(String text, String regex) {
	// int count = 0;
	// for (int i = 0; i < text.length(); ++i) {
	// for (int j = i + 1; j <= text.length(); ++j) {
	// String positionSpecificPattern = "((?<=^.{" + i + "})(" + regex
	// + ")(?=.{" + (text.length() - j) + "}$))";
	// Matcher m = Pattern.compile(positionSpecificPattern).matcher(
	// text);
	//
	// if (m.find()) {
	// System.out.println("Match found: \"" + (m.group())
	// + "\" at position [" + i + ", " + j + ")");
	// count++;
	// }
	// }
	// }
	// return count;
	// }
}
