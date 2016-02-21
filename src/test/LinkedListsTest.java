package test;

import structures.LinkedList;
import structures.Node;
import junit.framework.TestCase;


public class LinkedListsTest extends TestCase {
	private LinkedList list;
	public void setUp(){
		list = new LinkedList(3);
		list.appendToTail(4);
		list.appendToTail(3);
		list.appendToTail(3);
		list.appendToTail(5);
		list.appendToTail(3);
		
	}

	public void testRemoveDuplicates(){
		setUp();
		list.removeDuplicates();
		assertTrue(list.valueAt(2) == 5);
		assertTrue(list.length() == 3);
	}
	
	public void testRemoveDuplicatesNoBuffer(){
		setUp();
		list.removeDuplicatesNoBuffer();
		assertTrue(list.valueAt(2) == 5);
		assertTrue(list.length() == 3);
	}
	
	public void testFindKthLastElement(){
		setUp();
		Node n = list.findKthLastElement(1);
		assertTrue(n.data == 5);
	}
	
	public void testInsertOrdered(){
		setUp();
                LinkedList newlist = list.insertOrdered(4);
		assertTrue(newlist.valueAt(4) == 4);
		assertTrue(newlist.valueAt(5) == 4);
		assertTrue(newlist.valueAt(6) == 5);
	}
	
//	public void testAddNumbers(){
//		setUp();
//		LinkedList listA = new LinkedList(3);
//		listA.appendToTail(2);
//		listA.appendToTail(1);
//		
//		LinkedList listB = new LinkedList(5);
//		listB.appendToTail(6);
//		listB.appendToTail(4);
//		
//		LinkedList listC = listA.addNumbers(listB);
//		
//		assertTrue(listC.length() == 3);
//		assertTrue(listC.valueAt(0) == 8);
//		assertTrue(listC.valueAt(1) == 8);
//		assertTrue(listC.valueAt(2) == 5);
//	}
}
