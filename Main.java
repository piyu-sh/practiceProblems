import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException,
			IOException {

		// USE fast input reader for ip
		// USe stringbiulder to store op and print all at once at the end
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());
		String split[] = br.readLine().split(" ");
		int a[] = new int[N];
		for (int i = 0; i < N; i++) {
			a[i] = Integer.parseInt(split[i].trim());
		}
		// build segment tree here
		int segTree[]=new int[2*N+1];
		int M = Integer.parseInt(br.readLine().trim());
		for (int i = 0; i < M; i++) {
			String splString[] = br.readLine().split(" ");
			int x = Integer.parseInt(splString[0].trim());
			int y = Integer.parseInt(splString[1].trim());

			// run query on segment tree
		}
	}

	int getSegmentTreeSize(int N) {
		int size = 1;
		for (; size < N; size <<= 1)
			;
		// a left-shift is a *=2, 2 left-shifts is a *=4 and so on. A
		// right-shift is a /= 2 and so on
		return size << 1;
	}

}
