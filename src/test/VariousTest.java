package test;

import java.util.ArrayList;
import java.util.List;

import fundamentals.Various;
import junit.framework.TestCase;


public class VariousTest extends TestCase {

	public void testFib() {
		assertTrue(Various.fib(0) == 0);
		assertTrue(Various.fib(1) == 1);
		assertTrue(Various.fib(2) == 2);
		assertTrue(Various.fib(3) == 3);
		assertTrue(Various.fib(4) == 5);
		assertTrue(Various.fib(5) == 8);
		assertTrue(Various.fib(6) == 13);
		assertTrue(Various.fib(7) == 21);
	}

	public void testFindBreakingHeight(){
		int [] answer = Various.findBreakingHeight(100, Various.makeBulb(13));
		assertTrue(answer[0] == 13);
		assertTrue(answer[1] == 14);

		int [] answer2 = Various.findBreakingHeight(100, Various.makeBulb(98));
		assertTrue(answer2[0] == 98);
		assertTrue(answer2[1] == 14);
	}

	public void testSieveOfEratosthenes(){
		boolean [] primes = Various.sieveOfEratosthenes(10);
		assertTrue(primes[2]);
		assertTrue(primes[3]);
		assertTrue(primes[5]);
		assertTrue(primes[7]);
		assertFalse(primes[9]);
		assertFalse(primes[1]);
		assertFalse(primes[4]);
		assertFalse(primes[6]);
		assertFalse(primes[8]);
	}

	public void testGetProductsOfAllIntsExceptAtIndex() {
		int [] intArray = {3, 1, 2, 5, 6, 4};
		int [] products = Various.getProductsOfAllIntsExceptAtIndex(intArray);

		assertTrue(products[0] == 240);
	}

	public void testHighestProduct() {
		int [] intArray = {-10, -10, 1, 3, 2};
		assertTrue(Various.highestProductOf3(intArray) == 300);
	}

	public void testHasMatch()
	{
		String [] stringArray = {"foo", "bar", "buz", "bo"};
		assertTrue(Various.hasMatch(stringArray, "f.o"));
		assertTrue(Various.hasMatch(stringArray, "f.."));
		assertTrue(Various.hasMatch(stringArray, ".uz"));
		assertTrue(Various.hasMatch(stringArray, "..o"));
		assertTrue(Various.hasMatch(stringArray, "..."));
		assertFalse(Various.hasMatch(stringArray, "...."));
		assertFalse(Various.hasMatch(stringArray, "f.r"));
		assertFalse(Various.hasMatch(stringArray, "for"));
		assertFalse(Various.hasMatch(stringArray, ".."));
		assertFalse(Various.hasMatch(stringArray, "."));
	}

	public void testFindPairsThatSumTo() {
		//             0  1  2  3  4  5  6  7   8
		int [] data = {0, 1, 2, 3, 5, 2, 4, 6, -1};
		List <List<Integer>>pairs = Various.findPairsThatSumTo(data, 4);
		assertTrue(pairs.get(0).get(0) == 0);
		assertTrue(pairs.get(0).get(1) == 6);
	}

}
