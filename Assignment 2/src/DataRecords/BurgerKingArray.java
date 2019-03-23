package DataRecords;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Class representing an array of Burger King restaurants
 * @author Frank
 *
 */
public class BurgerKingArray {
	//array of Burger Kings
	public static ArrayList<BurgerKing> BKArray;
	
	/**
	 * Initializes BKArray with information from burgerking.csv
	 */
	public static void initBKArray() {
		BKArray = new ArrayList<BurgerKing>();
		String fileName = "data/burgerking.csv";
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
				BurgerKing bk = new BurgerKing(longitude, latitude);
				BKArray.add(bk);
			}
			inputStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
