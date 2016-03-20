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
	public Common app;
		
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Before
	public void setup() throws InterruptedException{
		app = new Common();
		driver = app.launchApp();
		
		LoginPage login_page = PageFactory.initElements(driver,LoginPage.class);
		login_page.login("superman", "Admin123","OPD-1");
		app.waitForObject(driver);
	}
	@Test
	public void testA() throws InterruptedException, IOException {
		
		HomePage homepage = PageFactory.initElements(driver,HomePage.class);
		homepage.clickClinicalApp();
		app.waitForObject(driver);
		
		PatientListingPage patients_page = PageFactory.initElements(driver,PatientListingPage.class);
		patients_page.searchSelectPatientFromTabs("All", app.getJsonKeyValue("patient", "ID"));
		app.waitForObject(driver);
		
		DashboardPage dashboard = PageFactory.initElements(driver,DashboardPage.class);
		dashboard.clickClinical();
		app.waitForObject(driver);
		
		ConsultationPage consultation_page = PageFactory.initElements(driver,ConsultationPage.class);
		consultation_page.clickTab("Medications");
		app.waitForObject(driver);
		
		TreatmentPage treatment_page = PageFactory.initElements(driver, TreatmentPage.class);
		treatment_page.prescribeDrugToPatient("Drug1");treatment_page.prescribeDrugToPatient("Drug2");
		treatment_page.prescribeDrugToPatient("Drug3");treatment_page.prescribeFreeTextDrugToPatient("Drug4");
		treatment_page.savePrecription();
		
		assertTrue(treatment_page.hasText(app.getJsonKeyValue("patient/Treatment/Drug1","Name")));
		
	}
	
	@After
	public void shutDown(){
		driver.quit();
		
	}

}