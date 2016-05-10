package test.bahmni;

import java.io.IOException;
import java.util.Hashtable;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;

public class RecordObservationsTest {

	ChromeDriver driver;
	@SuppressWarnings("rawtypes")
	Hashtable patient,drug1,drug2,drug3,drug4;
	Common commonTasks;
	PatientListingPage patients_page;
	RegistrationSearch registration_search;
	Registration_Page1 registration_page;
	DashboardPage dashboard;
	ConsultationPage consultation_page;
	
	@Before
	public void setup() throws InterruptedException, IOException{
		commonTasks = new Common();
		driver = Common.launchApp();
		
		LoginPage login_page = new LoginPage();
		HomePage homepage = new HomePage();
		consultation_page = new ConsultationPage();
		dashboard = new DashboardPage();
		patients_page = new PatientListingPage();
		
		login_page.login();
		homepage.clickClinicalApp();
	}
	
	@Test
	public void recordObservationsForPatient() throws InterruptedException, IOException {
		patients_page.searchSelectPatientFromAllTabs();
		dashboard.clickClinical(); 
		consultation_page.clickTab("Observations");
		
	}
	
	@After
	public void shutDown(){
		driver.quit();
		
	}

}
