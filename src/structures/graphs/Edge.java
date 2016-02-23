package structures.graphs;

/**
 * Edge is a directed edge, where v1 is the origin vertex and v2 is the vertex that v1 points to.
 * @author carlb
 *
 * @param <T>
 */
public class Edge<T> {
	public Vertex <T>v1;
	public Vertex <T>v2;
	public double weight;
	
	public Edge(Vertex <T>v1, Vertex <T>v2, double weight) {
		this.v1 = v1;
		this.v2 = v2;
		this.weight = weight; //for use in weighted graphs
	}
}
