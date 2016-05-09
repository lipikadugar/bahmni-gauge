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
		driver = Common.launchApp();
		
		LoginPage login_page = new LoginPage(driver);
		login_page.login("superman", "Admin123","OPD-1");
		
		HomePage homepage = new HomePage(driver);
		homepage.clickProgramsApp();
	}
	
	@Test
	public void testA() throws InterruptedException, IOException {
		
		PatientListingPage patients_page = new PatientListingPage(driver);
		patients_page.searchSelectPatientFromTabs("All", app.getJsonKeyValue("patient", "ID"));
		
		ProgramManagementPage prog_page = new ProgramManagementPage(driver);
		prog_page.expandProgramEnrollment();
		
		prog_page.enrollToProgram();
		assertTrue(prog_page.active_progs.getText().toString().contains(app.getJsonKeyValue("patient/Programs/Program", "Name")));
		
	}
	
	@Test
	public void testB() throws InterruptedException, IOException {
		
		PatientListingPage patients_page = new PatientListingPage(driver);
		patients_page.searchSelectPatientFromTabs("All", app.getJsonKeyValue("patient", "ID"));
		
		ProgramManagementPage program_page = new ProgramManagementPage(driver);
		program_page.editProgramEnrolled();
		
		assertTrue(program_page.active_progs.getText().toString().contains("E1111"));
		
	}
	
	@Test
	public void testC() throws InterruptedException, IOException {
		
		PatientListingPage patients_page = new PatientListingPage(driver);
		patients_page.searchSelectPatientFromTabs("All", app.getJsonKeyValue("patient", "ID"));
		
		ProgramManagementPage program_page = new ProgramManagementPage(driver);
		program_page.endProgramEnrollment("Cured");
		
		assertTrue(program_page.inactive_progs.getText().toString().contains(app.getJsonKeyValue("patient/Programs/Program", "Name")));
		
	}
	
	@After
	public void shutDown(){
		driver.quit();
		
	}

}
