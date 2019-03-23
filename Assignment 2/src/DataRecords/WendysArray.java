package DataRecords;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class representing an array of Wendys restaurants
 * 
 * @author Frank
 *
 */
public class WendysArray {
	//array of Wendys restaurants
	public static ArrayList<Wendys> WendysArray;
	
	/**
	 * Initializes WendysArray using information in wendys.csv
	 */
	public static void initWendysArray() {
		WendysArray = new ArrayList<Wendys>();
		int counter = 0;
		String fileName = "data/wendys.csv";
		File file = new File(fileName);
		try {
			Scanner inputStream = new Scanner(file);
			inputStream.nextLine();
			while(inputStream.hasNext()) {
				//parse out data using split()
				String line = inputStream.nextLine();
				String[] values = line.split(",");
				final double longitude = Double.parseDouble(values[0]);
				final double latitude = Double.parseDouble(values[1]);
				Wendys wendys = new Wendys(longitude, latitude);
				WendysArray.add(wendys);
			}
			inputStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
