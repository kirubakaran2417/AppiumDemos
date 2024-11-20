package org.example;

import org.testng.annotations.Test;

public class Testcase1 extends BaseTest {

	@Test
	public void testcase() {
		POM p=new POM();
		p.preference().click();
	}
}
