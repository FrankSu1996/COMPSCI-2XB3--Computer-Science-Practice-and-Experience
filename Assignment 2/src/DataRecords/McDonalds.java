package DataRecords;

/**
 * Class representing a McDonalds restaurant
 * @author Frank
 *
 */
public class McDonalds {
	//attributes
	private final double Longitude;
	private final double Latitude;

	/**
	 * Constructor for a McDonalds restaurant
	 * 
	 * @param longitude the longitude of the restaurant
	 * @param latitude the latitude of the restaurant
	 */
	public McDonalds(final double longitude, final double latitude) {
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
