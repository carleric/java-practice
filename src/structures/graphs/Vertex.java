package structures.graphs;

import java.util.ArrayList;

public class Vertex<T> {
	public ArrayList <Edge<T>>edges;
	public Boolean visited = false;
	public Vertex<T> parent = null;
	public double distance = 0;
	public T value;
	
	public Vertex(T value) {
		this.value = value;
		this.edges = new ArrayList<Edge<T>>();
	}
	
	public boolean addEdgeToVertex(Vertex <T>v, double weight) {
		Edge <T>e = new Edge<>(this, v, weight);
		this.edges.add(e);
		return true;
	}
	
//	public ArrayList<Vertex<T>> getAdjacentVertices(){
//		ArrayList <Vertex<T>>vertices = new ArrayList<>();
//		for(Edge <T>e : this.edges) {
//			Vertex<T> adjacent = e.v2;
//			vertices.add(adjacent);
//		}
//		return vertices;
//	}
}
