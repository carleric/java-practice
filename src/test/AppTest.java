package test;
import fundamentals.Various;
import junit.framework.TestCase;


public class AppTest extends TestCase {

	public void testFib() {
		Various app = new Various();
		assertTrue(app.fib(0) == 0);
		assertTrue(app.fib(1) == 1);
		assertTrue(app.fib(2) == 2);
		assertTrue(app.fib(3) == 3);
		assertTrue(app.fib(4) == 5);
		assertTrue(app.fib(5) == 8);
		assertTrue(app.fib(6) == 13);
		assertTrue(app.fib(7) == 21);
	}

}
