package org.bahmni.test.page;

import org.bahmni.test.BahmniPageTest;
import org.bahmni.test.BahmniTestCase;
import org.bahmni.test.page.program.EndTBProgramManagementPage;
import org.bahmni.test.page.registration.EndTBRegistrationFirstPage;
import org.bahmni.test.page.registration.RegistrationFirstPage;
import org.bahmni.test.page.registration.domain.EndTBPatient;
import org.bahmni.test.page.registration.domain.EndTBProgram;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertTrue;

public class ProgramManagementPageTest extends BahmniPageTest{

	private String patientId = "ab123"+ new Random().nextInt();

	private RegistrationFirstPage registrationFirstPage = null;

	@Before
	public void setupBeforeTest(){
		registrationFirstPage = BahmniTestCase.start()
				.login()
				.clickRegistrationApp()
				.clickCreateNew()
				.registerPatient(new EndTBPatient(patientId,"Program","Mgmt","Male",null,50,"123456"));
	}

	@Test
	public void ensurePatientIsEnrolledAndAttributesGetUpdated(){
		EndTBProgram endTBProgram = new EndTBProgram("Second-line TB treatment register","01/01/2015","123","Facility1, City1, Country1");

		EndTBProgramManagementPage programPage = (EndTBProgramManagementPage)((EndTBRegistrationFirstPage)registrationFirstPage)
				.clickTreatmentRegistration()
				.enrollPatientToProgram(endTBProgram);

		assertTrue(programPage.isPatientEnrolledToProgram(endTBProgram));

		endTBProgram = new EndTBProgram("Second-line TB treatment register","01/01/2015","123456","Facility1, City1, Country1");
		programPage = (EndTBProgramManagementPage)programPage.modifyProgramEnrollment(endTBProgram);
		assertTrue(programPage.isPatientEnrolledToProgram(endTBProgram));

	}

}
