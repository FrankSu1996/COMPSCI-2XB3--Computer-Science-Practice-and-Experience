package sort;

/**
 * ADT representing a product 
 * 
 * @author Frank 
 * @version 1.0
 */
public class Product implements Comparable<Product>{
	
	private int salesAmount;
	private final String id;
	
	/**
	 * Constructs a product with an id and number of sales
	 * 
	 * @param id A string representing a products id  
	 * @param salesAmount An int representing the number of sales for a product
	 */
	public Product(String id, int salesAmount) {
		this.id = id;
		this.salesAmount = salesAmount;
	}
	
	/**
	 * Returns the number of sales for a product
	 * 
	 * @return salesAmount The number of sales for a product
	 */
	public int getSalesAmount() {
		return this.salesAmount;
	}
	
	/**
	 * Returns the id of a product
	 * 
	 * @return id The id of a product 
	 */
	public String getId() {
		return this.id;
	}
	
	/**
	 * Sets the number of sales for a product
	 * 
	 * @param sales The number of sales of a product
	 */
	public void setSalesAmount(int sales) {
		this.salesAmount = sales;
	}
	
	/**
	 * A string representation of an object
	 * 
	 */
	public String toString() {
		return "id = " + this.id + " sales = " + this.salesAmount;
	}
	
	/**
	 * Method to compare two objects
	 * @param j A product 
	 * @return 1 if first product has more sales,
	 *  -1 if first product has less sales, and 0
	 *   if the products have the same number of sales, 
	 *   will compare lexicographically using compareTo() from java String library
	 */
	@Override
	public int compareTo(Product j)
	{
		if(this.salesAmount > j.salesAmount)
			return 1;
		else if(this.salesAmount < j.salesAmount)
			return -1;
		else if (this.salesAmount == j.salesAmount) {
			if (this.id.compareTo(j.id) < 0)
				return 1;
			else if (this.id.compareTo(j.id) > 0)
				return -1;
		}
		return 0;
	}
}
