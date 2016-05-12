import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException,
			IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCases = Integer.parseInt(br.readLine().trim());
		for (int i = 0; i < testCases; i++) {
			br.readLine();
			int N = Integer.parseInt(br.readLine().trim());
			int[] A=new int[N];
			for (int j = 0; j < N; j++) {
				A[j]=Integer.parseInt(br.readLine());
				
			}
		}
	}

}
