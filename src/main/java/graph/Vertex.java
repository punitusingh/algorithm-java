package graph;

import java.util.List;

public class Vertex {
    int id = -1;
    List<Vertex> neighbours = null;
    boolean visited = false;

    public Vertex(int i) {
        id = i;
    }

    @Override
    public String toString() {
        return "graph.Vertex [id=" + id + ", visited=" + visited + "]";
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Vertex> getNeighbours() {
        return neighbours;
    }

    public void setNeighbours(List<Vertex> neighbours) {
        this.neighbours = neighbours;
    }


}
