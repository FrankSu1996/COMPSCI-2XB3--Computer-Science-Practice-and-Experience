package Graph;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.Stack;

/**
 * This class represents an edge weighted digraph of cities in the USA. Adapted from Algorithms 4th edition,
 * by Bob Sedgewick
 * 
 * @author Frank
 *
 */
public class WeightedCityDigraph {
	private final int V;
	private final Bag<DirectedEdge>[] adj;
	
	/**
	 * Initializes a weighted city digraph with V vertices
	 * @param V The number of vertices in the graph
	 */
	public WeightedCityDigraph(int V) {
		this.V = V;
		this.adj = (Bag<DirectedEdge>[]) new Bag[V];
		for (int v = 0; v < V; v++)
			adj[v] = new Bag<DirectedEdge>();
	}
	
	/**
	 * Adds a directed edge to the weighted digraph
	 * @param e a directed edge
	 */
	public void addEdge(DirectedEdge e) {
		int v = e.from();
		adj[v].add(e);
	}
	
	/**
	 * Returns the directed edges adjacent to vertex v
	 * @param v A vertex
	 * @return a bag of directed edges adjacent to v
	 */
	public Iterable<DirectedEdge> adj(int v){
		return adj[v];
	}
	
	/**
	 * Builds a weighted city digraph using a stack of directed edges
	 * @param edges A stack of directed edges
	 * @return A weighted city digraph will all the directed edges added
	 */
	public static WeightedCityDigraph buildGraph(Stack<DirectedEdge> edges) {
		//build empty graph with 32 vertices
		WeightedCityDigraph graph = new WeightedCityDigraph(32);
		while (!edges.isEmpty()) {
			graph.addEdge(edges.pop());
		}
		return graph;
	}
	
	/**
	 * Returns the number of vertices in this edge-weighted digraph
	 * @return the number of vertices in this edge-weighted digraph
	 */
	public int V() {
		return this.V;
	}
}
