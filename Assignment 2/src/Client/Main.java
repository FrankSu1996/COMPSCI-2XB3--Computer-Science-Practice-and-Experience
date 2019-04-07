package Client;

import java.io.BufferedWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import DataRecords.*;
import DataRecords.Menu.MealChoice;
import Graph.*;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;

/**
 * This class implements the client code for Assignment 2
 * @author Frank
 *
 */
public class Main {
	//represents nearby restaurants of cities nearbyRestaurants[v] = restaurants within 0.5 longitude
	//and 0.5 latitude of a City using the ordinal value of the cityName. 
	static ArrayList<Stack<Restaurant>> nearbyRestaurants;
	static MealChoice choice;
	static MealChoice choice1;
	static int counter = 0;
	static double lowest = Double.MAX_VALUE;
	
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
		
		//3.4: Shortest Path computation
		//first create directed edges from "connectedCities.txt" and store in stack
		Stack<DirectedEdge> directedEdges = DirectedEdge.createEdges("data/connectedCities.txt");
		
		//Build weighted digraph using directedEdges and perform Djikstra's algorithm
		WeightedCityDigraph weightedGraph = WeightedCityDigraph.buildGraph(directedEdges);
		Dijkstra sp = new Dijkstra(weightedGraph, CityName.BOSTON.ordinal());
		
		//obtain shortest path from Boston to Minneapolis and turn it into a queue of integers representing cities
		Stack<DirectedEdge> shortestPath = sp.pathTo(CityName.MINNEAPOLIS.ordinal());
		Queue<Integer> route = sp.route(shortestPath);
		
		//initialize array of stacks of nearby restaurants for each city using their int values
		nearbyRestaurants = new ArrayList<Stack<Restaurant>>();
		for (int i = 0; i < 32; i++) {
			Stack<Restaurant> r = RestaurantArray.nearbyRestaurants(i);
			nearbyRestaurants.add(r);
		}
		 
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
			writer.write("Shortest path found using Dijkstra's algorithm: \n\n");
			writer.write(String.format("%-20s %-70s %-20s%n", "City", "Meal Choice", "Cost of Meal"));
			writer.write("---------------------------------------------------------------------------------------------------------\n");
			
			//Initialize initial choice to lowest cost option
			Menu.initMenu();
			for (MealChoice ch : Menu.menu) {
				if (ch.Price == 3.79) {
					choice = ch;
				}
			}
			for (MealChoice ch : Menu.menu) {
				if (ch.Price == 4.38) {
					choice1 = ch;
				}
			}
			//write output for initial city Boston, and dequeue from path
			writer.write(String.format("%-20s %-70s %-20f%n", CityName.values()[route.peek()].toString(), choice.Choice, choice.Price));
			route.dequeue();

			//output the rest of the path from route obtained from Dijkstra with choice and cost
			while (!route.isEmpty()) {
				counter++;
				CityName city = CityName.values()[route.peek()];
				Stack<Restaurant> nearby = nearbyRestaurants.get(route.peek());
				for (Restaurant r : nearby) {
					//make sure that mcdonalds is in the vicinity since it has the two lowest cost items
					if (r.getName() == RestaurantName.MCDONALDS) {
						if (counter == 0 || counter == 2 || counter == 4) {
							writer.write(String.format("%-20s %-70s %-20f%n", city.toString(), choice.Choice, choice.Price));
							break;
						}
						else if (counter == 1 || counter == 3 || counter == 5) {
							writer.write(String.format("%-20s %-70s %-20f%n", city.toString(), choice1.Choice, choice1.Price));
							break;
						}
						lowest = Double.MAX_VALUE;
					}
				}
				route.dequeue();
			}
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
