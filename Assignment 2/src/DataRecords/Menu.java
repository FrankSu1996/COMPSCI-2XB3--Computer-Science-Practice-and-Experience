package DataRecords;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Class representing the menu of a fast-food restaurant
 * @author Frank
 *
 */
public class Menu {
	
	public static MealChoice[] McDonaldsMenu;
	public static MealChoice[] BurgerKingMenu;
	public static MealChoice[] WendysMenu;
	
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
	
	/**
	 * Initializes the McDonalds menu from menu.csv
	 */
	public static void initMcDonaldsMenu() {
		int counter = 0;
		McDonaldsMenu = new MealChoice[18];
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
				McDonaldsMenu[counter] = selection;
				counter++;
				if (counter == 18)
					return;
			}
			inputStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Initializes the Burger King menu from menu.csv
	 */
	public static void initBurgerKingMenu() {
		int counter = 0;
		BurgerKingMenu = new MealChoice[12];
		String fileName = "data/menu.csv";
		File file = new File(fileName);
		try {
			Scanner inputStream = new Scanner(file);
			//skip mcdonalds items in the csv file
			for (int i = 0; i < 19; i++)
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
				//create new selection based on menu.csv, add to menu
				MealChoice selection = new MealChoice(choice, Price, proteinType);
				BurgerKingMenu[counter] = selection;
				counter++;
				if (counter == 12)
					return;
			}
			inputStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Initializes the Wendys menu from menu.csv
	 */
	public static void initWendysMenu() {
		int counter = 0;
		WendysMenu = new MealChoice[10];
		String fileName = "data/menu.csv";
		File file = new File(fileName);
		try {
			Scanner inputStream = new Scanner(file);
			//skip mcdonalds items in the csv file
			for (int i = 0; i < 31; i++)
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
				//create new selection based on menu.csv, add to menu
				MealChoice selection = new MealChoice(choice, Price, proteinType);
				WendysMenu[counter] = selection;
				counter++;
			}
			inputStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
