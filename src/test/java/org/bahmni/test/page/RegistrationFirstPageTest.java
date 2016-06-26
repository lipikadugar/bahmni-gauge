package org.bahmni.test.page;

import org.bahmni.test.BahmniTestCase;
import org.bahmni.test.domain.Patient;
import org.junit.Test;

public class RegistrationFirstPageTest extends BahmniPageTest{

	@Test
	public void registerNewPatient(){
		RegistrationFirstPage registrationFirstPage = BahmniTestCase.start()
				.login()
				.clickRegistrationApp()
				.clickCreateNew()
				.registerPatient(new Patient("123","bharat","akkin","Male",null,50));
	}
}
