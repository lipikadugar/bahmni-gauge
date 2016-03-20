package test.bahmni;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePage {

	@FindBy(how= How.CSS, using = ".fa-user")
    public WebElement registration;
	
	@FindBy(how= How.CSS, using = "i.icon-bahmni-program")
    public WebElement programs;
	
	@FindBy(how= How.CSS, using = "i.fa-stethoscope")
    public WebElement clinical;

    public void clickRegistrationApp() throws InterruptedException {
    	registration.click();
    }
    
    public void clickProgramsApp() throws InterruptedException {
    	programs.click();
    }
    
    public void clickClinicalApp() throws InterruptedException {
    	clinical.click();
    }
    
}
