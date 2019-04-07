package DataRecords;

/**
 * This class represents a fast food restaurant
 * @author Frank
 *
 */
public class Restaurant {
	//attributes
	private final double Longitude;
	private final double Latitude;
	private RestaurantName name;
	
	/**
	 * Create a new restaurant with its longitude and latitude
	 * @param longitude
	 * @param latitude
	 */
	public Restaurant(final double longitude, final double latitude, final RestaurantName name) {
		this.Longitude = longitude;
		this.Latitude = latitude;
		this.name = name;
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
	
	/**
	 * 
	 * @return the name of the restaurant
	 */
	public RestaurantName getName() {
		return this.name;
	}
	
	public String toString() {
		return "Name: " + this.name + " Latitude: " + this.Latitude + " Longitude: " + this.Longitude;
	}
}
