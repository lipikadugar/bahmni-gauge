package test.bahmni;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;

import Library.Common;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.ReportsPage;

public class RunReportsTest {

	ChromeDriver driver;
	LoginPage login_page;
	HomePage homepage;
	ReportsPage reports;
	Common app;
		
	@Before
	public void setup() throws InterruptedException, IOException{
		app = new Common();
		driver = Common.launchApp();
		
		login_page = new LoginPage();
		homepage = new HomePage();
		reports = new ReportsPage();
	}
	
	@Test
	public void test() throws InterruptedException, IOException {
		login_page.login();
		homepage.clickExportsApp();	
		reports.selectAndRunReport("Treatment Initiation Data Export","01/01/2016", "04/01/2016", "CSV");
		assertTrue(reports.report_name.getText().contains("Chief Complaint Report"));
	}
	
	/*@After
	public void shutDown(){
		driver.quit();
	}*/

}
