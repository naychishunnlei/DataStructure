package graph;

import java.util.*;

public class Kruskal {
	private int vertices;
	private List<GraphEdge> edges = new ArrayList<>();
	
	static class GraphEdge implements Comparable<GraphEdge> {
		int source;
		int destination;
		int weight;
		
		public GraphEdge(int source, int destination, int weight) {
			this.source = source;
			this.destination = destination;
			this.weight = weight;
		}
		
		@Override 
		public int compareTo(GraphEdge other) {
			return this.weight - other.weight;
		}
	}
	
	static class UnionFind {
		private int[] parent;
		private int[] rank;
		
		public UnionFind(int size) {
			parent = new int[size];
			rank = new int[size];
			for(int i=0; i < size; i++) {
				parent[i] = i;
				rank[i] = 0;
			}
		}
		
		public int find(int vertex) {
			if(parent[vertex] != vertex) {
				parent[vertex] = find(parent[vertex]);
			}
			return parent[vertex];
		}
		
		public boolean union(int vertex1, int vertex2) {
			int root1 = find(vertex1);
			int root2 = find(vertex2);
			
			if(root1 == root2) {
				return false;
			}
			
			if(rank[root1] < rank[root2]) {
				parent[root1] = root2;
			} else if(rank[root1] > rank[root2]) {
				parent[root2] = root1;
			} else {
				parent[root2] = root1;
				rank[root1]++;
			}
			return true;
		}	
	}
	
	public Kruskal(int vertices) {
		this.vertices = vertices;
	}
	
	public void addGraphEdge(int source, int destination, int weight) {
		edges.add(new GraphEdge(source, destination, weight));
	}
	
	public void findMST() {
		Collections.sort(edges);
		UnionFind uf = new UnionFind(vertices);
		
		List<GraphEdge> mst = new ArrayList<>();
		int totalWeight = 0;
		
		for(GraphEdge edge : edges) {
			if(uf.union(edge.source, edge.destination)) {
				mst.add(edge);
				totalWeight += edge.weight;
				
				if(mst.size() == vertices - 1) {
					break;
				}
			}
		}
		
		System.out.println("Minimun Spanning Tree(MST): ");
		for(GraphEdge edge : mst) {
			System.out.println("Edge: " + edge.source + " - " + edge.destination + ", Weight: " + edge.weight);
		}
		System.out.println("Total weight of MST: " + totalWeight);
	}
	
	public static void main(String[] args) {
        Kruskal graph = new Kruskal(4); // Example with 4 vertices
        graph.addGraphEdge(0, 1, 1);
        graph.addGraphEdge(0, 2, 4);
        graph.addGraphEdge(1, 2, 2);
        graph.addGraphEdge(1, 3, 6);
        graph.addGraphEdge(2, 3, 3);

        graph.findMST();
    }
}
