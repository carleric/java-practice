package test;
import fundamentals.Bits;
import junit.framework.TestCase;


public class BitsTests extends TestCase {
	
	public void testNumOnesInBinary(){
		Bits b = new Bits();
		assertTrue(b.numOnesInBinary(1) == 1);
		assertTrue(b.numOnesInBinary(2) == 1);
		assertTrue(b.numOnesInBinary(3) == 2);
		assertTrue(b.numOnesInBinary(4) == 1);
		assertTrue(b.numOnesInBinary(5) == 2);
		assertTrue(b.numOnesInBinary(6) == 2);
		assertTrue(b.numOnesInBinary(7) == 3);
		assertTrue(b.numOnesInBinary(8) == 1);
		assertTrue(b.numOnesInBinary(9) == 2);
	}
}
