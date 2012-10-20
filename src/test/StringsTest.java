package test;

import java.util.ArrayList;
import strings.Strings;
import junit.framework.TestCase;


public class StringsTest extends TestCase {
	
	
	public void testHasUniqueChars(){
		
		assertFalse(Strings.hasUniqueChars("poodles"));
		assertTrue(Strings.hasUniqueChars("stinky"));
	}
	
	public void testIsPermutation(){
		assertTrue(Strings.isPermutation("poodles", "spoodle"));
		assertFalse(Strings.isPermutation("googles", "google"));
	}
	
	public void testSortString(){
		assertEquals(Strings.sortString("poodles"), "deloops");
		assertEquals(Strings.sortString("catsndogs"), "acdgnosst");
	}
	
	public void testReplaceSpaces(){
		assertEquals(Strings.replaceSpaces("Mr John Smith    "), "Mr%20John%20Smith");
	}
	
	public void testGetPermutations(){
		String s = "Amazon";
		ArrayList<String> perms = Strings.getPermutations(s);
		assertTrue(perms.size() == 720);
	}
	
	public void testGetVanityNumbers(){
		String [] words = Strings.getVanityNumbers(2665);
		assertTrue(words.length == 3);
	}
}
