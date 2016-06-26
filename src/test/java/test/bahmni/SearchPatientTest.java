package test.bahmni;

import org.bahmni.test.BahmniTestCase;
import org.bahmni.test.Common;
import org.bahmni.test.page.HomePage;
import org.bahmni.test.page.LoginPage;
import org.bahmni.test.page.RegistrationSearch;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;

import static org.junit.Assert.assertNotNull;

public class SearchPatientTest {
	
	ChromeDriver driver;
	RegistrationSearch registration_search;
	LoginPage login_page;
	HomePage homepage;
	
	Common app;
	
	@Before
	public void setup() throws InterruptedException, IOException{
		app = new Common();
		driver = Common.launchApp();

		homepage = new HomePage();
		registration_search = new RegistrationSearch();
	}
	
	@Test
	public void searchPatientWithIDPrefix() throws InterruptedException, IOException{
		BahmniTestCase.start().login();
		homepage.clickRegistrationApp();
		registration_search.searchByIdentifier("EMR", "123");
		
		assertNotNull(registration_search.gridSearchResults);
	}
	
	@After
	public void shutDown(){
		driver.quit();
	}	

}
