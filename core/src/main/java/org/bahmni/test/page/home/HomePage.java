package org.bahmni.test.page.home;

import org.bahmni.test.Common;
import org.bahmni.test.page.BahmniPage;
import org.bahmni.test.page.PageFactory;
import org.bahmni.test.page.program.ProgramManagementPage;
import org.bahmni.test.page.registration.RegistrationSearch;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePage extends BahmniPage {

	@FindBy(how= How.CSS, using = "i.fa-user")
    public WebElement registration;

	@FindBy(how= How.CSS, using = "i.icon-bahmni-program")
	public WebElement programs;
	
	@FindBy(how= How.CSS, using = "i.icon-bahmni-admin")
    public WebElement admin;
	
	@FindBy(how= How.CSS, using = "i.icon-bahmni-reports")
    public WebElement exports;
	
	@FindBy(how= How.CSS, using = "i.icon-bahmni-program")
    public WebElement programs;

	//TODO: logout doesn't recognize
	@FindBy(how= How.XPATH, using = "#view-content > div > header > div > ul > li:nth-child(3) > a > span")
	public WebElement logout;

    public RegistrationSearch clickRegistrationApp(){
    	registration.click();
	    return PageFactory.getRegistrationSearchPage();
    }
    
    public ProgramManagementPage clickProgramsApp() {
    	Common.waitForSpinner();
		programs.click();
		return PageFactory.getProgramManagementPage();

	}
    
    public void clickAdminApp() throws InterruptedException {
    	Common.waitForSpinner();
    	admin.click();
    }
    
    public void clickExportsApp() throws InterruptedException {
    	Common.waitForSpinner();
    	exports.click();
    }
    
    public void clickProgramsApp() throws InterruptedException {
    	Common.waitForSpinner();
    	programs.click();
    }

	public void logout(){
		logout.click();
	}
}
