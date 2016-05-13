package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import Library.Common;

public class DashboardPage {
	
	@FindBy(how= How.CSS, using = ".btn--success")
    public WebElement clinical;
	
	@FindBy(how= How.CSS, using = ".bacteriology-dashboard")
    public WebElement bacteriology_results;
	
	public DashboardPage(){
    	PageFactory.initElements(Common.Webdriver,this);
    }

    public void clickClinical() throws InterruptedException {
    	Common.waitUntilAppReady(Common.Webdriver);
    	clinical.click();
    }
    
    public void navigateToConsultation() throws InterruptedException{
    	Common.waitUntilAppReady(Common.Webdriver);
    	clickClinical();
    }
    
    

}
