package com.pi.spoj.pt07z;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

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
		for (int i = 1; i <= nodes; i++) {
			adj[i] = new ArrayList<Integer>();
		}
		for (int i = 1; i <= nodes - 1; i++) {
			String temp[] = br.readLine().split(" ");
			Integer u = Integer.parseInt(temp[0]);
			Integer v = Integer.parseInt(temp[1]);
			adj[u].add(v);
			adj[v].add(u);
		}
		int farthest = findFarthest(adj, 1, nodes);
		int longestDistance = findDistance(farthest, adj, nodes);
		System.out.println(longestDistance - 1);
	}

	private static int findDistance(int farthestNode, ArrayList<Integer>[] adj,
			int nodes) {
		Queue<Integer> queue = new LinkedList<Integer>();

		queue.add(farthestNode);
		queue.add(-1);
		boolean visited[] = new boolean[nodes + 1];
		int distance = 0;
		int farthest;
		while (!queue.isEmpty()) {
			farthest = queue.remove();
			if (farthest == -1) {
				distance++;
				if (!queue.isEmpty()) {
					queue.add(-1);
				}
				continue;
			}
			visited[farthest] = true;
			for (int adjacent : adj[farthest]) {
				if (!visited[adjacent]) {
					queue.add(adjacent);
				}
			}
		}

		return distance;

	}

	private static int findFarthest(ArrayList<Integer>[] adj, int i, int nodes) {
		int farthest = i;
		Queue<Integer> queue = new LinkedList<Integer>();
		boolean visited[] = new boolean[nodes + 1];
		queue.add(i);
		while (!queue.isEmpty()) {
			farthest = queue.remove();
			visited[farthest] = true;
			for (int adjacent : adj[farthest]) {
				if (!visited[adjacent]) {
					queue.add(adjacent);
				}
			}
		}
		return farthest;
	}
}