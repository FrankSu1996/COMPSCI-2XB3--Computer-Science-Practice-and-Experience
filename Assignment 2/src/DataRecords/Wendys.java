package DataRecords;

/**
 * Class representing a Wendys restaurant
 * @author Frank
 *
 */
public class Wendys {
	//attributes
	private final double Longitude;
	private final double Latitude;
	
	public Wendys(final double longitude, final double latitude) {
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
