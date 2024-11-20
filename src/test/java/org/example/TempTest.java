package org.example;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

public class TempTest {

	@Test
	public void test() {
		assertEquals("amal22","amal");
		
	}
	@Test
	public void test2() {
		try {
		assertEquals("amal22","amal");
		}catch(AssertionError e) {
			e.printStackTrace();
		}
	}
}
