package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import Library.Common;

public class HomePage {

	@FindBy(how= How.CSS, using = ".fa-user")
    public WebElement registration;
	
	@FindBy(how= How.CSS, using = "i.icon-bahmni-program")
    public WebElement programs;
	
	@FindBy(how= How.CSS, using = "i.fa-stethoscope")
    public WebElement clinical;
	
	@FindBy(how= How.CSS, using = "i.icon-bahmni-reports")
    public WebElement reports;
	
	public HomePage(){
		PageFactory.initElements(Common.Webdriver, this);
	}

    public void clickRegistrationApp() throws InterruptedException {
    	Common.waitUntilAppReady(Common.Webdriver);
    	registration.click();
    }
    
    public void clickProgramsApp() throws InterruptedException {
    	Common.waitUntilAppReady(Common.Webdriver);
    	programs.click();
    }
    
    public void clickClinicalApp() throws InterruptedException {
    	Common.waitUntilAppReady(Common.Webdriver);
    	clinical.click();
    }
    
    public void clickReportsApp() throws InterruptedException {
    	Common.waitUntilAppReady(Common.Webdriver);
    	reports.click();
    }
    
}
