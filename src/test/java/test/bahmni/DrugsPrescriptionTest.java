package test.bahmni;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.Hashtable;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class DrugsPrescriptionTest {

	ChromeDriver driver;
	@SuppressWarnings("rawtypes")
	Hashtable patient,drug1,drug2,drug3,drug4;
	public Common commonTasks;
		
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Before
	public void setup() throws InterruptedException{
		commonTasks = new Common();
		driver = Common.launchApp();
		
		LoginPage login_page = new LoginPage(driver);
		login_page.login("superman", "Admin123","OPD-1");
		
		HomePage homepage = new HomePage(driver);
		homepage.clickClinicalApp();
		
	}
	@Test
	public void testA() throws InterruptedException, IOException {
		
		PatientListingPage patients_page = new PatientListingPage(driver);
		patients_page.searchSelectPatientFromTabs("All", commonTasks.getJsonKeyValue("patient", "ID"));
		
		DashboardPage dashboard = new DashboardPage(driver);
		dashboard.clickClinical();
		
		ConsultationPage consultation_page = new ConsultationPage(driver);
		consultation_page.clickTab("Medications");
		
		TreatmentPage treatment_page = new TreatmentPage(driver);
		treatment_page.prescribeDrugToPatient("Drug1");treatment_page.prescribeDrugToPatient("Drug2");
		treatment_page.prescribeDrugToPatient("Drug3");treatment_page.prescribeFreeTextDrugToPatient("Drug4");
		treatment_page.savePrecription();
		
		assertTrue(treatment_page.hasText(commonTasks.getJsonKeyValue("patient/Treatment/Drug1","Name")));
	}
	
	public void searchAndOpenVisit() throws InterruptedException, IOException{
		
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