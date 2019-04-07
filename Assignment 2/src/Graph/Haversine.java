package Graph;

/**
 * Static class that calculates the distance in km between two points on Earth using their latitudes
 * and longitudes
 * 
 * @author Frank
 *
 */
public class Haversine {
	private static final int EARTH_RADIUS = 6371; // Approximate radius of Earth in km
	
	/**
	 * Calculates the distance between two points using their longitudes and latitudes
	 * @param startLat Latitude of starting point
	 * @param startLong Longitude of starting point
	 * @param endLat Latitude of ending point
	 * @param endLong Longitude of ending point
	 * @return the distance between the two points
	 */
    public static double distance(double startLat, double startLong,
                                  double endLat, double endLong) {

        double dLat  = Math.toRadians((endLat - startLat));
        double dLong = Math.toRadians((endLong - startLong));

        startLat = Math.toRadians(startLat);
        endLat   = Math.toRadians(endLat);

        double a = haversin(dLat) + Math.cos(startLat) * Math.cos(endLat) * haversin(dLong);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return EARTH_RADIUS * c; 
    }
    
    /**
     * A helper function to simplify the Haversine formula
     * @param val an input value
     * @return a value used in the Haversine formula computation
     */
    public static double haversin(double val) {
        return Math.pow(Math.sin(val / 2), 2);
    }
}
