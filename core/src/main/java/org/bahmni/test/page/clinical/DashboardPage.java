package org.bahmni.test.page.clinical;

import org.bahmni.test.page.BahmniPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import org.bahmni.test.Common;

public class DashboardPage extends BahmniPage {
	
	@FindBy(how= How.CSS, using = ".btn--success")
    public WebElement clinical;
	
	@FindBy(how= How.CSS, using = ".bacteriology-dashboard")
    public WebElement bacteriology_results;
	
	public DashboardPage(){
    }

    public ConsultationPage clickClinical() throws InterruptedException {
    	Common.waitForSpinner();
    	clinical.click();
		return org.bahmni.test.page.PageFactory.getConsultationPage();
    }
    
    public DashboardPage navigateToConsultation() throws InterruptedException{
    	Common.waitForSpinner();
    	clickClinical();
		return org.bahmni.test.page.PageFactory.getDashboardPage();
    }
    
    

}
