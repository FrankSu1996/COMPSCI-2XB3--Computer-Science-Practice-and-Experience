package sort;

/**
 * Java implementation of Heap sort, referenced from Algorithms 4th edition
 * by Robert Sedgewick and Kevin Wayne
 * 
 * @author Frank
 * @version 1.0
 */
public class Heap {
	/**
	 * heap sort using Comparable
	 * Note: uses 1-based indexing for array (i.e. first element at a[1], not a[0])
	 * 
	 * @param x - the input array containing jobs that need to be sorted.
	 * @param n - the size of the input array
	 */
	public static void sortHeap ( Comparable[] x, int n ) {
		//first construct the heap
		for (int k = n/2; k >= 1; k--) {
			sink(x, k, n);
		}
		//perform sorting on heap
		while (n > 0) {
			exch(x, 1, n--);
			sink(x, 1, n);
		}
	}
	
	/**
	 * Helper method to restore heap invariant. Places element in correct position in heap
	 * 
	 * @param pq An array of comparable objects
	 * @param k the index of the element to perform the sink operation on
	 * @param n the size of the array
	 */
	private static void sink(Comparable[] pq, int k, int n) {
		while (2*k <= n) {
			int j = 2*k;
			if (j < n && greater(pq, j, j+1)) 
				j++;
			if(!greater(pq, k, j))
				break;
			exch(pq, k, j);
			k = j;
		}
	}
	
	/**
	 * 
	 * @param pq An array of comparable objects
	 * @param i the index of the first element to be compared
	 * @param j the index of the second element to be compared
	 * @return true if object at index i is greater than object at index j
	 */
	 private static boolean greater(Comparable[] pq, int i, int j) {
	        return pq[i-1].compareTo(pq[j-1]) > 0;
	    }
	
	/**
	 * Helper method to exchange two array elements without using comparable interface
	 * Note: indices are "off-by-one" to support 1-based indexing for heaps
	 * 
	 * @param a An array of comparable objects
	 * @param i An element in the array to swap
	 * @param j An element in the array to swap
	 */
	private static void exch(Comparable[] a, int i, int j) {
		Comparable swap = a[i-1];
		a[i-1] = a[j-1];
		a[j-1] = swap;
	}
	 
	/**
	 * A helper function to determine if array is sorted, for testing
	 * Note: indices are "off-by-one" to support 1-based indexing for heaps
	 * 
	 * @param a An array of comparable objects
	 * @return true if array is sorted (higher sales to lower sales), false otherwise
	 */
	public static boolean isSorted(Comparable[] a) {
		for (int i = 2; i < a.length; i++)
			if (greater(a, i, i-1))
				return false;
		return true;
	}
}
