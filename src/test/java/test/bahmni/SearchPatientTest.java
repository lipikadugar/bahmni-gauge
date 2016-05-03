package test.bahmni;

import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class SearchPatientTest {
	
	ChromeDriver driver;
	public Common app;
	
	@Before
	public void setup() throws InterruptedException{
		app = new Common();
		driver = Common.launchApp();
		//LoginPage login_page = PageFactory.initElements(driver,LoginPage.class);
		LoginPage login_page = new LoginPage(driver);
		login_page.login("superman", "Admin123", "OPD-1");
		
		HomePage homepage = new HomePage(driver);
		homepage.clickRegistrationApp();
		
	}
	
	@Test
	public void run() throws InterruptedException{
		
		RegistrationSearchPage registration_search = new RegistrationSearchPage(driver);
		registration_search.searchPatientWithID("GAN", "200");
		
		assertNotNull(registration_search.search_results);	
	}
	
	@After
	public void shutDown(){
		driver.quit();
	}	

}
