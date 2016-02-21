package test;

import static org.junit.Assert.*;

import org.junit.Test;
import fundamentals.Matrix;

public class MatrixTests {

	public void testFindMaxSum() {
		
		//max at lower right edge
		int [][] matrix = {{0, 1, 0, 2}, {0, 0, 0, 0}, {0, 0, 0, 0}, {2, 0, 6, 3}};
		int [] found = Matrix.findMaxSum(matrix);
		assertTrue(found[0] == 3);
		assertTrue(found[0] == 3);
		
		//empty array
		int [] found2 = Matrix.findMaxSum(new int[][]{});
		assertTrue(found2[0] == -1);
		assertTrue(found2[0] == -1);
	}

}
