package test;

import java.util.ArrayList;
import strings.Strings;
import junit.framework.TestCase;


public class StringsTest extends TestCase {
	private Strings strings;
	
	public void setUp(){
		strings = new Strings();
	}
	public void tearDow(){
		strings = null;
	}
	
	public void testHasUniqueChars(){
		
		assertFalse(strings.hasUniqueChars("poodles"));
		assertTrue(strings.hasUniqueChars("stinky"));
	}
	
	public void testIsPermutation(){
		assertTrue(strings.isPermutation("poodles", "spoodle"));
		assertFalse(strings.isPermutation("googles", "google"));
	}
	
	public void testSortString(){
		assertEquals(strings.sortString("poodles"), "deloops");
		assertEquals(strings.sortString("catsndogs"), "acdgnosst");
	}
	
	public void testReplaceSpaces(){
		assertEquals(strings.replaceSpaces("Mr John Smith    "), "Mr%20John%20Smith");
	}
	
	public void testReplaceSpaces2(){
		char [] s = new String("Mr John Smith").toCharArray();
		//strings.replaceSpaces(s, s.length);
		//assertEquals(s, "Mr%20John%20Smith");
	}
	
	public void testGetPermutations(){
		String s = "Amazon";
		ArrayList<String> perms = strings.getPermutations(s);
		assertTrue(perms.size() == 720);
	}
	
	public void testGetVanityNumbers(){
		String [] words = strings.getVanityNumbers(2665);
		assertTrue(words.length == 3);
	}
}
