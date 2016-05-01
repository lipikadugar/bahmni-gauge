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
	HomePage homepage;
	RegistrationSearch registration_search;
	Registration_Page1 registration_page;
		
	@Before
	public void setup() throws InterruptedException, IOException{
		
		//Objects Initialization
		commonTasks = new Common();
		driver = Common.launchApp();
		//Login to the App
		LoginPage login_page = PageFactory.initElements(driver,LoginPage.class);
		login_page.login("superman", "Admin123", "OPD-1");
		
		searchAndOpenVisit();
		Common.navigateToDashboard();
		
		homepage = PageFactory.initElements(driver,HomePage.class);
		homepage.clickClinicalApp();
	}
	
	@Test
	public void createBacteriologySample() throws InterruptedException, IOException{
		
		PatientListingPage patients_page = PageFactory.initElements(driver,PatientListingPage.class);
		patients_page.searchSelectPatientFromTabs("All", commonTasks.getJsonKeyValue("patient", "ID"));
		
		DashboardPage dashboard = PageFactory.initElements(driver,DashboardPage.class);
		dashboard.clickClinical();
		
		ConsultationPage consultation_page = PageFactory.initElements(driver,ConsultationPage.class);
		consultation_page.clickTab("Bacteriology");
		
		BacteriologyPage bacteriologyPage = PageFactory.initElements(driver,BacteriologyPage.class);
		bacteriologyPage.createSample("04/20/2016", "Sputum", "12345");
		
		assertTrue(bacteriologyPage.isSampleExists("Sputum", "12345"));
	
	}
	
	@Test
	public void editBacteriologySample() throws InterruptedException, IOException{
		
		PatientListingPage patients_page = PageFactory.initElements(driver,PatientListingPage.class);
		patients_page.searchSelectPatientFromTabs("All", commonTasks.getJsonKeyValue("patient", "ID"));
		
		DashboardPage dashboard = PageFactory.initElements(driver,DashboardPage.class);
		dashboard.clickClinical();
		
		ConsultationPage consultation_page = PageFactory.initElements(driver,ConsultationPage.class);
		consultation_page.clickTab("Bacteriology");
		
		BacteriologyPage bacteriologyPage = PageFactory.initElements(driver,BacteriologyPage.class);
		bacteriologyPage.editSample("04/20/2016", "Sputum", "12345");
		
		assertTrue(bacteriologyPage.isSampleExists("Sputum", "12345"));
	
	}
	
	@Test
	public void deleteBacteriologySample() throws InterruptedException, IOException{
		
		PatientListingPage patients_page = PageFactory.initElements(driver,PatientListingPage.class);
		patients_page.searchSelectPatientFromTabs("All", commonTasks.getJsonKeyValue("patient", "ID"));
		
		DashboardPage dashboard = PageFactory.initElements(driver,DashboardPage.class);
		dashboard.clickClinical();
		
		ConsultationPage consultation_page = PageFactory.initElements(driver,ConsultationPage.class);
		consultation_page.clickTab("Bacteriology");
		
		BacteriologyPage bacteriologyPage = PageFactory.initElements(driver,BacteriologyPage.class);
		bacteriologyPage.deleteSample("04/20/2016", "Sputum", "12345");
		
		assertTrue(bacteriologyPage.isSampleExists("Sputum", "12345"));
	
	}
	
	public void searchAndOpenVisit() throws InterruptedException, IOException{
	
		Common.navigateToSearchPage();
		
		registration_search = PageFactory.initElements(driver, RegistrationSearch.class);
		registration_search.searchPatientWithID("GAN", commonTasks.getJsonKeyValue("patient", "ID").substring(3,commonTasks.getJsonKeyValue("patient", "ID").length()));
		
		registration_page = PageFactory.initElements(driver, Registration_Page1.class);
		registration_page.startVisit();
	}
	
	@After
	public void shutDown(){
		driver.quit();
	}

}
