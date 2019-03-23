package sort;

/**
 * Java implementation of Insertion Sort, referenced from Algorithmss 4th edition
 * by Robert Sedgewick and Kevin Wayne
 * 
 * @author Frank
 * @version 1.0
 */
public class Insertion {
	/**
	 * regular insertion sort
	 * @param x - the input array containing products that need to be sorted.
	 */
	public static void sortInsert( Product[] x ) {
		int N = x.length;
		for (int i = 0; i < N; i++) {
			for(int j = i; j > 0; j--)
				if(greater(x[j], x[j-1]))
					exch(x, j, j-1);
				else break;
		}
	}
	
	/**
	 * insertion sort using Comparable
	 * @param x - the input array containing products that need to be sorted.
	 * @param n - the size of the input array
	 */
	public static void sortComparable ( Comparable[] x, int n ) {
		for(int i = 0; i < n; i++)
			for(int j = i; j > 0; j--)
				if(greater(x[j], x[j-1]))
					exch(x, j, j-1);
				else break;
	}
	/**
	 * optimized insertion sort
	 * @param x - the input array containing products that need to be sorted.
	 * @param n - the size of the input array
	 */
	public static void sortBinary ( Comparable[] x, int n ) {
		for (int i = 1; i < n; i++) {
			//use binary search to determine index j at which to insert a[i]
			Comparable v = x[i];
			int lo = 0, hi = i;
			while (lo < hi) {
				int mid = lo + (hi - lo) / 2;
				if (greater(v, x[mid]))
					hi = mid;
				else 
					lo = mid + 1;
			}
			//insert x[i] at index j and shift x[j], ..., x[i-1] to the right
			for (int j = i; j > lo; --j) {
				x[j] = x[j-1];
			}
			x[lo] = v;
		}
	}
	
	/**
	 * Helper method to determine if a product is "greater" than another product
	 * without using compareTo interface
	 * 
	 * @param v a comparable object (product in this case)
	 * @param w a comparable object (product in this case)
	 * @return true if v is greater than w, false otherwise
	 */
	private static boolean greater(Product a, Product b) {
		if(a.getSalesAmount() > b.getSalesAmount())
			return true;
		else if(b.getSalesAmount() == a.getSalesAmount())
			if (a.getId().compareTo(b.getId()) < 0)
				return true;
		return false;
	}
	
	/**
	 * Helper method to exchange two array elements without using comparable interface
	 * 
	 * @param a An array of products
	 * @param i An element in the array to swap
	 * @param j An element in the array to swap
	 */
	private static void exch(Product[] a, int i, int j) {
		Product t = a[i]; a[i] = a[j]; a[j] = t;
	}
	
	/**
	 * Helper method to exchange two array elements without using comparable interface
	 * 
	 * @param a An array of comparable objects
	 * @param i An element in the array to swap
	 * @param j An element in the array to swap
	 */
	private static void exch(Comparable[] a, int i, int j) {
		Comparable t = a[i]; a[i] = a[j]; a[j] = t;
	}
	
	/**
	 * Helper method to determine if a product is "greater" than another product
	 * using compareTo interface
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
