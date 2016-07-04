package org.bahmni.test.page.clinical;

import org.bahmni.test.Common;
import org.bahmni.test.page.BahmniPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ConsultationPage extends BahmniPage {
	
	@FindBy(how= How.CSS, using = ".btn--success")
    public WebElement clinical;
	
	@FindBy(how= How.CSS, using = ".consultation-tabs .tab-item")
    public List<WebElement> tabs;
	
	@FindBy(how= How.CSS, using = ".back-btn-link")
    public WebElement patient_profile;
	
	@FindBy(how= How.CSS, using = ".save-consultation")
    public WebElement save;
	
	public ConsultationPage(){
    }

    public BacteriologyPage clickBacteriologySave() throws InterruptedException {
    	Common.waitForSpinner();
    	save.click();
		return org.bahmni.test.page.PageFactory.getBacteriologyPage();
    }
    
    public void clickPatientProfile() throws InterruptedException {
    	Common.waitForSpinner();
    	patient_profile.click();
    	Common.waitForSpinner();
    }
    
    public BacteriologyPage clickTab(String Tabname) throws InterruptedException {
    	Common.waitForSpinner();
    	for(int i=0;i<=tabs.size()-1;i++){
    		if(tabs.get(i).getText().toString().contains(Tabname)){
    			tabs.get(i).click();
    		}
    	}
		return org.bahmni.test.page.PageFactory.getBacteriologyPage();
    }

}
