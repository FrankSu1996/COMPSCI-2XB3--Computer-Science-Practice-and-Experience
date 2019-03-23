package sort;

import java.util.Arrays;
import edu.princeton.cs.algs4.StdRandom;

/**
 * Java implementation of Quick sort, referenced from Algorithms 4th edition,
 * by Robert Sedgewick and Kevin Wayne
 * 
 * @author Frank
 * @version 1.0
 */
public class Quick {
	/**
	 * basic quick sort
	 * @param x - the input array containing products that need to be sorted.
	 */
	public static void sortBasicQuick (  Product[] x ) {
		//Used shuffle method from Algs4.jar external library, from Algorithms, 4th edition textbook
		StdRandom.shuffle(x);
		sort(x, 0, x.length - 1);
		assert isSorted(x, 0, x.length - 1);
	}
	
	/**
	 * three partition quick sort using Comparable
	 * @param x - the input array containing products that need to be sorted.
	 * @param n - the size of the input array
	 */
	public static void sortThreePartition ( Comparable[] x, int n ) {
		//Used shuffle method from Algs4.jar external library, from Algorithms, 4th edition textbook
		StdRandom.shuffle(x);
		sort(x, 0, n - 1);
		assert isSorted(x, 0, n - 1);
	}
	
	/**
	 * Helper sort method for sortBasicQuick, uses normalPartition as the partitioning method
	 * 
	 * @param a An array of comparable objects
	 * @param lo The beginning index of the array/subarrays to sort
	 * @param hi The end index of the array/subarrays
	 */
	private static void sort(Comparable[] a, int lo, int hi) {
		//base case, return when lo pointer crosses hi pointer
		if (hi <= lo) return;
		//partition initial array
		int j = normalPartition(a, lo, hi);
		//recursively sort left subarray
		sort(a, lo, j-1);
		//recursively sort right subarray
		sort(a, j+1, hi);
		//check if array is sorted
		assert isSorted(a, lo, hi);
	}
	
	/**
	 * Helper method to partition array using first element of as partitioning element
	 * 
	 * @param a An array of comparable objects
	 * @param lo The beginning index of the array/subarrays to sort
	 * @param hi The end index of the array/subarrays
	 * @return j The index of the partitioning element
	 */
	private static int normalPartition(Comparable[] a, int lo, int hi) {
		int i = lo;
		int j = hi + 1;
		Comparable v = a[lo];
		while (true) {
			//find an item on lo to swap
			while (greater(a[++i], v)) {
				if (i == hi) break;
			}
			//find item on hi to swap
			while(greater(v, a[--j])) {
				if (j == lo) break;
			}
			//check if pointers cross
			if(i >= j) break;
			//exchange i and j so partition element is in correct place
			exch(a, i, j);
		}
		//put partitioning item v at a[j]
		exch(a, lo, j);
		//return index of partitioning element
		return j;
	}
	
	/**
	 * Helper method to partition array using a median of a random sample size of 3 from the array
	 * 
	 * @param a An array of comparable objects
	 * @param lo The beginning index of the array/subarrays to sort
	 * @param hi The end index of the array/subarrays
	 * @return j The index of the partitioning element
	 */
	private static int medianPartition(Comparable[] a, int lo, int hi) {
		int i = lo;
		int j = hi + 1;
		int mid = (lo + hi)/2;
		//find median of random sample size of 3 from array
		Comparable[] x = {a[lo], a[mid], a[hi]};
		//set this median as the partitioning element
		Comparable v = findMedian(x, x.length);
		while (true) {
			//find an item on lo to swap
			while (greater(a[++i], v)) {
				if (i == hi) break;
			}
			//find item on hi to swap
			while(greater(v, a[--j])) {
				if (j == lo) break;
			}
			//check if pointers cross
			if(i >= j) break;
			//exchange i and j so partition element is in correct place
			exch(a, i, j);
		}
		//put partitioning item v at a[j]
		exch(a, lo, j);
		//return index of partitioning element
		return j;
	}
	
	/**
	 * Helper function to find median of array 
	 * 
	 * @param a An integer array 
	 * @return a[1] The second element of the array
	 */
	private static Comparable findMedian(Comparable[] a, int n) {
		//first sort array using insertion sort because of small n
		Insertion.sortComparable(a, a.length);
		return a[n/2];
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
	 * @param lo the beginning index of the array to check if sorted
	 * @param hi the end index of the array to check if sorted
	 * @return true if array is sorted (higher sales to lower sales), false otherwise
	 */
	public static boolean isSorted(Comparable[] a, int lo, int hi) {
		for (int i = lo+1; i <= hi; i++)
			if (greater(a[i], a[i - 1]))
				return false;
		return true;
	}
}
