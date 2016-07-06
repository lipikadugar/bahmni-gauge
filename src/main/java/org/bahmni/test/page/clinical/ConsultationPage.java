package org.bahmni.test.page.clinical;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class ConsultationPage {
	
	@FindBy(how= How.CSS, using = ".btn--success")
    public WebElement clinical;
	
	@FindBy(how= How.CSS, using = ".consultation-tabs .tab-item")
    public List<WebElement> tabs;
	
	@FindBy(how= How.CSS, using = ".back-btn-link")
    public WebElement patient_profile;
	
	@FindBy(how= How.CSS, using = ".save-consultation")
    public WebElement save;

}
