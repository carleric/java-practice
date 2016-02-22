package test;

import static org.junit.Assert.*;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.PriorityQueue;
import java.util.Deque;
import java.util.ArrayDeque;
import java.util.Map;
import java.util.HashMap;

import org.junit.Test;

/**
 * review the Collections interface
 * @author carlb
 *
 */
public class CollectionsTest {

	/**
	 * Set
	 */
	@Test
	public void testSet() {
		//fail("Not yet implemented");
		Set <Integer>s = new HashSet<>();
		s.add(1);
		s.add(2);
		s.add(1);//should fail
		assertTrue(s.size() == 2);
		assertTrue(s.contains(1));
		assertTrue(s.contains(2));
		assertFalse(s.contains(3));
	}
	
	/**
	 * List
	 */
	@Test
	public void testList() {
		//fail("Not yet implemented");
		List <Integer>s = new ArrayList<>();
		s.add(1);
		s.add(2);
		s.add(1);
		assertTrue(s.size() == 3);
		assertTrue(s.contains(1));
		assertTrue(s.contains(2));
		assertFalse(s.contains(3));
		assertTrue(s.get(2) == 1);
	}

	/**
	 * Queue
	 */
	@Test
	public void testQueue() {
		//fail("Not yet implemented");
		Queue <Integer>s = new PriorityQueue<>();
		s.add(1);
		s.add(2);
		s.add(1);
		s.add(4);
		assertTrue(s.size() == 4);
		assertTrue(s.contains(1));
		assertTrue(s.contains(2));
		assertFalse(s.contains(3));
		assertTrue(s.peek() == 1);
		assertTrue(s.poll() == 1);
		assertTrue(s.size() == 3);
	}
	
	/**
	 * Deque
	 */
	@Test
	public void testDeque() {
		//fail("Not yet implemented");
		Deque <Integer>s = new ArrayDeque<>();
		s.add(1);
		s.add(2);
		s.add(1);
		s.add(5);
		assertTrue(s.size() == 4);
		assertTrue(s.contains(1));
		assertTrue(s.contains(2));
		assertFalse(s.contains(3));
		assertTrue(s.getFirst() == 1);
		assertTrue(s.getLast() == 5);
	}
	
	/**
	 * Map
	 */
	@Test
	public void testMap() {
		//fail("Not yet implemented");
		Map <Integer, String>s = new HashMap<>();
		s.put(1, "Bob");
		s.put(2, "Sally");
		s.put(1, "Alexis");//should fail
		s.put(5,  "carl");
		assertTrue(s.size() == 3);
		assertTrue(s.containsKey(2));
		assertFalse(s.containsKey(3));
		assertTrue(s.containsKey(5));
		assertTrue(s.get(2).equals("Sally"));
	}
}
