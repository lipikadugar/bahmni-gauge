package org.bahmni.test.page;

import org.bahmni.test.BahmniTestCase;
import org.bahmni.test.page.registration.RegistrationFirstPage;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import static junit.framework.TestCase.assertTrue;

public class RegistrationSearchTest extends BahmniPageTest{

	private String patientId = "1234"+ new Random().nextInt();
	@Before
	public void setUp(){
//		RegistrationFirstPage registrationFirstPage = BahmniTestCase.start()
//				.login()
//				.clickRegistrationApp()
//				.clickCreateNew()
//				.registerPatient(new Patient(patientId,"bharat","akkin","Male",null,50));

	}

	@Test
	public void testRegistrationSearch(){
		BahmniTestCase.start()
				.login()
				.clickRegistrationApp()
				.searchByIdentifier("","123");
	}

	@Test
	public void ensureThatTheExactIdentifierSearchTakesToEditPage(){
		RegistrationFirstPage registrationFirstPage = BahmniTestCase.start()
				.login()
				.clickRegistrationApp()
				.searchByExactIdentifier("",patientId);
		assertTrue(registrationFirstPage.txtPatientName.isDisplayed());

	}

}
