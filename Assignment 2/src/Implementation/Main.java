package Implementation;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import DataRecords.BurgerKing;
import DataRecords.BurgerKingArray;
import DataRecords.City;
import DataRecords.CityArray;
import DataRecords.CityName;
import DataRecords.McDonaldsArray;
import DataRecords.Menu;
import DataRecords.WendysArray;
import Graph.BreadthFirstSearch;
import Graph.CityDigraph;
import Graph.DepthFirstSearch;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

/**
 * This class implements the client code for Assignment 2
 * @author Frank
 *
 */
public class Main {
	
	/**
	 * Client for producing output specifications for Assignment 2
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		//build city digraph using connectedCities.txt
		CityDigraph graph = CityDigraph.BuildGraph("data/connectedCities.txt");
		//3.2: Depth-First Search
		DepthFirstSearch dfs = new DepthFirstSearch(graph, CityName.BOSTON.ordinal());
		Stack<Integer> dfsPath = dfs.pathTo(CityName.MINNEAPOLIS.ordinal());
		//3.2: Breadth-First Search
		BreadthFirstSearch bfs = new BreadthFirstSearch(graph, CityName.BOSTON.ordinal());
		Stack<Integer> bfsPath = bfs.pathTo(CityName.MINNEAPOLIS.ordinal());
		//Write output to "a2_out.txt"
		BufferedWriter writer;
		try {
			writer = new BufferedWriter(new FileWriter("output/a2_out.txt"));
			//write 3.2 DFS results
			writer.write("DFS: ");
			while (dfsPath.peek() != CityName.MINNEAPOLIS.ordinal()) 
				writer.write(CityName.values()[dfsPath.pop()].toString() + ", ");
			writer.write(CityName.values()[dfsPath.pop()].toString() + "\n");
			//write 3.2 BFS results
			writer.write("BFS: ");
			while (bfsPath.peek() != CityName.MINNEAPOLIS.ordinal()) 
				writer.write(CityName.values()[bfsPath.pop()].toString() + ", ");
			writer.write(CityName.values()[bfsPath.pop()].toString() + "\n\n");
			//write 3.4 Shortest Path results
			writer.write(String.format("%-20s %-70s %-20s%n", "City", "Meal Choice", "Cost of Meal"));
			writer.write("---------------------------------------------------------------------------------------------------------\n");
			writer.write(String.format("%-20s %-70s %-20s%n", "ALBUQUERQUE", "Premium Chicken Bacon Clubhouse (Grilled or Crispy) - Meal", "$5.99"));
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
