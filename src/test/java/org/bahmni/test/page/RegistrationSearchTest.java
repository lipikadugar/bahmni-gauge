package org.bahmni.test.page;

import org.bahmni.test.BahmniTestCase;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class RegistrationSearchTest extends BahmniPageTest{

	@Test
	public void testRegistrationSearch(){
		BahmniTestCase.start()
				.login()
				.clickRegistrationApp()
				.searchByIdentifier("","13");
	}

	@Test
	public void ensureThatTheExactIdentifierSearchTakesToEditPage(){
		RegistrationFirstPage registrationFirstPage = BahmniTestCase.start()
				.login()
				.clickRegistrationApp()
				.searchByExactIdentifier("","13");
		assertTrue(registrationFirstPage.txtPatientName.isDisplayed());

	}

}
