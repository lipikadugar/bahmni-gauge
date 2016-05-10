package test.bahmni;

import static org.junit.Assert.assertNotNull;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.chrome.ChromeDriver;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class CreatePatientTest {
	
	ChromeDriver driver;
	public Common commonTasks;
	HomePage homepage;
	RegistrationSearch registration_search;
	Registration_Page1 registration_page;
		
	@Before
	public void setup() throws InterruptedException, IOException {
		
		//Launch the App
		driver = Common.launchApp();
		commonTasks =  new Common();
		//Login to the App
		LoginPage login_page = new LoginPage();
		HomePage homepage = new HomePage();
		
		login_page.login();
		homepage.clickRegistrationApp();
		
		registration_search = new RegistrationSearch();
		registration_page = new Registration_Page1();
		
	}
	
	@Test
	public void createPatient() throws InterruptedException, IOException{
		registration_search.clickCreateNew();		
		registration_page.createNewPatient();	
		assertNotNull(registration_page.new_patient);
	}
	
	@Test
	public void searchAndOpenVisit() throws InterruptedException, IOException {
		registration_search.searchPatientWithID("GAN", commonTasks.getJsonKeyValue("patient", "ID").substring(3,commonTasks.getJsonKeyValue("patient", "ID").length()));
		registration_page.startVisit();
	}
	
	@After
	public void shutDown(){
		driver.quit();
	}

}
