package graph;

import java.util.*;

import graph.Kruskal.GraphEdge;

public class Prim {
	private int vertices;
	private List<GraphEdge> edges= new ArrayList<>();
	
	public Prim(int vertices) {
		this.vertices = vertices;		
	}
	
	public void addGraphEdge(int source, int destination, int weight) {
        edges.add(new GraphEdge(source, destination, weight));
        edges.add(new GraphEdge(destination, source, weight)); // Add the reverse edge for undirected graph
    }
	
	public void findMST(int startVertex) {
		boolean[] visited = new boolean[vertices];
        PriorityQueue<GraphEdge> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(edge -> edge.weight));

        List<GraphEdge> mst = new ArrayList<>();
        int totalWeight = 0;
        
        visited[startVertex] = true;
        for(GraphEdge edge: edges) {
        	if(edge.source == startVertex) {
        		priorityQueue.add(edge);
        	}
        }
        
        while(!priorityQueue.isEmpty()) {
        	GraphEdge currentEdge = priorityQueue.poll();
        	int currentVertex = currentEdge.destination;
        	
        	if(visited[currentVertex]) {
        		continue;
        	}
        	
        	visited[currentVertex] = true;
        	mst.add(currentEdge);
        	totalWeight += currentEdge.weight;
        	
        	for(GraphEdge edge: edges) {
                if (edge.source == currentVertex && !visited[edge.destination]) {
                	priorityQueue.add(edge);
                }
        	
        	}
        }
        System.out.println("Minimum Spanning Tree (MST):");
        for (GraphEdge edge : mst) {
            System.out.println("Edge: " + edge.source + " - " + edge.destination + ", Weight: " + edge.weight);
        }
        System.out.println("Total weight of MST: " + totalWeight);
	}
    
        

	public static void main(String[] args) {
		Prim prim = new Prim(4); // Example with 4 vertices
		
        prim.addGraphEdge(0, 1, 1);
        prim.addGraphEdge(0, 2, 4);
        prim.addGraphEdge(1, 2, 2);
        prim.addGraphEdge(1, 3, 6);
        prim.addGraphEdge(2, 3, 3);

        prim.findMST(0); 
	}

}
