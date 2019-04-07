package DataRecords;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class representing the menu of a fast-food restaurant
 * @author Frank
 *
 */
public class Menu {
	public static ArrayList<MealChoice> menu;
	
	/**
	 * Class representing the individual choices of a menu
	 * @author Frank
	 *
	 */
	public static class MealChoice{
		//name and price of a selection
		public final String Choice;
		public final double Price;
		public final String ProteinType;
		
		private MealChoice(final String choice, final double price, final String proteinType) {
			this.Choice = choice;
			this.Price = price;
			this.ProteinType = proteinType;
		}
		
		public String toString() {
			return Choice + "," + Price + "," + ProteinType;
		}
	}
	
	public static void initMenu() {
		menu = new ArrayList<MealChoice>();
		String fileName = "data/menu.csv";
		File file = new File(fileName);
		try {
			Scanner inputStream = new Scanner(file);
			inputStream.nextLine();
			while(inputStream.hasNext()) {
				//parse out data using split()
				String line = inputStream.nextLine();
				String[] values = line.split(",");
				final String choice = values[1];
				String price = values[2];
				price = price.replace("$", "");
				final double Price = Double.parseDouble(price);
				final String proteinType = values[3];
				//create selection based on data
				MealChoice selection = new MealChoice(choice, Price, proteinType);
				//add selection to mcdonalds menu
				menu.add(selection);
			}
			inputStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
