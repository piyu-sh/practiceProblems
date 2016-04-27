import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;

import org.omg.CosNaming.IstringHelper;

public class Main {

	static LinkedList<Integer> adj[] = null;
	private static int V;

	public static void main(String[] args) throws NumberFormatException,
			IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String nm[] = br.readLine().trim().split(" ");
		int N = Integer.parseInt(nm[0].trim());
		int M = Integer.parseInt(nm[1].trim());
		adj = new LinkedList[N];
		for (int i = 0; i < M; i++) {
			String[] split = br.readLine().split(" ");
			adj[Integer.parseInt(split[0])] = new LinkedList<Integer>();
			adj[Integer.parseInt(split[0])].add(Integer.parseInt(split[1]));
		}

		System.out.println(isTree() ? "YES" : "NO");
	}

	// A recursive function that uses visited[] and parent
	// to detect cycle in subgraph reachable from vertex v.
	static Boolean isCyclicUtil(int v, Boolean visited[], int parent) {
		// Mark the current node as visited
		visited[v] = true;
		Integer i;

		// Recur for all the vertices adjacent to this vertex
		Iterator<Integer> it = adj[v].iterator();
		while (it.hasNext()) {
			i = it.next();

			// If an adjacent is not visited, then recur for
			// that adjacent
			if (!visited[i]) {
				if (isCyclicUtil(i, visited, v))
					return true;
			}

			// If an adjacent is visited and not parent of
			// current vertex, then there is a cycle.
			else if (i != parent)
				return true;
		}
		return false;
	}

	// Returns true if the graph is a tree, else false.
	static Boolean isTree() {
		// Mark all the vertices as not visited and not part
		// of recursion stack
		Boolean visited[] = new Boolean[V];
		for (int i = 0; i < V; i++)
			visited[i] = false;

		// The call to isCyclicUtil serves multiple purposes
		// It returns true if graph reachable from vertex 0
		// is cyclcic. It also marks all vertices reachable
		// from 0.
		if (isCyclicUtil(0, visited, -1))
			return false;

		// If we find a vertex which is not reachable from 0
		// (not marked by isCyclicUtil(), then we return false
		for (int u = 0; u < V; u++)
			if (!visited[u])
				return false;

		return true;
	}

}
