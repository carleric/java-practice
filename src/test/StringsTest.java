package test;

import java.util.List;
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

		char [] in = "Mr John Smith    ".toCharArray();
		Strings.replaceSpaces(in, 13);
		String out = new String(in);
		assertEquals(out, "Mr%20John%20Smith");
	}

	public void testGetPermutations(){
		String s = "abc";
		ArrayList<String> perms = Strings.getPermutations(s);
                assertTrue(perms.size() == 6); //720 is 6! (6*5*4*3*2*1)
		//assertTrue(perms.size() == 720); //720 is 6! (6*5*4*3*2*1)
	}

	public void testGetVanityNumbers(){
		String [] words = Strings.getVanityNumbers(2665);
		assertTrue(words.length == 3);
	}
        
        public void testPowerset() {
            ArrayList<String> list = new ArrayList<String>();
            list.add("a");
            list.add("b");
            list.add("c");
            List <List<String>> ps = Strings.powerset(list);
            assertTrue(ps.size() == 8);
            
        }
        
        public void testGetLongestWord() {
            String [] validWords = {"boo", "foo", "barge"};
            Character [] tiles = {'b', 'o', 'f', 'a', 'r', 'g', 'e'};
            String longestWord = Strings.getLongestWord(validWords, tiles);
            assertTrue(longestWord.equals("barge"));
        }
}
