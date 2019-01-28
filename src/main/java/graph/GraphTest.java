package graph;

import java.util.ArrayList;
import java.util.List;

public class GraphTest {
	public static void main(String[] arg) {
		Vertex V1 = new Vertex(1);
		Vertex V2 = new Vertex(2);
		Vertex V3 = new Vertex(3);
		Vertex V4 = new Vertex(4);
		Vertex V5 = new Vertex(5);
		Vertex V6 = new Vertex(6);
		
		List<Vertex> neighbours = new ArrayList<Vertex>();
		neighbours.add(V2);
		neighbours.add(V3);
		V1.setNeighbours(neighbours);
		
		neighbours = new ArrayList<Vertex>();
		neighbours.add(V1);
		neighbours.add(V5);
		V3.setNeighbours(neighbours);
		
		neighbours = new ArrayList<Vertex>();
		neighbours.add(V3);
		neighbours.add(V2);
		neighbours.add(V4);
		neighbours.add(V6);
		V5.setNeighbours(neighbours);
		
		neighbours = new ArrayList<Vertex>();
		neighbours.add(V5);
		neighbours.add(V4);
		V6.setNeighbours(neighbours);
		
		neighbours = new ArrayList<Vertex>();
		neighbours.add(V2);
		neighbours.add(V5);
		neighbours.add(V6);
		V4.setNeighbours(neighbours);
		
		neighbours = new ArrayList<Vertex>();
		neighbours.add(V1);
		neighbours.add(V5);
		neighbours.add(V4);
		V2.setNeighbours(neighbours);
		
		Graph g = new Graph( V1);

		//g.BFS(V1);
		//g.DFS(V1);
		g.DFSRecur(V1);
	}
}
