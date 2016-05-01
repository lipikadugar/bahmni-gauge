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
	HomePage homepage;
	RegistrationSearch registration_search;
	Registration_Page1 registration_page;
		
	@Before
	public void setup() throws InterruptedException {
		
		//Objects Initialization
		commonTasks = new Common();
		driver = Common.launchApp();
		//Login to the App
		LoginPage login_page = PageFactory.initElements(driver,LoginPage.class);
		login_page.login("superman", "Admin123", "OPD-1");
		
		homepage = PageFactory.initElements(driver,HomePage.class);
		homepage.clickRegistrationApp();
	}
	
	@Test
	public void testA_createPatient() throws InterruptedException, IOException{
	
		registration_search = PageFactory.initElements(driver, RegistrationSearch.class);
		registration_search.clickCreateNew();
			
		registration_page = PageFactory.initElements(driver, Registration_Page1.class);
		registration_page.createNewPatient("..//bahmni//PatientProfile.json");
			
		assertNotNull(registration_page.new_patient);
	}
	
	@Test
	public void testB_searchAndOpenVisit() throws InterruptedException, IOException{
	
		Common.navigateToSearchPage();
		
		registration_search = PageFactory.initElements(driver, RegistrationSearch.class);
		registration_search.searchPatientWithID("GAN", commonTasks.getJsonKeyValue("patient", "ID").substring(3,commonTasks.getJsonKeyValue("patient", "ID").length()));
		
		registration_page = PageFactory.initElements(driver, Registration_Page1.class);
		registration_page.startVisit();
	}
	
	@After
	public void shutDown(){
		driver.quit();
	}

}
