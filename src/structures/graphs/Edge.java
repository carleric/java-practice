package structures.graphs;

public class Edge<T> {
	public Vertex <T>v1;
	public Vertex <T>v2;
	public double distance;
	
	public Edge(Vertex <T>v1, Vertex <T>v2, double distance) {
		this.v1 = v1;
		this.v2 = v2;
		this.distance = distance;
	}
}
