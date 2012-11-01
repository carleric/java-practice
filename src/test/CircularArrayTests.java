package test;

import structures.CircularArray;
import junit.framework.TestCase;

public class CircularArrayTests extends TestCase {
	CircularArray <String> ca;
	
	public void setUp(){
		ca = new CircularArray<String>(3);
		ca.set(0, "First");
		ca.set(1, "Second");
		ca.set(2, "Third");
	}
	
	public void testRotate(){
		
		
		assertEquals("First", ca.get(0));
		assertEquals("Second", ca.get(1));
		assertEquals("Third", ca.get(2));
		
		ca.rotate(1);
		
		assertEquals("Second", ca.get(0));
		assertEquals("Third", ca.get(1));
		assertEquals("First", ca.get(2));
		
	}
	
	public void testIterator(){
		int count = 0;
		for(String item : ca){
			System.out.println(item);
			count++;
		}
		assertTrue(count == 3);
	}
}
