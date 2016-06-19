package test.bahmni;

import java.io.IOException;
import java.util.Hashtable;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;

import Library.Common;
import PageObjects.ConsultationPage;
import PageObjects.DashboardPage;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.ObservationTemplatesPage;
import PageObjects.PatientListingPage;
import PageObjects.ProgramManagamentPage;
import PageObjects.RegistrationSearch;
import PageObjects.Registration_Page1;

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
	ProgramManagamentPage programManagement_page;
	ObservationTemplatesPage observation_templates;
	
	@Before
	public void setup() throws InterruptedException, IOException{
		commonTasks = new Common();
		driver = Common.launchApp();
		
		LoginPage login_page = new LoginPage();
		HomePage homepage = new HomePage();
		consultation_page = new ConsultationPage();
		dashboard = new DashboardPage();
		patients_page = new PatientListingPage();
		observation_templates = new ObservationTemplatesPage();
		
		login_page.login();
		homepage.clickPatientRecords();
	}
	
	@Test
	public void recordObservationsForPatient() throws InterruptedException, IOException {
		patients_page.searchSelectPatientFromTable();
		programManagement_page.selectTreatmentDashboard();
		dashboard.navigateToConsultation();
		
		observation_templates.addTemplate("Lab Results - Other Tests");
		observation_templates.addTemplate("Audiometry");
		observation_templates.fillTemplateData("Audiometry date","textbox","01/01/2015");
		observation_templates.fillTemplateData("Type of assessment","button","Baseline");
		observation_templates.fillTemplateData("Left Ear : dB at 250Hz","textbox","3");
		observation_templates.fillTemplateData("Audio assessment comment","textarea","I Am A Bot");
		
	}
	
	@After
	public void shutDown(){
		driver.quit();
		
	}

}
