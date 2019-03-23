package Graph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import DataRecords.CityName;
import edu.princeton.cs.algs4.Bag;

/**
 * Class for creating a digraph of Cities. Uses Bag API from algorithms textbook, referenced in Algs4.jar 
 * in the lib folder
 * @author Frank
 *
 */
public class CityDigraph {
	private static final String NEWLINE = System.getProperty("line.separator");
	private final int V;            //number of vertices in the digraph
	private int E;                  //number of edges in this digraph
	private Bag<Integer>[] adj;     //adj[v] = adjacency list for vertex v
	private int[] indegree;         //indegree[v] = indegree of vertex v
	
	/**
     * Initializes an empty digraph with V vertices.
     *
     * @param  V the number of vertices
     * @throws IllegalArgumentException if {@code V < 0}
     */
    public CityDigraph(int V) {
        if (V < 0) throw new IllegalArgumentException("Number of vertices in a Digraph must be nonnegative");
        this.V = V;
        this.E = 0;
        indegree = new int[V];
        adj = (Bag<Integer>[]) new Bag[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new Bag<Integer>();
        }
    }
    
    /**
     * Returns the number of vertices in this digraph.
     *
     * @return the number of vertices in this digraph
     */
    public int V() {
        return V;
    }

    /**
     * Returns the number of edges in this digraph.
     *
     * @return the number of edges in this digraph
     */
    public int E() {
        return E;
    }
    
    /**
     * Adds a directed edge from v to w in this diagraph
     * @param v the tail vertex
     * @param w the head vertex
     */
    public void addEdge(int v, int w) {
    	adj[v].add(w);
    	indegree[w]++;
    	E++;
    }
    
    /**
     * Returns the vertices adjacent from vertex {@code v} in this digraph.
     *
     * @param  v the vertex
     * @return the vertices adjacent from vertex {@code v} in this digraph, as an iterable
     */
    public Iterable<Integer> adj(int v) {
        return adj[v];
    }
    
    /**
     * Returns the number of directed edges incident from vertex {@code v}.
     * This is known as the <em>outdegree</em> of vertex {@code v}.
     *
     * @param  v the vertex
     * @return the outdegree of vertex {@code v}               
     */
    public int outdegree(int v) {
        return adj[v].size();
    }

    /**
     * Returns the number of directed edges incident to vertex {@code v}.
     * This is known as the <em>indegree</em> of vertex {@code v}.
     *
     * @param  v the vertex
     * @return the indegree of vertex {@code v}               
     * @throws IllegalArgumentException unless {@code 0 <= v < V}
     */
    public int indegree(int v) {
        return indegree[v];
    }
    
    /**
     * Returns a string representation of the graph.
     *
     * @return the number of vertices <em>V</em>, followed by the number of edges <em>E</em>,  
     *         followed by the <em>V</em> adjacency lists
     */
    public void printGraph() {
        System.out.println("Graph has: " + V + " vertices, " + E + " edges \n");
        System.out.println("Cities to the right are connected to the cities to the left of colon \n");
        for (int i = 0; i < V; i++) {
        	System.out.print(CityName.values()[i] + ": ");
        	for (int j : adj[i]) {
        		System.out.print(CityName.values()[j] + " ");
        	}
        	System.out.println("\n");
        }
    }
    
    /**
	 * Builds a digraph of a city using a file (in this case fileName is "connectedCities.txt")
	 * 
	 * @param fileName The name of the file containing the query of connections between cities 
	 * @return A digraph representing connections between U.S. cities 
	 */
	public static CityDigraph BuildGraph(String fileName) {
		File file = new File(fileName);
		//initialize empty digraph with 32 vertices/cities
		CityDigraph graph = new CityDigraph(32);
		try {
			Scanner inputStream = new Scanner(file);
			while(inputStream.hasNext()) {
				//parse out data using split()
				String line = inputStream.nextLine();
				String[] values = line.split(",");
				//convert city names from String to type CityName
				String city1 = values[0];
				city1 = city1.toUpperCase().replaceAll("\\s+", "").replace(".", "");
				CityName City1 = CityName.valueOf(city1);
				String city2 = values[1];
				city2 = city2.strip().toUpperCase().replaceAll("\\s+", "").replace(".", "");
				CityName City2 = CityName.valueOf(city2);
				graph.addEdge(City1.ordinal(), City2.ordinal());
			}
			inputStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return graph;
	}
}
