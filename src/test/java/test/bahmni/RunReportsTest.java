package test.bahmni;

import java.io.IOException;
import java.util.Hashtable;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class RunReportsTest {

	ChromeDriver driver;
	@SuppressWarnings("rawtypes")
	Hashtable patient,program;
	public Common app;
		
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Before
	public void setup() throws InterruptedException{
		app = new Common();
		driver = Common.launchApp();
		
		LoginPage login_page = PageFactory.initElements(driver,LoginPage.class);
		login_page.login("superman", "Admin123","Registration Desk");
		
		HomePage homepage = PageFactory.initElements(driver,HomePage.class);
		homepage.clickReportsApp();	
	}
	
	@Test
	public void test() throws InterruptedException, IOException {
		
		ReportsPage reports = PageFactory.initElements(driver, ReportsPage.class);
		reports.selectAndRunReport("Chief Complaint Report","01/01/2016", "04/01/2016", "HTML");
		
		//assertNotNull(registration_search.search_results);
		/*URL url = new URL("https://172.18.2.10/bahmnireports/report?name=Chief%20Complaint%20Report&startDate=2016-01-01&endDate=2016-04-01&responseType=text/html&paperSize=A3");
		HttpURLConnection http = (HttpURLConnection)url.openConnection();
		System.out.println(http.getResponseCode());*/
	}
	
	@After
	public void shutDown(){
		driver.quit();
		
	}

}
