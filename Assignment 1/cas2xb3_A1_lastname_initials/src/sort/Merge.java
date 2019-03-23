package sort;

/**
 * Java implementation of Merge sort algorithm, referenced from Algorithms 4th edition,
 * by Robert Sedgewick and Kevin Wayne
 * 
 * @author Frank
 * @version 1.0
 */
public class Merge {
	
	private static final Product[] Product = null;
	private static Comparable[] aux;
	
	/**
	 * Merge operation to join two subarrays
	 * 
	 * @param a An array of comparable objects
	 * @param lo The beginning index of the auxiliary array for merging
	 * @param mid The middle index of the auxiliary array for merging
	 * @param hi The last index of the auxiliary array for merging
	 */
	private static void merge(Comparable[] a, int lo, int mid, int hi) {
		//Merge a[lo..mid] with a[mid+1.. hi]
		int i = lo, j = mid+1;
		
		for (int k = lo; k <= hi; k++)
			aux[k] = a[k];
		
		for (int k = lo; k <= hi; k++) {
			if (i > mid)
				a[k] = aux[j++];
			else if(j > hi)
				a[k] = aux[i++];
			else if (greater(aux[j], aux[i]))
				a[k] = aux[j++];
			else
				a[k] = aux[i++];
		}
	}
	
	/**
	 * top-down merge sort using Comparable
	 * @param x - the input array containing products that need to be sorted.
	 * @param n - the size of the input array
	 */
	public static void sortMergeTD ( Comparable[] x, int n ) {
		aux = new Comparable[n];
		sort(x, 0, n - 1);
	}
	
	/**
	 * private sorting method to sort a[low..hi]
	 * 
	 * @param a An array of comparable objects
	 * @param lo The beginning index of the array for sorting
	 * @param hi The end index of the array for sorting
	 */
	private static void sort(Comparable[] a, int lo, int hi) {
		if (hi <= lo)
			return;
		int mid = lo + (hi - lo)/2;
		//Sort left half first
		sort(a, lo, mid);
		//Then sort right half
		sort(a, mid+1, hi);
		//Merge results
		merge(a, lo, mid, hi);
	}
	
	/**
	 * bottom-up merge sort using Comparable
	 * @param x - the input array containing products that need to be sorted.
	 * @param n - the size of the input array
	 */
	public static void sortMergeBU ( Comparable[] x, int n ) {
		aux = new Comparable[n];
		for (int sz = 1; sz < n; sz = sz+sz)
			for(int lo = 0; lo < n - sz; lo += sz+sz)
				merge(x, lo, lo+sz-1, Math.min(lo+sz+sz-1, n-1));
	}
	
	/**
	 * Helper method to determine if a product is "greater" than another product
	 * 
	 * @param v a comparable object (product in this case)
	 * @param w a comparable object (product in this case)
	 * @return true if v is greater than w, false otherwise
	 */
	private static boolean greater(Comparable v, Comparable w) {
		return v.compareTo(w) > 0;
	}
	
	/**
	 * A helper function to determine if array is sorted, for testing
	 * 
	 * @param a An array of comparable objects
	 * @return true if array is sorted (higher sales to lower sales), false otherwise
	 */
	public static boolean isSorted(Comparable[] a) {
		for (int i = 1; i < a.length; i++)
			if (greater(a[i], a[i - 1]))
				return false;
		return true;
	}
}
