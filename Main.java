import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {

	public static void main(String[] args) throws NumberFormatException,
			IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int nodes = Integer.parseInt(br.readLine().trim());
		if (nodes == 0) {
			System.out.println("0");
			return;
		}
		ArrayList<Integer> adj[] = new ArrayList[nodes + 1];
		for (int i = 1; i < nodes - 1; i++) {
			adj[i] = new ArrayList<Integer>();
		}
		for (int i = 1; i <= nodes - 1; i++) {
			String temp[] = br.readLine().split(" ");
			Integer u = Integer.parseInt(temp[0]);
			Integer v = Integer.parseInt(temp[1]);
			adj[u].add(v);
			adj[v].add(u);
		}
		int farthest = findFarthest(adj, 1);
		int longestDistance = findDistance(farthest, adj);
		System.out.println(longestDistance - 1);
	}

	private static int findDistance(int farthest, ArrayList<Integer>[] adj) {
		// TODO Auto-generated method stub
		return 0;
	}

	private static int findFarthest(ArrayList<Integer>[] adj, int i) {
		int farthest = i;
		List<Integer> queue = new LinkedList<Integer>();

		return farthest;
	}
}