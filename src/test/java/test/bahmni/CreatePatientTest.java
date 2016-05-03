package test.bahmni;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class CreatePatientTest {
	
	ChromeDriver driver;
	public Common commonTasks;
		
	@Before
	public void setup() throws InterruptedException {
		
		//Objects Initialization
		commonTasks = new Common();
		driver = Common.launchApp();
		//Login to the App
		LoginPage login_page = new LoginPage(driver);
		login_page.login("superman", "Admin123", "OPD-1");
		
		HomePage homepage = new HomePage(driver);
		homepage.clickRegistrationApp();
	}
	
	@Test
	public void testA_createPatient() throws InterruptedException, IOException{
	
		RegistrationSearchPage registration_search = new RegistrationSearchPage(driver);
		registration_search.clickCreateNew();
			
		Registration_Page1 registration_page = new Registration_Page1(driver);
		registration_page.createNewPatient("..//bahmni//PatientProfile.json");
			
		assertNotNull(registration_page.new_patient);
	}
	
	@Test
	public void testB_searchAndOpenVisit() throws InterruptedException, IOException{
	
		Common.navigateToSearchPage();
		
		RegistrationSearchPage registration_search = new RegistrationSearchPage(driver);
		registration_search.searchPatientWithID("GAN", commonTasks.getJsonKeyValue("patient", "ID").substring(3,commonTasks.getJsonKeyValue("patient", "ID").length()));
		
		Registration_Page1 registration_page = new Registration_Page1(driver);
		registration_page.startVisit();
	}
	
	@After
	public void shutDown(){
		driver.quit();
	}

}
