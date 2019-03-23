package DataRecords;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class represents an array of cities
 * 
 * @author Frank
 *
 */
public class CityArray {
	//array of cities
	public static ArrayList<City> Cities;
	
	/**
	 * Initializes City array with city information from USCities.csv
	 */
	public static void initCities() {
		Cities = new ArrayList<City>();
		String fileName = "data/USCities.csv";
		File file = new File(fileName);
		try {
			Scanner inputStream = new Scanner(file);
			inputStream.nextLine();
			while(inputStream.hasNext()) {
				//parse out data using split()
				String line = inputStream.nextLine();
				String[] values = line.split(",");
				//make sure data fits member types of City
				final int StateCode = Integer.parseInt(values[0]);
				final int ZipCode = Integer.parseInt(values[1]);
				final String State = values[2];
				String Name = values[3];
				Name = Name.replaceAll("\\s+", "");
				Name = Name.replace(".", "");
				CityName name1 = CityName.valueOf(Name);
				final double Latitude = Double.parseDouble(values[4]);
				final double Longitude = Double.parseDouble(values[5]);
				City city = new City(StateCode, ZipCode, State, name1, Latitude, Longitude);
				//add city to the array of cities
				Cities.add(city);
			}
			inputStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
