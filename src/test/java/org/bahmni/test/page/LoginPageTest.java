package org.bahmni.test.page;

import org.bahmni.test.BahmniTestCase;
import org.junit.Test;
import org.openqa.selenium.NoSuchElementException;

import java.io.IOException;

import static org.junit.Assert.assertTrue;

public class LoginPageTest extends BahmniPageTest{


	@Test
	public void testLogin() throws IOException, InterruptedException {
		HomePage homePage = BahmniTestCase.start().login();
		assertTrue(homePage.registration.isDisplayed());
//		homePage.logout();
	}

	@Test(expected = NoSuchElementException.class)
	public void testInvalidLogin() throws IOException, InterruptedException {
		HomePage homePage = BahmniTestCase.start().login("superman","blah..blah..blah");
		homePage.registration.isDisplayed();
	}

}
