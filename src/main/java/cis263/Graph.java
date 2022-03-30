package cis263;

import java.util.ArrayList;
import java.util.Collections;

public class Graph {

    private ArrayList<Edge> edges;

    private ArrayList<Integer> vertices;

    public Graph(){
        edges = new ArrayList<Edge>();
        vertices = new ArrayList<Integer>();
    }

    public void addEdge(int firstNode, int secondNode, int weight) {
        
        Edge e = new Edge(firstNode, secondNode, weight);

        edges.add(e);

        if (!vertices.contains(firstNode)) {
            vertices.add(firstNode);
        }
        
        if (!vertices.contains(secondNode)) {
            vertices.add(secondNode);
        }
    }

    public ArrayList<Edge> getEdges() {
        return edges;
    }

    public int getNumVertices() {
        return vertices.size();
    }

    public int getNumEdges() {
        return edges.size();
    }

    public void sort() {
        Collections.sort(edges);
    }
}
