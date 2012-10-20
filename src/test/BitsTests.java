package test;

import fundamentals.Bits;
import junit.framework.TestCase;


public class BitsTests extends TestCase {
	
	public void testNumOnesInBinary(){
		assertTrue(Bits.numOnesInBinary(1) == 1);
		assertTrue(Bits.numOnesInBinary(2) == 1);
		assertTrue(Bits.numOnesInBinary(3) == 2);
		assertTrue(Bits.numOnesInBinary(4) == 1);
		assertTrue(Bits.numOnesInBinary(5) == 2);
		assertTrue(Bits.numOnesInBinary(6) == 2);
		assertTrue(Bits.numOnesInBinary(7) == 3);
		assertTrue(Bits.numOnesInBinary(8) == 1);
		assertTrue(Bits.numOnesInBinary(9) == 2);
	}
}
