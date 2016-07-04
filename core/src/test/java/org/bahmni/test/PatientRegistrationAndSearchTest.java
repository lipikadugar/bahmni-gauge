package org.bahmni.test;

import org.bahmni.test.Startup;
import org.bahmni.test.page.registration.RegistrationFirstPage;
import org.bahmni.test.page.registration.domain.Patient;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Random;

/**
 * Created by dharmens on 6/30/16.
 */

public class PatientRegistrationAndSearchTest {

	@Ignore
	@Test
	public void shoudldBeAbleToRegisterNewPatient(){
		RegistrationFirstPage registrationFirstPage = BahmniTestCase.start()
				.login()
				.clickRegistrationApp()
				.clickCreateNew()
				.registerPatient(new Patient("1234"+ new Random().nextInt(),"bharat","akkin","Male",null,50))
				.isPatientCreated();
	}

	@Test
	public void shoudldBeAbleToSearchPatient(){
		RegistrationFirstPage registrationFirstPage = BahmniTestCase.start()
				.login()
				.clickRegistrationApp()
				.searchByIdentifier("IND","20020")
				.getFirstResult();
	}
}
