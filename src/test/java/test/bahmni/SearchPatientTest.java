package test.bahmni;

import static org.junit.Assert.*;
import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.support.PageFactory;

public class SearchPatientTest {
	
	ChromeDriver driver;
	public Common app;
	
	@Before
	public void setup() throws InterruptedException{
		app = new Common();
		driver = app.getChromeDriver();
		app.launchApp();
	}
	
	@Test
	public void run() throws InterruptedException{
		
		LoginPage login_page = PageFactory.initElements(driver,LoginPage.class);
		login_page.login("superman", "Admin123", "OPD-1");
		
		app.waitForObject(driver);
		
		HomePage homepage = PageFactory.initElements(driver,HomePage.class);
		homepage.clickModule("Registration");
		
		app.waitForObject(driver);
		
		RegistrationSearch registration_search = PageFactory.initElements(driver, RegistrationSearch.class);
		registration_search.searchPatientWithID("GAN", "200");
		
		app.waitForObject(driver);
		assertNotNull(registration_search.search_results);
		
	}
	
	@After
	public void shutDown(){
		driver.quit();
	}
	
	

}
