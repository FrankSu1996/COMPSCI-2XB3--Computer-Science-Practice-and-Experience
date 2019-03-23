
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
	
	
	public DepthFirstSearch(CityDigraph G, int s) {
		this.s = s;
		edgeTo = new int[G.V()];
		marked = new boolean[G.V()];
		dfs(G, s);
	}
	
	private void dfs(CityDigraph G, int v) {
		marked[v] = true;
		for (int w : G.adj(v)) {
			if (!marked[w]) {
				edgeTo[w] = v;
				dfs(G, w);
			}
		}
	}
	
	public boolean hasPathTo(int v) {
		return marked[v];
	}
	
	public int gets() {
		return this.s;
	}
	
	public Stack<Integer> pathTo(int v){
		if (!hasPathTo(v)) 
			return null;
		Stack<Integer> path = new Stack<Integer>();
		for (int x = v; x != s; x = edgeTo[x])
			path.push(x);
		path.push(s);
		return path;
	}
}
