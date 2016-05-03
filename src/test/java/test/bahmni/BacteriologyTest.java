package test.bahmni;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class BacteriologyTest {

	ChromeDriver driver;
	public Common commonTasks;
		
	@Before
	public void setup() throws InterruptedException, IOException{
		
		//Objects Initialization
		commonTasks = new Common();
		driver = Common.launchApp();
		//Login to the App
		LoginPage login_page = new LoginPage(driver);
		login_page.login("superman", "Admin123", "OPD-1");
		
		searchAndOpenVisit();
		Common.navigateToDashboard();
		
		HomePage homepage = new HomePage(driver);
		homepage.clickClinicalApp();
	}
	
	@Test
	public void createBacteriologySample() throws InterruptedException, IOException{
		
		PatientListingPage patients_page = new  PatientListingPage(driver);
		patients_page.searchSelectPatientFromTabs("All", commonTasks.getJsonKeyValue("patient", "ID"));
		
		DashboardPage dashboard = new DashboardPage(driver);
		dashboard.clickClinical();
		
		ConsultationPage consultation_page = new ConsultationPage(driver);
		consultation_page.clickTab("Bacteriology");
		
		BacteriologyPage bacteriologyPage = new BacteriologyPage(driver);
		bacteriologyPage.createSample("04/20/2016", "Sputum", "12345");
		
		assertTrue(bacteriologyPage.isSampleExists("Sputum", "12345"));
	
	}
	
	@Test
	public void editBacteriologySample() throws InterruptedException, IOException{
		
		PatientListingPage patients_page = new  PatientListingPage(driver);
		patients_page.searchSelectPatientFromTabs("All", commonTasks.getJsonKeyValue("patient", "ID"));
		
		DashboardPage dashboard = new DashboardPage(driver);
		dashboard.clickClinical();
		
		ConsultationPage consultation_page = new ConsultationPage(driver);
		consultation_page.clickTab("Bacteriology");
		
		BacteriologyPage bacteriologyPage = new BacteriologyPage(driver);
		bacteriologyPage.editSample("04/20/2016", "Sputum", "12345");
		
		assertTrue(bacteriologyPage.isSampleExists("Sputum", "12345"));
	
	}
	
	@Test
	public void deleteBacteriologySample() throws InterruptedException, IOException{
		
		PatientListingPage patients_page = new PatientListingPage(driver);
		patients_page.searchSelectPatientFromTabs("All", commonTasks.getJsonKeyValue("patient", "ID"));
		
		DashboardPage dashboard = new DashboardPage(driver);
		dashboard.clickClinical();
		
		ConsultationPage consultation_page = new ConsultationPage(driver);
		consultation_page.clickTab("Bacteriology");
		
		BacteriologyPage bacteriologyPage = new BacteriologyPage(driver);
		bacteriologyPage.deleteSample("04/20/2016", "Sputum", "12345");
		
		assertTrue(bacteriologyPage.isSampleExists("Sputum", "12345"));
	
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
