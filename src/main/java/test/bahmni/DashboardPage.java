package test.bahmni;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class DashboardPage {
	
	@FindBy(how= How.CSS, using = ".btn--success")
    public WebElement clinical;

    public void clickClinical() throws InterruptedException {
    	clinical.click();
    }

}
