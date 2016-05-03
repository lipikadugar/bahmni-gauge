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
	RegistrationSearchPage registration_search;
	Registration_Page1 registration_page;
		
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Before
	public void setup() throws InterruptedException{
		commonTasks = new Common();
		driver = Common.launchApp();
		
		LoginPage login_page = PageFactory.initElements(driver,LoginPage.class);
		login_page.login("superman", "Admin123","OPD-1");
		
		HomePage homepage = PageFactory.initElements(driver,HomePage.class);
		homepage.clickClinicalApp();
		
	}
	@Test
	public void testA() throws InterruptedException, IOException {
		
		PatientListingPage patients_page = PageFactory.initElements(driver,PatientListingPage.class);
		patients_page.searchSelectPatientFromTabs("All", commonTasks.getJsonKeyValue("patient", "ID"));
		
		DashboardPage dashboard = PageFactory.initElements(driver,DashboardPage.class);
		dashboard.clickClinical();
		
		ConsultationPage consultation_page = PageFactory.initElements(driver,ConsultationPage.class);
		consultation_page.clickTab("Medications");
		
		TreatmentPage treatment_page = PageFactory.initElements(driver, TreatmentPage.class);
		treatment_page.prescribeDrugToPatient("Drug1");treatment_page.prescribeDrugToPatient("Drug2");
		treatment_page.prescribeDrugToPatient("Drug3");treatment_page.prescribeFreeTextDrugToPatient("Drug4");
		treatment_page.savePrecription();
		
		assertTrue(treatment_page.hasText(commonTasks.getJsonKeyValue("patient/Treatment/Drug1","Name")));
	}
	
	public void searchAndOpenVisit() throws InterruptedException, IOException{
		
		Common.navigateToSearchPage();
		
		registration_search = PageFactory.initElements(driver, RegistrationSearchPage.class);
		registration_search.searchPatientWithID("GAN", commonTasks.getJsonKeyValue("patient", "ID").substring(3,commonTasks.getJsonKeyValue("patient", "ID").length()));
		
		registration_page = PageFactory.initElements(driver, Registration_Page1.class);
		registration_page.startVisit();
	}
	
	@After
	public void shutDown(){
		driver.quit();	
	}

}