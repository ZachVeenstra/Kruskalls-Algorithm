package cis263;

import java.util.ArrayList;
import java.util.Collections;

public class Graph {

    /** A list of the edges in the graph. */
    private ArrayList<Edge> edges;

    /** A list of the vertices in the graph. */
    private ArrayList<Integer> vertices;

    public Graph(){
        edges = new ArrayList<Edge>();
        vertices = new ArrayList<Integer>();
    }

    /**
     * Add an edge object to the graph.
     * 
     * @param e The edge to be added.
     */
    public void addEdge(Edge e) {
        edges.add(e);
    }

    /**
     * Add an edge to the graph.
     * 
     * @param firstNode The first node of the edge.
     * @param secondNode The seconde node of the edge.
     * @param weight The weight of the edge.
     */
    public void addEdge(int firstNode, int secondNode, int weight) {
        
        /** Create the edge object. */
        Edge e = new Edge(firstNode, secondNode, weight);

        // Add the edge to the graph.
        edges.add(e);

        // If the firstNode is not already in the graph, add it.
        if (!vertices.contains(firstNode)) {
            vertices.add(firstNode);
        }
        
        // If the secondNode is not already in the graph, add it.
        if (!vertices.contains(secondNode)) {
            vertices.add(secondNode);
        }
    }

    /**
     * Gets the list of edges.
     * 
     * @return The ArrayList of edges.
     */
    public ArrayList<Edge> getEdges() {
        return edges;
    }

    /**
     * Gets the number of vertices in the graph.
     * 
     * @return The number of vertices.
     */
    public int getNumVertices() {
        return vertices.size();
    }

    /**
     * Gets the number of edges in the graph.
     * 
     * @return The number of edges.
     */
    public int getNumEdges() {
        return edges.size();
    }

    /**
     * Sorts the edges of the graph in ascending order.
     */
    public void sort() {
        Collections.sort(edges);
    }
}
