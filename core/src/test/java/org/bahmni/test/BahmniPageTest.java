package org.bahmni.test;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;

public class BahmniPageTest {

	static ChromeDriver driver = null;

	@Before
	public void setup() throws IOException, InterruptedException {
		driver = Common.launchApp();
	}
	
	@After
	public void cleanUp() {
		driver.close();
	}

}