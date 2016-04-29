import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class Main {

	public static void main(String[] args) throws NumberFormatException,
			IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String nm[] = br.readLine().trim().split(" ");
		int N = Integer.parseInt(nm[0].trim());
		int M = Integer.parseInt(nm[1].trim());
		LinkedList<Integer> adj[] = null;
		int[] edges=new int[2];
		Set<Integer> nodes=new HashSet<Integer>();
		for (int i = 0; i < M; i++) {
			String[] split = br.readLine().split(" ");
			edges[0]=Integer.parseInt(split[0]);
			edges[1]=Integer.parseInt(split[1]);
			nodes.add(edges[0]);
			nodes.add(edges[1]);
		}
		Integer[] arr = null;
		arr=(Integer[]) nodes.toArray();
		
	}

	void initialize(int Arr[], int N) {
		for (int i = 0; i < N; i++)
			Arr[i] = i;
	}

	// returns true,if A and B are connected, else it will return false.
	boolean find(int Arr[], int A, int B) {
		if (Arr[A] == Arr[B])
			return true;
		else
			return false;
	}

	// change all entries from Arr[ A ] to Arr[ B ].
	void union(int Arr[], int N, int A, int B) {
		int TEMP = Arr[A];
		for (int i = 0; i < N; i++) {
			if (Arr[i] == TEMP)
				Arr[i] = Arr[B];
		}
	}

}
