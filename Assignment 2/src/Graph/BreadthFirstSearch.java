package Graph;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;

/**
 * Implementation of Breadth First Search for a digraph, adapted from 
 * Algorithms, 4th edition, by Bob Sedgewick
 * 
 * @author Frank
 *
 */
public class BreadthFirstSearch {
	private boolean[] marked; //marked[v] = is there a path from source to vertex
	private int[] edgeTo;     //edgeTo[v] = previous edge on shortest path from source to vertex
	private int[] distTo;     //distTo[v] = number of edges in shortest path from source to vertex
	
	/**
	 * Client function that performs breadth first search on a CityDigraph G with the source vertex as s
	 * @param G A CityDigraph
	 * @param s The source vertex to begin the search
	 */
	public BreadthFirstSearch(CityDigraph G, int s) {
		marked = new boolean[G.V()];
		distTo = new int[G.V()];
		edgeTo = new int[G.V()];
		bfs(G, s);
	}
	
	/**
	 * Implementation of of breadth first search
	 * @param G A CityDigraph
	 * @param s The source vertex to begin the search
	 */
	private void bfs(CityDigraph G, int s) {
		Queue<Integer> q = new Queue<Integer>();
		for (int v = 0; v < G.V(); v++)
			distTo[v] = Integer.MAX_VALUE;
		distTo[s] = 0;
		marked[s] = true;
		q.enqueue(s);
		
		while (!q.isEmpty()) {
			int v = q.dequeue();
			for (int w : G.adj(v)) {
				if (!marked[w]) {
					edgeTo[w] = v;
					distTo[w] = distTo[v] + 1;
					marked[w] = true;
					q.enqueue(w);
				}
			}
		}
	}
	
	/**
	 * Returns a stack of integers representing the path from source to vertex v
	 * @param v The end vertex of a path in the bfs
	 * @return A stack of integers representing the path from source to vertex v
	 */
	public Stack<Integer> pathTo(int v) {
        Stack<Integer> path = new Stack<Integer>();
        int x;
        for (x = v; distTo[x] != 0; x = edgeTo[x])
            path.push(x);
        path.push(x);
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
