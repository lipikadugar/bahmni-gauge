package org.bahmni.test.page;

import org.bahmni.test.Common;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;

public class BahmniPageTest {

	static ChromeDriver driver = null;

	@BeforeClass
	public static void setup() throws IOException, InterruptedException {
		driver = Common.launchApp();
	}

	@AfterClass
	public static void cleanUp() {
//		driver.close();
	}

}
