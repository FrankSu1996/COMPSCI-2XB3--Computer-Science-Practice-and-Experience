/**
 * 
 */
package sort;
import java.io.*;
import java.util.*;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import org.apache.commons.lang3.time.StopWatch;

/**
 * JUnit test class for sorting algorithms, uses Stopwatch api from apache lang package.
 * 
 * @author Frank
 * @version 1.0
 */
public class SortTest {
	
	//variables necessary for file input
	private static FileInputStream inFile;
	private static InputStreamReader inReader;
	private static BufferedReader reader;
	
	//arrays to store product data
	private static Product[] array1 = new Product[16];
	private static Product[] array2 = new Product[64];
	private static Product[] array3 = new Product[256];
	private static Product[] array4 = new Product[1024];
	private static Product[] array5 = new Product[4096];
	private static Product[] array6 = new Product[16384];
	private static Product[] array7 = new Product[65536];
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		//initialize file reader
		inFile = new FileInputStream ("data\\a1_in.txt");
		inReader = new InputStreamReader(inFile);
		reader = new BufferedReader(inReader);
		//retrieve data from file
		String line = reader.readLine();
		fillArray(line, array1);
		String line2 = reader.readLine();
		fillArray(line2, array2);
		String line3 = reader.readLine();
		fillArray(line3, array3);
		String line4 = reader.readLine();
		fillArray(line4, array4);
		String line5 = reader.readLine();
		fillArray(line5, array5);
		String line6 = reader.readLine();
		fillArray(line6, array6);
		String line7 = reader.readLine();
		fillArray(line7, array7); 
	}
	
	/**
	 * Helper method to fill array with data from each line of file
	 * 
	 * @param line A string representing a line from the data file
	 * @param a An array of Products to be filled
	 */
	public static void fillArray(String line, Product[] a) {
		StringTokenizer strTkn1 = new StringTokenizer(line, "{");
		for (int i = 0; strTkn1.hasMoreElements(); i++){
			String x = strTkn1.nextToken();
			StringTokenizer strTkn2 = new StringTokenizer (x, "}");
			String product = strTkn2.nextToken();
			StringTokenizer strTkn3 = new StringTokenizer(product, ",");
			Product prod = new Product(strTkn3.nextToken(), Integer.parseInt(strTkn3.nextToken()));
			a[i] = prod;
		}
	}

	@Test
	public void testMergeTD() {
		System.out.println("Top-Down Merge Sort Results:");
		StopWatch timer1 = new StopWatch();
		timer1.start();
		Merge.sortMergeTD(array1, array1.length);
		System.out.println("Time in milleseconds to sort array of size " + array1.length + " : " + timer1.getNanoTime()/Math.pow(10, 6) );
		timer1.reset();
		timer1.start();
		Merge.sortMergeTD(array2, array2.length);
		System.out.println("Time in milleseconds to sort array of size " + array2.length + " : " + timer1.getNanoTime()/Math.pow(10, 6) );
		timer1.reset();
		timer1.start();
		Merge.sortMergeTD(array3, array3.length);
		System.out.println("Time in milleseconds to sort array of size " + array3.length + " : " + timer1.getNanoTime()/Math.pow(10, 6) );
		timer1.reset();
		timer1.start();
		Merge.sortMergeTD(array4, array4.length);
		System.out.println("Time in milleseconds to sort array of size " + array4.length + " : " + timer1.getNanoTime()/Math.pow(10, 6) );
		timer1.reset();
		timer1.start();
		Merge.sortMergeTD(array5, array5.length);
		System.out.println("Time in milleseconds to sort array of size " + array5.length + " : " + timer1.getNanoTime()/Math.pow(10, 6) );
		timer1.reset();
		timer1.start();
		Merge.sortMergeTD(array6, array6.length);
		System.out.println("Time in milleseconds to sort array of size " + array6.length + " : " + timer1.getNanoTime()/Math.pow(10, 6) );
		timer1.reset();
		timer1.start();
		Merge.sortMergeTD(array7, array7.length);
		System.out.println("Time in milleseconds to sort array of size " + array7.length + " : " + timer1.getNanoTime()/Math.pow(10, 6) + "\n\n" );
		assert Merge.isSorted(array1);
		assert Merge.isSorted(array2);
		assert Merge.isSorted(array3);
		assert Merge.isSorted(array4);
		assert Merge.isSorted(array5);
		assert Merge.isSorted(array6);
		assert Merge.isSorted(array7);
	}
	
	@Test
	public void testMergeBU() {
		System.out.println("Bottom-Up Merge Sort Results:");
		StopWatch timer2 = new StopWatch();
		timer2.start();
		Merge.sortMergeBU(array1, array1.length);
		System.out.println("Time in milleseconds to sort array of size " + array1.length + " : " + timer2.getNanoTime()/Math.pow(10, 6) );
		timer2.reset();
		timer2.start();
		Merge.sortMergeBU(array2, array2.length);
		System.out.println("Time in milleseconds to sort array of size " + array2.length + " : " + timer2.getNanoTime()/Math.pow(10, 6) );
		timer2.reset();
		timer2.start();
		Merge.sortMergeBU(array3, array3.length);
		System.out.println("Time in milleseconds to sort array of size " + array3.length + " : " + timer2.getNanoTime()/Math.pow(10, 6) );
		timer2.reset();
		timer2.start();
		Merge.sortMergeBU(array4, array4.length);
		System.out.println("Time in milleseconds to sort array of size " + array4.length + " : " + timer2.getNanoTime()/Math.pow(10, 6) );
		timer2.reset();
		timer2.start();
		Merge.sortMergeBU(array5, array5.length);
		System.out.println("Time in milleseconds to sort array of size " + array5.length + " : " + timer2.getNanoTime()/Math.pow(10, 6) );
		timer2.reset();
		timer2.start();
		Merge.sortMergeBU(array6, array6.length);
		System.out.println("Time in milleseconds to sort array of size " + array6.length + " : " + timer2.getNanoTime()/Math.pow(10, 6) );
		timer2.reset();
		timer2.start();
		Merge.sortMergeBU(array7, array7.length);
		System.out.println("Time in milleseconds to sort array of size " + array7.length + " : " + timer2.getNanoTime()/Math.pow(10, 6) + "\n\n");
		assert Merge.isSorted(array1);
		assert Merge.isSorted(array2);
		assert Merge.isSorted(array3);
		assert Merge.isSorted(array4);
		assert Merge.isSorted(array5);
		assert Merge.isSorted(array6);
		assert Merge.isSorted(array7);
	}
	
	@Test
	public void testSortInsert() {
		System.out.println("Basic Insertion Sort Results:");
		StopWatch timer3 = new StopWatch();
		timer3.start();
		Insertion.sortInsert(array1);
		System.out.println("Time in milleseconds to sort array of size " + array1.length + " : " + timer3.getNanoTime()/Math.pow(10, 6) );
		timer3.reset();
		timer3.start();
		Insertion.sortInsert(array2);
		System.out.println("Time in milleseconds to sort array of size " + array2.length + " : " + timer3.getNanoTime()/Math.pow(10, 6) );
		timer3.reset();
		timer3.start();
		Insertion.sortInsert(array3);
		System.out.println("Time in milleseconds to sort array of size " + array3.length + " : " + timer3.getNanoTime()/Math.pow(10, 6) );
		timer3.reset();
		timer3.start();
		Insertion.sortInsert(array4);
		System.out.println("Time in milleseconds to sort array of size " + array4.length + " : " + timer3.getNanoTime()/Math.pow(10, 6) );
		timer3.reset();
		timer3.start();
		Insertion.sortInsert(array5);
		System.out.println("Time in milleseconds to sort array of size " + array5.length + " : " + timer3.getNanoTime()/Math.pow(10, 6) );
		timer3.reset();
		timer3.start();
		Insertion.sortInsert(array6);
		System.out.println("Time in milleseconds to sort array of size " + array6.length + " : " + timer3.getNanoTime()/Math.pow(10, 6) );
		timer3.reset();
		timer3.start();
		Insertion.sortInsert(array7);
		System.out.println("Time in milleseconds to sort array of size " + array7.length + " : " + timer3.getNanoTime()/Math.pow(10, 6) + "\n\n");
		assert Insertion.isSorted(array1);
		assert Insertion.isSorted(array2);
		assert Insertion.isSorted(array3);
		assert Insertion.isSorted(array4);
		assert Insertion.isSorted(array5);
		assert Insertion.isSorted(array6);
		assert Insertion.isSorted(array7);
	}
	
	@Test
	public void testInsertComparable() {
		System.out.println("Comparable Insertion Sort Results:");
		StopWatch timer4 = new StopWatch();
		timer4.start();
		Insertion.sortComparable(array1, array1.length);
		System.out.println("Time in milleseconds to sort array of size " + array1.length + " : " + timer4.getNanoTime()/Math.pow(10, 6) );
		timer4.reset();
		timer4.start();
		Insertion.sortComparable(array2, array2.length);
		System.out.println("Time in milleseconds to sort array of size " + array2.length + " : " + timer4.getNanoTime()/Math.pow(10, 6) );
		timer4.reset();
		timer4.start();
		Insertion.sortComparable(array3, array3.length);
		System.out.println("Time in milleseconds to sort array of size " + array3.length + " : " + timer4.getNanoTime()/Math.pow(10, 6) );
		timer4.reset();
		timer4.start();
		Insertion.sortComparable(array4, array4.length);
		System.out.println("Time in milleseconds to sort array of size " + array4.length + " : " + timer4.getNanoTime()/Math.pow(10, 6)  );
		timer4.reset();
		timer4.start();
		Insertion.sortComparable(array5, array5.length);
		System.out.println("Time in milleseconds to sort array of size " + array5.length + " : " + timer4.getNanoTime()/Math.pow(10, 6) );
		timer4.reset();
		timer4.start();
		Insertion.sortComparable(array6, array6.length);
		System.out.println("Time in milleseconds to sort array of size " + array6.length + " : " + timer4.getNanoTime()/Math.pow(10, 6) );
		timer4.reset();
		timer4.start();
		Insertion.sortComparable(array7, array7.length);
		System.out.println("Time in milleseconds to sort array of size " + array7.length + " : " + timer4.getNanoTime()/Math.pow(10, 6) + "\n\n");
		assert Insertion.isSorted(array1);
		assert Insertion.isSorted(array2);
		assert Insertion.isSorted(array3);
		assert Insertion.isSorted(array4);
		assert Insertion.isSorted(array5);
		assert Insertion.isSorted(array6);
		assert Insertion.isSorted(array7);
	}
	
	@Test
	public void testInsertBinary() {
		System.out.println("Binary Search Insertion Sort Results:");
		StopWatch timer5 = new StopWatch();
		timer5.start();
		Insertion.sortBinary(array1, array1.length);
		System.out.println("Time in milleseconds to sort array of size " + array1.length + " : " + timer5.getNanoTime()/Math.pow(10, 6) );
		timer5.reset();
		timer5.start();
		Insertion.sortBinary(array2, array2.length);
		System.out.println("Time in milleseconds to sort array of size " + array2.length + " : " + timer5.getNanoTime()/Math.pow(10, 6) );
		timer5.reset();
		timer5.start();
		Insertion.sortBinary(array3, array3.length);
		System.out.println("Time in milleseconds to sort array of size " + array3.length + " : " + timer5.getNanoTime()/Math.pow(10, 6) );
		timer5.reset();
		timer5.start();
		Insertion.sortBinary(array4, array4.length);
		System.out.println("Time in milleseconds to sort array of size " + array4.length + " : " + timer5.getNanoTime()/Math.pow(10, 6) );
		timer5.reset();
		timer5.start();
		Insertion.sortBinary(array5, array5.length);
		System.out.println("Time in milleseconds to sort array of size " + array5.length + " : " + timer5.getNanoTime()/Math.pow(10, 6) );
		timer5.reset();
		timer5.start();
		Insertion.sortBinary(array6, array6.length);
		System.out.println("Time in milleseconds to sort array of size " + array6.length + " : " + timer5.getNanoTime()/Math.pow(10, 6) );
		timer5.reset();
		timer5.start();
		Insertion.sortBinary(array7, array7.length);
		System.out.println("Time in milleseconds to sort array of size " + array7.length + " : " + timer5.getNanoTime()/Math.pow(10, 6) + "\n\n");
		assert Insertion.isSorted(array1);
		assert Insertion.isSorted(array2);
		assert Insertion.isSorted(array3);
		assert Insertion.isSorted(array4);
		assert Insertion.isSorted(array5);
		assert Insertion.isSorted(array6);
		assert Insertion.isSorted(array7);
	}
	
	@Test
	public void testBasicQuick() {
		System.out.println("Basic Quick Sort Results:");
		StopWatch timer6 = new StopWatch();
		timer6.start();
		Quick.sortBasicQuick(array1);
		System.out.println("Time in milleseconds to sort array of size " + array1.length + " : " + timer6.getNanoTime()/Math.pow(10, 6) );
		timer6.reset();
		timer6.start();
		Quick.sortBasicQuick(array2);
		System.out.println("Time in milleseconds to sort array of size " + array2.length + " : " + timer6.getNanoTime()/Math.pow(10, 6) );
		timer6.reset();
		timer6.start();
		Quick.sortBasicQuick(array3);
		System.out.println("Time in milleseconds to sort array of size " + array3.length + " : " + timer6.getNanoTime()/Math.pow(10, 6) );
		timer6.reset();
		timer6.start();
		Quick.sortBasicQuick(array4);
		System.out.println("Time in milleseconds to sort array of size " + array4.length + " : " + timer6.getNanoTime()/Math.pow(10, 6) );
		timer6.reset();
		timer6.start();
		Quick.sortBasicQuick(array5);
		System.out.println("Time in milleseconds to sort array of size " + array5.length + " : " + timer6.getNanoTime()/Math.pow(10, 6) );
		timer6.reset();
		timer6.start();
		Quick.sortBasicQuick(array6);
		System.out.println("Time in milleseconds to sort array of size " + array6.length + " : " + timer6.getNanoTime()/Math.pow(10, 6) );
		timer6.reset();
		timer6.start();
		Quick.sortBasicQuick(array7);
		System.out.println("Time in milleseconds to sort array of size " + array7.length + " : " + timer6.getNanoTime()/Math.pow(10, 6) + "\n\n");
		assert Quick.isSorted(array1, 0, array1.length - 1);
		assert Quick.isSorted(array2, 0, array1.length - 1);
		assert Quick.isSorted(array3, 0, array1.length - 1);
		assert Quick.isSorted(array4, 0, array1.length - 1);
		assert Quick.isSorted(array5, 0, array1.length - 1);
		assert Quick.isSorted(array6, 0, array1.length - 1);
		assert Quick.isSorted(array7, 0, array1.length - 1);
	}
	
	@Test
	public void testThreePartition() {
		System.out.println("Three Partition Quick Sort Results:");
		StopWatch timer7 = new StopWatch();
		timer7.start();
		Quick.sortThreePartition(array1, array1.length);
		System.out.println("Time in milleseconds to sort array of size " + array1.length + " : " + timer7.getNanoTime()/Math.pow(10, 6) );
		timer7.reset();
		timer7.start();
		Quick.sortThreePartition(array2, array2.length);
		System.out.println("Time in milleseconds to sort array of size " + array2.length + " : " + timer7.getNanoTime()/Math.pow(10, 6) );
		timer7.reset();
		timer7.start();
		Quick.sortThreePartition(array3, array3.length);
		System.out.println("Time in milleseconds to sort array of size " + array3.length + " : " + timer7.getNanoTime()/Math.pow(10, 6) );
		timer7.reset();
		timer7.start();
		Quick.sortThreePartition(array4, array4.length);
		System.out.println("Time in milleseconds to sort array of size " + array4.length + " : " + timer7.getNanoTime()/Math.pow(10, 6) );
		timer7.reset();
		timer7.start();
		Quick.sortThreePartition(array5, array5.length);
		System.out.println("Time in milleseconds to sort array of size " + array5.length + " : " + timer7.getNanoTime()/Math.pow(10, 6) );
		timer7.reset();
		timer7.start();
		Quick.sortThreePartition(array6, array6.length);
		System.out.println("Time in milleseconds to sort array of size " + array6.length + " : " + timer7.getNanoTime()/Math.pow(10, 6) );
		timer7.reset();
		timer7.start();
		Quick.sortThreePartition(array7, array7.length);
		System.out.println("Time in milleseconds to sort array of size " + array7.length + " : " + timer7.getNanoTime()/Math.pow(10, 6) + "\n\n");
		assert Quick.isSorted(array1, 0, array1.length - 1);
		assert Quick.isSorted(array2, 0, array1.length - 1);
		assert Quick.isSorted(array3, 0, array1.length - 1);
		assert Quick.isSorted(array4, 0, array1.length - 1);
		assert Quick.isSorted(array5, 0, array1.length - 1);
		assert Quick.isSorted(array6, 0, array1.length - 1);
		assert Quick.isSorted(array7, 0, array1.length - 1);
	}
	
	@Test
	public void testHeap() {
		System.out.println("Heap Sort Results:");
		StopWatch timer8 = new StopWatch();
		timer8.start();
		Heap.sortHeap(array1, array1.length);
		System.out.println("Time in milleseconds to sort array of size " + array1.length + " : " + timer8.getNanoTime()/Math.pow(10, 6) );
		timer8.reset();
		timer8.start();
		Heap.sortHeap(array2, array2.length);
		System.out.println("Time in milleseconds to sort array of size " + array2.length + " : " + timer8.getNanoTime()/Math.pow(10, 6) );
		timer8.reset();
		timer8.start();
		Heap.sortHeap(array3, array3.length);
		System.out.println("Time in milleseconds to sort array of size " + array3.length + " : " + timer8.getNanoTime()/Math.pow(10, 6) );
		timer8.reset();
		timer8.start();
		Heap.sortHeap(array4, array4.length);
		System.out.println("Time in milleseconds to sort array of size " + array4.length + " : " + timer8.getNanoTime()/Math.pow(10, 6) );
		timer8.reset();
		timer8.start();
		Heap.sortHeap(array5, array5.length);
		System.out.println("Time in milleseconds to sort array of size " + array5.length + " : " + timer8.getNanoTime()/Math.pow(10, 6) );
		timer8.reset();
		timer8.start();
		Heap.sortHeap(array6, array6.length);
		System.out.println("Time in milleseconds to sort array of size " + array6.length + " : " + timer8.getNanoTime()/Math.pow(10, 6) );
		timer8.reset();
		timer8.start();
		Heap.sortHeap(array7, array7.length);
		System.out.println("Time in milleseconds to sort array of size " + array7.length + " : " + timer8.getNanoTime()/Math.pow(10, 6) + "\n\n");
		assert Insertion.isSorted(array1);
		assert Insertion.isSorted(array2);
		assert Insertion.isSorted(array3);
		assert Insertion.isSorted(array4);
		assert Insertion.isSorted(array5);
		assert Insertion.isSorted(array6);
		assert Insertion.isSorted(array7);
	}
}
