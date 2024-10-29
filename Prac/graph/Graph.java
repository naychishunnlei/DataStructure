package graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Graph {
	private int[][] adjMatrix;
	private int vertices;
	
	public Graph(int vertices) {
		this.vertices = vertices;
		adjMatrix = new int[vertices][vertices];
	}
	
	public void addEdge(int src, int dest) {
		adjMatrix[src][dest] = 1;
		adjMatrix[dest][src] = 1;
	}
	
	//DFS using recursion
	public void dfs(int start) {
		boolean[] visited = new boolean[vertices];
		System.out.print("DFS Traversal: ");
		dfsRecursion(start, visited);
		System.out.println();
		
	}
	
	private void dfsRecursion(int vertex, boolean[] visited) {
		visited[vertex] = true;
		System.out.print(vertex + " ");
		
		for(int i=0; i < vertices; i++) {
			if(adjMatrix[vertex][i] == 1 && !visited[i]) {
				dfsRecursion(i, visited);
			}
		}
	}
	
	public int findDepth(int start) {
		boolean[] visited = new boolean[vertices];
		return findDepthRecursion(start, visited, 0);
	}
	
	private int findDepthRecursion(int vertex, boolean[] visited, int depth) {
		visited[vertex] = true;
		int maxDepth = depth;
		
		for(int i=0; i < vertices; i++) {
			if(adjMatrix[vertex][i] == 1 && !visited[i]) {
				maxDepth = Math.max(maxDepth, findDepthRecursion(i, visited, depth+1));
			}
		}
		return maxDepth;
	}
	
	public void dfsUsingStack(int start) {
		boolean[] visited  = new boolean[vertices];
		Stack<Integer> stack = new Stack<>();
		stack.push(start);
		
		while(!stack.isEmpty()) {
			int current = stack.pop();
			
			if(!visited[current]) {
				visited[current] = true;
				System.out.print(current + " ");
				
				for(int i= vertices - 1; i>=0; i++) {
					if(adjMatrix[current][i] == 1 && !visited[i]) {
						stack.push(i);
					}
				}
			}
		}
		System.out.println();
	}
	
	public int countVisitedDFS(int start) {
		boolean[] visited = new boolean[vertices];
		return countVisitedDFSRecursion(start, visited);
	}
	
	private int countVisitedDFSRecursion(int vertex, boolean[] visited) {
		visited[vertex] = true;
		int count = 1;
		
		for(int i=0; i< vertices; i++) {
			if(adjMatrix[vertex][i] == 1 && !visited[i]) {
				countVisitedDFSRecursion(i, visited);
				count++;
			}
		}
		return count;
		
	}
	
	public void bfs(int start) {
		boolean[] visited = new boolean[vertices];
		Queue<Integer> queue = new LinkedList<>();
		queue.add(start);
		visited[start] = true;
		
		while(!queue.isEmpty()) {
			int current = queue.poll();
			
			System.out.print(current+ " ");
			
			for(int i=0; i< vertices; i++) {
				if(adjMatrix[current][i] == 1 && !visited[i]) {
					visited[i]= true;
					queue.add(i);
				}
			}
		}
		System.out.println();
		
	}
	
	public int countVisitedBFS(int start) {
		boolean[] visited = new boolean[vertices];
		Queue<Integer> queue = new LinkedList<>();
		visited[start] = true;
		queue.add(start);
		
		int count = 0;
		
		while(!queue.isEmpty()) {
			int current = queue.poll();
			count++;
			
			for(int i=0; i< vertices; i++) {
				if(adjMatrix[current][i] == 1 && !visited[i]) {
					visited[i] = true;
					queue.add(i);
				}
			}
		}
		return count;
	}
	
	public void displayMatrix() {
		for(int i=0; i< vertices; i++) {
			for(int j=0; j<vertices; j++) {
				System.out.print(adjMatrix[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	 // Main method to test the graph implementation
    public static void main(String[] args) {
        Graph graph = new Graph(6); // Create a graph with 6 vertices

        // Adding edges to the graph
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 5);

        // Perform DFS and BFS traversals
        graph.dfs(0); // Starting DFS from vertex 0
        graph.dfsUsingStack(0); // DFS using stack from vertex 0
        graph.bfs(0); // Starting BFS from vertex 0

        // Find depth and count visited vertices
        int depth = graph.findDepth(0);
        System.out.println("Depth of the graph: " + depth);
        int visitedCountDFS = graph.countVisitedDFS(0);
        System.out.println("Number of vertices visited in DFS: " + visitedCountDFS);
        int visitedCountBFS = graph.countVisitedBFS(0);
        System.out.println("Number of vertices visited in BFS: " + visitedCountBFS);
    }

}
