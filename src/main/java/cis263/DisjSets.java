package cis263;
// DisjSets class
//
// CONSTRUCTION: with int representing initial number of sets
//
// ******************PUBLIC OPERATIONS*********************
// void union( root1, root2 ) --> Merge two sets
// int find( x )              --> Return set containing x
// ******************ERRORS********************************
// No error checking is performed

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Disjoint set class, using union by rank and path compression.
 * Elements in the set are numbered starting at 0.
 * @author Mark Allen Weiss
 */
public class DisjSets
{
    /**
     * Construct the disjoint sets object.
     * @param numElements the initial number of disjoint sets.
     */
    public DisjSets( int numElements )
    {
        s = new int [ numElements ];
        for( int i = 0; i < s.length; i++ )
            s[ i ] = -1;
    }

    /**
     * Union two disjoint sets using the height heuristic.
     * For simplicity, we assume root1 and root2 are distinct
     * and represent set names.
     * @param root1 the root of set 1.
     * @param root2 the root of set 2.
     */
    public void union( int root1, int root2 )
    {
        if( s[ root2 ] < s[ root1 ] )  // root2 is deeper
            s[ root1 ] = root2;        // Make root2 new root
        else
        {
            if( s[ root1 ] == s[ root2 ] )
                s[ root1 ]--;          // Update height if same
            s[ root2 ] = root1;        // Make root1 new root
        }
    }

    /**
     * Perform a find with path compression.
     * Error checks omitted again for simplicity.
     * @param x the element being searched for.
     * @return the set containing x.
     */
    public int find( int x )
    {
        if( s[ x ] < 0 )
            return x;
        else
            return s[ x ] = find( s[ x ] );
    }

    private int [ ] s;


    // Test main; all finds on same output line should be identical
    public static void main( String [ ] args )
    {
        // int NumElements = 128;
        // int NumInSameSet = 16;

        // DisjSets ds = new DisjSets( NumElements );
        // int set1, set2;

        // for( int k = 1; k < NumInSameSet; k *= 2 )
        // {
        //     for( int j = 0; j + k < NumElements; j += 2 * k )
        //     {
        //         set1 = ds.find( j );
        //         set2 = ds.find( j + k );
        //         ds.union( set1, set2 );
        //     }
        // }

        // for( int i = 0; i < NumElements; i++ )
        // {
        //     System.out.print( ds.find( i )+ "*" );
        //     if( i % NumInSameSet == NumInSameSet - 1 )
        //         System.out.println( );
        // }
        // System.out.println( );

         // takes user input
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
                    // TODO: Add edges from file
                }
 
                // Print the edges of the MST and the cost.
                fileInput.close(); // closes the file scanner
            }
            catch (FileNotFoundException f) { // if the user's file wasn't found
                System.out.println("File not found. Try again.");
                main(args); // run the program again
            }
        }
        else if (choice.equals("stdin")) {
            System.out.println("Enter first node, second node, and weight, or ctrl + d to end: ");
 
            while (userInput.hasNext()) { // asks user for input until ctrl + d is sent
                //int value = userInput.nextInt();
                // TODO: Add edges
            }
            // Print the edges of the MST and the cost.
            
        }
        else { // if the user didn't input file or stdin
            System.out.println("Incorrect formatting.");
            main(args); // run the program again
        }
        
        userInput.close(); // closes the input scanner
    }
}
