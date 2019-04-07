package Graph;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import DataRecords.CityName;
import edu.princeton.cs.algs4.Stack;

class GraphSearchTest {
	
	CityDigraph graph;
	
	@BeforeEach
	void setUp() throws Exception {
		//build graph using "connectedCities.txt"
		graph = CityDigraph.BuildGraph("data/connectedCities.txt");
	}

	@Test
	void testBreadthFirstSearch() {
		//create new bfs using Boston as source vertex
		BreadthFirstSearch bfs = new BreadthFirstSearch(graph, CityName.BOSTON.ordinal());

		//loop through all possible paths in bfs 
		for (int i = 0; i < CityName.MIAMI.ordinal(); i++) {
			Stack<Integer> bfsPath = bfs.pathTo(i);
			
			//check that each vertex popped from stack is an edge to 
			//the next vertex popped from stack using edgeTo(). This validates
			//that the cities are connected properly
			while (bfsPath.size() > 1) {
				int v1 = bfsPath.pop();
				int v2 = bfsPath.peek();
				assert ((bfs.edgeTo(v2)) == v1);
			}
		}
	}

	
	@Test
	void testDepthFirstSearch() {
		//create new dfs using Boston as source vertex
		DepthFirstSearch dfs = new DepthFirstSearch(graph, CityName.BOSTON.ordinal());
		
		//loop through all possible paths in dfs
		for (int i = 0; i < CityName.MIAMI.ordinal(); i++) {
			Stack<Integer> dfsPath = dfs.pathTo(i);
			
			//check that each vertex popped from stack is an edge to 
			//the next vertex popped from stack using edgeTo(). This validates
			//that the cities are connected properly
			while (dfsPath.size() > 1) {
				int v1 = dfsPath.pop();
				int v2 = dfsPath.peek();
				assert ((dfs.edgeTo(v2)) == v1);
			}
		}
	}
}
