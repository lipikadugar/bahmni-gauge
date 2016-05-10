package test.bahmni;

import static org.junit.Assert.*;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;

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
		homepage.clickReportsApp();	
		reports.selectAndRunReport("Chief Complaint Report","01/01/2016", "04/01/2016", "HTML");
		assertTrue(reports.report_name.getText().contains("Chief Complaint Report"));
	}
	
	@After
	public void shutDown(){
		driver.quit();
	}

}
