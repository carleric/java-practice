package test;

import files.Files;
import junit.framework.TestCase;

public class FilesTests extends TestCase {
	public static void testGetMinTempSpreadDay(){
		assertEquals(14, Files.getMinTempSpreadDay("/home/carl/Dev/cs-practice/weather.dat"));
	}

}
