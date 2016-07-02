package org.bahmni.test;

import static org.junit.Assert.*;

import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.bahmni.test.page.home.HomePage;
import org.bahmni.test.page.login.LoginPage;
import org.bahmni.test.page.registration.RegistrationFirstPage;
import org.bahmni.test.page.registration.RegistrationSearch;
import org.bahmni.test.page.registration.RegistrationVisitDetailsPage;
import org.bahmni.test.page.registration.domain.Patient;
import org.junit.Test;

public class CreatePatientTest extends BahmniPageTest{

	@Test
	public void testCreatePatient() throws InterruptedException {
		String patientFirstName = "test" + RandomStringUtils.randomAlphabetic(4);
		
    			
		LoginPage testCase = BahmniTestCase.start();
		testCase.login()
				.clickRegistrationApp()
				.clickCreateNew()
				.registerPatient(new Patient(null, patientFirstName, "name","Male",null, 10))
				.startVisit("OPD")
				.enterVisitDetails("180","90","100", "no comments")
				.navigateToPatientSearchPage()
				.verifySearchResultForPatient(patientFirstName);
		
	}
}
