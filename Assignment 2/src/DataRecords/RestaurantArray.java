package DataRecords;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import edu.princeton.cs.algs4.Stack;

public class RestaurantArray {
	//array of restaurants
	public static ArrayList<Restaurant> restaurants;
	
	/**
	 * Goes through the restaurant data sets, initializes array with restaurants of all type
	 */
	public static void init() {
		restaurants = new ArrayList<Restaurant>();
		File file1 = new File("data/mcdonalds.csv");
		File file2 = new File("data/wendys.csv");
		File file3 = new File("data/burgerking.csv");
		try {
			Scanner inputStream1 = new Scanner(file1);
			Scanner inputStream2 = new Scanner(file2);
			Scanner inputStream3 = new Scanner(file3);
			inputStream1.nextLine();
			inputStream2.nextLine();
			inputStream3.nextLine();
			
			//add all mcdonalds to arraylist 
			while(inputStream1.hasNext()) {
				//parse out data using split()
				String line = inputStream1.nextLine();
				String[] values = line.split(",");
				final double longitude = Double.parseDouble(values[0]);
				final double latitude = Double.parseDouble(values[1]);
				Restaurant mcdonalds = new Restaurant(longitude, latitude, RestaurantName.MCDONALDS);
				restaurants.add(mcdonalds);
			}
			
			//add all wendys to arraylist
			while(inputStream2.hasNext()) {
				//parse out data using split()
				String line = inputStream2.nextLine();
				String[] values = line.split(",");
				final double longitude = Double.parseDouble(values[0]);
				final double latitude = Double.parseDouble(values[1]);
				Restaurant wendys = new Restaurant(longitude, latitude, RestaurantName.WENDYS);
				restaurants.add(wendys);
			}
			
			//add all burger kings to arraylist
			while(inputStream3.hasNext()) {
				//parse out data using split()
				String line = inputStream3.nextLine();
				String[] values = line.split(",");
				final double longitude = Double.parseDouble(values[0]);
				final double latitude = Double.parseDouble(values[1]);
				Restaurant burgerking = new Restaurant(longitude, latitude, RestaurantName.BURGERKING);
				restaurants.add(burgerking);
			}
			
			inputStream1.close();
			inputStream2.close();
			inputStream3.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Returns a stack of nearby restaurants of a city 
	 * @param city A integer value representing a city, using the ordinal value of CityName
	 * @return a stack of nearby restaurants of a city 
	 */
	public static Stack<Restaurant> nearbyRestaurants(int city){
		//initialize restaurant and city arrays
		init();
		CityArray.initCities();
		Stack<Restaurant> rest = new Stack<Restaurant>();
		
		//loop through cities, if name matches input, get that cities latitude and longitude
		for (City c: CityArray.Cities) {
			if (c.getName() == CityName.values()[city]) {
				double cityLatitude = c.getLatitude();
				double cityLongitude = c.getLongitude();
				//loop through restaurant array to find restaurants within 0.5 lat/long
				for (Restaurant r : restaurants) {
					if ((cityLatitude - 0.5 <= r.getLatitude()) && (r.getLatitude() <= cityLatitude + 0.5) 
							&& (cityLongitude - 0.5 <= r.getLongitude()) && (r.getLongitude() <= cityLongitude + 0.5)) 
					{
						rest.push(r);
						
					}
				}
			}
		}
		return rest;
	}
	public static void main(String[] args) {
		for (int i = 0; i < 32; i++) {
			Stack<Restaurant> r = nearbyRestaurants(i);
			System.out.println(r.size());
		}
	}
}
