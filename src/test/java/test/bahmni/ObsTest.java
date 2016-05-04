package test.bahmni;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;

public class ObsTest {
	
	ChromeDriver driver;
	public Common app;
	
	@Before
	public void setup() throws InterruptedException{
		app = new Common();
		driver = Common.launchApp();
		
		LoginPage login_page = new LoginPage(driver);
		login_page.login("superman", "Admin123","OPD-1");
		
		HomePage homepage = new HomePage(driver);
		homepage.clickClinicalApp();
		
	}
	
	@Test
	public void test() throws InterruptedException, IOException {
		
		PatientListingPage patients_page = new PatientListingPage(driver);
		patients_page.searchSelectPatientFromTabs("All", app.getJsonKeyValue("patient", "ID"));
		
		DashboardPage dashboard = new DashboardPage(driver);
		dashboard.clickClinical();
		
		ConsultationPage consultation_page = new ConsultationPage(driver);
		consultation_page.clickTab("Observations");
		
		ObservationPage obsPage = new ObservationPage(driver);
		obsPage.fillObsTemplate(("Vitals"));
		//obsPage.fillObsTemplate(("History and Examination"));
	}

}
