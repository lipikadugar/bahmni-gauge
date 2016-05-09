package test.bahmni;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class endTBTest {
	
	ChromeDriver driver;
	public Common app;
	
	@Before
	public void setup() throws InterruptedException{
		app = new Common();
		driver = Common.launchAppWithURL("https://172.18.2.35/home");
		
		LoginPage login_page = new LoginPage(driver);
		login_page.login("superman", "Admin123","Registration Desk");
		
	}

	@Test
	public void test() throws InterruptedException, IOException {

		HomePage homepage = new HomePage(driver);
		homepage.clickOnCustomApp("Patient Records");
		
		PatientListingPage patients_page = new PatientListingPage(driver);
		Common.waitUntilAppReady(Common.Webdriver);
		patients_page.enterPatientIDOrName("LD test");
		
		driver.findElements(By.cssSelector(".table.patient-list-table span")).get(0).click();
		
		ProgramManagementPage programPage = new ProgramManagementPage(driver);
		programPage.gotoDashboard("Second-line");
		
		DashboardPage dashboard = new DashboardPage(driver);
		dashboard.clickClinical();
		
		ConsultationPage consultation_page = new ConsultationPage(driver);
		consultation_page.clickTab("Observations");
		
		ObservationPage obsPage = new ObservationPage(driver);
		obsPage.expandSection("Baseline");
		obsPage.fillBaselineTemplate();
	}

}
