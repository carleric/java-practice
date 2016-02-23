package test;

import static org.junit.Assert.*;
import structures.graphs.Graph;
import structures.graphs.Vertex;
import java.util.List;

import org.junit.Test;

public class GraphTests {

	@Test
	public void testShortestPath() {
		Vertex <Integer>v1 = new Vertex<>(1);
		Vertex <Integer>v2 = new Vertex<>(2);
		Vertex <Integer>v3 = new Vertex<>(3);
		Vertex <Integer>v4 = new Vertex<>(4);
		Vertex <Integer>v5 = new Vertex<>(5);
		Vertex <Integer>v6 = new Vertex<>(6);
		
		v1.addEdgeToVertex(v2, 1);
		v2.addEdgeToVertex(v3, 1);
		v3.addEdgeToVertex(v4, 1);
		v4.addEdgeToVertex(v5, 1);
		v5.addEdgeToVertex(v6, 1);
		v2.addEdgeToVertex(v6, 1);
		
		Graph <Integer>g = new Graph<>(v1, v2, v3, v4, v5, v6);
		
		List <Vertex<Integer>> path = g.shortestPathUnweighted(v1, v6);
		
		assertTrue(path.size() == 3);
		assertTrue(path.get(0).value == 1);
		assertTrue(path.get(2).value == 6);
		
	}

}
