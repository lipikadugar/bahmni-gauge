package org.bahmni.test;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;

/**
 * Created by dharmens on 6/30/16.
 */

public class Startup {

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
