
package Graph;

import edu.princeton.cs.algs4.Stack;

/**
 * Class that implements depths first search for directed graphs, adapted from 
 * Algorithms 4th edition textbook, by Bob Sedgewick
 * 
 * @author Frank
 *
 */
public class DepthFirstSearch {
	private boolean[] marked; //marked[v] is true is there is path from source to v
	private int[] edgeTo;     //edgeTo[v] last edge on source to v path
	private final int s;      //source vertex
	
	/**
	 * Client function that performs depth first search on a CityDigraph G with the source vertex as s
	 * @param G A CityDigraph
	 * @param s The source vertex to begin the search
	 */
	public DepthFirstSearch(CityDigraph G, int s) {
		this.s = s;
		edgeTo = new int[G.V()];
		marked = new boolean[G.V()];
		dfs(G, s);
	}
	
	/**
	 * Implementation of of depth first search
	 * @param G A CityDigraph
	 * @param s The source vertex to begin the search
	 */
	private void dfs(CityDigraph G, int v) {
		marked[v] = true;
		for (int w : G.adj(v)) {
			if (!marked[w]) {
				edgeTo[w] = v;
				dfs(G, w);
			}
		}
	}

	/**
	 * Returns a stack of integers representing the path from source to vertex v
	 * @param v The end vertex of a path in the dfs
	 * @return A stack of integers representing the path from source to vertex v
	 */
	public Stack<Integer> pathTo(int v) {
		Stack<Integer> path = new Stack<Integer>();
		for (int x = v; x != s; x = edgeTo[x])
			path.push(x);
		path.push(s);
		return path;
	}

	/**
	 * Client function to return the vertex that is an edge to vertex v
	 * @param v A vertex in the CityDigraph
	 * @return The vertex that is an edge to vertex v
	 */
	public int edgeTo(int v) {
		return this.edgeTo[v];
	}
}
