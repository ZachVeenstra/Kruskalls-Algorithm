package cis263;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class KruskalsAlgorithm {

    private static void kruskal(Graph g) {

        /** The minimum spanning tree outputed by Kruskal's Algorithm. */
        Graph solutionTree = new Graph();

        /** The disjoint set used for the union/find algorithm. */
        DisjSets nodes = new DisjSets(g.getNumEdges() + 1);

        /** The total cost of the minimum spanning tree. */
        int cost = 0;


        // Sort the graph in ascending order.
        g.sort();

        // Look at each edge in the graph.
        for(Edge e : g.getEdges()) {
            // Look for the first node of e in the disjoint set and assign it to root1.
            int root1 = nodes.find(e.getFirstNode());

            // Look for the second node of e in the disjoint set and assign it to root2.
            int root2 = nodes.find(e.getSecondNode());

            // If they aren't in the same set it means there won't be a cycle created.
            if (root1 != root2) {
                nodes.union(root1, root2); // So we union them together.
                cost += e.getWeight(); // Update cost.
                solutionTree.addEdge(e); // And add the edge to the solution.
            }

            // If the number of edges in solutionTree are equal to the 
            // number of vertices in g, minus 1, we are finished.
            if (solutionTree.getNumEdges() == g.getNumVertices() - 1)
                break;
        }

        // Print each edge in solutionTree along with the total cost.
        for (Edge e : solutionTree.getEdges()) {
            System.out.println(e.toString());
        }
        System.out.println("The total cost is: " + cost);
        
    }
    public static void main(String[] args) {

        Graph g = new Graph();
        
        /** The graph entered by the user. */
        // ArrayList<Edge> inputGraph = new ArrayList<Edge>();

        /** The first node of an edge. */
        int firstNode;

        /** The second node of an edge. */
        int secondNode;

        /** The weight of an edge. */
        int weight;
 
        /** Accepts the user's input */
        Scanner userInput = new Scanner(System.in); 
 
 
        System.out.println("Read from file or stdin? (file/stdin): ");
  
        // the user's choice between file or stdin
        String choice = userInput.nextLine();
            
        if (choice.equals("file")) {
            
            System.out.println("Enter File name: ");
            
            try {
                
                // the user-inputed file
                File userFile = new File(userInput.nextLine());
  
                // parses the user-inputed file
                Scanner fileInput = new Scanner(userFile);
  
                while (fileInput.hasNext()) { // loops through the whole file
                    
                    // gets the values
                    firstNode = fileInput.nextInt();
                    secondNode = fileInput.nextInt();
                    weight = fileInput.nextInt();

                    // add the edge to the graph
                    g.addEdge(firstNode, secondNode, weight);
                    
                }

                fileInput.close(); // closes the file scanner
            }

            catch (FileNotFoundException f) { // if the user's file wasn't found
                System.out.println("File not found. Try again.");
                main(args); // run the program again
            }

            catch (InputMismatchException i) { // if the file had something that wasn't an int
                System.out.println("Unacceptable input from file.");
            }
        }

        else if (choice.equals("stdin")) {

            System.out.println("Enter first node, second node, and weight, or ctrl + c to end: ");

            while (userInput.hasNext()) { // asks user for input until ctrl + d is sent

                System.out.println("Enter first node, second node, and weight, or ctrl + d to end: ");

                try {
                    // get the values
                    firstNode = userInput.nextInt();
                    secondNode = userInput.nextInt();
                    weight = userInput.nextInt();

                    // add the edge to the graph
                    g.addEdge(firstNode, secondNode, weight);
                }
                catch (InputMismatchException i) { // if the user didn't input an int
                    System.out.println("Unacceptable input.");
                }
                catch (NoSuchElementException n) { // if the user didn't enter the right amount of values
                    System.out.println("Incorrect formatting.");
                }

            }
        }
        else { // if the user didn't input file or stdin
            System.out.println("Incorrect formatting.");
            main(args); // run the program again
        }
        
        userInput.close(); // closes the input scanner

        // run kruskal's algorithm on the inputed graph
        kruskal(g);
    }
}
