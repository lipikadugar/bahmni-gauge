package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import Library.Common;

public class HomePage {

	@FindBy(how= How.CSS, using = "i.icon-bahmni-registration")
    public WebElement registration;
	
	@FindBy(how= How.CSS, using = "i.icon-bahmni-documents")
    public WebElement patient_records;
	
	@FindBy(how= How.CSS, using = "i.icon-bahmni-admin")
    public WebElement admin;
	
	@FindBy(how= How.CSS, using = "i.icon-bahmni-reports")
    public WebElement exports;
	
	public HomePage(){
		PageFactory.initElements(Common.Webdriver, this);
	}

    public void clickRegistrationApp() throws InterruptedException {
    	Common.waitUntilAppReady(Common.Webdriver);
    	registration.click();
    }
    
    public void clickPatientRecords() throws InterruptedException {
    	Common.waitUntilAppReady(Common.Webdriver);
    	patient_records.click();
    }
    
    public void clickAdminApp() throws InterruptedException {
    	Common.waitUntilAppReady(Common.Webdriver);
    	admin.click();
    }
    
    public void clickExportsApp() throws InterruptedException {
    	Common.waitUntilAppReady(Common.Webdriver);
    	exports.click();
    }
    
}
