package graph;

public class Edge {
	public int vertex;
	public int weight;
	
	public Edge(int vertex, int weight) {
		this.vertex = vertex;
		this.weight = weight;
	}
	
	public int getVertex() {
		return vertex;
	}
	
	public int getWeight() {
		return weight;
	}

}
