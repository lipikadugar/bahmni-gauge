package test.bahmni;

import org.bahmni.test.BahmniTestCase;
import org.bahmni.test.Common;
import org.bahmni.test.page.HomePage;
import org.bahmni.test.page.LoginPage;
import org.bahmni.test.page.RegistrationSearch;
import org.bahmni.test.page.Registration_Page1;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;

import static org.junit.Assert.assertNotNull;

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
		LoginPage login_page = BahmniTestCase.start();
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
	
	/*@After
	public void shutDown(){
		driver.quit();
	}*/

}
