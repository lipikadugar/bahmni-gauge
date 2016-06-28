package org.bahmni.test.page;

import org.bahmni.test.BahmniPageTest;
import org.bahmni.test.BahmniTestCase;
import org.bahmni.test.page.program.ProgramManagamentPage;
import org.bahmni.test.page.registration.EndTBRegistrationFirstPage;
import org.bahmni.test.page.registration.domain.EndTBPatient;
import org.bahmni.test.page.registration.domain.EndTBProgram;
import org.junit.Test;

import java.util.Random;

public class EndTBRegistrationFirstPageTest extends BahmniPageTest {

	@Test
	public void registerNewPatient(){
		EndTBRegistrationFirstPage registrationFirstPage = (EndTBRegistrationFirstPage) BahmniTestCase.start()
				.login()
				.clickRegistrationApp()
				.clickCreateNew()
				.registerPatient(new EndTBPatient("1234"+ new Random().nextInt(),"bharat","akkin","Male",null,50,"nationalId123"));
		registrationFirstPage.clickTreatmentRegistration();


	}

	@Test
	public void enrollPatient(){

		EndTBRegistrationFirstPage registrationFirstPage = (EndTBRegistrationFirstPage) BahmniTestCase.start()
				.login()
				.clickRegistrationApp()
				.searchByExactIdentifier("","1234-1983991473");


		ProgramManagamentPage programManagamentPage = registrationFirstPage
				.clickTreatmentRegistration()
				.enrollPatientToProgram(new EndTBProgram("Second-line TB treatment register","01/01/2015","123","Facility1, City1, Country1"))
				;

	}

}
