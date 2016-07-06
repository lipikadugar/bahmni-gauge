package org.bahmni.test.page.clinical;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ObservationsPage {
	
	@FindBy(how= How.CSS, using = "#drug-name")
    public WebElement drug_name;
	
	@FindBy(how= How.CSS, using = ".accept-btn")
    public WebElement accept_btn;
	
	@FindBy(how= How.CSS, using = "#uniform-dose")
    public WebElement dose;
	

}
