package DataRecords;
/**
 * Class representing us cities as an enumeration type
 * 
 * @author Frank
 * @version 1.0
 */


public class City {
	//attributes of each city
	private final int StateCode;
	private final int ZipCode;
	private final String State;
	private final CityName Name;
	private final double Latitude;
	private final double Longitude;
	
	/**
	 * Constructor for a city
	 * 
	 * @param StateCode The State code of the city
	 * @param ZipCode The Zip code of the city
	 * @param State The state that the city resides in
	 * @param Name The name of the city
	 * @param Latitude The Latitude of the city
	 * @param Longitude The Longitude of the city
	 */
	public City(final int StateCode, final int ZipCode, final String State, 
			final CityName Name, final double Latitude, final double Longitude) 
	{
		this.StateCode = StateCode;
		this.ZipCode = ZipCode;
		this.State = State;
		this.Name = Name;
		this.Latitude = Latitude;
		this.Longitude = Longitude;
	}

	/**
	 * @return the stateCode
	 */
	public int getStateCode() {
		return StateCode;
	}

	/**
	 * @return the zipCode
	 */
	public int getZipCode() {
		return ZipCode;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return State;
	}

	/**
	 * @return the name
	 */
	public CityName getName() {
		return Name;
	}

	/**
	 * @return the latitude
	 */
	public double getLatitude() {
		return Latitude;
	}

	/**
	 * @return the longitude
	 */
	public double getLongitude() {
		return Longitude;
	}
	
	/**
	 * @return the string representation of a city
	 */
	public String toString() {
		return this.Name + "," + this.StateCode + "," + this.ZipCode + "," 
				+ this.State + "," + this.Latitude + "," + this.Longitude;
	}

}
