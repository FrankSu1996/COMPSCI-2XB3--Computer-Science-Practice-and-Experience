package DataRecords;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class representing an array of McDonald restaurants
 * @author Frank
 *
 */
public class McDonaldsArray {
	//array of McDonald restaurants
	public static ArrayList<McDonalds> MDArray;
	
	/**
	 * Initializes MDArray using information from mcdonalds.csv
	 */
	public static void initMDArray() {
		MDArray = new ArrayList<McDonalds>();
		String fileName = "data/mcdonalds.csv";
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
				McDonalds md = new McDonalds(longitude, latitude);
				MDArray.add(md);
			}
			inputStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
