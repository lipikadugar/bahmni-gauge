package test.bahmni;

import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class CreatePatientTest {
	
	ChromeDriver driver;
	public Common app;
		
	@Before
	public void setup() throws InterruptedException{
		app = new Common();
		driver = app.getChromeDriver();
		app.launchApp();
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void run() throws InterruptedException{
		
		LoginPage login_page = PageFactory.initElements(driver,LoginPage.class);
		login_page.login("superman", "Admin123","OPD-1"); 				//"OPD-1");
		
		app.waitForObject(driver);
		
		HomePage homepage = PageFactory.initElements(driver,HomePage.class);
		homepage.clickModule("Registration");
		
		app.waitForObject(driver);
		
		RegistrationSearch registration_search = PageFactory.initElements(driver, RegistrationSearch.class);
		registration_search.clickCreateNew();
		
		app.waitForObject(driver);
		
		Registration_Page1 registration_page = PageFactory.initElements(driver, Registration_Page1.class);
		registration_page.createNewPatient("Automation", "Tester", "Male", "32", "Kadar");
		
		app.waitForObject(driver);
		assertNotNull(registration_page.new_patient);
	}
	
	@After
	public void shutDown(){
		driver.quit();
		
	}
	
	

}
