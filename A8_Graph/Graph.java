package A8_Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.Scanner;

class Graph {
	Scanner input = new Scanner(System.in);
	int v;
	int e;
	int source;
	int destination;
	int[][] adj;
	ArrayList<ArrayList<Integer>> adjList;

	void createAdjacencyMatrix() {
		System.out.print("Enter the number of vertex : ");
		v = input.nextInt();
		System.out.print("Enter the number of edges : ");
		e = input.nextInt();
		adj = new int[v][v];
		for (int i = 0; i < e; i++) {
			System.out.print("Enter source[" + i + "] : ");
			source = input.nextInt();
			System.out.print("Enter destination[" + i + "] : ");
			destination = input.nextInt();
			System.out.print("Enter weight between source and destination: ");
			int w = input.nextInt();
			adj[source][destination] = w;
			adj[destination][source] = w;
		}
		System.out.println("Adjacency Matrix : ");
		for (int i = 0; i < v; i++) {
			for (int j = 0; j < v; j++) {
				System.out.print(adj[i][j] + " ");
			}
			System.out.println();
		}
	}

	void createAdjacencyList() {
		System.out.print("Enter the number of vertices : ");
		v = input.nextInt();
		System.out.print("Enter the number of edges : ");
		e = input.nextInt();
		adjList = new ArrayList<>(v);
		for (int i = 0; i < v; i++) {
			adjList.add(new ArrayList<>());
		}
		for (int i = 0; i < e; i++) {
			System.out.print("Enter source[" + i + "] : ");
			source = input.nextInt();
			System.out.print("Enter destination[" + i + "] : ");
			destination = input.nextInt();
			adjList.get(source).add(destination);
			adjList.get(destination).add(source);
		}
		System.out.println("Adjacency List representation of Graph :");
		for (int i = 0; i < v; i++) {
			System.out.print(i + " -> ");
			for (int j = 0; j < adjList.get(i).size(); j++) {
				System.out.print(adjList.get(i).get(j) + " ");
			}
			System.out.println();
		}
	}

	void BFS(int start) {
		boolean[] visited = new boolean[v];
		Queue<Integer> queue = new LinkedList<>();
// queue is not a class in java but an interface in java.util which is implemented using linkedlist
// mark start as visited and enqueue it
		visited[start] = true;
		queue.add(start);
		System.out.print("BFS traversal starting from vertex " + start + ": ");
		while (!queue.isEmpty()) {
			int node = queue.poll();
			System.out.print(node + " ");
// get all the adjacent vertices of the dequeued vertex
			for (int i = 0; i < adjList.get(node).size(); i++) {
				if (!visited[adjList.get(node).get(i)]) // if not visited
				{
					visited[adjList.get(node).get(i)] = true; // mark as visited
					queue.add(adjList.get(node).get(i)); // enqueue it
				}
			}
		}
	}

	void DFS(int start) {
		boolean[] visited = new boolean[v];
		Stack<Integer> stack = new Stack<>();
		stack.push(start);
		System.out.print("\nDFS traversal starting from vertex " + start + ": ");
		while (!stack.isEmpty()) {
			int node = stack.pop();
// If the node is not visited, print it and mark visited
			if (!visited[node]) {
				System.out.print(node + " ");
				visited[node] = true;
			}
// Push all adjacent unvisited vertices to the stack
// (Reverse order to maintain left-to-right order of traversal)
			for (int i = adjList.get(node).size() - 1; i >= 0; i--) {
				int neighbor = adjList.get(node).get(i);
				if (!visited[neighbor]) {
					stack.push(neighbor);
				}
			}
		}
	}

	void primsAlgorithm() {
// Ensure adjacency matrix exists
		if (adj == null) {
			System.out.println("Please create adjacency matrix first!");
			return;
		}
		int n = v; // number of vertices
		int[] key = new int[n]; // minimum weights to connect each vertex
		int[] parent = new int[n]; // parent array to store MST
		boolean[] inMST = new boolean[n]; // track vertices included in MST
// Initialize keys
		for (int i = 0; i < n; i++) {
			key[i] = Integer.MAX_VALUE;
			inMST[i] = false;
		}
// Start MST from vertex 0
		key[0] = 0;
		parent[0] = -1; // start node has no parent
		for (int count = 0; count < n - 1; count++) {
// Pick minimum key vertex not yet included in MST
			int min = Integer.MAX_VALUE, u = -1;
// This loop is selecting the next best vertex to add to the MST.
// It finds the unvisited vertex (!inMST[i]) with the smallest key value.
			for (int i = 0; i < n; i++) {
				if (!inMST[i] && key[i] < min) {
					min = key[i];
					u = i;
				}
			}
// Include u in MST
			inMST[u] = true;
// Update keys of adjacent vertices
			for (int v = 0; v < n; v++) {
// Check if adj[u][v] is a valid edge and not yet in MST
				if (adj[u][v] != 0 && !inMST[v] && adj[u][v] < key[v]) {
					key[v] = adj[u][v];
					parent[v] = u;
				}
			}
		}
// Print MST
		System.out.println("\nEdge \tWeight");
		int totalCost = 0;
		for (int i = 1; i < n; i++) {
			System.out.println(parent[i] + " - " + i + "\t" + adj[i][parent[i]]);
			totalCost += adj[i][parent[i]];
		}
		System.out.println("Total Minimum Cost = " + totalCost);
	}
}