import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String num;
		while (!"0".equals((num = br.readLine().trim()))) {

			double result = Math.pow(Integer.parseInt(num), 2) / (2 * Math.PI);
			double finalValue = Math.round(result * 100.0) / 100.0;
			System.out.println(finalValue);
		}
	}

}
