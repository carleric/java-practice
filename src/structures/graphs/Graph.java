package structures.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Queue;
import java.util.LinkedList;
import java.util.List;


public class Graph <T>{
	private ArrayList <Vertex<T>>vertices;
	
	public Graph(Vertex<T>... vertices) {
		this.vertices = new ArrayList<Vertex<T>>(Arrays.asList(vertices));
	}

	/**
	 * Given an unweighted directed graph, how would you find the shortest path from s to t? 
	 * Print out all vertices along the shortest path. Assume no two vertices have the same value.  
	 */
	public List<Vertex<T>> shortestPathUnweighted(Vertex <T>origin, Vertex <T>destination) {
		
		//do a BFS to find accumulated cost of paths from origin to destination
		BFS(origin);
		
		//walk from destination back to origin from the destination via parent pointer and load into a list 
		List <Vertex<T>>path = new ArrayList<>();
		Vertex <T>current = destination;
		while(current != null) {
			path.add(current);
			current = current.parent;
		}
		Collections.reverse(path);//reverse it so that the origin is at the beginning
		
		//iterate over the list and print out the path
		for(Vertex <T>v : path) {
			System.out.println(String.format("vertex value=%s", v.value));
		}
		
		//return path to caller
		return path;
	}
	
	public void BFS( Vertex <T>origin) {
		
		for(Vertex <T>v : this.vertices) {
			v.visited = false;
			v.parent = null;
		}
		
		Queue <Vertex<T>>q = new LinkedList<>();
		
		origin.distance = 0;
		q.add(origin);
		while(q.isEmpty() == false) {
			Vertex <T>current = q.poll();
			
			for(Vertex <T>v : current.getAdjacentVertices()) {
				if(v.visited == false) {
					v.distance = current.distance + 1;
					v.parent = current;
					v.visited = true;
					q.add(v);
				}
			}
		}
	}
}
