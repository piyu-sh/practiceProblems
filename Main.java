import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException,
			IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCases = Integer.parseInt(br.readLine().trim());
		for (int i = 0; i < testCases; i++) {
			String[] split = br.readLine().trim().split(" ");
			int N=Integer.parseInt(split[0]);
			int player=Integer.parseInt(split[1]);
		}
	}

}
