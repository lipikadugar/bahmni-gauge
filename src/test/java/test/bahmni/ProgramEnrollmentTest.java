package test.bahmni;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.Hashtable;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class ProgramEnrollmentTest {

	ChromeDriver driver;
	@SuppressWarnings("rawtypes")
	Hashtable patient,program;
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
		homepage.clickProgramsApp();		
		app.waitForObject(driver);
		
		PatientListingPage patients_page = PageFactory.initElements(driver,PatientListingPage.class);
		patients_page.searchSelectPatientFromTabs("All", app.getJsonKeyValue("patient", "ID"));
		
		app.waitForObject(driver);
		
		ProgramManagamentPage prog_page = PageFactory.initElements(driver,ProgramManagamentPage.class);
		prog_page.expandProgramEnrollment();
		app.waitForObject(driver);
		
		prog_page.enrollToProgram();
		app.waitForObject(driver);
		
		assertTrue(prog_page.active_progs.getText().toString().contains(app.getJsonKeyValue("patient/Programs/Program", "Name")));
		
	}
	
	@Test
	public void testB() throws InterruptedException, IOException {
		
		HomePage homepage = PageFactory.initElements(driver,HomePage.class);
		homepage.clickProgramsApp();
		
		app.waitForObject(driver);
		
		PatientListingPage patients_page = PageFactory.initElements(driver,PatientListingPage.class);
		patients_page.searchSelectPatientFromTabs("All", app.getJsonKeyValue("patient", "ID"));
		app.waitForObject(driver);
		
		ProgramManagamentPage program_page = PageFactory.initElements(driver,ProgramManagamentPage.class);
		program_page.endProgramEnrollment("Cured");
		app.waitForObject(driver);
		
		assertTrue(program_page.inactive_progs.getText().toString().contains(app.getJsonKeyValue("patient/Programs/Program", "Name")));
		
	}
	
	@After
	public void shutDown(){
		driver.quit();
		
	}

}
