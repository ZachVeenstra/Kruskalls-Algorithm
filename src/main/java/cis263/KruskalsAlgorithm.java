package cis263;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class KruskalsAlgorithm {

    private static void kruskal(Graph g) {

        /** The minimum spanning tree outputed by Kruskal's Algorithm */
        ArrayList<Edge> solutionTree = new ArrayList<Edge>();

        // Collections.sort(inputGraph);
        g.sort();

        // DisjSets nodes = new DisjSets(inputGraph.size());
        DisjSets nodes = new DisjSets(g.getNumEdges() + 1);

        int cost = 0;

        for(Edge e : g.getEdges()) {
            int root1 = nodes.find(e.getFirstNode());

            int root2 = nodes.find(e.getSecondNode());

            if (root1 != root2) {
                nodes.union(root1, root2);
                cost += e.getWeight();
                solutionTree.add(e);
            }
            if (solutionTree.size() == g.getNumVertices() - 1)
                break;
        }

        for (Edge e : solutionTree) {
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
                    //int value = fileInput.nextInt();
                    firstNode = fileInput.nextInt();
                    secondNode = fileInput.nextInt();
                    weight = fileInput.nextInt();

                    // Edge e = new Edge(firstNode, secondNode, weight);

                    // inputGraph.add(e);

                    g.addEdge(firstNode, secondNode, weight);
                    
                }
  
                // Print the edges of the MST and the cost.
                fileInput.close(); // closes the file scanner
            }
            catch (FileNotFoundException f) { // if the user's file wasn't found
                System.out.println("File not found. Try again.");
                main(args); // run the program again
            }
            catch (InputMismatchException i) {
                System.out.println("Unacceptable input from file.");
            }
        }
        else if (choice.equals("stdin")) {
            System.out.println("Enter first node, second node, and weight, or ctrl + d to end: ");
  
            while (userInput.hasNext()) { // asks user for input until ctrl + d is sent
                //int value = userInput.nextInt();
                // TODO: Add edges
                firstNode = userInput.nextInt();
                secondNode = userInput.nextInt();
                weight = userInput.nextInt();
                // Edge e = new Edge(firstNode, secondNode, weight);
                // inputGraph.add(e);

                g.addEdge(firstNode, secondNode, weight);
            }
            // Print the edges of the MST and the cost.
            
        }
        else { // if the user didn't input file or stdin
            System.out.println("Incorrect formatting.");
            main(args); // run the program again
        }
        
        userInput.close(); // closes the input scanner

        // kruskal(inputGraph);
        kruskal(g);
    }
}
