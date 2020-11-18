/*
  Jonathan Gentry
  COSC 2336-48F
  Instructor: Dr. Doerschuk
  Programming Assignment 10
  Due: 11/18/2020
  (Find shortest paths).  Write a program that reads a connected graph from a file. The graph is stored in a file
  using the format specified below. Your program should prompt the user to enter the name of the file then two
  vertices, and should display a shortest path between the two vertices.
  I used fileString instead of s to help with the naming.
 */

package Main.Java.ClassWork.GraphsAndApplications.Assignment;

public class ShortestPathsJonathanGentry{
    public static void main(String[] args) throws Exception {
        // Create a scanner object to read from console
        java.util.Scanner scan = new java.util.Scanner(System.in);

        // Ask user for the file name and store name in new file object
        System.out.print("Enter a file name: ");
        java.io.File file = new java.io.File(scan.nextLine());

        // Check if file exists and loop until existing file input
        while (!file.exists()) {
            System.out.println("File does not exist");

            // Ask user for the file name and store name in new file object
            System.out.print("Enter a file name: ");
            file = new java.io.File(scan.nextLine());
        }

        // Ask user to input two vertices and store the integers in two int variables
        System.out.print("Enter two vertices (integer indexes): ");
        int vortex1 = scan.nextInt();
        int vortex2 = scan.nextInt();

        // Create new scanner object to scan file
        java.util.Scanner scanFile = new java.util.Scanner(file);

        // Create a string variable to store the file strings, read first line (Number of Vertices)
        // I used fileString instead of s to help with the naming.
        String fileString = scanFile.nextLine();
        // Create int variable to hold number of Vertices and parse the first line of file to int. Print to console
        int numberOfVertices = Integer.parseInt(fileString);
        System.out.println("The number of vertices is " + numberOfVertices);

        // Create a list of WeightedEdge objects
        java.util.List<WeightedEdge> list = new java.util.ArrayList<WeightedEdge>();

        // Loop while the file scanner object has a next line
        while (scanFile.hasNext()) {

            // Update file string
            fileString = scanFile.nextLine();

            // Create string array and spilt to extract the triplets.
            String[] triplets = fileString.split("[\\|]");

            // Loop to split the all the triplets in the line and store in respective int variables.
            // u = vertex | v = vertex | w = weight
            for (String triplet: triplets) {
                String[] tokens = triplet.split("[,]");
                int u = Integer.parseInt(tokens[0].trim());
                int v = Integer.parseInt(tokens[1].trim());
                int w = Integer.parseInt(tokens[2].trim());

                /* Add new WeightedEdge objects to the list and represent both edges.
                Note that we assume the graph is undirected. If the graph has an edge ( u , v ),
                it also has an edge ( v , u ). Only one edge is represented in the file.
                When you construct a graph, both edges need to be added. */
                list.add(new WeightedEdge(u, v, w));
                list.add(new WeightedEdge(v, u, w));
            }
        }

        // Create new weighted graph using WeightedGraph(list, numberOfVertices)
        WeightedGraph<Integer> graph = new WeightedGraph<Integer>(list, numberOfVertices);
        // Call method to display the vertex's edges and weights
        graph.printWeightedEdges();

        // Create a ShortestPathTree and call method from WeightedGraph to get the shortest path (give first user vertex for sourceVertex)
        WeightedGraph<Integer>.ShortestPathTree tree = graph.getShortestPath(vortex1);
        // Print the path from the sourceVertex to second user vertex, using printPath() from UnweightedGraph
        tree.printPath(vortex2);
    }
}


