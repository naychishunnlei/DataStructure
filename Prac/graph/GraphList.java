package graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class GraphList {
	//private List<Integer>[] adjList;
	private List<Edge>[] adjList;
	private int vertices;
	
	public GraphList(int vertices) {
		this.vertices = vertices;
		adjList = new LinkedList[vertices];
		for(int i=0; i<vertices; i++) {
			adjList[i] = new LinkedList<>();
			
		}
	}
	
	public int getVertices() {
		return vertices;
	}
	
	public List<Edge>[] getAdjList() {
		return adjList;
	}

	public void addEdge(int i, int j, int weight) {
//		adjList[i].add(j);
//		adjList[j].add(i); //for undirected graph
		adjList[i].add(new Edge(j, weight));
		adjList[j].add(new Edge(i, weight)); // for undirected graph
	}
	
//	public void printGraph() {
//		System.out.println("Adjacency List: ");
//		for(int i=0; i<vertices; i++) {
//			System.out.print(i + ": "); 
//			for(int j : adjList[i]) {
//				System.out.print(j + " ");
//			}
//			System.out.println();
//		}
//	}
	
	public boolean checkEdge(int i, int j) {
		for(Edge edge: adjList[i]) {
			if(edge.getVertex() == j) {
				return true; // Edge i to j exist
			}
		}
		return false;
	}
	
	public void removeEdge(int i, int j) {
		adjList[i].removeIf(edge -> edge.getVertex() == j);
		adjList[j].removeIf(edge -> edge.getVertex() == i);
	}
	
	public void printGraph() {
		System.out.println("Weighted Adjacency List: ");
		for(int i=0; i<vertices; i++) {
			System.out.print(i + ": ");
			for(Edge edge: adjList[i]) {
				System.out.print("(" + edge.getVertex() + ", weight: " + edge.getWeight() + ") ");
			}
			System.out.println();
		}
	}
	
	public void bfs(int start) {
		boolean[] visited = new boolean[vertices];
		LinkedList<Integer> queue = new LinkedList<>();
		
		queue.add(start);
		visited[start] = true;
		
		System.out.print("BFS Traversal: ");
		
		while(!queue.isEmpty()) {
			int vertex = queue.poll();
			System.out.print(vertex + " ");
			
			for(Edge edge: adjList[vertex]) {
				int adjacent = edge.getVertex();
				
				if(!visited[adjacent]) {
					visited[adjacent] = true;
					queue.add(adjacent);
				}
			}
		}
		System.out.println();
		
	}
	
	public void dfs(int start) {
		boolean[] visited = new boolean[vertices];
		Stack<Integer> stack = new Stack<>();
		
		stack.push(start);
		
		System.out.print("DFS traversal: ");
		
		while(!stack.isEmpty()) {
			int vertex = stack.pop();
			System.out.print(vertex + " ");
			
			if(!visited[vertex]) {
				visited[vertex] = true;
				
				for(Edge edge: adjList[vertex]) {
					int adjacent = edge.getVertex();
					
					if(!visited[adjacent]) {
						stack.push(adjacent);
					}
				}
			}
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		GraphList graph = new GraphList(4);
		
		graph.addEdge(0, 1, 2);
        graph.addEdge(0, 3, 6);
        graph.addEdge(1, 2, 3);
        graph.addEdge(2, 3, 1);
		
        System.out.println("Before modifying");
		graph.printGraph();
		
		System.out.println("Edge between 0 and 1: " + graph.checkEdge(0, 1)); // true
        System.out.println("Edge between 1 and 3: " + graph.checkEdge(1, 3)); // false

        // Remove an edge
        graph.removeEdge(0, 1);
        graph.printGraph(); 
        
        graph.bfs(0);
        graph.dfs(0);

	}

}
