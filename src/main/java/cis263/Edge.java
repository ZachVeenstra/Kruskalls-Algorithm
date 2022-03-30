package cis263;

public class Edge implements Comparable<Edge> {

    /** The first node of an edge. */
    private int firstNode;

    /** The second node of an edge. */
    private int secondNode;

    /** The weight of the edge. */
    private int weight;


    /**
     * Constructor.
     * 
     * @param firstNode
     * @param secondNode
     * @param weight
     */
    public Edge (int firstNode, int secondNode, int weight) {
        this.firstNode = firstNode;
        this.secondNode = secondNode;
        this.weight = weight;
    }

    
    /**
     * Gets the first node.
     * 
     * @return firstNode.
     */
    public int getFirstNode() {
        return firstNode;
    }

    
    /**
     * Gets the second node.
     * 
     * @return secondNode.
     */
    public int getSecondNode() {
        return secondNode;
    }


    /**
     * Gets the weight.
     * 
     * @return weight
     */
    public int getWeight() {
        return weight;
    }


    @Override
    public int compareTo(Edge e) {
        // Signum forces the method to return -1, 0, or 1.
        return Integer.signum(this.getWeight() - e.getWeight());
    }


    @Override
    public String toString() {
        return "[" + this.getFirstNode() + "," + this.getSecondNode() +
                "] weight: " + this.getWeight();
    }
}
