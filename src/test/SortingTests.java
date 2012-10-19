package test;

import fundamentals.Sorting;
import junit.framework.TestCase;

public class SortingTests extends TestCase {
	private int [] arrayOne = {31, 45, 17, 87, 56, 22};
	private Sorting sorting = new Sorting();
	
	public void setUp(){
		
	}
	
	public void testBubbleSort(){
		sorting.bubbleSort(arrayOne);
		assertTrue(arrayOne[0] == 17);
		assertTrue(arrayOne[1] == 22);
		assertTrue(arrayOne[2] == 31);
		assertTrue(arrayOne[3] == 45);
		assertTrue(arrayOne[4] == 56);
		assertTrue(arrayOne[5] == 87);
	}
	
	public void testSelectionSort(){
		sorting.selectionSort(arrayOne);
		assertTrue(arrayOne[0] == 17);
		assertTrue(arrayOne[1] == 22);
		assertTrue(arrayOne[2] == 31);
		assertTrue(arrayOne[3] == 45);
		assertTrue(arrayOne[4] == 56);
		assertTrue(arrayOne[5] == 87);
	}
	
	public void testMergeSort(){
		sorting.mergeSort(arrayOne, 0, 5);
		assertTrue(arrayOne[0] == 17);
		assertTrue(arrayOne[1] == 22);
		assertTrue(arrayOne[2] == 31);
		assertTrue(arrayOne[3] == 45);
		assertTrue(arrayOne[4] == 56);
		assertTrue(arrayOne[5] == 87);
	}
	
	public void testQuickSort(){
		sorting.quickSort(arrayOne, 0, 5);
		assertTrue(arrayOne[0] == 17);
		assertTrue(arrayOne[1] == 22);
		assertTrue(arrayOne[2] == 31);
		assertTrue(arrayOne[3] == 45);
		assertTrue(arrayOne[4] == 56);
		assertTrue(arrayOne[5] == 87);
	}
}
