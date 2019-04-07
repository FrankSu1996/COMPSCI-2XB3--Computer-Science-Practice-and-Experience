package Graph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import DataRecords.City;
import DataRecords.CityArray;
import DataRecords.CityName;
import edu.princeton.cs.algs4.Stack;

/**
 * Class that represents a weighted directed edge in an edge weighted graph. Adapted from Algorithms 4th edition
 * textbook, by Bob Sedgewick
 * 
 * @author Frank
 *
 */
public class DirectedEdge {
	private final int v;
	private final int w;
	private final double weight;
	
	//variables to store latitude and longitude of cities
	static double lat1, lat2, long1, long2;
	
	/**
	 * Initializes a directed edge from vertex v to vertex w with a given weight
	 * @param v The tail vertex
	 * @param w The head vertex
	 * @param weight The weight of the directed edge
	 */
	public DirectedEdge(int v, int w, double weight) {
		this.v = v;
		this.w = w;
		this.weight = weight;
	}
	
	/**
	 * Reads from input file ("connectedCities.txt"), simultaneously computes the weight of each directed edge and returns 
	 * a stack of all the weighted directed edges. This function will initialize city array, so client doesn't have to 
	 * @param filename The name of the file containing city connection information
	 * @return A stack containing all of the directed edges
	 */
	public static Stack<DirectedEdge> createEdges(String fileName) {
		//initialize city array and create empty stack of directed edges
		CityArray.initCities();
		Stack<DirectedEdge> edges = new Stack<DirectedEdge>();
		
		//read from file an create new directed edge using distance between connected cities as weight
		File file = new File(fileName);
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
				
				//loop through city array to find latitude and longitude values of the connected cities
				for (City city : CityArray.Cities) {
					if (city.getName() == City1) {
						lat1 = city.getLatitude();
						long1 = city.getLongitude();
					}
					if (city.getName() == City2) {
						lat2 = city.getLatitude();
						long2 = city.getLongitude();
					}
				}
				
				//calculate distance between two cities to use as weight of directed edge
				double weight = Haversine.distance(lat1, long1, lat2, long2);
				DirectedEdge edge = new DirectedEdge(City1.ordinal(), City2.ordinal(), weight);
				edges.push(edge);
			}
			inputStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return edges;
	}
	/**
	 * Returns the tail vertex of the directed edge
	 * @return the tail vertex of the directed edge
	 */
	public int from() {
		return this.v;
	}
	
	/**
	 * Returns the head vertex of the directed edge
	 * @return the head vertex of the directed edge
	 */
	public int to() {
		return this.w;
	}
	
	/**
     * Returns the weight of the directed edge.
     * @return the weight of the directed edge
     */
    public double weight() {
        return weight;
    }
    
    /**
     * Returns a string representation of the directed edge.
     * @return a string representation of the directed edge
     */
    public String toString() {
        return v + "->" + w + " " + String.format("%5.2f", weight);
    }
}
