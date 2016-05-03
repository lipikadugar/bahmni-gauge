package test.bahmni;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {
	
	public DashboardPage(ChromeDriver driver){
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(how= How.CSS, using = ".btn--success")
    public WebElement clinical;

    public void clickClinical() throws InterruptedException {
    	Common.waitUntilAppReady(Common.Webdriver);
    	clinical.click();
    }

}
