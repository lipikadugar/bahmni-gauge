package test.bahmni;

import org.bahmni.test.BahmniTestCase;
import org.bahmni.test.Common;
import org.bahmni.test.page.HomePage;
import org.bahmni.test.page.LoginPage;
import org.bahmni.test.page.ReportsPage;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;

import static org.junit.Assert.assertTrue;

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
		
		login_page = BahmniTestCase.start();
		homepage = new HomePage();
		reports = new ReportsPage();
	}
	
	@Test
	public void test() throws InterruptedException, IOException {
		login_page.login();
		homepage.clickExportsApp();	
		reports.selectAndRunReport("Treatment Initiation Data Export","01/01/2016", "04/01/2016", "EXCEL");
		assertTrue(reports.report_name.getText().contains("Patient Information Report (Excel)"));
	}
	
	/*@After
	public void shutDown(){
		driver.quit();
	}*/

}
