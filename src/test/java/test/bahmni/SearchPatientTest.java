package test.bahmni;

import static org.junit.Assert.assertNotNull;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;

import Library.Common;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.RegistrationSearch;

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
		
		login_page = new LoginPage();
		homepage = new HomePage();
		registration_search = new RegistrationSearch();
	}
	
	@Test
	public void searchPatientWithIDPrefix() throws InterruptedException, IOException{
		login_page.login();
		homepage.clickRegistrationApp();
		registration_search.searchPatientWithID("EMR", "123");
		
		assertNotNull(registration_search.search_results);	
	}
	
	@After
	public void shutDown(){
		driver.quit();
	}	

}
