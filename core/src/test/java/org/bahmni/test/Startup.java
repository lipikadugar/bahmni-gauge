package org.bahmni.test;

import org.bahmni.test.page.registration.RegistrationFirstPage;
import org.bahmni.test.page.registration.domain.Patient;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.Random;

/**
 * Created by dharmens on 6/30/16.
 */

public class Startup {

    static ChromeDriver driver = null;

    @Before
    public void setup() throws IOException, InterruptedException {
        driver = Common.launchApp();

        RegistrationFirstPage registrationFirstPage = BahmniTestCase.start()
                .login()
                .clickRegistrationApp()
                .clickCreateNew()
                .registerPatient(new Patient("1234"+ new Random().nextInt(),"bharat","akkin","Male",null,50))
                .isPatientCreated();
    }

    @After
    public void cleanUp() {
        driver.close();
    }

}
