package test.bahmni;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.chrome.ChromeDriver;

import Library.Common;
import PageObjects.BacteriologyPage;
import PageObjects.ConsultationPage;
import PageObjects.DashboardPage;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.PatientListingPage;
import PageObjects.ProgramManagamentPage;
import PageObjects.RegistrationSearch;
import PageObjects.Registration_Page1;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class BacteriologyTest {

	ChromeDriver driver;
	public Common commonTasks;
	HomePage homepage;
	RegistrationSearch registration_search;
	Registration_Page1 registration_page;
	PatientListingPage patients_page;
	DashboardPage dashboard;
	ProgramManagamentPage programManagement_page;
	ConsultationPage consultation_page;
	BacteriologyPage bacteriologyPage;
	
	
	@Before
	public void setup() throws InterruptedException, IOException{
		
		//Objects Initialization
		commonTasks = new Common();
		driver = Common.launchApp();
		//Login to the App
		LoginPage login_page = new LoginPage();
		HomePage homepage = new HomePage();
		patients_page = new PatientListingPage();
		dashboard = new DashboardPage();
		consultation_page = new ConsultationPage();
		programManagement_page = new ProgramManagamentPage();
		bacteriologyPage = new BacteriologyPage();
		
		login_page.login();
		//Create a new Patient
		//commonTasks.createPatient();
		//Common.navigateToDashboard();
		homepage.clickPatientRecords();
	}
	
	@Test
	public void createBacteriologySample() throws InterruptedException, IOException{
		
		patients_page.searchSelectPatientFromTable();
		programManagement_page.selectTreatmentDashboard();
		dashboard.navigateToConsultation();
		consultation_page.createBacteriologySample("04/20/2016", "Sputum", "12345");
		assertTrue(bacteriologyPage.isSampleExists("Sputum", "12345"));
		consultation_page.clickPatientProfile();
		assertTrue(dashboard.bacteriology_results.getText().contains("12345"));
	
	}
	
	@Test
	public void editBacteriologySample() throws InterruptedException, IOException{
		
		patients_page.searchSelectPatientFromTable();
		programManagement_page.selectTreatmentDashboard();
		dashboard.navigateToConsultation();
		consultation_page.createBacteriologySample("01/15/2016", "Sputum", "4444");
		bacteriologyPage.editSample("02/18/2016", "Sputum", "1111");
		assertTrue(bacteriologyPage.isSampleExists("Sputum", "1111"));
		consultation_page.clickPatientProfile();
		assertTrue(dashboard.bacteriology_results.getText().contains("1111"));
	
	}
	
	@Test
	public void deleteBacteriologySample() throws InterruptedException, IOException{
		
		patients_page.searchSelectPatientFromTable();
		programManagement_page.selectTreatmentDashboard();
		dashboard.navigateToConsultation();
		consultation_page.createBacteriologySample("02/20/2016", "Sputum", "5555");
		bacteriologyPage.deleteSample("02/20/2016", "Sputum", "5555");
		assertFalse(bacteriologyPage.isSampleExists("Sputum", "5555"));
		consultation_page.clickPatientProfile();
		assertFalse(dashboard.bacteriology_results.getText().contains("5555"));
	
	}
	
	@After
	public void shutDown(){
		driver.quit();
	}

}
