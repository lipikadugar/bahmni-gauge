package test.bahmni;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.chrome.ChromeDriver;

import Library.Common;
import PageObjects.ConsultationPage;
import PageObjects.DashboardPage;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.PatientListingPage;
import PageObjects.ProgramManagamentPage;
import PageObjects.RegistrationSearch;
import PageObjects.Registration_Page1;
import PageObjects.TreatmentPage;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class DrugsPrescriptionTest {

	ChromeDriver driver;
	Common commonTasks;
	RegistrationSearch registration_search;
	Registration_Page1 registration_page;
	PatientListingPage patients_page;
	DashboardPage dashboard;
	ProgramManagamentPage programManagement_page;
	ConsultationPage consultation_page;
	TreatmentPage treatment_page;
		
	@Before
	public void setup() throws InterruptedException, IOException{
		commonTasks = new Common();
		driver = Common.launchApp();
		
		LoginPage login_page = new LoginPage();
		HomePage homepage = new HomePage();
		registration_search = new RegistrationSearch();
		patients_page = new PatientListingPage();
		dashboard = new DashboardPage();
		consultation_page = new ConsultationPage();
		treatment_page = new TreatmentPage();
		
		login_page.login();
		homepage.clickPatientRecords();
		
	}
	@Test
	public void prescribeDrugsToPatient() throws InterruptedException, IOException {
		
		patients_page.searchSelectPatientFromTable();
		programManagement_page.selectTreatmentDashboard();
		dashboard.navigateToConsultation();
		consultation_page.clickTab("Non TB Drugs");
		treatment_page.prescribeDrugToPatient("Drug1");
		treatment_page.prescribeDrugToPatient("Drug2");
		treatment_page.prescribeDrugToPatient("Drug3");
		treatment_page.prescribeFreeTextDrugToPatient("Drug4");
		treatment_page.savePrecription();
		
		assertTrue(treatment_page.hasText(commonTasks.getJsonKeyValue("patient/Treatment/Drug1","Name")));
	}

	/*@After
	public void shutDown(){
		driver.quit();	
	}*/

}