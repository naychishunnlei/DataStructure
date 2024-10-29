package graph;

import java.util.*;

public class Dijkstra {
	private GraphList graph;
	
	public Dijkstra(GraphList graph) {
		this.graph = graph;
	}
	
	public void findShortestPath(int start, int destination) {
		int vertices = graph.getVertices();
		int[] distances = new int[vertices];
		boolean[] visited = new boolean[vertices];
		int[] previous = new int[vertices];
		
		Arrays.fill(distances, Integer.MAX_VALUE);
		Arrays.fill(previous, -1);
		distances[start] = 0;
		
		PriorityQueue<VertexDistance> priorityQueue = new PriorityQueue<>((a, b) -> a.distance - b.distance);
		priorityQueue.add(new VertexDistance(start, 0));
		
		while(!priorityQueue.isEmpty()) {
			int currentVertex = priorityQueue.poll().vertex;
			
			if(visited[currentVertex]) continue;
			visited[currentVertex] = true;
			
			for(Edge edge : graph.getAdjList()[currentVertex]) {
				int adjacentVertex = edge.getVertex();
				int weight = edge.getWeight();
				
				if(!visited[adjacentVertex] && distances[currentVertex] + weight < distances[adjacentVertex]) {
					distances[adjacentVertex] = distances[currentVertex] + weight;
					previous[adjacentVertex] = currentVertex;
					priorityQueue.add(new VertexDistance(adjacentVertex, distances[adjacentVertex]));
				}
			
			}
		}
		System.out.println("Shortest distances from vertex " + start + ": ");
		for(int i=0; i < vertices; i++) {
			System.out.println("Vertex " + i + ": " + distances[i]);
		}
		printPath(start, destination, previous, distances);
	}
	
	private void printPath(int start, int destination, int[] previous, int[] distances) {
		if(distances[destination] == Integer.MAX_VALUE) {
			System.out.println("No path from" + start + "to "+ destination);
			return;
		}
		
		List<Integer> path = new ArrayList<>();
		for(int vertex = destination; vertex != -1; vertex = previous[vertex]) {
			path.add(vertex);
		}
		Collections.reverse(path);
		
		System.out.println("Shortest path from " + start + " to " + destination + ": " + path);
        System.out.println("Total distance: " + distances[destination]);
	}
	
	private static class VertexDistance {
		int vertex;
		int distance;
		
		VertexDistance(int vertex, int distance) {
			this.vertex = vertex;
			this.distance = distance;
		}
	}

	public static void main(String[] args) {
		GraphList graph = new GraphList(4);
		
		graph.addEdge(0, 1, 2);
		graph.addEdge(0, 3, 6);
		graph.addEdge(1, 2, 3);
		graph.addEdge(2, 3, 1);
		
		graph.printGraph();
		
		Dijkstra dijkstra = new Dijkstra(graph);
		int start = 0;
		int destination = 2;
		dijkstra.findShortestPath(start, destination);
		
	}

}
