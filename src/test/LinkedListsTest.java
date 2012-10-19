package test;
import fundamentals.LinkedLists;
import fundamentals.Node;
import junit.framework.TestCase;


public class LinkedListsTest extends TestCase {
	private Node list;
	private LinkedLists linkedLists;
	public void setUp(){
		list = new Node(3);
		list.appendToTail(4);
		list.appendToTail(3);
		list.appendToTail(3);
		list.appendToTail(5);
		list.appendToTail(3);
		
		linkedLists = new LinkedLists();
	}

	public void testRemoveDuplicates(){
		setUp();
		linkedLists.removeDuplicates(list);
		assertTrue(list.valueAt(2) == 5);
		assertTrue(list.length() == 3);
	}
	
	public void testRemoveDuplicatesNoBuffer(){
		setUp();
		linkedLists.removeDuplicatesNoBuffer(list);
		assertTrue(list.valueAt(2) == 5);
		assertTrue(list.length() == 3);
	}
	
	public void testFindKthLastElement(){
		setUp();
		Node n = linkedLists.findKthLastElement(list, 1);
		assertTrue(n.data == 5);
	}
	
	public void testInsertOrdered(){
		setUp();
		Node newlist = linkedLists.insertOrdered(list, 4);
		assertTrue(newlist.valueAt(4) == 4);
		assertTrue(newlist.valueAt(5) == 4);
		assertTrue(newlist.valueAt(6) == 5);
	}
	
	public void testAddReversedNumbers(){
		setUp();
		Node listA = new Node(3);
		listA.appendToTail(2);
		listA.appendToTail(1);
		
		Node listB = new Node(5);
		listB.appendToTail(6);
		listB.appendToTail(4);
		
		Node listC = linkedLists.addReversedNumbers(listA, listB);
		
		assertTrue(listC.length() == 3);
		assertTrue(listC.valueAt(0) == 8);
		assertTrue(listC.valueAt(1) == 8);
		assertTrue(listC.valueAt(2) == 5);
	}
}
