package org.bahmni.test.page;

import org.bahmni.test.BahmniPageTest;
import org.bahmni.test.BahmniTestCase;
import org.bahmni.test.page.registration.RegistrationFirstPage;
import org.bahmni.test.page.registration.domain.Patient;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Random;

public class RegistrationFirstPageTest extends BahmniPageTest {

	@Ignore
	@Test
	public void registerNewPatient(){
		RegistrationFirstPage registrationFirstPage = BahmniTestCase.start()
				.login()
				.clickRegistrationApp()
				.clickCreateNew()
				.registerPatient(new Patient("1234"+ new Random().nextInt(),"bharat","akkin","Male",null,50));
	}
}
