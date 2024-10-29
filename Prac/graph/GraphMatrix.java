package graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class GraphMatrix {
	private int[][] adjMatrix;
	private int vertices;
	
	public GraphMatrix(int vertices) {
		this.vertices= vertices;
		adjMatrix = new int[vertices][vertices];
	}
	
	public void addEdge(int i, int j, int weight) {
		adjMatrix[i][j] = weight;
		adjMatrix[j][i] = weight; // for undirected graph	
	}
	
	public boolean checkEdge(int i, int j) {
		return adjMatrix[i][j] != 0;
	}
	
	public void removeEdge(int i, int j) {
		adjMatrix[i][j] = 0;
		adjMatrix[j][i] = 0;
	}
	
	public void printGraph() {
		System.out.println("Adjacency Matrix: ");
		for(int i=0; i< vertices; i++) {
			for(int j=0; j < vertices; j++) {
				System.out.print(adjMatrix[i][j] + " " );
			}
			System.out.println();
		}
	}
	
	public void bfs(int start) {
		boolean[] visited = new boolean[vertices];
		Queue<Integer> queue = new LinkedList<>();
		
		queue.add(start);
		visited[start] = true;
		
		System.out.print("BFS Traversal: ");
		
		while(!queue.isEmpty()) {
			int vertex = queue.poll();
			System.out.print(vertex + " ");
			
			for(int j = 0; j< vertices; j++) {
				if(adjMatrix[vertex][j] !=0 && !visited[j]) {
					queue.add(j);
					visited[j] = true;
				}
			}
		}
		System.out.println();
	}
	
	public void bfsRec(int start) {
		boolean[] visited = new boolean[vertices];
		System.out.print("BFS Recursive: ");
		bfsUtil(start, visited);
		System.out.println();
	}
	
	private void bfsUtil(int vertex, boolean[] visited) {
		Queue<Integer> queue = new LinkedList<Integer>();
		visited[vertex] = true;
		System.out.print(vertex + " ");
		
		for(int j=0; j < vertices; j++) {
			if(adjMatrix[vertex][j] != 0 && !visited[j]) {
				queue.add(j);
			}
		}
		
		if(!queue.isEmpty()) {
			int current = queue.poll();
			bfsUtil(current, visited);
		}
	}
	
	public void dfs(int start) {
		boolean[] visited = new boolean[vertices];
		Stack<Integer> stack = new Stack<>();
		
		stack.push(start);
		visited[start] = true;
		
		System.out.print("DFS Traversal: ");
		while(!stack.isEmpty()) {
			int vertex = stack.pop();
			
			System.out.print(vertex + " ");
			
			for(int j=0; j< vertices; j++) {
				if(adjMatrix[vertex][j] != 0 && !visited[j]) {
					stack.push(j);
					visited[j] = true;
				}
			}
			
		}
	}
	
	public void dfsRec(int start) {
		boolean[] visited = new boolean[vertices];
		System.out.print("DFS Recursive: ");
		dfsUtil(start, visited);
		System.out.println();
	}
	
	private void dfsUtil(int vertex, boolean[] visited) {
		visited[vertex] = true;
		System.out.print(vertex + " ");
		
		for(int j= 0; j < vertices; j++) {
			if(adjMatrix[vertex][j] != 0 && !visited[j]) {
				dfsUtil(j, visited);
				
			}
		}
	}

	public static void main(String[] args) {
		GraphMatrix graph = new GraphMatrix(4);
		
		graph.addEdge(0, 1, 2);
		graph.addEdge(0, 3, 1);
		graph.addEdge(1, 2, 3);
		graph.addEdge(2, 3, 1);
		System.out.println("Before modifying");
		graph.printGraph();
		
		graph.removeEdge(0, 3);
		
		System.out.println("After modifying: ");
		graph.printGraph();
		
		graph.bfs(0);
		graph.dfs(0);

	}

}
