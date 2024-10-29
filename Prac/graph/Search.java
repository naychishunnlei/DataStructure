package graph;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Search {
	private List<List<Integer>> adjList;
	
	public Search(int vertices) {
		adjList = new ArrayList<>(vertices);
		for(int i=0; i< vertices; i++) {
			adjList.add(new ArrayList<>());
		}
	}
	
	public void addEdge(int src, int dest) {
		adjList.get(src).add(dest);
		adjList.get(dest).add(src); //no need if it is a directed graph
	}
	
	//BFS algorithm
	public void bfs(int start) {
		boolean[] visited = new boolean[adjList.size()];
		Queue<Integer> queue = new LinkedList<>();
		
		visited[start] = true;
		queue.add(start);
		
		System.out.print("BFS Traversal: ");
		while(!queue.isEmpty()) {
			int vertex = queue.poll();
			System.out.print(vertex + " ");
			
			for(int neighbor: adjList.get(vertex)) {
				if(!visited[neighbor]) {
					visited[neighbor] = true;
					queue.add(neighbor);
				}
			}
		}
		System.out.println();
	}
	
	public void dfs(int start) {
		boolean[] visited = new boolean[adjList.size()];
		System.out.print("DFS Traversal: ");
		dfsRecursive(start, visited);
		System.out.println();
	}
	
	private void dfsRecursive(int vertex, boolean[] visited) {
		visited[vertex] = true;
		System.out.print(vertex + " ");
		
		for(int neighbor: adjList.get(vertex)) {
			if(!visited[neighbor]) {
				dfsRecursive(neighbor, visited);
			}
		}
	}
	
	public void dequeue(int start) {
		boolean[] visited = new boolean[adjList.size()];
		Deque<Integer> stack = new LinkedList<>();
		stack.push(start);
		System.out.print("DFS using Stack: ");
		
		while(!stack.isEmpty()) {
			int current = stack.pop();
			
			if(!visited[current]) {
				visited[current] = true;
				System.out.print(current);
				
				for(int neighbor: adjList.get(current)) {
					if(!visited[neighbor]) {
						stack.push(neighbor);
					}
				}	
			}
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int vertices = 6;
		Search searchGraph = new Search(vertices);
		
		searchGraph.addEdge(0, 1);
		searchGraph.addEdge(0, 2);
        searchGraph.addEdge(1, 3);
        searchGraph.addEdge(2, 4);
        searchGraph.addEdge(3, 5);
        searchGraph.addEdge(4, 5);

        searchGraph.bfs(0);
        searchGraph.dfs(0); 

	}

}
