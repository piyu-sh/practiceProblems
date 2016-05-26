import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String numString;
		while (!"-1".equals((numString = br.readLine().trim()))) {
			long num = Long.parseLong(numString);
			long cells = 0;
			for (long i = 0; cells < num; i++) {
				if (i == 1) {
					cells = 1;
					continue;
				}
				cells += 6 * (i - 1);
			}
			System.out.println(cells == num ? "Y" : "N");
		}
	}

}
