package org.bahmni.test.page;

import org.bahmni.test.BahmniTestCase;
import org.junit.Test;

public class RegistrationSearchTest extends BahmniPageTest{

	@Test
	public void testRegistrationSearch(){
		BahmniTestCase.start()
				.login()
				.clickRegistrationApp()
				.searchByIdentifier("","1");
	}

}
