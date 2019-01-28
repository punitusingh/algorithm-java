package graph;

import java.util.Queue;
import java.util.LinkedList;
import java.util.Stack;

public class Graph {
	Vertex start;

	public Graph(Vertex s) {
		start = s;
	}
	
	public void BFS(Vertex startVertex) {
		Queue<Vertex> q = new LinkedList<Vertex>();
		q.offer(startVertex);
		startVertex.setVisited(true);
		
		while(!q.isEmpty()) {
			Vertex v = q.poll();
			System.out.println(v.id);
			for(Vertex child : v.getNeighbours()) {
				if(!child.isVisited()) {
					q.offer(child);
					child.setVisited(true);
				}
			}
		}
	}
	
	public void DFS(Vertex startVertex) {
		Stack<Vertex> s = new Stack<Vertex>();
		s.push(startVertex);
		startVertex.setVisited(true);
		
		while(!s.isEmpty()) {
			Vertex v = s.pop();
			System.out.println(v.id);
			for(Vertex child : v.getNeighbours()) {
				if(!child.isVisited()) {
					s.push(child);
					child.setVisited(true);
				}
			}
		}
	}
	
	public void DFSRecur(Vertex v) {
		if(v.isVisited()) {
			return ;
		}
		System.out.println(v.id);
		v.setVisited(true);
		for(Vertex child : v.getNeighbours()) {
			if(!child.isVisited()) {
				DFSRecur(child);
			}
		}
	}
}
