package Graph;

import edu.princeton.cs.algs4.IndexMinPQ;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;

/**
 * This class implements Dijkstra's algorithm for solving the shortest path problem in a weighted digraph.
 * Adapted from Algorithm's 4th edition, by Bob Sedgewick
 * @author Frank
 *
 */
public class Dijkstra {
	private double[] distTo;			//distTo[v] = distance of shortest path from source vertex to v
	private DirectedEdge[] edgeTo;		//edgeTo[v] = the last edge on the shortest path from sourve vertex to v
	private IndexMinPQ<Double> pq; 		//priority queue of vertices based on their weight value
	
	/**
	 * Computes a shortest path from the source vertex s to every other vertex in the weighted city digraph G
	 * @param G a weighted city digraph
	 * @param s the source vertex
	 */
	public Dijkstra(WeightedCityDigraph G, int s) {
		distTo = new double[G.V()];
		edgeTo = new DirectedEdge[G.V()];
		
		for (int v = 0; v < G.V(); v++)
			distTo[v] = Double.POSITIVE_INFINITY;
		distTo[s] = 0.0;
		
		//relax vertices in order of distance from s
		pq = new IndexMinPQ<Double>(G.V());
		pq.insert(s, distTo[s]);
		while (!pq.isEmpty()) {
			int v = pq.delMin();
			for (DirectedEdge e : G.adj(v))
				relax(e);
		}
	}
	
	/**
	 * relax a directed edge 
	 * @param e A directed edge
	 */
	private void relax(DirectedEdge e) {
		int v = e.from(), w = e.to();
		if (distTo[w] > distTo[v] + e.weight()) {
			distTo[w] = distTo[v] + e.weight();
			edgeTo[w] = e;
			if (pq.contains(w)) 
				pq.decreaseKey(w, distTo[w]);
			else 
				pq.insert(w, distTo[w]);
		}
	}
	
	/**
	 * Returns a stack containing the shortest path from the source vertex
	 * @param v
	 * @return
	 */
	public Stack<DirectedEdge> pathTo(int v){
		Stack<DirectedEdge> path = new Stack<DirectedEdge>();
		for (DirectedEdge e = edgeTo[v]; e != null; e = edgeTo[e.from()])
			path.push(e);
		return path;
	}
	
	/**
	 * Takes a stack containing a path and turns it into a queue of integers containing the sequence of cities in the path
	 * @param path A stack of directed edges representing a path
	 * @return a queue of integers containing the sequence of cities in the path
	 */
	public Queue<Integer> route(Stack<DirectedEdge> path){
		Queue<Integer> route = new Queue<Integer>();
		//add starting city first from top of stack
		route.enqueue(path.peek().from());
		route.enqueue(path.peek().to());
		path.pop();
		//take edge off of path one at time, add vertices to queue
		while (!path.isEmpty()) {
			route.enqueue(path.peek().to());
			path.pop();
		}
		return route;
	}
}
