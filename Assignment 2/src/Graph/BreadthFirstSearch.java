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
	
	public BreadthFirstSearch(CityDigraph G, int s) {
		marked = new boolean[G.V()];
		distTo = new int[G.V()];
		edgeTo = new int[G.V()];
		bfs(G, s);
	}
	
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
	
	public boolean hasPathTo(int v) {
        return marked[v];
    }
	
	public int distTo(int v) {
        return distTo[v];
    }
	
	public Stack<Integer> pathTo(int v) {
        if (!hasPathTo(v)) return null;
        Stack<Integer> path = new Stack<Integer>();
        int x;
        for (x = v; distTo[x] != 0; x = edgeTo[x])
            path.push(x);
        path.push(x);
        return path;
    }
}
