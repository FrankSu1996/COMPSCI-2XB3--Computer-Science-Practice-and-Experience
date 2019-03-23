package DataRecords;

/**
 * Class representing a Burger King restaurant
 * @author Frank
 *
 */
public class BurgerKing {
	//attributes
	private final double Longitude;
	private final double Latitude;
	
	/**
	 * Constructor for a Burger King restaurant
	 * 
	 * @param longitude the longitude of the restaurant
	 * @param latitude the latitude of the restaurant
	 */
	public BurgerKing(final double longitude, final double latitude) {
		this.Longitude = longitude;
		this.Latitude = latitude;
	}

	/**
	 * @return the longitude
	 */
	public double getLongitude() {
		return Longitude;
	}

	/**
	 * @return the latitude
	 */
	public double getLatitude() {
		return Latitude;
	}
}
