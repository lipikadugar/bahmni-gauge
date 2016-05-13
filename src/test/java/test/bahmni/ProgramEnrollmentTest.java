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
import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.PatientListingPage;
import PageObjects.ProgramManagamentPage;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class ProgramEnrollmentTest {

	ChromeDriver driver;
	public Common app;
	PatientListingPage patients_page;
	ProgramManagamentPage programManagement_page;
		
	@Before
	public void setup() throws InterruptedException, IOException{
		app = new Common();
		driver = Common.launchApp();
		
		LoginPage login_page = new LoginPage();
		HomePage homepage = new HomePage();
		patients_page = new PatientListingPage();
		programManagement_page = new ProgramManagamentPage();
		
		login_page.login();
		homepage.clickProgramsApp();
		
	}
	
	@Test
	public void createProgramForPatient() throws InterruptedException, IOException {
		patients_page.searchSelectPatientFromAllTabs();
		programManagement_page.enrollToProgram();
		assertTrue(programManagement_page.hasEnrolledProgram());
	}
	
	@Test
	public void editPatientProgram() throws InterruptedException, IOException {
		patients_page.searchSelectPatientFromAllTabs();
		programManagement_page.editProgramEnrolled();
		assertTrue(programManagement_page.hasAttribute());
	}
	
	@Test
	public void endPatientProgram() throws InterruptedException, IOException {
		patients_page.searchSelectPatientFromAllTabs();
		programManagement_page.endProgramEnrolled();
		assertTrue(programManagement_page.hasEndedProgram());
	}
	
	@After
	public void shutDown(){
		driver.quit();
		
	}

}
