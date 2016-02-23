package test;

import files.Files;
import junit.framework.TestCase;

public class FilesTests extends TestCase {
	public static void testGetMinTempSpreadDay(){
		assertEquals(14, Files.getMinTempSpreadDay("./weather.dat"));
	}

}
